package com.xzq.design.facade;

public class Facade {

    private VegVendor vegVendor;
    private Chef chef;
    private Waiter waiter;
    private Cleaner cleaner;

    public Facade() {
        vegVendor = new VegVendor();
        chef = new Chef();
        waiter = new Waiter();
        cleaner = new Cleaner();
    }

    public void order() {
        waiter.order();
        chef.cook();
        waiter.serve();
        cleaner.clean();
        cleaner.wash();
    }
}

class Chef {
    public void cook() {

    }
}

class Waiter {

    public void order() {
    }

    public void serve() {
    }

}

class Cleaner {
    public void clean() {
    }

    public void wash() {
    }
}
