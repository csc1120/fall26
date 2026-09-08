/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week2.section111;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TextFileIO {
    static void main() {
        // Absolute Path
        // C:\Program Files\Java\java-sdk-25.0.2\lib\javafx.jar
        File file = new File("data/Words.txt");
        Path path = Paths.get("data",  "textfiles", "Words.txt");
        file = path.toFile();
        path = file.toPath();
//        System.out.println(file.length());
//        Scanner in = null;
//        try {
//            in = new Scanner(file);
//            int i = 0;
//            while(in.hasNextLine()) {
//                System.out.println(++i + ": " + in.nextLine());
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("Can't find files");
//        } finally {
//            in.close();
//        }

        // stream must is AutoCloseable
        // implements AutoCloseable
        try(Scanner in = new Scanner(path)) {
            // read from file
        } catch(IOException e) {
            System.out.println("Can't find file");
        }

        Path newFile = Paths.get("data", "test.txt");

        try(PrintWriter pw = new PrintWriter(newFile.toFile())) {
            pw.println("Here is my first line of text.");
            pw.println(6);
            pw.println(7.32);
            pw.printf("%d%n", 8);
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file.");
        }

        try(Scanner in = new Scanner(newFile)) {
            while(in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        } catch(IOException e) {
            System.out.println("Can't open file");
        }

        // append to end of a text file
//        PrintWriter pw = new PrintWriter(
//                new FileWriter(newFile.toFile()));
    }
}
