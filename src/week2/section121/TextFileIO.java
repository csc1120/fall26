/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week2.section121;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TextFileIO {
    static void main() {
        // relative path
        File file = new File("data/Words.txt");
//        System.out.println(file.length());
        Path path = Paths.get("data", "moreData", "Words.txt");
        file = path.toFile();
        path = file.toPath();

//        Scanner in = null;
//        try {
//            in = new Scanner(file);
//            int i = 0;
//            while(in.hasNextLine()) {
//                System.out.println(++i + ": " + in.nextLine());
//            }
//        } catch(FileNotFoundException e) {
//            System.out.println("can't find file");
//        } finally {
//            in.close();
//        }

        // AutoCloseable must be implemented
        try(Scanner in = new Scanner(path)) {

        } catch (IOException e) {
            System.out.println("can't find file");
        }

        Path newFile = Paths.get("data", "test.txt");
        try(PrintWriter pw = new PrintWriter(newFile.toFile())) {
            pw.println("Hello!");
            pw.println(5);
            pw.println(3.78);
            pw.printf("%d%n", 9);
        } catch(FileNotFoundException e) {
            System.out.println("can't write file");
        }

        try(PrintWriter pw =
                    new PrintWriter(
                            new FileWriter(newFile.toFile(), true))) {
            pw.println("I append!");
        } catch (FileNotFoundException e) {
            System.out.println("can't write to file");
        } catch(IOException e) {
            System.out.println("IOException occurred");
        }
    }
}
