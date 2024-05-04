package com.xzq.design.creater.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoadBalancer {

    private static volatile LoadBalancer instance;
    private List<String> serviceList;

    private LoadBalancer() {
        serviceList = new ArrayList<>();
    }

    public static LoadBalancer getInstance() {
        if (null == instance) {
            synchronized (LoadBalancer.class) {
                if (instance == null) {
                    instance = new LoadBalancer();
                }
            }
        }
        return instance;
    }


    public void addServer(String server) {
        serviceList.add(server);
    }

    public void removeServer(String server) {
        serviceList.remove(server);
    }

    public String getServer() {
        Random random = new Random();
        int ran = random.nextInt(serviceList.size());
        return serviceList.get(ran);
    }
}
