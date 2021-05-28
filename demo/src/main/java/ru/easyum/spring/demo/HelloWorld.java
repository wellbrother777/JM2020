package ru.easyum.spring.demo;

public class HelloWorld {

    @Override
    public String toString() {
        return "HelloWorld from spring bean!";
    }

    public String printMe() {
        return "Hello world from method of spring bean!";
    }
}
