package com.tw;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class StudentGrade {

    private List<Student> students =  new ArrayList<Student>();

    public void shell(InputHandle console) {
        String answer = console.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n");

        while(! answer.equals("3") ) {
            if (answer.equals("1")) {
                addStudentInfo(console);
            } else if(answer.equals("2")) {
                answer = console.ask("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
                continue;
            }
            answer = console.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n");
        }

        System.out.println("Bye!");
    }

    private void addStudentInfo(InputHandle console) {
        String answer;
        answer = console.ask("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n");
         while (!isFormatValid(answer)) {
            answer = console.ask("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n");
        }

        String name = answer.split(",")[0].trim();
        int id = Integer.parseInt(answer.split(",")[1].trim());

        Map<String, Integer> grade = new HashMap<String, Integer>();
        praseGrade(answer, grade);

        Student student = new Student(name, id, grade);
        students.add(student);
        console.println("学生"+ student.getName() + "的成绩被添加");
    }

    private void praseGrade(String answer, Map<String, Integer> grade) {
        for(String entry: answer.split(",")) {
            if(entry.contains(":")) {
                String[] s = entry.split(":");
                switch (s[0].trim()) {
                    case "数学":
                        grade.put("math", Integer.parseInt(s[1].trim()));
                        break;
                    case "语文":
                        grade.put("chinese", Integer.parseInt(s[1].trim()));
                        break;
                    case "英语":
                        grade.put("english", Integer.parseInt(s[1].trim()));
                        break;
                    case "编程":
                        grade.put("computer", Integer.parseInt(s[1].trim()));
                        break;
                }
            }
        }
    }

    private boolean isaBoolean(String answer) {
        return !answer.contains(",");
    }

    private boolean isFormatValid(String answer) {
        if(!answer.contains(",")) return false;
        if(!answer.contains(":")) return false;
        if(!answer.contains("数学")) return false;
        if(!answer.contains("语文")) return false;
        if(!answer.contains("英语")) return false;
        if(!answer.contains("编程")) return false;

        return true;
    }
}
