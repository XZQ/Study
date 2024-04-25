package com.xzq.java.genericity;

import com.xzq.java.genericity.android.Button;
import com.xzq.java.genericity.android.Stack;
import com.xzq.java.genericity.android.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        List<Button> buttons = new ArrayList<Button>();
//        // 「extends」上界通配符表示这个类型只能是其子类或者本身
//        List<? extends TextView> textViews = buttons;


        Stack<TextView> stack = new Stack<>();
        List<Button> buttonList = new ArrayList<>();
        buttonList.add(new Button());
        buttonList.add(new Button());
        stack.pushAll(buttonList);

//        out == <? extends E>
//        in  =  <? super E>


    }
}

