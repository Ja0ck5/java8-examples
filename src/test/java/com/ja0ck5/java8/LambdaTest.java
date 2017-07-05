package com.ja0ck5.java8;

import com.ja0ck5.java8.functional.ServiceFunction;
import com.ja0ck5.java8.model.Man;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

    List<Man> list = Arrays.asList(
            new Man("test-1", 15),
            new Man("test-2", 16),
            new Man("test-3", 17),
            new Man("test-4", 18),
            new Man("test-5", 19),
            new Man("test-6", 28),
            new Man("test-7", 8),
            new Man("test-8", 8),
            new Man("test-9", 8),
            new Man("test-10", 10),
            new Man("test-11", 18)
    );


    @Test
    public void testCollections(){

        Collections.sort(list,(e1,e2)->{
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });

        list.forEach(System.out::println);
    }

    @Test
    public void testTwoPServiceFuntion(){
        System.out.println(service(10L,12L,(x,y) -> x+y));
    }

    public Long service(Long l1, Long l2, ServiceFunction<Long ,Long> sf){
        return sf.service(l1,l2);
    }

    /**
     * Consumer<T>
     */
    @Test
    public void testFunctionalInterfaceConsumer(){
        consume("this message may be consume",(msg) -> System.out.println(msg+",this is a truth"));
    }

    public void consume(String msg,Consumer<String> con){
        con.accept(msg);
    }

    /**
     * Supplier<T>
     */
    @Test
    public void testFunctionalInterfaceSupplier(){
        genNums(10,() -> new Random().nextInt(100)).forEach(System.out::println);
    }

    public List<Integer> genNums(int num, Supplier<Integer> sup){
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i=0;i<num;i++){
            Integer n = sup.get();
            integers.add(n);
        }
        return integers;
    }

    /**
     * Function<T,R>
     */
    @Test
    public void testFunctionalInterfaceFunction(){
        Integer i = str2Int("10", s -> Integer.parseInt(s));
        System.out.println(i);
    }

    public Integer str2Int(String s, Function<String,Integer> fun){
        return fun.apply(s);
    }

    /**
     * Predicate<T>
     */
    @Test
    public void testFunctionalInterfacePredicate(){
        optList(list,x -> x.getAge() > 8).forEach(System.out::println);
    }

    public List<Man> optList(List<Man> list, Predicate<Man> pre){
        ArrayList<Man> nl = new ArrayList<>(list.size());
        list.forEach(e -> {
            if(pre.test(e)){
                nl.add(e);
            }
        });

        return nl;
    }
}
