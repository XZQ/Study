package mypkg;


public class JNITest {

    public native void init();

    public native void init(int age);

    public static void main(String[] args) {
        Log1.getInstance().getMa();
    }
}
