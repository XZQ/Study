package com.xzq.design.facade;


/**
 * 门面模式
 */
public class Client {

    public void eat() {
        System.out.println("开始用餐");
    }

    public void wash() {
        System.out.println("洗晚");
    }


    public static void main(String[] args) {

        // 1 买菜
        VegVendor vegVendor = new VegVendor();
        vegVendor.purchase();
        // 2 找妹妹下厨
        Helper helper = new Helper();
        helper.cook();
        // 3 客户端用餐
        Client client = new Client();
        client.eat();

        client.wash();

    }
}
