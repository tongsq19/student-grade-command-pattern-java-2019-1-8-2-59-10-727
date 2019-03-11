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
}
