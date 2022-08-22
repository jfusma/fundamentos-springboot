package com.platzi.springboot.fundamentos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class FunctionTest {

    protected static class MyMath {
        public static Integer add(Integer x, Integer y) {
            return x + y;
        }

        public static Integer combineValues(BiFunction<Integer, Integer, Integer> combine) {
            return combine.apply(2, 3);
        }
    }
    @Test
    void test_Bifunction(){
       Integer result =  MyMath.combineValues(MyMath::add);
        System.out.println("result " + result);
        System.out.println(MyMath.combineValues((x, y) -> 9* x + 2 * y));
        Assertions.assertTrue(result>=0);
    }

    @Test
    void reduceTest(){
        Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));

        BinaryOperator<Integer> getSum = (acc, x) -> {
            Integer result = acc + x;
            System.out.println("acc: " + acc + ", x: " + x + ", result: " + result);
            return result;
        };

        Integer sum = listOfIntegers
                .stream()
                .reduce(1, getSum);

        System.out.println(sum);
    }

    static boolean exists(int[] ints, int k) {
         return Arrays.stream(ints).filter(ob -> {return ob == k;}).findAny().isPresent();

    }
}
