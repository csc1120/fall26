/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week1.section121;

public class Driver {
    static void main() {
        Student s = new Student("Jhon");
        Person p = new Student("Jeorgue");
        System.out.println(p);
        System.out.println();
        ((Student) p).yell();

        Person[] people = new Person[3];
        people[0] = s;
        people[1] = p;
        people[2] = new Teacher("Norbert");
        ((Student) people[2]).yell();
    }
}
