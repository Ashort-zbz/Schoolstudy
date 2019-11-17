# Experiments Three

1、编程序，计算下面分段函数的值（if-else）

​    ![img](file:///C:/Users/12970/AppData/Local/Temp/msohtmlclip1/01/clip_image002.gif)

```c
#include <stdio.h>
#include <stdlib.h>

int main(){

    int x=0,y=0;
	printf("请输入一个x的值：\n");
	scanf("%d",&x);

    if(x<0){
        y=x+10;
	}else if(x>=15){
        y=2*x-10;
    }else{
        y=3*x+5;
    }

    printf("x=%d  y=%d",x,y);
    return 0;
}
```



2、编写程序，输入一个小写英文字母，如果它位于字母表的前半部分，输出它的后一个字母；位于后半部分时输出它的前一个字母（if-else）。

```c
#include <stdio.h>
#include <stdlib.h>

int main(){

    char a;
	printf("请输入一个小写字母\n");
	scanf("%c",&a);
	if(a<=109){
        a=a+1;
        printf("%c",a);
    }else{
        a=a-1;
        printf("%c",a);
    }
  return 0;
}
```



3、输入某学生的考试成绩等级A、B、C、D（或a、b、c、d），要求按照等级输出对应的分数段。A级对应的分数段为85~100分；B级对应分数段为70~84；C级对应分数段为60~69；D级对应分数段位60分以下（switch）。

```c
#include <stdio.h>
#include <stdlib.h>

int main(){

    char grade;
	printf("Your level:\n");
	scanf("%c",&grade);
	printf("Your score:");
	switch(grade){
		case'A':printf("85~100\n");break;
        case'B':printf("70~84\n");break;
		case'C':printf("60~69\n");break;
        case'D':printf("<60\n");break;
        default:printf("enter data error!\n");
    }
    
    return 0;
    
}
```





4、输入某学生的考试成绩，如果在90分以上，输出“A”；80~89分输出“B”；70~79分输出“C”；60~69分输出“D”；60分以下则输出“E”（if-else 或swiitch）。

```c
#include <stdio.h>
#include <stdlib.h>

int main(){
	int a;
	printf("Your score:");
	scanf("%d",&a);
	printf("Your level:");
	if(a>=90){
		printf("A");
	}else if(a>=80&&a<=89){
		printf("B");
	}else if(a>=70&&a<=79){
		printf("C");
	}else{
		printf("D");
	}
	return 0;
}
```

