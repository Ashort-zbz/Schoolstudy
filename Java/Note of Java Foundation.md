# Note of Java Foundation

## Chapter One    Calculation

[TOC]

### 1.0、写在前面

Java的教材在世面上有很多，建议用清华出版社的书，个人觉得很详细。

关于编译器，对于计算机小白来说，eclipse很友好。但是有一定基础的，建议用vs code。当你用了eclipse后再用vs code，就觉得用vs code太爽了！！！但是因为vs code只是一个代码编辑器，本身不带有编译等其他功能，所以要你自己去配置。配置详情自己去看vs code的说明书。此处附上链接。 [VScode配置Java说明](https://code.visualstudio.com/docs/java/java-tutorial) 

### 1.1、第一个Java程序

- 在Java中类的第一个字母大写
- 在eclipse中只需要打出你需要单词的前几个字母，然后 Alt+/ ，它会出现一些东西让你选，这是eclipse的一个功能。而在vs code中编写代码，它会智能提示，不需要按 Alt+/ 。

```java
public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
	}

}
```

### 1.2、变量与计算

#### 1.2.1、读输入

在我们需要输入一些东西给计算机时，我们需要下面的语句。

```java
Scanner in = new Scanner(System.in);
System.out.println(in.nextLine());
```

如果不想进行简单的输入，想要在其中加一点东西，我们可以这样`System.out.println("echo:" + in.nextLine());`用 + 号将两个字符串连接起来区分输入和输出。

#### 1.2.2、变量

Java中定义变量和使用变量与C语言类似。

- 变量定义的一般形式——<类型名称><变量名称>

如该句`System.out.println("100"+in.nextInt()+"="+(100-in.nextInt()));`它就会从用户那里读两个int值进来。而我们想要的的是只输入一次，所以这个时候就可以用到变量。这样——

```java
int price;
price = in.nextInt();
System.out.println("100"+price+"="+(100-price));
```

一旦你定义了这个变量，你就可以重复使用很多次。

变量需要一个名字，变量的名字是一种“标识符”，即用来识别这个和那个的不同的名字。标识符有标识符的构造规则。基本的原则是：标识符只能由字母、数字和下划线组成，数字不可以出现在第一个位置上，Java的关键字（有的地方叫保留字）不可用做标识符。Java的关键字可在官网查到。

在上面`int price;`这一行声明了变量的类型。**Java是一种强类型语言**，所有的变量在使用之前必须定义或声明，所有的变量必须具有确定的数据类型。并不像Python那样随意。数据类型表示在变量中可以存放什么样的数据，变量中只能存放指定类型的数据，程序运行过程中一般情况下也不能改变变量的类型。**例外的情况是强制类型转换。**

#### 1.2.3、常量

如果在程序中有某些变量的值是在初始化之后永远是不变的，我们可以把它作为常量，即保持不变的量，可以这样`final int amount = 100;`，在这之后变量就不能改变

#### 1.2.4、赋值

在上一节中有这样的语句`price = in.nextIne;`，其中的等号被称为赋值运算符。在计算机中的 ‘=’ 表示一个动作，例如`a = b;`是将 b 的值赋给 a，即 b->a (或者a<-b)，在这个动作中，左右两边的东西是不对等的。并不是数学上的表达关系的意思。在计算机中  a = b 与 b = a 完全不同。

在早期的计算机编程语言当中，为了强化这种概念，不用等号表达这种赋值关系，而是用`a:=b`或者`make ^a b`，就是为了避免运用数学上的 '='，然而从C语言开始，现代的编程语言广泛使用 '='来表示这种赋值关系。

而如果我们像这样`int price = 0;`在定义变量的时候给变量赋一个值，我们把这个赋值称为**初始化**。如果一个变量没有做过初始化，在它第一次被赋值之前，是不能用的。

如果像这样`int price, amount = 0;`，变量price还是没有被初始化，初始化的是变量amount。所以在一行中要定义多个变量时，每个变量都要初始化，即赋值0。 **在这里建议一行就只定义一个变量，这在以后的代码阅读和代码维护都是有好处的**。

### 1.3、浮点数计算

#### 1.3.1、浮点数

这里有个例子：5英尺7英寸转换为米，是多少？

```java
//先用数学解决（5+7/12）*0.3048=1.7018米，用程序实现
int foot;
int inch;
Scanner in = new Scanner(System.in);
System.out.println((foot + inch/12)*0.3048);
```

执行这个程序，输出结果为1.524，结果不是1.7018。再用别的数试试？5尺1，输出1.524，5尺9，输出还是1.524。好像只有英尺在起作用，而英寸并没有起作用，为什么？

如果之前学过C语言的人应该知道，两个整数运算的结果只能是整数。比如3/4，正常来说结果应该是0.75，而对于计算机而言，结果只能是0。因此对于上面的代码，因为英寸不可能大于12，也就是说 inch/12 的结果永远是0。因此看起来只有英尺在起作用。如何改？

可以这样`System.out.println((foot + inch/12)*0.3048);`，这样运行的结果就是对的了。因为在计算机中 12 和 12.0 是不一样的两个数。当浮点数和整数在一起运算时，计算机会将整数转化为浮点数，然后进行浮点数运算。

带小数点的数值在计算机中称为浮点数。浮点的本意就是指小数点是浮动的，是计算机内部表达非整数（包括分数和无理数）的一种方式。另一种方式叫做定点数，不过在现代语言中应该不会遇到。我们借用浮点数来表达所有带小数点的数。

**划重点——如果你肯动手，可以试试让计算机输出 1.2 - 1.1 的值。用常理说肯定是 0.1 。但计算机会输出很奇怪的数。究其原理，是二进制，二进制表达小数部分只能精确表达2的幂次以及整数数乘的数，其余只能表达近似值。因此对于二进制的比较要注意：当二者之差小于这个很小的数时，就认为二者是相等的了，而不能直接用 == 或 ！= 比较！！！这个很小的数，称为精度。 精度由需求而定。**具体代码如下

```java
double a;
double b;
System.out.println(Math.abs(a-b) < 1e-6);
```



当然也可以将 inch 改为浮点型变量，而 12 不变。即在声明变量时`double inch;`，即可。

#### 1.3.2、优先级

优先级知识与C语言类似，这里不多说明。

## Chapter Two    Process control

### 2.1、条件语句

计算机的智能是建筑在规则的基础上的，在遇到情况的时候，根据事先制定的规则做出判断，是计算机最基本的能力。

能做判断的基础，是能对数据做比较，比较就是关于两个数据是否相等、谁大谁小的结论，这需要用到关系运算：对两个数据之间的关系的计算。

Java提供了六个关系运算符：

- ==	相等
- !=	不相等
- \>	大于
- \>=	大于或等于
- <	小于
- <=	小于或等于

注意其中有两个字符的运算符：==、>=和<=的两个字符必须紧紧连在一起，中间不能插入空格。

关系运算的结果是一个逻辑值，逻辑值只有两种可能的值：true（真，表示成立）或false（假，表示不成立）。当两个值的关系符合关系运算符的预期时，关系运算的结果为true，否则为false。

根据比较的结果，决定做、还是不做某些动作，就要用到if语句。

一个基本的if语句由一个关键字if开头，跟上在括号里的一个表示条件的逻辑表达式，然后是一对大括号“{}”之间的若干条语句。如果表示条件的逻辑表达式的结果为true，那么就执行后面跟着的这对大括号中的语句，否则就跳过这些语句不执行，而继续下面的其他语句。

有的时候我们希望在条件成立的时候做一件事情，而在条件不成立的时候做另外一件事情。这可以在if语句后面跟上一个else子句，形成一个if-else语句。

判断控制语句基本用法和C语言类似，有两种大的用法—— if-else 和 switch-case；下面用一个例子说明，要求模拟一个车站自动售票机的工作过程：

```java
public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请投币:");
        int amount = in.nextInt();
        System.out.println(amount);
        if(amount >= 10){
            System.out.println("****************");
            System.out.println("*Java城际专线   *");
            System.out.println("*票价：10元     *");
            System.out.println("****************");
            System.out.println("找零：" + (amount - 10));
        }
	}
```

if语句这一行结束的时候并没有表示语句结束的 ";" ，因为后面还有受 if 控制的语句，if和后面的语句加起来才算是一个完整的控制结构。

### 2.2、循环语句

#### 2.2.1、while循环

if语句可以判断条件是否满足，满足时才做相应的动作，而循环语句可以在满足条件时，不断地重复执行一些动作。

重复执行的语句（循环语句）可以多次执行其他语句，它检查一个逻辑条件是否满足，只在满足的时候执行它的循环体。

while语句是一个循环语句，它会首先判断一个条件是否满足，如果条件满足，则执行后面紧跟着的语句或语句括号，然后再次判断条件是否满足，如果条件满足则再次执行，直到条件不满足为止。后面紧跟的语句或语句括号，就是循环体。

do-while循环和while循环很像，唯一的区别是我们在循环体执行结束的时候才来判断条件。也就是说，无论如何，循环都会执行至少一遍，然后再来判断条件。与while循环相同的是，条件满足时执行循环，条件不满足时结束循环。

#### 2.2.2、for循环

for循环语句。for循环是编程中最有用的循环语句之一。

在Java 5 以后新增了 foreach 语法。foreach 语句是 for 语句的特殊简化版本，不能完全取代 for 语句，但任何 foreach 语句都可以改为 for 语句版本。foreach 并不是一个关键字，习惯上将这种特殊的 for 语句格式称为 foreach 语句。 foreach 在遍历数组等方面为程序员提供很大方便。

例：

```java
public static void main(final String[] args) {
        int arr[] = {7, 10, 1};
        System.out.println("一维数组中的元素分别是：");
        for(int x:arr){
            //foreach语句，int x引用的变量，arr指定要循环遍历的数组，最后将x输出
            System.out.println(x);
        }
	}
```

#### 2.2.3、循环控制

1、break语句

break可跳出switch结构，在循环结构中也可跳出当前循环。在循环嵌套的情况下，break语句将只会使程序流程跳出包含它的最内层的循环结构，即只跳出一层循环。

例：

```java
public static void main(final String[] args) {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 6; j++){
                if (j == 4) {    //如果j等于4就结束内部循环
                    break;
                }
                System.out.println("i=" + i + "j=" + j);
            }
        }
	}
```

如果想让 break 跳出外层循环，Java 提供了“标签”的功能，语法如下：

```java
标签名：循环体{
    break 标签名;
}
```

- break 标签名：break 跳出指定的循环体，次循环体的标签名必须与 break 的标签名一致。带有标签的 break 可以指定跳出的循环，这个循环可以是内层循环，也可以是外层循环。

例：

```java
public static void main(final String[] args) {
        Loop:for(int i = 0; i < 3; i++){
            for(int j = 0; j < 6; j++){
                if (j == 4) {
                    break Loop;
                }
                System.out.println("i=" + i + "j=" + j);
            }
        }  
}
```

2、continue 语句

continue 语句是对 break 语句的补充。continue 不是立即跳出循环体，而是跳出本次循环结束前的语句，回到循环的条件测试部分，重新开始执行循环。在 while 和 do...while 循环中，continue 语句使控制直接回到条件测试部分。在 for 循环语句中遇到 continue 后，首先执行循环的增量部分，然后进行条件测试。

例：输出1~20之间的奇数，使用 continue 跳出循环。

```java
public static void main(final String[] args) {
        for (int i = 1; i < 20; i++) {
            if (i % 2 == 0) {    //如果i是偶数，跳到下一循环
                continue;
            }
            System.out.println(i);    //输出i
        }
	}
```

和 break 语句一样，continue 语句也支持标签功能，语法与 break 相似。

最后给出一个实例，打印菱形，行数由用户输入，且只能输入奇数：

```java
public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入菱形的行数，只能为奇数：");
        int lineCount = 0;
        lineCount = in.nextInt();// 输出的菱形有多少行，请赋值成奇数

		int maxLineNum = (lineCount + 1) / 2;// 计算星号最多的一行
		for (int i = 1; i <= maxLineNum; i++) {// 循环菱形数量越来越多的几行
			for (int space = 1; space <= maxLineNum - i; space++) {// 输出空格，数量=最后一行-当前行数
				System.out.print("  ");
			}
			for (int star = 1; star <= (i * 2) - 1; star++) {// 输出星号，数量=行数*2-1
				System.out.print("* ");
			}
			System.out.println();// 换行
		}

		int declineCount = lineCount - maxLineNum;// 计算剩下的几行，这几行星号的数量是递减的
		for (int i = 1; i <= declineCount; i++) {// 循环菱形数量越来越少的行数
			for (int space = 1; space <= i; space++) {// 输出空格，数量等于当前的行数
				System.out.print("  ");
			}
			for (int star = 1; star <= (declineCount - i + 1) * 2 - 1; star++) {// 输出星号，数量等于（总数-当前行数）*2-1
				System.out.print("* ");
			}
			System.out.println();
		}
	}
```

## Chapter Three    Array

 数据可以存放在变量里，每一个变量有一个名字，有一个类型，还有它的生存空间。如果我们需要保存一些相同类型、相似含义、相同生存空间的数据，我们可以用数组来保存这些数据，而不是用很多个独立的变量。数组是长度固定的数据结构，用来存放指定的类型的数据。一个数组里可以有很多个数据，所有的数据的类型都是相同的。 

### 3.1、初识数组

数组是一种容器，**一旦创建之后就不能改变其大小**。每个数组都有一个内部成员 length，它会告诉数组元素的数量。数组是一种数据结构，数组中每个数据叫做元素，所有元素具有相同的数据类型。当在程序中需要处理一组数据，或者传递一组数据时，可用数组。先来看一个程序，计算用户输入的数字的平均数，并输出所有大于平均数的数。

例：

```java
public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        int x;
        int[] numbers = new int[100];
        double sum = 0;
        int cnt = 0;
        x = in.nextInt();

        while( x != -1){
            numbers[cnt] = x;
            sum += x;
            cnt++;
            x = in.nextInt();
        }

        if (cnt > 0) {
            double average = sum / cnt;
            for (int i = 0; i < cnt; i++) {
                if (numbers[i] > average) {
                    System.out.println(numbers[i]);
                }
            }
            System.out.println(average);
        }
	}
```

其中我们做了一些关于数组的事情：

- 定义数组：`int[] numbers = new int[100];`
- for 循环遍历数组
- ...

#### 3.1.1、创建数组

创建数组有两种方法

1）先声明，再用 new 运算符进行内存分配

声明方式：`数组元素类型 数组名字[];` 或 `数组元素类型[] 数组名字;`，符号"[]"表明该变量是一个数组类型变量。

声明之后还不能立即访问它的任何元素，因为声明数组只是给出数组的名字和元素的数据类型，要想真正使用数组，还要给它分配内存空间。分配内存的方式为：`数组名 = new 数组元素类型[数组元素个数]`。使用 new 关键字分配内存时，整形数组中各元素的初始值均为0。

2）声明的同时为数组分配内存

推荐使用这种方法，格式为：`<类型>[] <名字> = new <类型>[元素个数];` 或者 `<类型> <名字>[] = new <类型>[元素个数];`。上面的代码就用了第一种方法。

在这里要注意，定义时**元素个数必须为整数**，**元素个数必须明确**，**元素个数可以是变量**。

#### 3.1.2、初始化数组

初始化和变量的初始化意义相似，有两种格式：

```java
int arr[] = new int[]{1.2.3.4.5};
int arr[] = {12,34,56};
```

这样既创建了数组，又进行了初始化操作。

#### 3.1.3、二维数组的创建

二维数组可看作是特殊的一维数组，创建方式与一维数组的创建方式类似。举例说明：

```java
int arr[][]; //first
arr = new int[2][4];

int arr[][] = new int[2][4]; //second
```

那么类似的，二维数组的初始化与一维数组也类似。

### 3.2、数组的基本操作

1、遍历数组
