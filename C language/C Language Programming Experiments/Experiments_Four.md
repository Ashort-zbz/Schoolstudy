# Experiments Four

1、编程，利用循环计算以下表达式的值：

（5＋52）*(4+42)*(3+32)*(2+22)*(1+12)*(1/2+1/3+1/4+1/5)（for循环）

```c
#include <stdio.h>
#include <stdlib.h>

int main(){

	int i,a=1.0;
	float k,r;

	for(i=1;i<=5;i++){
		a=a*(i*i+i);
	}
	for(i=2;i<=5;i++){
		k=1.0/i;
		r=r+k;
	}

	printf("表达式的值为%f\n",a*r);
	return 0;

}
```



2、编程，从键盘输入若干个整数，当输入0时，输入停止。统计并输出总共输入了几个数，以及所有输入数的和。（while循环）

```c
#include <stdio.h>
#include <stdlib.h>

#define NORN 0

int main(){

	int i,sum,a=0;
	printf("请输入一个整数\n");

	while(1){
		scanf("%d",&i);
		a++;
		if(i==NORN) break;
		printf("请再输入一个整数（输入0结束）\n");
		sum=sum+i;
}

    printf("您一共输入了%d个整数\n您输入所有数的和是%d\n",a,sum);

    return 0;
}
```



3、输入一行字符，分别统计其中的英文字母、数字、空格和其他字符的个数。

```c
#include <stdio.h>
#include <stdlib.h>

int main(){

	char ch;
	int a=0,b=0,c=0,d=0;
	printf("请输入一行字符\n");
	scanf("%c",&ch);

	while(ch!='\n'){
		if(ch>='a'&&ch<='z'||ch>='A'&&ch<='Z')a++;
		else if(ch>='0'&&ch<='9')b++;
		else if(ch==32)c++;
		else d++;
		scanf("%c",&ch);
	}

	printf("字母有%d个，数字有%d个，空格有%d个，其他字符有%d个\n",a,b,c,d);
	return 0;
}
```



4、使用二重循环编程，绘制如下图形：

```c
*****A
****B
***C
**D
*E
```

```c
include <stdio.h>
include <stdlib.h>

int main(){

int i,j,k=65;

    for(i=5;i>=1;i--){
        for(j=i;j>=1;j--)printf("*");
        printf("%c\n",k++);
    }
    return 0;
}
```



5．输入10个整数，输出最大值、最小值和平均分。（用循环实现）

```c
include <stdio.h>
include <stdlib.h>

int main(){

    int i=0,x=0,sum=0,max,min;
    float ave;
    printf("请输入十个整数(输入一次按一次回车)\n");
    
    for(i=1;i<=10;i++){
        scanf("%d",&x);
        if(i==1) min=max=x;
        if(x>max) max=x;
        if(x<min) min=x;
        sum+=x;
    }
    
    ave=sum/10;
    printf("十个数的最大值为%d,最小值为%d,平均值为%f\n",max,min,ave);
    
    return 0;
}
```



6．编写程序，其功能是：根据以下公式求π的值(要求精度0.0005，即某项小于0.0005时停止迭代)。程序运行后，若输入精度0.0005，则程序应输出为3.14…。

![clip_image002.gif](https://upload-images.jianshu.io/upload_images/19680844-285507d6d2c464ac.gif?imageMogr2/auto-orient/strip)

```c
#include <stdio.h>
#include <stdlib.h>

int main(){
    
    double pi=0.0,t=1.0;
    int i=1;
    
    while(t>=0.0005){
        pi=pi+t;
        t=t*i/(2*i+1);
        i++;
    }
    
    pi=2*pi;
    printf("估计值（精度0.0005）为：%lf\n",pi);
    
    return 0;
}
```



