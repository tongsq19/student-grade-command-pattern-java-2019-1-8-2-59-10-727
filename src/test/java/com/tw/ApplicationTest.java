package com.tw;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class ApplicationTest {
    @Test
    public void Scenario1() throws Exception {
        InputHandle mock = mock(InputHandle.class);
        when(mock.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n")).thenReturn("3");
        (new StudentGrade()).shell(mock);
        verify(mock).ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n");
    }

    @Test
    public void Scenario2() throws Exception {
        InputHandle mock = mock(InputHandle.class);
        when(mock.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n")).thenReturn("1").thenReturn("3");
        when(mock.ask("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n")).thenReturn("张三, 1, 数学: 75, 语文: 95, 英语: 80, 编程: 80");

        (new StudentGrade()).shell(mock);

        verify(mock,times(2)).ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n");
        verify(mock).ask("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n");
    }

    @Test
    public void Scenario3() throws Exception {
        InputHandle mock = mock(InputHandle.class);
        when(mock.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n")).thenReturn("2").thenReturn("3");
        when(mock.ask("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n")).thenReturn("3");

        (new StudentGrade()).shell(mock);

        verify(mock).ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n");
        verify(mock).ask("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
    }

    @Test
    public void Scenario4() throws Exception {
        InputHandle mock = mock(InputHandle.class);
        when(mock.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n")).thenReturn("1").thenReturn("3");
        when(mock.ask("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n")).thenReturn("张三");
        when(mock.ask("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n")).thenReturn("张三, 1, 数学: 75, 语文: 95, 英语: 80, 编程: 80");

        (new StudentGrade()).shell(mock);

        verify(mock, times(2)).ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n");
        verify(mock).ask("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n");
        verify(mock).ask("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n");
    }

    @Test
    public void Scenario5() throws Exception {
        InputHandle mock = mock(InputHandle.class);
        when(mock.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n")).thenReturn("1").thenReturn("3");
        when(mock.ask("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n")).thenReturn("张三, 1, 数学: 75, 语文: 95, 英语: 80, 编程: 80");

        (new StudentGrade()).shell(mock);

        verify(mock, times(2)).ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n");
        verify(mock).ask("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n");
        verify(mock).println("学生张三的成绩被添加");
    }
}
