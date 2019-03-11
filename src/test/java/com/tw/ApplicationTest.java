package com.tw;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class ApplicationTest {
    @Test
    public void Scenario1() throws Exception {
        //主菜单
        InputHandle mock = mock(InputHandle.class);
        when(mock.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n")).thenReturn("3");
        (new StudentGrade()).shell(mock);
        verify(mock).ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n");
    }

    @Test
    public void Scenario2() throws Exception {
        //添加学生菜单
        InputHandle mock = mock(InputHandle.class);
        when(mock.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n")).thenReturn("1").thenReturn("3");
        when(mock.ask("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n")).thenReturn("张三, 1, 数学: 75, 语文: 95, 英语: 80, 编程: 80");

        (new StudentGrade()).shell(mock);

        verify(mock).ask("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n");
    }

    @Test
    public void Scenario3() throws Exception {
        //生成成绩单菜单
        InputHandle mock = mock(InputHandle.class);
        when(mock.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n")).thenReturn("2").thenReturn("3");
        when(mock.ask("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n")).thenReturn("3");

        (new StudentGrade()).shell(mock);

        verify(mock).ask("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
    }

    @Test
    public void Scenario4() throws Exception {
        //添加学生，格式错误
        InputHandle mock = mock(InputHandle.class);
        when(mock.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n")).thenReturn("1").thenReturn("3");
        when(mock.ask("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n")).thenReturn("张三");
        when(mock.ask("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n")).thenReturn("张三, 1, 数学: 75, 语文: 95, 英语: 80, 编程: 80");

        (new StudentGrade()).shell(mock);

        verify(mock).ask("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n");
    }

    @Test
    public void Scenario5() throws Exception {
        //添加学生，格式正确
        InputHandle mock = mock(InputHandle.class);
        when(mock.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n")).thenReturn("1").thenReturn("3");
        when(mock.ask("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n")).thenReturn("张三, 1, 数学: 75, 语文: 95, 英语: 80, 编程: 80");

        (new StudentGrade()).shell(mock);


        verify(mock).println("学生张三的成绩被添加");
    }


    @Test
    public void Scenario6() throws Exception {
        //添加学生，格式正确但是交换学科顺序
        InputHandle mock = mock(InputHandle.class);
        when(mock.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n")).thenReturn("1").thenReturn("3");
        when(mock.ask("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n")).thenReturn("张三, 1, 语文: 95, 数学: 75, 英语: 80, 编程: 80");

        (new StudentGrade()).shell(mock);

        verify(mock).println("学生张三的成绩被添加");
    }

    @Test
    public void Scenario7() throws Exception {
        //生成单个学生成绩，输入错误
        InputHandle mock = mock(InputHandle.class);
        when(mock.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n")).thenReturn("1").thenReturn("2").thenReturn("3");
        when(mock.ask("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n")).thenReturn("张三, 1, 语文: 95, 数学: 75, 英语: 80, 编程: 80");
        when(mock.ask("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n")).thenReturn("");
        when(mock.ask("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n")).thenReturn("1");

        (new StudentGrade()).shell(mock);

        verify(mock).ask("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
    }

    @Test
    public void Scenario8() throws Exception {
        //生成单个学生成绩，格式正确，学号正确
        InputHandle mock = mock(InputHandle.class);
        when(mock.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n")).thenReturn("1").thenReturn("2").thenReturn("3");
        when(mock.ask("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n")).thenReturn("张三, 1, 数学: 75, 语文: 95, 英语: 80, 编程: 80");
        when(mock.ask("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n")).thenReturn("1");

        (new StudentGrade()).shell(mock);
        verify(mock).println("学生张三的成绩被添加");
        verify(mock).println("成绩单\n姓名|数学|语文|英语|编程|平均分|总分\n========================\n张三|75|95|80|80|82.5|330\n========================\n全班总分平均数：330\n全班总分中位数：330\n");
    }

    @Test
    public void Scenario9() throws Exception {
        //生成单个学生成绩，格式正确，学号查询不到
        InputHandle mock = mock(InputHandle.class);
        when(mock.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n")).thenReturn("1").thenReturn("2").thenReturn("3");
        when(mock.ask("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n")).thenReturn("张三, 1, 数学: 75, 语文: 95, 英语: 80, 编程: 80");
        when(mock.ask("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n")).thenReturn("2");

        (new StudentGrade()).shell(mock);
        verify(mock).println("学生张三的成绩被添加");
        verify(mock).println("成绩单\n姓名|数学|语文|英语|编程|平均分|总分\n========================\n========================\n全班总分平均数：330\n全班总分中位数：330\n");
    }

    @Test
    public void Scenario10() throws Exception {
        //生成多个学生成绩，格式正确
        InputHandle mock = mock(InputHandle.class);
        when(mock.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n")).thenReturn("1").thenReturn("2").thenReturn("3");
        when(mock.ask("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n")).thenReturn("张三, 1, 数学: 75, 语文: 95, 英语: 80, 编程: 80")
        .thenReturn("李四, 2, 数学: 85, 语文: 80, 英语: 70, 编程: 90");
        when(mock.ask("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n")).thenReturn("1, 2");

        (new StudentGrade()).shell(mock);
        verify(mock).println("学生张三的成绩被添加");
        verify(mock).println("成绩单\n姓名|数学|语文|英语|编程|平均分|总分\n========================\n张三|75|95|80|80|82.5|330\n李四|85|80|70|90|81.25|325\n========================\n全班总分平均数：327.5\n全班总分中位数：327.5\n");
    }
}
