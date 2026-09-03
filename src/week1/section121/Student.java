/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week1.section121;

/**
 * A student is actually a person. Who knew?
 */
public class Student extends Person {

    /**
     * Constructor for the Student.
     * @param name the student's name
     */
    public Student(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return name;
    }

    public void yell() {
        System.out.println("AAAAAAAHHHHHHHH!");
    }

}
