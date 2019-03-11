package com.tw;

import java.text.DecimalFormat;
import java.util.*;

public class StudentGrade {

    private List<Student> students =  new ArrayList<Student>();

    public void shell(InputHandle console) {
        String answer = console.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n");

        while(! answer.equals("3") ) {
            if (answer.equals("1")) {
                addStudentInfo(console);
            } else if(answer.equals("2")) {
                printStudentGrade(console);
            }
            answer = console.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n");
        }

        System.out.println("Bye!");
    }

    private void printStudentGrade(InputHandle console) {
        String answer = console.ask("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
        while(isListNotValid(answer)) {
            answer = console.ask("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
        }
        int id = Integer.parseInt(answer);

        StringBuilder transcript = new StringBuilder("成绩单\n姓名|数学|语文|英语|编程|平均分|总分\n========================\n");

        double classAverage = 0;
        double classMedian = 0;

        if(students.size() > 0) {
            int sum  = 0;
            List<Integer> classGrades = new ArrayList<Integer>();

            for (Student s: students) {
                if (s.getId() == id) {
                    transcript.append(s.getName()).append("|").append(s.getMath()).append("|").append(s.getChinese()).append("|")
                            .append(s.getEnglish()).append("|").append(s.getComputer()).append("|").append(s.getAver())
                            .append("|").append(s.getTotal()).append("\n");
                }
                sum += s.getTotal();
                classGrades.add(s.getTotal());
            }

            classAverage = (double)sum/students.size();
            Integer[] classGradeArray = classGrades.toArray(new Integer[students.size()]);
            Arrays.sort(classGradeArray);
            if (students.size() % 2 == 0) {
                classMedian = classGradeArray[students.size()/2-1] + classGradeArray[students.size()/2];
            } else {
                classMedian = classGradeArray[students.size()/2];
            }
        }

        DecimalFormat df = new DecimalFormat("###.#");
        transcript.append("========================\n全班总分平均数：").append(df.format(classAverage)).
                append("\n全班总分中位数：").append(df.format(classMedian)).append("\n");

        console.println(transcript.toString());
    }

    private boolean isListNotValid(String answer) {
        if(!answer.matches("[0-9]+")) return true;
        return false;
    }


    private void addStudentInfo(InputHandle console) {
        String answer;
        answer = console.ask("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n");
         while (!isFormatNotValid(answer)) {
            answer = console.ask("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n");
        }

        String name = answer.split(",")[0].trim();
        int id = Integer.parseInt(answer.split(",")[1].trim());

        Map<String, Integer> grade = new HashMap<String, Integer>();
        praseGrade(answer, grade);

        Student student = new Student(name, id, grade);
        students.add(student);
        console.println("学生"+ student.getName() + "的成绩被添加");
        System.out.println("");
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

    private boolean isFormatNotValid(String answer) {
        if(!answer.contains(",")) return false;
        if(!answer.contains(":")) return false;
        if(!answer.contains("数学")) return false;
        if(!answer.contains("语文")) return false;
        if(!answer.contains("英语")) return false;
        if(!answer.contains("编程")) return false;

        return true;
    }
}
