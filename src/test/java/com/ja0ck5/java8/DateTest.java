package com.ja0ck5.java8;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.*;

/**
 * Created by Ja0ck5 on 2017/7/10.
 */
public class DateTest {

    @Test
    public void testSimpleDateFormat() throws ExecutionException, InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Callable<Date> callable = () -> simpleDateFormat.parse("20170710");

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<Date>> futures = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            futures.add(pool.submit(callable));
        }

        for (Future<Date> future : futures) {
            /**
             * java.util.concurrent.ExecutionException: java.lang.NumberFormatException: For input string: ""

             at java.util.concurrent.FutureTask.report(FutureTask.java:122)
             at java.util.concurrent.FutureTask.get(FutureTask.java:192)
             at com.ja0ck5.java8.DateTest.testSimpleDateFormat(DateTest.java:30)
             at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
             at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
             at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
             at java.lang.reflect.Method.invoke(Method.java:498)
             at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
             at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
             at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
             at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
             at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
             at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
             at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
             at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
             at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
             at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
             at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
             at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
             at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
             at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
             at org.junit.runner.JUnitCore.run(JUnitCore.java:115)
             at org.junit.vintage.engine.execution.RunnerExecutor.execute(RunnerExecutor.java:43)
             at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
             at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:193)
             at java.util.Iterator.forEa
             */
            System.out.println(future.get());
        }
        pool.shutdown();

    }


    @Test
    public void testLocalDate() throws ExecutionException, InterruptedException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        Callable<LocalDate> callable = () -> LocalDate.parse("20170711", dateTimeFormatter);

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<LocalDate>> futures = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            futures.add(pool.submit(callable));
        }

        for (Future<LocalDate> future : futures) {
            System.out.println(future.get());
        }
        pool.shutdown();


    }
}
