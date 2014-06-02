package com.grisaf.mqttSample;

import java.util.LinkedList;
import java.util.Queue;

public class MqttUtils {
    
    private static Queue<MyMqttMessage> queue;

    public static Queue<MyMqttMessage> getQueue() {
        if (queue == null) {
            queue = new LinkedList<>();
        }
        return queue;
    }

    public static void add(String topic, String message) {
        add(topic, message, System.currentTimeMillis());
    }

    public static void add(String topic, String message, Long time) {
        getQueue().add(new MyMqttMessage(topic, message, time));
    }

    public static MyMqttMessage remove() {
        return getQueue().poll();
    }
    
    public static MyMqttMessage peek() {
        return getQueue().peek();
    }
    
}
