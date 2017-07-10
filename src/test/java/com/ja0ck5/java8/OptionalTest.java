package com.ja0ck5.java8;

import com.ja0ck5.java8.model.Man;
import org.junit.Test;

import javax.xml.transform.Source;
import java.util.Optional;

import static com.ja0ck5.java8.model.Man.*;

/**
 * Created by Ja0ck5 on 2017/7/10.
 */
public class OptionalTest {

    @Test
    public void testOptional() {
        Optional<Man> optional = Optional.of(new Man());
        System.out.println(optional);
        //nullPointerException
        Optional<Man> nullOptional = Optional.of(null);
    }

    @Test
    public void testOptionalEmpty() {
        Optional<Man> optional = Optional.empty();
        // java.util.NoSuchElementException: No value present
        System.out.println(optional.get());
    }

    @Test
    public void testOptionalNullable() {
        Optional<Man> optional = Optional.ofNullable(new Man());
        System.out.println(optional.get());
        Optional<Man> nullOptional = Optional.ofNullable(null);

        // java.util.NoSuchElementException: No value present when
//            System.out.println(nullOptional.get());
        if (nullOptional.isPresent()) {// false
            System.out.println(nullOptional.get());
        }

        Man man = nullOptional.orElse(new Man("Nam-1", 19));
        Man man2 = optional.orElse(new Man("Nam-1", 19));
        System.out.println(man);
        System.out.println(man2);

        Man man3 = optional.orElseGet(() -> born(Man::new));
        System.out.println(man3);

    }

    @Test
    public void testMapAndFlatMap(){
        Optional<Man> optional = Optional.ofNullable(new Man("Nam-1", 19));
        Optional<String> s = optional.map(e -> e.getName());
        System.out.println(s.get());

        Optional<String> stringOptional = optional.flatMap(e -> Optional.of(e.getName()));
        System.out.println(stringOptional.get());
    }

}
