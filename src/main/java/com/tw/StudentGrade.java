package com.tw;

public class StudentGrade {

    public static void main(String[] args) {
        shell(new InputHandle(System.in, System.out));
    }

    public static void shell(InputHandle console) {
        console.ask("hello?");
    }
}
