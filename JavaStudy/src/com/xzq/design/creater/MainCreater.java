package com.xzq.design.creater;

import com.xzq.design.creater.singleton.LoadBalancer;

public class MainCreater {

    public static void main(String[] args) {
        testBalancer();
    }

    static void testBalancer() {
        LoadBalancer balancer1, balancer2, balancer3, balancer4;
        balancer1 = LoadBalancer.getInstance();
        balancer2 = LoadBalancer.getInstance();
        balancer3 = LoadBalancer.getInstance();
        balancer4 = LoadBalancer.getInstance();

        System.out.println("balancer1= " + balancer1);
        System.out.println("balancer2= " + balancer2);
        System.out.println("balancer3= " + balancer3);
        System.out.println("balancer4= " + balancer4);

        balancer1.addServer("Service 1");
        balancer1.addServer("Service 2");
        balancer1.addServer("Service 3");
        balancer1.addServer("Service 4");

        for (int i = 0; i < 10; i++) {
            String server = balancer1.getServer();
            System.out.println("分发请求 " + server);
        }
    }

}
