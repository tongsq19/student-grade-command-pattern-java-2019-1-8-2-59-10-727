package com.tw;

import java.util.Map;

public class Student {
    private String name;
    private int id;
    private int math;
    private int chinese;
    private int english;
    private int computer;

    public Student(String name, Integer id, Map<String, Integer> grade) {
        this.name = name;
        this.id = id;
        this.math = grade.get("math");
        this.chinese = grade.get("chinese");
        this.english = grade.get("english");
        this.computer = grade.get("computer");
    }

    public String getName() {
        return name;
    }

    public int getId() { return id; }

    public int getMath() { return math;}

    public int getChinese() { return chinese; }

    public int getEnglish() { return english; }

    public int getComputer() { return computer; }

    public double getAver() {
        return getTotal()/4.;
    }

    public int getTotal() {
        return (math + chinese + english + computer);
    }
}
