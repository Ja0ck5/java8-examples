package com.ja0ck5.java8.functional;

/**
 * Created by Ja0ck5 on 2017/7/5.
 */
@FunctionalInterface
public interface ServiceFunction<T,R> {

    R service(T t1, T t2);

}
