package com.ja0ck5.java8;

import org.junit.Test;

import java.util.Arrays;

import static java.util.concurrent.ThreadLocalRandom.*;

/**
 * Created by Jack on 2017/6/20.
 */
public class ParallelTest {

    @Test
	public void testParallelArrays() {
		long[] arrayOfLong = new long[20000];
		Arrays.parallelSetAll(arrayOfLong, index -> current().nextInt(1000000));
		Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();

		Arrays.parallelSort(arrayOfLong);
		Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();
	}

}
