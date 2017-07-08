package com.ja0ck5.java8;

import com.ja0ck5.java8.model.Man;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Jack on 2017/6/19.
 */
public class StreamTest {

    List<Man> men = Arrays.asList(new Man("one-man", 19, Man.Status.SHORT), new Man("NONO", 21, Man.Status.SHORT),
            new Man("MOMO", 39, Man.Status.SHORT), new Man("HEHE", 29, Man.Status.TALL),
            new Man("HAHA", 22, Man.Status.SHORT), new Man("one", 23, Man.Status.TALL));

    @Test
    public void testSimpleMan() {
        OptionalDouble average = men.stream().filter(man -> man.getStatus() == Man.Status.TALL).mapToInt(Man::getAge)
                .average();
        System.out.println("average age : " + average.getAsDouble());

        final double totalAge = men.stream().parallel().map(Man::getAge/*man -> man.getAge()*/) // or Man::getAge
                .reduce(0, Integer::sum);
        System.out.println("totalAge:" + totalAge);

        men.stream().collect(Collectors.groupingBy(Man::getStatus)).forEach((k, v) -> System.out.println("Item : " + k + " Man : " + v));
    }

    @Test
    public void testStream() {
        List<Integer> list = new ArrayList<>();
        Stream<Integer> stream = list.stream();

        Man[] array = new Man[10];
        Stream<Man> arrayStream = Arrays.stream(array);

        Stream<String> stringStream = Stream.of("a", "d", "c", "f");

        Stream<Integer> iterateStream = Stream.iterate(0, (x) -> x + 2);
        iterateStream/*.limit(10)*/.forEach(System.out::println);

        Stream<Double> doubleStream = Stream.generate(() -> Math.random());

    }


    @Test
    public void testStream2() {
        men.stream().filter(e -> {
            System.out.println("opt in middle");
            return e.getAge() > 19;
        }).forEach(System.out::println);
    }

    @Test
    public void testStreamMap() {

        List<String> strings = Arrays.asList("a", "b", "c", "d");

        strings.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
    }

}
