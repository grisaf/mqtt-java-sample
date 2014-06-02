package com.grisaf.mqttSample;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MqttListener implements ServletContextListener {

    MqttClient client;
    
    public MqttListener() {
    }

    public void contextDestroyed(ServletContextEvent sce) {
        try {
            if (client != null) {
                client.disconnect();
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void contextInitialized(ServletContextEvent sce) {
        String clientId = "cli1";
        try {
            client = new MqttClient("tcp://localhost:1883", clientId);
            client.connect();
            client.subscribe("#");
            client.setCallback(new MyMqttCallback());
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
