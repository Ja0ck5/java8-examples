package com.ja0ck5.java8.model;

import com.ja0ck5.java8.i.MyInterface;
import com.ja0ck5.java8.i.MySecInterface;

/**
 * Created by Ja0ck5 on 2017/7/10.
 */
public class MyClass implements MyInterface ,MySecInterface{

    @Override
    public String handleName(String name) {
        return MyInterface.super.handleName("haha");
    }
}
