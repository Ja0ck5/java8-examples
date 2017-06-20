package com.ja0ck5.java8;

import com.ja0ck5.java8.model.Man;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Jack on 2017/6/19.
 */
public class StreamTest {

	@Test
	public void testSimpleMan() {
		List<Man> men = Arrays.asList(new Man("one-man", 19, Man.Status.SHORT), new Man("NONO", 21, Man.Status.SHORT),
				new Man("MOMO", 39, Man.Status.SHORT), new Man("HEHE", 29, Man.Status.TALL),
				new Man("HAHA", 22, Man.Status.SHORT), new Man("one", 23, Man.Status.TALL));
		OptionalDouble average = men.stream().filter(man -> man.getStatus() == Man.Status.TALL).mapToInt(Man::getAge)
				.average();
		System.out.println("average age : "+average.getAsDouble());

		final double totalAge = men.stream().parallel().map(Man::getAge/*man -> man.getAge()*/) // or Man::getAge
				.reduce(0, Integer::sum);
        System.out.println("totalAge:"+totalAge);

        men.stream().collect(Collectors.groupingBy(Man::getStatus)).forEach((k,v)->System.out.println("Item : " + k + " Man : " + v));

	}

}
