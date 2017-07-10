package com.ja0ck5.java8.i;

/**
 * Created by Ja0ck5 on 2017/7/10.
 */
public interface MySecInterface {

    default String handleName(String name){
        return "MySecInterface " + name;
    }

}
