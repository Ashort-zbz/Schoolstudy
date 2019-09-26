1、编程输出“我的信息”，包括姓名、性别、学号和课程名称，格式为：
    姓名：
    性别：
    学号：
    课程名称：

```c
#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("我的信息\n姓名：张伯仲\n性别：男\n学号：20181060271\n课程名称：计算机程序设计实验\n");
    return 0;
}
```

 2、编程求以下表达式的值：

![](https://upload-images.jianshu.io/upload_images/19680844-7fde0b5044b61478.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

```c
#include <stdio.h>

int main()
{
    printf("表达式的值为%d\n",(9*15+(8*30/1/3)+60));
    return 0;
}
```

3、编程计算并输出16.8与27.5两个数的和、差、积、商， 要求输出界面

和是：                 差是：

积是：                 商是：

```c
#include <stdio.h>
#include <stdlib.h>

int main()
{
    double a,b;
    a=16.8;
    b=27.5;
    printf("和是：%lf              差是：%lf\n",a+b,a-b);
    printf("积是：%lf              商是：%lf\n",a*b,a/b);
    return 0;
}
```

