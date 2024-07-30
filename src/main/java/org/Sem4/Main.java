package org.Sem4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat(Male.MALE);
        Cat cat2 = new Cat(Male.FEMALE);
        Cat cat3 = new Cat(Male.MALE);
//        Cat cat4 = new Cat("Banan");

        Cat[] cats = {cat1, cat2, cat3};

        List<Cat> catList = Arrays.asList(cats);

        for (Cat cat : cats) {
            switch (cat.getMale()) {
                case MALE -> System.out.println("cat - boy");
                case FEMALE -> System.out.println("cat - girl");
            }
        }

        System.out.println("************************");
        for (Cat cat : catList) {
            System.out.println(cat.getMale().getRuMaleTitle());
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Run!");
            }
        };

        Runnable runnable1 = () -> System.out.println("Run!");

        runnable.run();
        runnable1.run();

        BiFunction<Integer, Integer, String> biFunction = new BiFunction<Integer, Integer, String>() {
            @Override
            public String apply(Integer a, Integer b) {
                return String.format("%s + %s = %s", a, b, (a + b));
            }
        };

        BiFunction<Integer, Integer, String> biFunction1 = (a, b) -> String.format("%s + %s = %s", a, b, (a + b));

        System.out.println(biFunction.apply(5, 7));
        System.out.println(biFunction1.apply(5, 3));
    }
}
