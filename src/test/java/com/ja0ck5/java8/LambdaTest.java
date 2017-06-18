package com.ja0ck5.java8;

import com.ja0ck5.java8.model.Man;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Ja0ck5 on 2017/6/18.
 */
public class LambdaTest {

    @Test
    public void test1() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
    }

    @Test
    public void testManWhoIsAdult() {
        List<Man> list = Arrays.asList(
                new Man("test-1", 15),
                new Man("test-2", 16),
                new Man("test-3", 17),
                new Man("test-4", 18),
                new Man("test-5", 19),
                new Man("test-6", 28),
                new Man("test-7", 48),
                new Man("test-8", 58),
                new Man("test-9", 8),
                new Man("test-10", 10),
                new Man("test-11", 18)
        );

        // old
        List<Man> adults = new ArrayList<>();
        List<Man> children = new ArrayList<>();
        for (Man man : list)
            (man.getAge() < 18 ? children : adults).add(man);
        System.out.println("old:\r\nadults : " + adults +"\r\nchildren" + children);


        // java8 lambda & stream api
        list.stream().filter((e) -> e.getAge() <18).forEach(System.out::println);
        list.stream().map(Man::getName).forEach(System.out::println);
    }

    @Test
    public void testNoParamsNoReturning(){
        new Thread(() -> System.out.println("This is a runnable")).start();
    }

    @Test
    public void testOneParamsNoReturning(){
        Consumer<Man> consumer = (m) -> System.out.println(m);
        consumer.accept(new Man("Lynn",18));
    }

}
