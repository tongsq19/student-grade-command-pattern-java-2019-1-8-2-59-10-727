package com.tw;

import java.util.Objects;

public class StudentGrade {

    public static void main(String[] args) {
        shell(new InputHandle(System.in, System.out));
    }

    public static void shell(InputHandle console) {
        String answer = console.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n");

        while(! answer.equals("3") ) {
            answer = console.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n");
        }

        System.out.println("Bye!");
    }
}
