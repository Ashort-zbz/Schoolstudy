# 第二周编程题

## 有秒计时的数字时钟

这一周的编程题是需要你在课程所给的时钟程序的基础上修改而成。但是我们并不直接给你时钟程序的代码，请根据视频自己输入时钟程序的 Display 和 Clock 类的代码，然后来做这个题目。

我们需要给时钟程序加上一个表示秒的 Display，然后为 Clock 增加以下 public 的成员函数：

`public Clock(int hour, int minute, int second);`

用 hour,  minute 和 second 初始化时间。

`public void tick();`

“嘀嗒”一下，时间走1秒。

`public String toString();`

返回一个 String 的值，以“hh:mm:ss“的形式表示当前时间。这里每个数值都占据两位，不足两位时补0。如“00:01:22"。注意其中的冒号是西文的，不是中文的。

*提示：String.format()可以用和printf一样的方式来格式化一个字符串。*

另外写一个Main类，它的main函数为下面的样子，注意，必须原封不动地作为 Main 的 main 函数：

```java
public static void main(String[] args) {
    java.util.Scanner in = new java.util.Scanner(System.in);
    Clock clock = new Clock(in.nextInt(), in.nextInt(), in.nextInt());
    clock.tick();
    System.out.println(clock);
    in.close();
	}
```

