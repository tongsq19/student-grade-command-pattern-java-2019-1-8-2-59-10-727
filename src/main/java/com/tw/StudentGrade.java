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

        while(true) {
            try {
                toPrintStudentGrade(console, answer);
                break;
            } catch (Exception e) {
                answer = console.ask("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
            }
        }
    }

    private void toPrintStudentGrade(InputHandle console, String answer) {
        StringBuilder transcript = new StringBuilder("成绩单\n姓名|数学|语文|英语|编程|平均分|总分\n========================\n");

        for(String idStr :answer.split(",") ) {
            int id = Integer.parseInt(idStr.trim());
            for (Student s: students) {
                if (s.getId() == id) {
                    transcript.append(s.getName()).append("|").append(s.getMath()).append("|").append(s.getChinese())
                            .append("|").append(s.getEnglish()).append("|").append(s.getComputer()).append("|")
                            .append(s.getAver()).append("|").append(s.getTotal()).append("\n");
                }
            }
        }

        double classAverage = 0;
        double classMedian = 0;

        int number = students.size();

        if(number > 0) {
            List<Integer> classGrades = new ArrayList<Integer>();

            int sum  = 0;
            for (Student s: students) {
                classGrades.add(s.getTotal());
                sum += s.getTotal();
            }

            Integer[] gradeArray = classGrades.toArray(new Integer[number]);
            Arrays.sort(gradeArray);

            if (number % 2 == 0) {
                classMedian = 0.5*(gradeArray[number /2-1] + gradeArray[number /2]);
            } else {
                classMedian = gradeArray[number /2];
            }

            classAverage = (double)sum/ number;
        }

        DecimalFormat df = new DecimalFormat("###.#");
        transcript.append("========================\n全班总分平均数：").append(df.format(classAverage)).
                append("\n全班总分中位数：").append(df.format(classMedian)).append("\n");

        console.println(transcript.toString());
    }


    private void addStudentInfo(InputHandle console) {
        String answer;
        answer = console.ask("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n");

        while(true) {
            try {
                toAddStudentInfo(console, answer);
                break;
            } catch(Exception e){
                answer = console.ask("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n");
            }
        }
    }

    private void toAddStudentInfo(InputHandle console, String answer) {
        String name = answer.split(",")[0].trim();

        int id = Integer.parseInt(answer.split(",")[1].trim());
        Map<String, Integer> grade = new HashMap<String, Integer>();
        praseGrade(answer, grade);

        Student student = new Student(name, id, grade);

        students.add(student);

        console.println("学生" + student.getName() + "的成绩被添加");

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

}
