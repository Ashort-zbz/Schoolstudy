#  Experiments  Two

1、输入3个人的成绩，计算3人的总成绩和平均成绩。（输入3个浮点数，将其相加，再将其求平均，分别输出结果，结果保留小数点后2位（%.2f））

```c
#include <stdio.h>
#include <stdlib.h>

int main(){

  system("color f1");
  float a=0,b=0,c=0,d;
    
  printf("这是一个计算三人成绩平均数的计算器\n");
  printf("----------------------------------\n");
  printf("请输入第一个人的成绩（输入完毕后请按回车键）\n");
  scanf("%2f",&a);
  printf("请输入第二个人的成绩（输入完毕后请按回车键）\n");
  scanf("%2f",&b);
  printf("请输入第三个人的成绩（输入完毕后请按回车键）\n");
  scanf("%2f",&c);

  d=(a+b+c)/3;
  printf("三人的平均分是%2f",d);

  return 0;
}
```



2、输入英尺为单位的长度量，将其转换为以厘米为单位的量。（输入浮点数n英尺，将其转换为厘米输出，1英尺=30.48厘米）

```c
#include <stdio.h>
#include <stdlib.h>

int main(){

  float a=0,b=0;

  printf("请输入长度量（单位：英尺）\n");
  scanf("%f",&a);
  b=a*30.48;
  printf("-------------------------\n");
  printf("转换成厘米为：%f",b);

  return 0;

}
```



3、输入3个整数变量a,b,c, 输出a+2b+3c的值，之后先交换a和b的值后再交换b和c的值，最后输出a+2b+3c的值。（交换a、b、c的值通过赋值操作编程实现）

 ```c
#include <stdio.h>
#include <stdlib.h>

int main(){

  double a=0,b=0,c=0,d=0;

  scanf("%lf %lf %lf",&a,&b,&c);
  printf("a+2b+3c=%lf\n",a+2*b+3*c);
  d=a,a=b,b=d;
  d=c,c=b,b=d;
  printf("a+2b+3c=%lf\n",a+2*b+3*c);
  return 0;

} 
 ```



4、输入正方体的长、宽、高，计算长方形的表面积和体积。（输入长、宽、高3个浮点数值，计算输出结果，输出时要求有文字说明）

```c
#include <stdio.h>
#include <stdlib.h>

int main(){

  float a,b,c;

  printf("请分别输入立方体的长，宽，高\n");
  scanf("%f %f %f",&a,&b,&c);
  printf("该立方体的表面积为：%f\n",2*a+2*b+2*c);
  printf("该立方体的体积为：%f",a*b*c);
  return 0;
}

```



5、输入1个小写字母，将其转换为大写字母（输入char类型的字符，通过ASCii码表中的编码差值将其转换为大写字符，并输出）

```c
#include <stdio.h>
#include <stdlib.h>

 

int main(){

  char a;

  printf("请输入一个小写字母\n");
  scanf("%c",&a);
  a=a-32;
  printf("字母的大写是：%c",a);
    
  return 0;

}
```