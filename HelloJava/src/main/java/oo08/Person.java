package oo08;

public class Person {
    private String name;
    private int birthday;

    public String getName() {
        return name;
    }

    public int getAge() {
        return 2021 - birthday;
    }
}