

## 任务分解(基本版)


Scenario1: 主菜单  
    Given []  
    When 命令行应用  
    Then 显示主菜单
```
[
    "1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n"
]
```

Scenario2: 添加学生菜单  
    Given [1]  
    When 命令行应用  
    Then 进入添加学生菜单。 
```
[
    "1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n", 
    "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n"
]
```

Scenario3: 生成成绩单菜单  
    Given [2]  
    When 命令行应用  
    Then 进入生成成绩单菜单
```
[
    "1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n", 
    "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n"
]
```    
 
Scenario4: 添加学生，格式错误  
    Given [1, ""]  
    When 命令行应用  
    Then 添加学生失败，
```
[
    "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n", 
    "请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n"
]
```

Scenario5: 添加学生，格式正确  
    Given [1, "张三, 1, 数学: 75, 语文: 95, 英语: 80, 编程: 80"]    
    When 命令行应用  
    Then 成功添加学生 
```
[
    "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n",
    "学生张三的成绩被添加\n",
    "1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n",
]
```    

Scenario6: 添加学生，格式正确但是交换学科顺序  
    Given [1, "张三, 1, 数学: 75, 英语: 80, 语文: 95, 编程: 80"]    
    When 命令行应用  
    Then 成功添加学生 ["请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n" "学生张三的成绩被添加\n"]   

 ```
 [
    "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n", 
    "学生张三的成绩被添加\n",
    "1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n", 
 ]
 ```    

Scenario7: 生成单个学生成绩，输入错误  
    Given [1, "张三, 1, 数学: 75, 语文: 95, 英语: 80, 编程: 80", 2, ""]  
    When 命令行应用  
    Then 返回 ""  
 ```
 [
    "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n", 
    "学生张三的成绩被添加\n", 
    "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n",
    "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n",
 ]
 ```  

Scenario8: 生成单个学生成绩，格式正确，学号正确  
    Given [1, "张三, 1, 数学: 75, 语文: 95, 英语: 80, 编程: 80", 2, 1]  
    When 命令行应用  
    Then 返回 ""  

 ```
 [
    "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n", 
    "学生张三的成绩被添加\n", 
    "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n",
    "成绩单\n姓名|数学|语文|英语|编程|平均分|总分\n========================\n张三|75|95|80|80|82.5|330========================\n全班总分平均数：82.5\n全班总分中位数：330\n",
    "1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n",
 ]
 ```    
 
 
Scenario9: 生成单个学生成绩，格式正确，学号查询不到  
    Given [1, "张三, 1, 数学: 75, 语文: 95, 英语: 80, 编程: 80", 2, 2]  
    When 命令行应用  
    Then 返回 ""  
 ```
 [
    "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n", 
    "学生张三的成绩被添加\n", 
    "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n",
    "成绩单\n姓名|数学|语文|英语|编程|平均分|总分\n========================\n========================\n全班总分平均数：82.5\n全班总分中位数：330\n",
    "1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n",
 ]
 ```  
 

Scenario10: 生成多个学生的成绩    
    Given [1, "张三, 1, 数学: 75, 语文: 95, 英语: 80, 编程: 80", 1, "李四, 1, 数学: 85, 语文: 80, 英语: 70, 编程: 90", 2, 1, 2]  
    When 命令行应用  
    Then 返回  

```
[
    "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n",
    "学生张三的成绩被添加\n", 
    "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n"],
    "成绩单\n姓名|数学|语文|英语|编程|平均分|总分\n========================\n张三|75|95|80|80|82.5|330\n李四|85|80|70|90|81.25|325\n========================\n全班总分平均数：327.5\n全班总分中位数：327.5\n",
    "1. 添加学生\n2. 生成成绩单\n3. 退出请输入你的选择（1～3）：\n",
]
```



## 任务分解(改进需求1)


   少数民族 +10分 
   体育特长 +20分 
   艺术特长 +15分
   
   
## 任务分解(改进需求2)
   