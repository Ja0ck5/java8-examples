package com.ja0ck5.java8;

import com.ja0ck5.java8.model.Man;
import org.junit.Test;

import java.util.*;
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
        System.out.println("old:\r\nadults : " + adults + "\r\nchildren" + children);


        // java8 lambda & stream api
        list.stream().filter((e) -> e.getAge() < 18).forEach(System.out::println);
        list.stream().map(Man::getName).forEach(System.out::println);
    }

    @Test
    public void testNoParamsNoReturning() {
        new Thread(() -> System.out.println("This is a runnable")).start();
    }

    @Test
    public void testOneParamsNoReturning() {
        Consumer<Man> consumer = (m) -> System.out.println(m);
        consumer.accept(new Man("Lynn", 18));

        Consumer<Man> con = m -> System.out.println(m);
        con.accept(new Man("Ja0ck5", 18));
    }

    @Test
    public void testMultiParamsAndHasReturning() {


        Comparator<Integer> comparator = (a, b) -> {
            System.out.println("===========");
            return Integer.compare(a, b);
        };

        TreeSet<Integer> setOne = new TreeSet<>(comparator);
        setOne.add(20);
        setOne.add(10);
        setOne.add(50);
        setOne.add(110);
        System.out.println(setOne);

        Comparator<Integer> comparatorOmitted = (a, b) -> Integer.compare(a,b);

        TreeSet<Integer> set = new TreeSet<>(comparatorOmitted);
        set.add(2);
        set.add(1);
        set.add(5);
        set.add(0);
        System.out.println(set);
    }

}
