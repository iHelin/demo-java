package me.ianhe.test;

import java.io.Serializable;

public class Person implements Serializable {

    public String name;
    public String address;
    public transient int SSN;
    public int number;

    public void mailCheck() {
        System.out.println("Mailing a check to " + name + " " + address);
    }
}
