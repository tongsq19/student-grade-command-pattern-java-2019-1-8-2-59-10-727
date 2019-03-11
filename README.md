# 学生成绩单（命令行模式版）

## 使用方法

A 运行程序

1. 使用 git clone 克隆项目到本地/或者下载压缩包到本地
2. 打开 IntelliJ IDEA ，选择 import 或者 open 项目目录，而默认配置导入，
3. 菜单栏：点击 Run -> Run ..., 配置 Run/Debug configuration 面板：
   1. 点击 “+” 选择 Application 
   2. Name: `Unnamed` 换成 `Application`
   3. Main Class: 填入 `com.tw.Application`
   4. Working directory: 填入 `$MODULE_WORKING_DIR$`
   5. Use classpath of module: <no module> 换成 `student-grade-command-pattern-2019-1-8-2-59-10-727-master.main`
   6. 点击 Apply -> 点击 Run

![](https://ws2.sinaimg.cn/large/006tKfTcly1g0z7bynh0xj30t30iawgu.jpg)

B 运行测试

在项目目录下，打开终端并运行

```
$ ./gradlew test
```

出现 BUILD SUCCESSFUL 

## 运行效果

![](https://ws3.sinaimg.cn/large/006tKfTcly1g0z7bplrb0j30uz0a0gmr.jpg)


------


## 练习要求

我们现在做一个应用，该应用是一个命令行应用。当程序启动的时候，我们会看到一个命令行的主界面：

```
1. 添加学生
2. 生成成绩单
3. 退出请输入你的选择（1～3）：
```

如果我们输入1，那么界面就会变成：

```
请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：
```

如果输入格式不正确，就返回：

```
请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：
```

如果输入格式正确就会返回

```
学生xxx的成绩被添加
```

然后打印

```
1. 添加学生
2. 生成成绩单
3. 退出请输入你的选择（1～3）：
```

等于回到了主界面。 
如果我们在主界面输入了2，那么界面就会变成：

```
请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：
```

如果我们输入的不正确，就会打印：

```
请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：
```

如果输入的格式正确，则会打印成绩单并回到主界面。

```
成绩单
姓名|数学|语文|英语|编程|平均分|总分
========================
张三|75|95|80|80|82.5|330
李四|85|80|70|90|81.25|325
========================
全班总分平均数：xxx
全班总分中位数：xxx
```

如果我们输入的学号不存在，该学号在计算时就会被忽略。

## 练习附加要求（选做）

### 改进需求1: 

1. 请引入加分策略：
```
   少数民族 +10分 
   体育特长 +20分 
   艺术特长 +15分
```

如果我们输入1，那么界面就会变成：

```
请输入学生信息（格式：姓名, 学号, 民族, 班级, 学科: 成绩, ...），按回车提交：
```

如果输入格式不正确，就返回：

```
请按正确的格式输入（格式：姓名, 学号, 民族, 班级, 学科: 成绩, ...）：
```

### 改进需求2: 请把每次添加学生信息输出到文件，每次打印成绩单时，从文件读取。画出图和任务列表。

要求：

- 绘制任务分解图
- 绘制基于业务场景的任务分解图（可选）
- 列出任务列表（包含预估完成时间）
- 写测试用例
- 使用TDD
- 使用IDE快捷键代替鼠标的使用

### 输出结果

将个人练习代码库地址提交到教练指定的位置。

代码库需包含：

1. 任务分解图的tasking.md文件
2. 说明如何运行和测试代码的README.md文件
3. 运行结果截图的result.png文件

## 如何开始：

1. `git clone https://github.com/tws-online-quiz/student-grade-command-pattern-java`
2. 打开并修改项目文件，完成练习。

## 学习资源

1. [任务分解](https://www.zybuluo.com/jtong/note/504192)
2. [Gradle基础教程](http://tutorials.jenkov.com/gradle/gradle-tutorial.html)
3. [Java 基础](http://www.runoob.com/java/java-tutorial.html)
4. [Git 参考手册](http://gitref.org/zh/index.html)
5. [Junit](http://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions)
6. [Mockito](http://site.mockito.org/)
