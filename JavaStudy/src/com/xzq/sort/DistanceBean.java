package com.xzq.sort;

public class DistanceBean {

    private String id;
    private String name;
    private int distance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public DistanceBean() {

    }

    public DistanceBean(String id, String name, int distance) {
        this.id = id;
        this.name = name;
        this.distance = distance;
    }

//    @Override
//    public int compare(DistanceBean o1, DistanceBean o2) {
//        return o1.distance - o2.distance;
//    }

    @Override
    public String toString() {
        return "DistanceBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}
