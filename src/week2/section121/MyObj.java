/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week2.section121;

import java.io.Serializable;

public class MyObj implements Serializable {
    private int num;
    private String str;

    public MyObj(int num, String str) {
        this.num = num;
        this.str = str;
    }

    @Override
    public String toString() {
        return num + " " + str;
    }
}
