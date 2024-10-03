package com.johny.fleet.management.iot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.johny.fleet.management.vehicle.domain.LocationData;
import com.johny.fleet.management.vehicle.service.VehicleService;
import com.johny.fleet.management.vehicle.service.VehicleServiceImpl;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class MqttConfig {

    private static final String MQTT_BROKER = "tcp://localhost:1883";
    private static final String CLIENT_ID = "fleetManagementSystem";
    private static final String TOPIC = "fleet/vehicle/#";
    @Autowired
    private VehicleServiceImpl vehicleService;

    @Bean
    public MqttConnectOptions mqttConnectOptions() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[]{MQTT_BROKER});
        options.setCleanSession(true);
        return options;
    }

    @Bean
    public DefaultMqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(mqttConnectOptions());
        return factory;
    }

    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MqttPahoMessageDrivenChannelAdapter inbound() {
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(CLIENT_ID, mqttClientFactory(), TOPIC);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }





    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return message -> {
            String topic = message.getHeaders().get("mqtt_receivedTopic").toString();
            String payload = message.getPayload().toString();
            System.out.println("Received message: " + payload + " from topic: " + topic);

            String[] topicParts = topic.split("/");
            Long vehicleId = Long.parseLong(topicParts[2]);

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                if (topic.endsWith("location")) {
                    LocationData locationData = objectMapper.readValue(payload, LocationData.class);
                    vehicleService.updateVehicleData(vehicleId, locationData.getLatitude(), locationData.getLongitude(),
                            locationData.getSpeed(), 0);
                } else if (topic.endsWith("fuel")) {
                    LocationData fuelData = objectMapper.readValue(payload, LocationData.class);
                    vehicleService.updateVehicleData(vehicleId, 0, 0, 0, fuelData.getFuelLevel());
                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        };
    }



}
