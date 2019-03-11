package com.tw;

public class Application {
    public static void main(String[] args) {
        StudentGrade studentGrade = new StudentGrade();
        studentGrade.shell(new InputHandle(System.in, System.out));
    }
}
