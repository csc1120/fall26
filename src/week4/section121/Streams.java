/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week4.section121;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    static void main() {
        String[] words = {"goodbye", "see ya", "ciao", "see you later alligator", "bye",
            "in a while", "later", "adios", "deuces", "peace out", "hasta la vista, baby"};
        List<String> wordlist = Arrays.asList(words);
        List<String> result = wordlist.stream().filter(s -> s.length() > 5)
                .map(s -> s.replace('o', 'O'))
                .collect(Collectors.toList());
        System.out.println(result);
        int total = wordlist.stream().mapToInt(String::length)
                .sum();
        System.out.println(total);
//        wordlist.parallelStream()
    }
}
