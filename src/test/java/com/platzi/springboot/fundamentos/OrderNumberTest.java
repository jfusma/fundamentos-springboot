package com.platzi.springboot.fundamentos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class OrderNumberTest {

    //find the first positive value that are missing in the array.
    @Test
    void findMissingOrderNumberListTest() {
        int[] initial = {1, 2, 3, 4, 5, 99, 1};
//        int[] initial = {-1, -2,- 3, -5, -99, -1};
//       int[] initial = {1, 2, -3, 5, -99, 1};
//       int[] initial = {1,2,3,4,5,6,7,8};
        // int[] initial = {-15, 1,5,6,7,8};
        //       int[] initial = {5, 6, 7, 8};
        // write your code in Java SE 8
        int missingOrderNumber = 1;
        int limit = initial.length - 1;
        int start;
        Arrays.sort(initial);
        if (initial[limit] > 0) {
            start = initial[0];
            for (int x = 0; x < limit; x++) {
                if (start < 0) {
                    //negative values
                    start = initial[x + 1];
                    continue;
                }

                if ((initial[x + 1] - start) > 1) {
                    missingOrderNumber = missingOrderNumber + start;
                    break;
                }
                if ((initial[x + 1] - start) == 1 || (initial[x + 1] - start) == 0) {
                    start = initial[x + 1];
                }
                //  System.out.println("record " + x + "- value=" + initial[x]);
            }
            if ((initial[0] > 0 && initial[0] != 1)) {
                missingOrderNumber = 1;
            } else if (missingOrderNumber == 1) {
                missingOrderNumber = initial[limit] + 1;
            }
        }
        System.out.println("result " + missingOrderNumber);
        Assertions.assertNotEquals(missingOrderNumber, 0);
    }

    @Test
    void putAllZerosToTheFinal() {

        int counter = 0;
        int numberOfZeros = 0;
        //int[] arrayInts = {1, 2, 0, 4, 3, 0, 5, 0};
        // int[] arrayInts = {0,1, 0,0};
        int[] arrayInts = {4, 1, 9, 687};
        Arrays.sort(arrayInts);
        for (int i = 0; i < arrayInts.length; i++) {
            if (arrayInts[i] != 0) {
                arrayInts[counter++] = arrayInts[i];
            } else {
                numberOfZeros++;
            }
        }
        while (numberOfZeros > 0) {
            arrayInts[counter++] = 0;
            numberOfZeros--;
        }
        Arrays.stream(arrayInts).forEach(System.out::println);

    }

}

