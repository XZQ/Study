package com.xzq.design.behavior.strategy;

public class MainTest {

    public static final int AUDIOFOCUS_GAIN = 1;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;

    public static final int AUDIOFOCUS_LOSS = -1 * AUDIOFOCUS_GAIN;

    public static final int AUDIOFOCUS_LOSS_TRANSIENT = -1 * AUDIOFOCUS_GAIN_TRANSIENT;
    public static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK = -1 * AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK;

    public static void main(String[] args) {
        System.out.println("AUDIOFOCUS_LOSS = " + AUDIOFOCUS_LOSS);
        System.out.println("AUDIOFOCUS_LOSS_TRANSIENT = " + AUDIOFOCUS_LOSS_TRANSIENT);
        System.out.println("AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK = " + AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK);
    }
}
