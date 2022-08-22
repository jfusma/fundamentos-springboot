package com.platzi.springboot.fundamentos;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountNumberTest {


    @Test
    public void countNmberTest(){
        Integer arraList [] = {1,1,2,3,1,2,3};
        int arraList1 [] = {1,1,2,3,1,2,3};
        List<Integer> listado =  new ArrayList<>(Arrays.asList(arraList));
        long result = listado.stream().collect(Collectors.toSet()).stream().count();
        System.out.println(result);
        IntStream asd = Arrays.stream( arraList1);
       long result2 = asd.distinct().count();
        System.out.println("resultado 2 " + result2);
    }
}
