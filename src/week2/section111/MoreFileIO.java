/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week2.section111;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MoreFileIO {
    static void main() {
        Path dataPath = Paths.get("data", "data.bin");
        try(DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(dataPath.toFile()));
                DataInputStream dis = new DataInputStream(
                        new FileInputStream(dataPath.toFile())
                )) {
            dos.writeInt(5);
            dos.writeDouble(7.142);
            dos.writeUTF("hello");

            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
            System.out.println(dis.readUTF());
        } catch(IOException e) {
            System.out.println("can't write: " + e.getMessage());
        }

        Path objectPath = Paths.get("data", "object.bin");
        try(ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(objectPath.toFile()));
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream(objectPath.toFile()))) {
            MyObj obj = new MyObj(5, "hello");
            oos.writeObject(obj);

            MyObj obj2 = (MyObj) ois.readObject();
            System.out.println(obj2);
        } catch(IOException e) {
            System.out.println("oops");
        } catch (ClassNotFoundException e) {
            System.out.println("wrong class");
        }
    }
}
