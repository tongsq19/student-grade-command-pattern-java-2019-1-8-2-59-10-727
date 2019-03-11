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
        StudentGrade.shell(mock);
        verify(mock).ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n");
    }

    @Test
    public void Scenario2() throws Exception {
        InputHandle mock = mock(InputHandle.class);
        when(mock.ask("1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n")).thenReturn("1").thenReturn("3");

        StudentGrade.shell(mock);
        verify(mock).ask("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n");
    }

}
