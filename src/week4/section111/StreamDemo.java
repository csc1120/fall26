/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week4.section111;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    static void main() {
        String[] words = {"hello", "hi", "salutations", "hola", "hallo",
                "greetings", "gute", "yoyoyoyyo", "go away", "goodbye"};
        List<String> wordList = Arrays.asList(words);
        List<String> result = wordList.stream().filter(s -> s.length() > 5)
                .map(s -> s.replace('o', 'O'))
                .collect(Collectors.toList());
        System.out.println(result);
        int total = wordList.stream().mapToInt(String::length).sum();
        System.out.println(total);

    }
}
