package com.ja0ck5.java8;

import com.ja0ck5.java8.model.Man;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jack on 2017/6/19.
 */
public class ReferenceTest {

	/**
	 * 方法引用
	 */
	@Test
	public void testManBorn() {
		/**
		 * 构造器引用 Class::new || Class<T>::new
		 */
		Man man = Man.born(Man::new);
		List<Man> mans = Arrays.asList(man);

		/**
		 * 静态方法引用 Class::static_method
		 */
		mans.forEach(Man::grow);

		/**
		 * 特定类的任意对象的方法引用，Class::method
		 */
		mans.forEach(Man::die);

		/**
		 * 特定对象的方法引用，instance::method
		 */
        Man man1 = Man.born(Man::new);
        mans.forEach(man1::sick/*sick method 接收 Man 类型参数*/);
    }

}
