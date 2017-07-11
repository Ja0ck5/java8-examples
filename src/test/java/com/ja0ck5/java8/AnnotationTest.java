package com.ja0ck5.java8;

import com.ja0ck5.java8.myAnnotation.MyAnnotation;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by Ja0ck5 on 2017/7/12.
 */
public class AnnotationTest {

    @Test
    public void testAnnotation() throws NoSuchMethodException {

        Class<AnnotationTest> clazz = AnnotationTest.class;
        Method clazzMethod = clazz.getMethod("show");
        Annotation[] annotations = clazzMethod.getAnnotations();
        for (Annotation annotation : annotations) {
            //@com.ja0ck5.java8.myAnnotation.MyAnnotations(value=[@com.ja0ck5.java8.myAnnotation.MyAnnotation(value=Haha), @com.ja0ck5.java8.myAnnotation.MyAnnotation(value=Happy)])
            System.out.println(annotation);
        }

        MyAnnotation[] annotationsByType = clazzMethod.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation ma : annotationsByType){
            System.out.println(ma);
        }
    }

    @MyAnnotation("Haha")
    @MyAnnotation("Happy")
    public void show() {
    }

}
