package com.grisaf.mqttSample;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class RestEasyApp extends Application {
    HashSet<Object> singletons = new HashSet<Object>();

    public RestEasyApp() {
        singletons.add(new MqttService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
