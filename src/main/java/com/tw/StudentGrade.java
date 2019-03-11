package com.tw;

import java.util.Objects;

public class StudentGrade {

    public static void main(String[] args) {
        shell(new InputHandle(System.in, System.out));
    }

    public static void shell(InputHandle console) {
        String answer = console.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n");

        while(! answer.equals("3") ) {
            if (answer.equals("1")) {
                answer = console.ask("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n");
            } else if(answer.equals("2")) {
                answer = console.ask("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
            } else {
                answer = console.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n");
            }
        }

        System.out.println("Bye!");
    }
}
