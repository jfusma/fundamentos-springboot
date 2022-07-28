package com.platzi.springboot.fundamentos;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ProcessesWordTest {

@Test
    public void processWordTest1(){
    String[] wordsArr = {"hello", "apple", "functional", "programming", "is", "cool"};
    List<String> words = new ArrayList<>(Arrays.asList(wordsArr));

    List<String> processedWords = words
            .parallelStream()
            .map((word) -> {
                System.out.println("Uppercasing " + word);
                return word.toUpperCase();
            })
            .map((word) -> {
                System.out.println("Adding exclamation point to " + word);
                return word + "!";
            })
            .collect(Collectors.toList());

    System.out.println(processedWords);

}
}
