# Note of Java

## 第一个Java程序

- 在Java中类的第一个字母大写
- 在eclipse中只需要打出你需要单词的前几个字母，然后Alt+/，它会出现一些东西让你选，这是eclipse的一个功能。

```java
public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
	}

}
```

## 变量与计算

读输入

在我们需要输入一些东西给计算机时，我们需要下面的语句。

```java
Scanner in = new Scanner(System.in);
System.out.println(in.nextLine());
```

