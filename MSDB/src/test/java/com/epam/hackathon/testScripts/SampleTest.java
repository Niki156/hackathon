package com.epam.hackathon.testScripts;

import org.testng.annotations.Test;

public class SampleTest {

    @Test(alwaysRun = true)
    public void test(){
        System.out.println("hello");
    }

    @Test()
    public void anotherTest(){
        System.out.println("Hackathon");
    }
    @Test()
    public void another(){
        System.out.println("Hey Leela and Nikhil");
    }
}
