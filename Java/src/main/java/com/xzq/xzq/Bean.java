package com.xzq.xzq;


public class Bean implements Comparable<Bean> {

    public String name;
    public String equityCode;

    public Bean(String name, String equityCode) {
        this.name = name;
        this.equityCode = equityCode;
    }

    public Bean() {

    }

    @Override
    public int compareTo(Bean other) {
        return Integer.compare(getNoWorriesSortValue(this.equityCode), getNoWorriesSortValue(other.equityCode));
    }

    /**
     * 服务无忧相关排序
     *
     * @param equityCode
     * @return
     */
    private Integer getNoWorriesSortValue(String equityCode) {
        // 服务无忧顺序：保险>免费维修>增强保养服务>维保代步出行服务>维保取送车服务 >事故安心服务>上门补胎>增值服务>爱车积分>年检代办服务>增强流量服务
        // 保险无忧顺序：保险>划痕补漆服务>基础保养服务>维保代步出行服务>维保取送车服务 >事故安心服务>上门补胎>增值服务>爱车积分>年检代办服务>增强流量服务
        switch (equityCode) {
            case "value_added_service":
                return 0;
            case "scooter_service":
                return 1;
            case "enhanced_maintenance":
                return 2;
            case "maintenance":
                return 3;
            case "scratch_repair":
                return 4;
            case "inspection":
                return 5;
            case "point":
                return 6;
            case "deliverycar_service":
                return 7;
            case "home_tirerepair":
                return 8;
            case "accident_relieving":
                return 9;
            default:
                return Integer.MAX_VALUE;
        }
    }

    @Override
    public String toString() {
        return "Bean{" +
                "name='" + name + '\'' +
                ", equityCode='" + equityCode + '\'' +
                '}';
    }
}
