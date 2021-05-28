package ru.easyum.spring;

public class HelloWorld {

    @Override
    public String toString() {
        return "HelloWorld from spring bean!";
    }

    public String printMe() {
        return "Hello world from method of spring bean!";
    }
}
