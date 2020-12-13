# Java编程思想——Bruce Eckel

源代码，资料下载：https://www.mindviewllc.com

[TOC]

## 第一章 对象导论

编程语言的产生始于对机器的模仿。OOP（面向对象程序设计）。

### 1.1 抽象过程

所有编程语言都提供抽象机制。人类能够解决的问题的复杂性直接取决于对象的类型和质量。所谓“类型”即“所抽象的是什么？”**汇编语言**是对底层机器的轻微抽象。接着出现**“命令式”语言**（FORTRAN、BASIC、C等）都是对汇编语言的抽象。这些在汇编的基础上有大幅度改进，但其所作的主要抽象仍要求在解决问题时**要基于计算机结构**，而不是基于所要解决的问题的结构来考虑。

另一种对机器建模的方式就是只针对待解决问题建模。OOP就是其中一种，OOP通过向程序员提供表示问题空间中的元素的工具。将问题空间中的元素及其在解空间中的表示称为“对象”。OOP思想实质是：程序可通过添加新类型的对象使自身适用于某个特定问题。

Alan Kay 曾总结了第一个成功的OOP语言、同时也是Java所基于的语言之一的smalltalk的五个特性：

1. 万物皆为对象。

2. 程序是对象的集合，它们通过发送消息来告知彼此要做的。

3. 每个对象都有自己的由其他对象所构成的存储。

4. 每个对象都拥有类型。
5. 某一特定类型的所有对象都可以接受同样的信息。

Booch 对对象提出了一个更加简洁的描述：**对象具有状态、行为和标识。**这意味着每个对象都可拥有内部数据（它们给出该对象的状态）和方法（它们产生行为），并且每个对象都可以唯一地与其他对象区分开，具体说，就是每个对象在内存中都有一个唯一的地址。

### 1.2 每个对象都有一个接口

亚里士多德大概是第一个深入研究**类型（type）**的哲学家，他曾提出过鱼类和鸟类这样的概念。**所有对象都是唯一的，但同时也是具有相同特性和行为的对象所属的类的一部分。**这种思想被直接应用于第一个OOP语言Simula-67，在程序中使用关键字**class**引入新的类型。Simula，“人如其名”，是为了开发诸如经典问题“银行出纳员问题”（bank teller problem）这样的仿真程序创建的。在银行出纳员问题中，有出纳、客户、账户、货币单位等许多“对象”。在程序执行期间具有不同的状态而其他方面都相似的对象会被分组到对象的类中，即关键字**class**的由来。创建抽象数据类型（类）是OOP的基本概念之一。你可以创建某一类型的变量（按照面向对象的说法，称为**对象**或**实例**），然后操作这些变量（称其为**发送消息**或**请求**）。每个类的成员或元素都具有某种共性：每个账户都有结余金额。同时，每个成员都有自身的状态：每个账户都有不同的结余金额。因此，出纳、客户、账户、货币单位都可以在程序中被表示成唯一的实体。这些实体就是对象，每个对象都属于定义了特性和行为的某个特定的类。

事实上所有OOP语言都使用class关键词来表示数据类型。**当看到类型这一词是，可将其作为类来考虑，反之亦然**。因为类描述了具有相同特性（数据元素）和行为（功能）的对象集合，所以一个类实际上就是一个数据类型。程序员可以通过定义类来适应问题，而不再被迫只能使用现有的用来表示机器中的存储单元的数据类型。可以通过需求，通过添加新的数据类型来扩展编程语言。

OOP方法并不是仅限于构建仿真程序，任何程序是所设计的系统的一种仿真，OOP技术的应用确实可以将大量的问题很容易的降解为一个简单的解决方案。一旦类被建立，就可以随心所欲地创建类的任意个对象，然后操作它们，就像是它们是存在于待求解问题中的元素一样。事实上，OOP的挑战之一，就是**在问题空间的元素和解空间的对象之间创建一对一的映射**。

如何获得有用的对象？必须有某种方式产生对对象的请求，使对象完成各种任务。每个对象都只能满足某些请求，这些请求由对象的**接口（interface）**所定义，决定接口的便是类型。接口确定了对某一特定对象所能发出的**请求**。但是，在程序中必须有满足这些请求的代码，这些代码与隐藏的数据一起构成了**实现**。此过程可概括为：向某个对象“发送消息”（产生请求），这个对象便知道此消息的目的，然后执行对应的程序代码。

### 1.3 每个对象都提供服务

当正在试图开发或理解一个程序设计时，最好的方法就是**将对象想象为“服务提供者”**。程序本身向用户提供服务，它通过其他对象提供的服务来实现这一目的。程序员的目标就是去创建（活着最好是在现有代码库中寻找）能够提供理想的服务来解决问题的一系列对象。

开始做这件事的一种方式就是问自己：“如果我能将问题从表象中抽取出来，那么什么样的对象可以马上解决问题？”对于那些不存在的对象，它们看上去是什么样子？它们能提供那些服务？它们需要哪些对象才能履行它们的义务？这是将问题分解为对象集合的一种合理方式。

将对象看作服务提供者还有一个附带好处：有助于提高对象的内聚性。**高内聚**是软件设计的基本质量要求之一：这意味着一个软件构建（例如一个对象，也有可能指一个语法或一个对象库）的各个方面“组合”得很好。在良好的OOP中，每个对象都可以很好地完成一项任务但是它并不试图做更多的事。

将对象作为服务提供者看待是一件伟大的简化工具，这不仅在设计中非常有用，而且当其他人试图理解你的代码或重用某个对象时，如果他们看出这个对象所能提供的服务的价值，它会使调整对象以适应其设计的过程变得简单多。

### 1.4 被隐藏的具体实现

将程序员按照角色分为**类创建者**（能创建新数据类型的程序员）和**客户端程序员**（在应用开发中使用数据类型的类消费者）是有益的，客户端程序员目标是收集各种用来实现快速应用开发的类。类创建者目标是构建类，这种类只向客户端程序员暴露必需的部分，隐藏其他部分。为什么？如果加以隐藏，那么客户端程序员将不能访问它，这意味着类创建者可以任意修改被隐藏的部分，不用担心对其他任何人造成影响。被隐藏的部分通常代表对象内部脆弱的部分，它们很容易被粗心或不知内情的客户端程序员所毁坏，因此将实现隐藏起来可以减少程序bug。

在任何相互关系中，具有关系所涉及的各方都遵守的边界是十分重要的事情。当创建一个类库时，就建立了与客户端程序员之间的关系。如果他们不受任何约束，没有任何控制访问，所有东西将赤裸裸暴露在人面前。

访问控制第一个存在原因就是让客户端程序员无法触及他们不应触及的部分。

访问控制的第二个存在原因就是允许库设计者可以改变类内部的工作方式而不用担心会影响到客户端程序员。

Java用三个关键字在类的内部设定边界：**public**、**private**、**protected**。这些**访问指定词**（access specifier）决定了紧跟其后被定义的东西可以被谁使用。**public**表示紧随其后的元素对任何人都是可用的，**private**关键字表示除类型创建者和类型内部方法之外的任何人都不能访问的元素。**private**就像类创建者和客户端程序员之间的一堵墙，如果有人试图访问**private**成员，就会在编译时得到错误信息。**protected**关键字与**provide**作用相当，差别在于继承的类可以访问**protected**成员，但不能访问**private**成员。

Java还有一种默认的访问权限，当没有使用前面提到的访问指定词时，它将发挥作用。这种权限通常被称为**包访问权限**，在这种权限下，类可以访问同一个包（库构件）中的其他类成员，但是在包之外，这些成员就如同指定了**private**一样。

## 第二章 一切都是对象

尽管Java是基于C++的，但是相比之下，Java是一种更“纯粹”的OOP语言。C++杂合是因为它支持与C语言的向后兼容，这使得C++在某些方面显得过于复杂。Java假设我们只进行面向对象的程序设计，即在使用Java之前，必须将思想转换到OOP的世界中。

### 2.1 用引用操纵对象

每种编程语言都有自己操纵内存中元素的方式。有时候，程序员必须注意将要处理的数据是什么类型。所有这些在Java中都得到简化。一切都被视为对象，因此可以采用单一固定的语法。

尽管一切都看作对象，但操纵的标识符实际上是对象的一个“引用”（reference）。可以将这一情景想象成用遥控器（引用）操纵电视机（对象）。只要握住这个遥控器，就能保持与电视机的连接。当有人想换台或是减小音量，实际操控的是遥控器，再由遥控器来调控电视机。如果想在房间四处走走同时仍能调控电视机，那么只能带着遥控器而不是电视机。

此外，即使没有电视机，遥控器也可以独立存在。即你有一个引用，并不需要有一个对象与它关联。因此，想操纵一个词或句子，可以创建一个**String**引用：

```java
String s;
//创建并初始化
String s = "asdf";
```

这里创建的只是引用，并不是对象。如果此时向s发送消息，就会返回一个运行时错误。因为此时s实际上没有与任何事物相关联。因此，一种安全的方法是：创建一个引用同时便进行初始化。这里用到了Java的一个特性：**字符串可以用带引号的文本初始化**。

### 2.2 必须由你创建所有对象

一旦创建了一个引用，就希望它能与一个新的对象关联。通常用 **new** 操作符来实现。所以前面的例子可以写成：

```java
String s = new String("asdf");
```

重要的是，你可以自己创建类型。这是 Java 程序设计中一项基本行为。

#### 2.2.1 存储到什么地方

1）**堆** 一种通用的内存池（位于RAM区），用于存放所有 Java 对象。堆不同于堆栈的好处是：编译器不需要知道存储的数据在堆里存活多长时间。所以在堆里分配存储有很大的活性。当然为此付出的代价是：用堆进行存储分配和清理可能比用堆栈进行存储分配需要更多时间。

2）**常量存储** 常量值通常直接存放在代码内部，这样做很安全。

#### 2.2.2 特例：基本类型

基本类型的创建，Java 采取与 C 和 C++ 相同的方法。也就是不用 new 创建，而是创建一个“自动”变量。直接存储“值”，并置于堆栈中，更加高效。Java的基本类型大小都需要确定，它们大小不像大多数语言一样随机器硬件架构而变化。这是 Java 程序比用大多数语言更具可移植性的原因之一。

基本类型具有包装器类，使得可以在堆中创建一个非基本对象，用来表示对应的基本类型。如：

```java
char c='x';
Character ch=new Character(c);
//也可以这样
Character ch= new Character('x');
```

**高精度数字**——Java 提供两个用于高精度计算的类：BigInterger 和 BigDecimal。这两者没有对应的基本类型。但是这两类包含的方法，提供的操作与对基本类型所能执行的操作相似。即能用于 **int** 或 **float** 的操作，用同样适用于这两者。**BigInterger** 支持任意精度的整数。**BigDecimal** 支持任何精度的定点数。

#### 2.2.3 Java 数组

在 C 和 C++ 中使用数组是很危险的，因为 **C 和 C++ 的数组就是内存块**。如果程序要访问其自身内存块之外的数组，或在初始化前使用内存（程序中常见的错误），都会产生难以预料的后果。

Java 确保数组会被初始化，而且不能在它的范围之外被访问。当创建一个数组对象时，实际上就是**创建一个引用数组**，并且每个引用都会自动被初始化为一个特定值，该值拥有自己的关键字 **null**。一旦 Java 看到 **null**，就知道这个引用还没有指向某个对象。在使用任何引用之前，必须为其指定一个对象；如果试图使用一个还是 **null** 的引用，运行时将会报错。

还可以创建用来存放基本数据类型的数组。

### 2.3 永远不需要销毁对象

**变量的生命周期**在编程中是重要的概念。

#### 2.3.1 作用域

**作用域**（scope），大多数过程语言（C）都有作用域的概念。**作用域决定了在其内定义的变量名的可见性和生命周期。**作用域由花括号位置决定，在作用域里定义的变量只可用于作用域结束之前。

```c
{
    int x=12;
    {
        int x=96;
    }
}
```

上面的做法在 Java 中是不允许的，但是在 C 和 C++ 里，会将一个较大的作用域变量“隐藏”起来，不会报错。

#### 2.3.2 对象的作用域

Java 对象不具备和基本类型一样的生命周期。当用 **new** 创建一个对象时，它可以存活于作用域之外。

```java
{
    String s = new String("a string");
}//end of scope
```

引用 s 在作用域终点就消失了。然而，s 指向的 **String** 对象仍然占据内存空间。在这一段代码中，无法在这个作用域之后访问这个对象，因为对它唯一的引用已经超出作用域范围。

问题是，如果让对象继续存在，那么靠什么才能防止这些对象填满内存空间，进而阻塞程序？Java 有一个垃圾回收器，用来监视用 **new** 创建的所有对象，并辨别那些不会再被引用的对象。随后，释放这些对象的内存空间，以便供其他新对象使用。这样就消除了编程的“内存泄露”问题。

### 2.4 创建新的数据类型：类

什么确定了对象的类型？多数OOP语言习惯用关键字 **class** 来表示，class 关键字之后紧跟的是新类型的名称。如：

```java
class ATypeName{/*class body goes here */}
```

此时就可用 **new** 来创建这种类型的对象：`ATypeName a = new ATypeName();`

一旦定义了一个类，就可以在类中设置两种类型的元素：**字段**（数据成员）和方法（成员函数）。字段可以是任何类型的对象，可以通过其引用与其进行通信；也可以是基本类型的一种。如果字段是对某个对象的引用，那么必须初始化该引用。

每个对象都有用来存储其字段的空间；普通字段不能在对象间共享。

```java
class DataOnly{
    int i;
    double d;
    boolean b;
}
```

尽管这个类除了存储数据之外什么也不能做，但仍旧可以创建它的一个对象：`DataOnly data = new DataOnly();`，可以给字段赋值，但必须先引用一个对象成员。具体实现为：`objectReference.member`，例如：

```java
data.i = 47;
data.d = 1.1;
data.b = false;
```

**DataOnly** 类除了保存数据外没别的用处，因为没有任何成员方法。

若类的某个成员是基本数据类型，即使没有初始化，Java 也会确保它获得一个默认值。当变量作为类的成员使用时，Java 才确保给定其默认值，以确保那些是基本类型的成员变量得到初始化，防止产生程序错误。但是，初始值对程序来说可能是不正确的，甚至是不合法的。所以最好明确地对变量进行初始化。

### 2.5 方法、参数和返回值

在 Java 中常用方法来表示“做某些事情的方式”。实际上，把它看作函数也无妨。Java 方法决定了一个对象能够接受什么样的消息。方法的基本组成部分包括：名称、参数、返回值和方法体。

```java
returnType methodName(/*Augument list*/){
    /*method body*/
}
```

返回类型描述在调用方法之后从方法返回的值。参数列表给出要传给方法的信息的类型和名称。方法名和参数列表（两者合起来被称为“方法签名”）唯一地标识出某个方法。Java 中方法只能作为类的一部分来创建。方法只有通过对象才能被调用，且这个对象必须能执行这个方法的调用。

假设有一个方法 f() ，不带任何参数，返回类型 int。如果有个名为 a 的对象，可以通过它调用 f() ，则可以`int x= a.f();`返回值类型必须与x类型兼容。

这种调用方法的行为通常被称为发送消息给对象。OOP程序设计通常被简单的归纳为“向对象发送消息”。

```java
int storage(String s){
    return s.length() * 2;
}
```

Java 中任何传递对象的场合都一样，都是传递引用。

return 关键字用法包括两方面：首先代表“已经做完，离开此方法”。其次，如果此方法产生一个值，值要放在 return 语句后面。若返回类型是 void ，return 的作用只是用来退出方法。

### 2.6 构建一个Java程序

在构建第一个 Java程序之前，还必须了解其他一些问题。

#### 2.6.1名字可见性

#### 2.6.2 运用其他构建

关键字 **import** 可以准确的告诉编译器你想要什么类，指示编译器导入一个包，也就是一个类库。类库中包含众多类，有时你想使用一个包中的多个类可以使用**通配符 “\*”** 来达到目的：`import java.util.*`，这种一次导入一群类的方式比一个一个导入类的方式更常用。

#### 2.6.3 static 关键字

**当创建类时，就是在描述类的对象的外观和行为。**除非用 **new** 创建类的对象，否则实际上并没有获得任何对象。执行 **new** 来创建对象时， 数据存储空间才被分配。

有两种情况用上述方法无法解决。1、只想为某特定域分配单一存储空间，而不用去考虑究竟要创建多少对象，甚至可以不用创建任何对象；2、希望某个方法不与包含它的类的任何对象关联在一起，即没有创建对象，也可以调用这个方法。

通过 **static** 关键字可以满足这两个需要。当声明事物是 **static** 时，就意味着这个域或方法不会与包含在它类里的任何对象实例关联在一起。OOP 语言中采用类数据和类方法两个属于，代表那些数据和方法知识作为整个类，而不是类的某个特定对象而存在。

只需将 **static** 关键字放在定义之前，就可以将字段或方法设为 **static**。引用时可以直接通过类名引用字段或方法。

```java
class StaticTest{
    static int i = 47;
}
StaticTest st1=new StaticTest();
StaticTest st2=new StaticTest();

class Incrementable{
    static void increment(){StaticTest.i++;}
}
Incrementalbe sf= new Incrementable();
sf.increment();
Incrementable.increment();
```

在这里，**st1.i** 和 **st2.i** 指向同一存储空间。

**static** 方法一个重要用法就是在不创建任何对象的前提下就可以调用它。这一点对定义 **main()** 方法很重要，这个方法是运行一个应用时的入口点。和其他任何方法都一样，**static 方法可以创建或使用与其类型相同的被命名对象**，因此 **static** 方法常常拿来做“牧羊人”的角色，负责看护与其隶属同一类型的实例群。

### 2.7 第一个Java程序

写一个完整程序。打印“helloworld”

```java
//App.java
public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // System.out.println("Hello, it's:");
//		System.out.println(new Date());
		// System.out.println("Helloworld!");
		System.getProperties().list(System.out);
		System.out.println(System.getProperty("user.name"));
		System.out.println(
            System.getProperty("java.library.path")
        );
    }
}

```

类的名字必须和文件名相同。如果你像现在创建一个独立运行的程序，那么文件中必须存在某个类与该文件同名，且那个类必须包含一个名为 **main()** 的方法。形如：`public static void main(String[] args) {`。其中 **public** 关键字指这是一个可由外部调用的方法。**main()** 方法的参数是一个 **String** 对象的数组。在这个程序中并未用到 **args**，但是 Java编译器要求必须这样做，因为 **args** 要用来存储命令行参数。

### 2.8 注释和嵌入式文档

Java 有两种注释风格，一种是传统注释，以“/\*"开始，"*/"结束，可跨很多行。很多程序员在连续的注释内容的每行都以一个”\*“开头：

```java
/*This is a comment
 *that continues
 *across lines
 */
//上面等于下面
/*This is a comment that
continues across lines*/
```

另一种注释是“单行注释”，以“//”起头，这种更方便，更常用。

#### 2.8.1 注释文档

写代码文档的最大问题，就是对文档的维护。若代码与文档是分离的，那么每次改代码都需要修改相应的文档。可以将代码和文档“链接”起来。为实现这个目的，必须使用一种特殊的注释语法来标记文档；此外还需要一个工具，用于提取那些注释，并将其装换成有用的形式。

Java 提供 javadoc，是一个用于提取注释的工具，是 JDK 安装的一部分。输出的是一个 HTML 文件，可以用web 浏览器查看。这个工具就使得只需创建和维护单一的源文件，并自动生成有用的文档。

#### 2.8.2 语法

所有 javadoc 命令只能在 “/\*\*" 注释中出现，和通常一样，注释结束于 ”\*/“。使用 javadoc 的方式主要有两种：嵌入 HTML，或使用”文档标签“。独立文档标签是一些以 **”@“** 字符开头的命令，且要置于注释行最前面。而 ”行内文档标签“ 则可以出现在 javadoc 注释任何地方，它们也是 ”@“ 开头，但要在花括号里。

一共有三种类型的注释文档，分别对应于注释位置后面的三种元素：类、域和方法。

注意，javadoc 只能为 **public** （公共）和 **protected** （受保护）成员进行文档注释。 **private**（私有）是程序员不希望用户可以看到的。

#### 2.8.3 嵌入式 HTML

**javadoc** 通过生成的 HTML 文档传送 HTML 命令，使得能充分利用 HTML。当然其主要目的还是为了对代码进行格式化。在文档注释中，位于每一行开头的星号和前导空格都会被 javadoc 丢弃。 javadoc会对所有内容重新格式化，使其与标准文档外观一致。不要在嵌入式 HTML 中使用标题标签，javadoc 会插入自己的标题，而你自己的标题可能会和他们发生冲突。

#### 2.8.4 一些标签

在使用 javadoc 处理重要事情之前，应该先去 **JDK 文档**中查阅 javadoc 参考。

1. @see：引用其他类

@see 标签允许用户引用其他类的文档。 javadoc 会在其生成的 HTML 文件中，通过 @see 链接到其他文档。

2. {@docRoot}

产生到文档根目录的相对路径，用于文档树页面的显示超链接。

3. @version

生成版本信息

4. @author

5. @deprecated

用于指出一些就特性已经由改进的新特性所取代，建议用户不要再使用这些旧特性，因为在不久的将来它们可能会被删除。

#### 2.8.5 文档示例

```java
//:src/App.java

import java.util.*;

/**The first Thinking in Java example program.
 * Displays a string and today's data
 * @author zbz
 * @version 4.0 
 */
public class App {
    /**
     * 
     * @param args array of string arguments
     * @throws Exception No exceptions thrown
     */
    public static void main(String[] args) throws Exception {
        
        System.out.println("Hello, it's:");
		System.out.println(new Date());
        
    }
}/*Output:(55% match) 

*///:~

```

### 2.9 编码风格

在“ Java 编程语言编码约定” 中，代码风格这样约定：类名的首字母要大写，如果类名由几个单词构成，那么把它们并在一起，每个单词首字母大写。这种风格被称作“驼峰风格”。**只是**标识符的第一个字母采用小写。



## 第三章 操作符

在最底层，Java 中的数据是通过操作符来操作的。

Java 是建立在 C++ 基础之上的，所以 C 和 C++ 熟悉的人应该非常熟悉 Java大多数操作符。Java 也做了一些改进与简化。

### 3.1 更简单的打印语句

在前面介绍了 Java 的打印语句：`System.out.println("...");`

可以看到这条语句不仅涉及许多类型（有许多多余的链接），而且它读起来也很费劲。在 Java SE5 中新增加了一个概念——静态导入（static import），并将创建一个小类库来简化打印语句编写。

```java
import java.util.*;
import static java.lang.System.out;

public class Example27 {
  public static void main(String[] args) throws Exception {  
      out.println("Hello, it's:");
      out.println(new Date());     
  }
}
```

改写后程序清爽很多。注意上面程序的第二行代码：`import static java.lang.System.out;`，import 中插入了 static。尽管使用静态导入可以很好的简化代码，但是它并非在任何场合都显得恰当。如果在代码中只有少量的打印语句，还是先用 import 然后编写完整的 `System.out.println();`。

### 3.2 使用 Java 操作符

+，-，*，/号用法与其他编程语言类似。几乎所有操作符都只能操作“基本类型”。例外的是 “=”，“==”，“!=”，这些操作符能操作所有的对象。除此之外，**String** 类支持 “+” 和 “+=”。

### 3.3 优先级

操作符的优先级决定了各部分的计算顺序，如果不确定优先级，应该用括号明确规定计算顺序。

```java
public class Example31 {
	public static void main(String[] args) {
		int x=1,y=2,z=3;
		int a=x+y-2/2+z;
		int b=x+(y-2)/(2+z);
		System.out.println("a="+a+"\tb="+b);
	}
}
/*Output:
 * a=5 b=1
 * */
```

上面例子可以看出有无括号的输出有很大不同。

注意，`System.out.println()`语句中包含 “+” 操作符，在这种上下文环境中，“+” 意味着“字符串连接”，并且如果有必要，还要执行“字符串转换”。

### 3.4 赋值

Java 中对基本数据类型的赋值是很简单的。基本类型存储了实际的数值，而并非指向一个对象的引用，所以在为其赋值的时候，就是直接将一个地方的内容复制到另一个地方。但是，要注意给对象“赋值”的情况。对一个对象进行操作，真正操作的是对对象的引用，所以”将一个对象赋值给另一个对象“，实际上是将”引用“从一个地方复制到另一个地方。即若对对象使用 **c=d**，那么 **c** 和 **d** 都原本只有 **d** 指向的那个对象。

```java
class Tank{
	int level;
}
public class Example32 {
	public static void main(String[] args) {
		Tank t1 = new Tank();
        Tank t2 = new Tank();
        t1.level = 9;
        t2.level = 47;
        System.out.println("1:t1.level:"+t1.level+",t2.level:"+t2.level);
        t1=t2;
        System.out.println("2:t1.level:"+t1.level+",t2.level:"+t2.level);
        t1.level=27;
        System.out.println("3:t1.level:"+t1.level+",t2.level:"+t2.level);
        
	}
}/*Output:
*1:t1.level:9,t2.level:47
*2:t1.level:47,t2.level:47
*3:t1.level:27,t2.level:27
*///:~
```

原本 **t1** 包含的对对象的引用是指向一个值为 9 的对象。在对 **t1** 赋值的时候，这个引用被 **t2** 的引用覆盖，也就是丢失了；然后 **t1** 和 **t2** 包含同一个引用，指向相同的对象，所以后面的修改 **t1** 的同时也改变了 **t2**。而那个原本的 **t1** 的引用的对象 9 会由“垃圾回收器”自动清理。

这种现象被称为**“别名现象”**，是 Java 操作对象的一种基本方式。在上面的例子中，若想避免这样的现象，可以这样写`t1.level=t2.level`，这样就可以使两个对象彼此独立，而不是将 **t1** 和 **t2** 绑定到相同的对象。从现在开始就要留意，为对象赋值可能会产生意想不到的结果。

#### 3.4.1 方法调用中的别名问题

将一个对象传递给方法时，也会产生别名问题：

```java
class Letter{
	char c;
}
public class Examole33 {
	static void f(Letter y) {
		y.c='z';
	}
	public static void main(String[] args) {
		Letter x=new Letter();
		x.c='a';
		System.out.println("1:x.c:"+x.c);
		f(x);
		System.out.println("2:x.c:"+x.c);
	}
}/*Output:
*1:x.c:a
*2:x.c:z
*///:~
```

在许多其他语言中，方法 **f()** 似乎要在它的作用域内复制参数 **Letter y** 的一个副本；但实际上只是传递了一个引用。所以`y.c='z';`实际上改变的是 **f()** 之外的对象。别名引起的问题及其解决办法是个很复杂的话题，但是现在就应该知道它的存在，并且在使用中注意这个陷阱。

### 3.5 算术操作符

Java 基本算术操作符与其他大多数程序设计语言相同，例子：

```java
import java.util.*;

public class Example34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random(47);
		int i, j, k;
		j = rand.nextInt(100) + 1;
		System.out.println("j:" + j);
		k = rand.nextInt(100) + 1;
		System.out.println("k:" + k);
		i = j + k;
		System.out.println("j+k:" + i);
		i = j - k;
		System.out.println("j-k:" + i);
		i = k / j;
		System.out.println("k/j:" + i);
		i = k * j;
		System.out.println("j*k:" + i);
		i = k % j;
		System.out.println("k%j:" + i);
		j %= k;
		System.out.println("j%k:" + j);
		// Float u,v,w;
		float u, v, w;
		v = rand.nextFloat();
		System.out.println("v:" + v);
		w = rand.nextFloat();
		System.out.println("w:" + w);
		u = v + w;
		System.out.println("v+w:" + u);
		u = v - w;
		System.out.println("v-w:" + u);
		u = v * w;
		System.out.println("v*w:" + u);
		u = v / w;
		System.out.println("v/w:" + u);
		// The following also works for char
		// byte, short, int, long, and double
		u += v;
		System.out.println("u+=v:" + u);
		u -= v;
		System.out.println("u-=v:" + u);
		u *= v;
		System.out.println("u*=v:" + u);
		u /= v;
		System.out.println("u/=v:" + u);
	}

}/*Output:
j:59
k:56
j+k:115
j-k:3
k/j:0
j*k:3304
k%j:56
j%k:3
v:0.5309454
w:0.0534122
v+w:0.5843576
v-w:0.47753322
v*w:0.028358962
v/w:9.940527
u+=v:10.471473
u-=v:9.940527
u*=v:5.2778773
u/=v:9.940527
*/

```

要生成数字，首先要创建一个 **Random** 类的对象，如果在创建过程中没有传递任何参数，那么 Java 就会将当前的时间作为随机数生成器的种子（用于随机数生成器的初始化值，随机数生成器对于特定的种子值总是产生相同的随机数序列），上面示例通过在创建 **Random** 对象时提供种子，就可以在每次执行程序时生成相同的随机数，因此输出是可以验证的。

通过 **Random** 类对象，程序可以生成许多不同类型的随机数字。需要调用方法 **nextInt()** 和 **nextFloat()** 即可（也可调用 **nextLong()** 或者 **nextDouble()**）。传递给 **nextInt()** 的参数设置了所产生的随机数的上限，而其下限为 0，所以要对结果进行加 1 操作，避免除 0 的可能性。

#### 3.5.1 一元加、减操作符

一元加（+）和一元减（-）与二元加减号使用相同的符号。一元减号用于转变数据的符号，而一元加号只是为了与一元减相对应，它唯一的作用仅仅是将较小类型的操作数提升为 **int**。

### 3.6 自动递增和递减

Java 提供大量快捷运算，使得编码更方便，同时也使得代码更容易阅读，但是有时可能使代码阅读起来更困难。与 C 和 C++ 类似，自增与自减操作符有“前缀式”和“后缀式”两种使用方法。对于前缀式，会先执行运算，再生成值。后缀式与之相反。例子：

```java
public class Example35 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=1;
		System.out.println("i:"+i);
		System.out.println("++i:"+ ++i);
		System.out.println("i:"+i);
		System.out.println("i++:"+ i++);
		System.out.println("i:"+i);
		System.out.println("--i:"+ --i);
		System.out.println("i:"+i);
		System.out.println("i--:"+ i--);
		System.out.println("i:"+i);
	}
}/*Output
*i:1
*++i:2
*i:2
*i++:2
*i:3
*--i:2
*i:2
*i--:2
*i:1
*/
```

### 3.7 关系操作符

关系操作符包括 “<”、“>”、“<=”、“>=”、“==”、“!=”，与 C 和 C++ 类似，生成一个 boolean 结果。“==” 和 “!=” 适用于所有基本类型，而其他比较符不使用与 boolean 类型。

#### 3.7.1 测试对象的等价性

关系操作符 “==” 和 “!=” 也适用于所有对象，但是他们比较的是对象的引用。如果想比较两个对象的实际内容是否相同，必须使用对所有对象都适用的特殊方法 **equals()**，但是这个方法不适用与“基本类型”，基本类型直接使用 “==” 和 “!=”。例：

```java
public class Example36 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 9;
		int n2 = 9;
		System.out.println(n1 == n2);
		System.out.println(n1 != n2);
		String s1 = new String("abc");
		String s2 = new String("abc");
		System.out.println(s1 == s2);
		System.out.println(s1 != s2);
		System.out.println(s1.equalsIgnoreCase(s2));
	}
}/*Output:
*true
*false
*false
*true
*true
*/
```

注意：这本书以 JDK5.0 为基~~础而作，书中的例子里`Integer n1 = new Integer(47);` 这种建立 int 型的方法在 JDK9.0 之后就不再支持，Eclipse 会报错。从jdk1.9开始就不建议用Integer构建包了，官方推荐使用ValueOf方法来构建包 ：

~~Integer obj = new Integer(1024);~~ 

Integer obj = Integ-- er.v --alueOf(1024);

但是事情并没有那么简单，假设你自己创建了类：

```java
class Value{
	int i;
}
public class Example36 {
	public static void main(String[] args) {
        Value v1 = new Value();
		Value v2 = new Value();
		v1.i=v2.i=10;
		System.out.println(v1.equals(v2));
	}
}/*Output:
*false
*/
```

很费解的是结果又是 false ！！！，这是由于 equals() 的默认行为是比较引用。所以除非在自己的新类中覆盖 equals() 方法，否则不会表现出我们希望的行为。后面会学到覆盖，如何恰当地定义 equals()。但是现在开始需要留意 equals() 的表现方式，会避免一些错误。

### 3.8 逻辑操作符

逻辑操作符：“&&”（与）、“||”（或）、“!"（非），结果是一个 boolean 值。例子：

```java
import java.util.Random;
public class Example37 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random(47);
		int i = rand.nextInt(100);
		int j = rand.nextInt(100);
		System.out.println("i=" + i);
		System.out.println("j=" + j);
		// Treating an int as a boolean is not legal Java;
		// !System.out.println("i && j:"+(i && j));
		// !System.out.println("i || j:"+(i || j));
		// !System.out.println("!i:"+(!i));
		System.out.println("(i<10) && (j<10) is " + ((i < 10) && (j < 10)));
		System.out.println("(i<10) || (j<10) is " + ((i < 10) || (j < 10)));
	}
}/*Output:
*i=58
*j=55
*(i<10) && (j<10) is false
*(i<10) || (j<10) is false
*/
```

逻辑操作符**只可应用于布尔值**，这与 C、C++ 中不同：不能将一个非布尔值当作布尔值在逻辑表达式中使用。代码中用 “//!” 注释掉的语句，就是错误的方法。

#### 3.8.1 短路

使用逻辑操作符时，一旦能够明确无误地确定整个表达式的值，就不再计算表达式余下部分了。这种现象叫做“短路”。所以整个逻辑表达式靠后的部分有可能不会被运算。例子：

```java
public class Example37 {
	static boolean test1(int val) {
		System.out.println("test1(" + val + ")");
		System.out.println("result:" + (val < 1));
		return val < 1;
	}

	static boolean test2(int val) {
		System.out.println("test2(" + val + ")");
		System.out.println("result:" + (val < 2));
		return val < 2;
	}

	static boolean test3(int val) {
		System.out.println("test3(" + val + ")");
		System.out.println("result:" + (val < 3));
		return val < 3;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean b = test1(0) && test2(2) && test3(2);
		System.out.println("expression is " + b);
	}
}/*
	 * Output: 
	 * test1(0)
	 * result:true
	 * test2(2)
	 * result:false
	 * expression is false
	 */

```

输出结果显示，第二个测试产生了一个 **false** 结果，这意味着整个结果肯定是 **false**，所以没必要计算剩余的式子，不论这个式子后面还有多少个 test，都会直接跳过。这样可以获得潜在的性能提升。

### 3.9 直接常量

如果在程序里使用了**“直接常量”**，编译器可以准确的知道要生成什么样的类型，但有时候却是模棱两可。如果发生这样的情况，必须对编译器加以适当的“指导”，用与直接量相关的某些字符来额外增加一些信息。

（此处直接常量的意思，个人认为是用十六进制表示）

例子：

```java
public class Example38 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i1 = 0x2f;// Hexadecimal(lowercase)
		System.out.println("i1:" + i1);
		System.out.println("i1:" + Integer.toBinaryString(i1));// toBinaryString 返回无符号二进制整数
		int i2 = 0X2F;// Hexadecimal(uppercase)
		System.out.println("i2:" + Integer.toBinaryString(i2));
		int i3 = 0177;// Octal (leading zero)
		System.out.println("i3:" + i3);
		System.out.println("i3:" + Integer.toBinaryString(i3));
		char c = 0xffff; // max char hex value
		System.out.println("c:" + c);
		System.out.println("c:" + Integer.toBinaryString(c));
	}
}/*
	 * Output: 
	 * i1:47 
	 * i1:101111 
	 * i2:101111 
	 * i3:127 
	 * i3:1111111 
	 * c:￿ 
	 * c:1111111111111111
	 */
```

C 、C++ 或者 Java 中二进制数没有直接常量表示方法。但是在使用十六进制和八进制时，以二进制形式显示结果将非常有用。通过使用 **Integer** 和 **Long** 类的静态方法 **toBinaryString()** 可以很容易实现二进制表示。

#### 3.9.1 指数记数法

Java 采用很不直观的记数法来表示指数，例子：

```java
public class Example39 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float expFloat = 1.39e-43f;
		System.out.println(expFloat);
		double expDouble = 47e47d;
		System.out.println(expDouble);
		double expDouble2 = 47e47;
		System.out.println(expDouble2);
	}
}/*
	 * Output: 
	 * 1.39E-43 
	 * 4.7E48 
	 * 4.7E48
	 */
```

在科学与工程领域，**“e”** 代表自然对数的基数，约等于 2.718。在 FORTRAN 语言中，**“e”** 代表 “10的幂次”，所以在 C、C++、Java中被保留下来。如果编译器能过正确地识别类型，就不必在数值后附加字符。而对于`float f4 = 1e-43f`，编译器通常会将指数作为双精度数处理，所以假如没有这个尾随的 **f**，就会收到一条出错提示，告诉我们必须使用类型装换将 **double** 转换成 **float**。

### 3.10 按位操作符

按位操作符用来操作整数基本数据类型中的单个“比特”（bit），即二进制位，对两个参数中对应的位执行布尔运算，生成结果。

按位操作符和逻辑操作符都使用相同的符号，仅添加一个亦或操作符 “^” ，由于位是非常“小”的，所以按位操作符仅使用一个字符。

按位操作符可以与等号联合使用，以便合并运算和赋值：&=、|=、^=都是合法的，但是“~”是一元操作符，所以不能与等号联用。

### 3.11 移位操作符

移位操作符的运算对象也是二进制的“位”，有左移位操作符（<<）、有符号右移位操作符（>>）和无符号右移位操作符（>>>）。左移位操作符按操作符右侧指定位数将操作符左边操作数向左移位（低位补0）；有符号右移位操作符按照操作符右侧指定位数将操作符左边的操作数向右移动，在移动时使用“符号扩展”，若符号为正，在高位插入0，符号为负，高位插入1；无符号右移位操作符在移位操作时使用“零扩展”，无论正负，高位都插入0，这是 C 或 C++ 中没有的。

如果对 char、byte 等类型的数值进行移位处理，在移位之前，会被转换为 int 类型，并且得到一个 int 类型的值。

移位可以和等号组合使用（<<=、>>=等），此时操作符左边的值会移动由右边的值指定的位数，再将得到的结果赋值给左边的变量。

例子：

```java
public class Example310 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = -1;
		System.out.println(Integer.toBinaryString(i));
		i >>>= 10;
		System.out.println(Integer.toBinaryString(i));
		long l = -1;
		System.out.println(Long.toBinaryString(l));
		l >>>= 10;
		System.out.println(Long.toBinaryString(l));
		short s = -1;
		System.out.println(Integer.toBinaryString(s));
		s >>>= 10;
		System.out.println(Integer.toBinaryString(s));
	}
}/*
	 * Output: 
	 * 11111111111111111111111111111111 
	 * 1111111111111111111111
	 * 1111111111111111111111111111111111111111111111111111111111111111
	 * 111111111111111111111111111111111111111111111111111111
	 * 11111111111111111111111111111111 
	 * 11111111111111111111111111111111
	 */
```

下面的例子展示了如何应用涉及“按位”操作的所有操作符：

```java
public class Example310 {

	public static void main(String[] args) {
        Random rand = new Random(47);
		int i = rand.nextInt();
		int j = rand.nextInt();
		System.out.println("-1:" + Integer.toBinaryString(-1));
		System.out.println("+1:" + Integer.toBinaryString(1));
		int maxpos = 2147483647; // int型数上限
		System.out.println("maxpos:" + Integer.toBinaryString(maxpos));
		int maxneg = -2147483648;// int型数下线
		System.out.println("maxneg:" + Integer.toBinaryString(maxneg));
		System.out.println("i:" + Integer.toBinaryString(i));
		System.out.println("~i:" + Integer.toBinaryString(~i));
		System.out.println("-i:" + Integer.toBinaryString(-i));
		System.out.println("j:" + Integer.toBinaryString(j));
		System.out.println("i & j:" + Integer.toBinaryString(i & j));
		System.out.println("i | j:" + Integer.toBinaryString(i | j));
		System.out.println("i ^ j:" + Integer.toBinaryString(i ^ j));
		System.out.println("i << 5:" + Integer.toBinaryString(i << 5));
		System.out.println("i >> 5:" + Integer.toBinaryString(i >> 5));
		System.out.println("(~i) >> 5:" + Integer.toBinaryString((~i) >> 5));
		System.out.println("i >>> 5:" + Integer.toBinaryString(i >>> 5));
		System.out.println("(~i) >>> 5:" + Integer.toBinaryString((~i) >>> 5));
	}
}
/* Output2: 
 * -1:11111111111111111111111111111111 
 * +1:1
 * maxpos:1111111111111111111111111111111
 * maxneg:10000000000000000000000000000000 
 * i:-1172028779
 *  i:10111010001001000100001010010101
 * ~i:1000101110110111011110101101010 
 * -i:1000101110110111011110101101011
 * j:1717241110
 * j:1100110010110110000010100010110 
 * i & j:100010000000000000000000010100 
 * i | j:11111110011111110100011110010111 
 * i ^ j:11011100011111110100011110000011 
 * i << 5:1000100100010000101001010100000 
 * i >> 5:11111101110100010010001000010100
 * (~i) >> 5:10001011101101110111101011 
 * i >>> 5:101110100010010001000010100 
 * (~i) >>> 5:10001011101101110111101011
 */
```

long 类型数据也可像上面一样操作。

### 3.12 三元操作符&if-else

三元操作符（条件操作符），很特别：唯一一个三元操作符，且最终会生成一个值，与普通 if-else 语句不同。表达式：`boolean-exp ? value0 : value1`，与 C 和 C++一样，当然也可以换用普通 if-else 语句，但是三元操作符更加简洁。假如打算频繁使用它，要慎重考虑，因为很容易产生可读性极差的代码。下面是比较三元操作符和 if-else 比较的例子：

```java
public class Example311 {
	static int ternary(int i) {
		return i < 10 ? i * 100 : i * 10;
	}
	// 如果编写方法，建议使用三元操作符，根据代码规范，函数有两个出口是不合格的！！！
	static int standardIfElse(int i) {
		if (i < 10)
			return i * 100;
		else
			return i * 10;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ternary(9));
		System.out.println(ternary(10));
		System.out.println(standardIfElse(9));
		System.out.println(standardIfElse(10));
	}
}/*
	 * Output: 
	 * 900 
	 * 100 
	 * 900 
	 * 100
	 */
```

### 3.13 字符串操作符 + 和 +=

“+” 这个操作符在 Java 中有特殊的用途：连接不同的字符串。字符串操作符有一些很有趣的行为。如果表达式以一个字符串起头，那么后续所有操作数都必须是字符串型。

```java
public class Example312 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0, y = 1, z = 2;
		String s = "x, y, z ";
		System.out.println(s + x + y + z);
		System.out.println(x + "" + s);
		s += "summed = ";
		System.out.println("" + x);
	}
}/*
	 * Output: x, y, z 012 
	 * 0x, y, z 
	 * 0
	 */
```

### 3.14 使用操作符时常犯的错误

### 3.15 类型转换操作符

类型转换（cast）的原意是“模型铸造”。类型转换运算允许显式地进行类型转换，或者在不能自动进行转换的时候强制进行类型转换。例子：

```java
public class Exmaple313 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 200;
		long lng = (long) i;
		System.out.println(lng);
		long lng2 = 200;
		i = (int) lng2;
		System.out.println(i);
	}
}/*
	 * Output: 
	 * 200 
	 * 200
	 */
```

在 C 和 C++ 中，类型转换有时会让人头痛，但是在 Java 中，类型转换是一种比较安全的操作。类型转换分为两种——窄化转换（narrowing conversion）和扩展转换（widening conversion）。执行窄化转换时（即将能容纳更多信息的数据类型转换为无法容纳那么多信息的类型），会面临信息丢失的危险，此时编译器会强制程序员进行类型转换。执行扩展转换则不需要显式类型转换。

Java 允许将任何基本数据类型转换成别的基本数据类型，布尔类型除外。

#### 3.15.1 截尾和舍入

在执行窄化转换时，必须注意截尾和舍入的问题。例子：

```java
public class Example314 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double above = 0.7, below = 0.4;
		float fabove = 0.7f, fbelow = 0.4f;
		System.out.println("(int)above:" + (int) above);
		System.out.println("(int)below:" + (int) below);
		System.out.println("(int)fabove:" + (int) fabove);
		System.out.println("(int)fbelow:" + (int) fbelow);
		System.out.println("Math.round(above):" + Math.round(above));
		System.out.println("Math.round(below):" + Math.round(below));
		System.out.println("Math.round(fabove):" + Math.round(fabove));
		System.out.println("Math.round(fbelow):" + Math.round(fbelow));
	}
}/*
	 * Output: 
	 * (int)above:0 
	 * (int)below:0 
	 * (int)fabove:0 
	 * (int)fbelow:0
	 * Math.round(above):1 
	 * Math.round(below):0 
	 * Math.round(fabove):1
	 * Math.round(fbelow):0
	 */
```

可以看出， **float** 或者 **double** 类型转为整型时，会将数字执行截尾操作。如果要得到舍入的结果，需使用 **java.lang.Math** 中的 **round()** 方法。

### 3.16 Java 没有 sizeof

在 C 和 C++ 中，sizeof() 操作符可以告诉你为数据项分配的字节数。在 C 和 C++ 中，需要使用 sizeof() 的原因最大的原意是为了“移植”。Java 不需要 sizeof() 的原因是所有数据类型在所有机器中大小是相同的。

## 第四章 控制执行流程

**就像有知觉的生物一样，程序必须在执行过程中控制它的世界，并做出选择。在 Java 中，你要使用执行控制语句来做出选择。**

Java 中使用所有 C 语言中的流程控制语言，所以在此仅简单介绍。

### 4.1 true & false

注意 Java 不允许我们将一个数字作为布尔值使用，但这在 C 和 C++ 中是允许的（“真”是非零，“假”是零）。

### 4.2 if-else

该语句是控制程序流程最基本的形式，其中 else 是可选的。例子：

```java
public class Example401 {
	static int result = 0;

	static void test(int testval, int target) {
		if (testval > target)
			result = +1;
		else if (testval < target)
			result = -1;
		else
			result = 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test(10, 5);
		System.out.println(result);
		test(5, 10);
		System.out.println(result);
		test(5, 5);
		System.out.println(result);
	}
}/*
	 * Output: 
	 * 1 
	 * -1 
	 * 0
	 */
```

### 4.3 迭代

**while**、**do-while** 和 **for** 用来控制循环。

```java
//while
public class Example402 {
	static boolean condition() {
		boolean result = Math.random() < 0.99;
		System.out.println(result + ",");
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (condition())
			System.out.println("Inside 'while'");
		System.out.println("Exited 'while'");
	}
}/*
	 * Output: (Execute to see output)
	 */
```

```java
//for
public class Example403 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(char c = 0; c < 128; c++){
            int i = (int)c;
            if(Character.isLowerCase(c));{
                System.out.println("value:" + i + "character:" + c);
            }
        }
	}

}
```



### 4.4 foreach 语法

该语法和 python 的 foreach 相似。

### 4.5 return

return 关键词有两方面用途：一方面指定一个方法返回什么值，另一方面会导致当前的方法退出，并且返回那个值。

### 4.6 break 和 continue

任何迭代语句的主体部分，都可用 break 和 continue 控制循环的流程。其中，break 用于强行退出循环，不执行剩余语句。而continue 则停止当前迭代，然后退回循环起始处，开始下一次迭代。

### 4.7 switch

switch 有时也被规划为一种选择语句，是实现多路选择的一种干净利落的方法。

## 第五章 初始化与清理

**随着计算机革命的发展。“不安全”的编程方式已逐渐成为编程代价高昂的主要原因之一。**

初始化和清理正是涉及安全的两个问题。C++ 引入了**构造器（constructor）**概念，这是一个在创建对象时被自动调用的特殊方法。Java 中也采用了构造器，并额外提供了“垃圾回收器”。对于不再使用的内存资源，垃圾回收器能自动将其释放。

### 5.1 用构造器确保初始化

在 Java 中，通过提供构造器，类的设计者可以确保每个对象都会得到初始化。创建对象时，如果类具有构造器，Java 就会在用户有能力操作对象之前自动调用相应的构造器，从而保证初始化的进行。

如何命名构造器？构造器采用与类相同的名称。例子：

```java
public class Example501 {
	Example501() {// This is the constructor
		System.out.println("Rock");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			new Example501();
		}
	}
}/*
	 * Output: Rock Rock Rock Rock Rock Rock Rock Rock Rock Rock
	 */
```

注意，由于构造器名称必须与类名完全相同，所以“每个方法首字母小写”的编码风格在此不适用。

不接受任何参数的构造器叫做**默认构造器**，Java 文档中通常用术语**无参构造器**。和其他方法一样，构造器也能带有形式参数，以便指定如何创建对象。将上面例子稍加改写：

```java
public class Example501 {
	Example501(int i) {// This is the constructor
		System.out.println("Rock" + i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			new Example501(i);
		}
	}
}/*
	 * Output: Rock0 Rock1 Rock2 Rock3 Rock4 Rock5 Rock6 Rock7 Rock8 Rock9
	 * 
	 */
```

有了构造器参数，就可以在初始化对象时提供实际参数。构造器有助于减少错误，并使代码更易阅读。在 Java 中，“初始化”和创建捆绑在一起，两者不分离。

构造器是一种特殊类型的方法，因为它没有返回值。

### 5.2 方法重载

任何程序设计语言都具备一项重要特性就是对名字的运用。当创建一个对象时，也就给此对象分配到的存储空间取了个名字。

在 Java 里，构造器是强制重载方法名的另一个原因。假如要创建一个类，其有两种构造器：一个是默认构造器，另一个取字符串作为形参。由于都是构造器，所以它们必须有相同的名字，即类名。为了让方法名和相同而形参不同的构造器同时存在，必须用到**方法重载**。尽管方法重载是构造器说必需的，但它亦可以用于其他方法，且用法同样方便。例子：

```java
public class Example502 {
	int height;

	Example502() {
		System.out.println("Planting a seeding");
		height = 0;
	}

	Example502(int i) {
		height = i;
		System.out.println("Creating new Tree that is " + height + "feet tall");
	}

	void info() {
		System.out.println("Tree is " + height + "feet tall");
	}

	void info(String s) {
		System.out.println(s + ": Tree is " + height + " feet tall");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			Example502 t = new Example502(i);
			t.info();
			t.info("overloaded method");
		}
		System.out.println();
		new Example502();
	}
}/*
	 * Output:
	 * Creating new Tree that is 0feet tall 
	 * Tree is 0feet tall 
	 * overloaded method: Tree is 0 feet tall 
	 * Creating new Tree that is 1feet tall 
	 * Tree is 1feet tall 
	 * overloaded method: Tree is 1 feet tall 
	 * Creating new Tree that is 2feet tall 
	 * Tree is 2feet tall 
	 * overloaded method: Tree is 2 feet tall 
	 * Creating new Tree that is 3feet tall 
	 * Tree is 3feet tall 
	 * overloaded method: Tree is 3 feet tall 
	 * Creating new Tree that is 4feet tall 
	 * Tree is 4feet tall 
	 * overloaded method: Tree is 4 feet tall
	 * 
	 * Planting a seeding
	 */

```

#### 5.2.1 区分重载方法

区分规则：每个重载的方法都必须有一个独一无二的参数类型列表。甚至参数顺序不同也可以区分两个方法，但是一般情况下别这么做，会使代码难以**维护**。

### 5.3 默认构造器

默认构造器（又称“无参”构造器）是没有形参的。它的作用是创建一个“默认对象”，如果类中没有构造器，编译器会自动创建一个默认构造器。

### 5.4 this 关键字

假设希望在方法的内部获得对当前对象的引用。由于这个引用是由编译器“偷偷”传入的，所以没有标识符可用。但是为此有个专门的关键字：this。this 关键字只能在方法内部使用，表示对“调用方法的那个对象”的引用。this 用法和其他对象引用并无不同。但如果在方法内部调用同一个类的另一个方法，就不必使用 this，直接调用即可。例子：

```java
class Person{
	public void eat(Apple apple) {
		Apple peeled = apple.getPeeled();
		System.out.println("Yummy");
	}
}

class Peeler{
	static Apple peel(Apple apple) {
		//...
		return apple;
	}
}

class Apple{
	Apple getPeeled() {
		return Peeler.peel(this);
	}
}
public class Example503 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Person().eat(new Apple());
	}
}
```

Apple 需要调用 Peeler.peel() 方法，是一个外部的工具方法，将执行由于某种原因而必须放在 Apple 外部的操作。为了将其自身传递给外部方法，Apple 必须使用 this 关键字。

#### 5.4.1 在构造器中调用构造器

可能为一个类写了多个构造器，有时可能想在一个构造器中调用另一个构造器，以避免重复代码。可用 this 关键字做到这一点。通常写 this 时，都是指“这个对象”或者“当前对象”，而且它本身表示对当前对象的引用。在构造器中，如果为 this 添加了参数列表，那么就有了不同的含义。这将产生对符合此参数列表的某个构造器的明确调用；这样，调用其他构造器就有了直接的途径。例子：

```java
public class Example504 {
	int petalCount = 0;
	String s = "initial value";

	Example504(int petals) {
		petalCount = petals;
		System.out.println("Constructor w/ int arg only, petalCount= " + petalCount);
	}

	Example504(String ss) {
		System.out.println("Constructor w/ String arg only, s = " + ss);
		s = ss;
	}

	Example504(String s, int petals) {
		this(petals);
		// ! this(s); //Can't call two!
		this.s = s; // Another use of "this"
		System.out.println("String & int args");
	}

	Example504() {
		this("hi", 47);
		System.out.println("petalCount = " + petalCount + " s = " + s);
	}

	void printPetalCount() {
		// ! this(11); //not inside non-constructor!
		System.out.println("petalCount = " + petalCount + " s = " + s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example504 x = new Example504();
		x.printPetalCount();
	}
}/*
	 * Output: 
	 * Constructor w/ int arg only, petalCount= 47 
	 * String & int args
	 * petalCount = 47 s = hi 
	 * petalCount = 47 s = hi
	 * 
	 */
```

构造器 Example504(String s,int petals) 表明，尽管可以用 this 调用一个构造器，但不恩调用两个。此外，必须将构造器调用置于最起始处，否则编译器会报错。

例子也展示了 this 的另一种用法。由于参数 s 的名称和数据成员 s 的名字相同，所以会产生歧义。使用 this.s 代表数据成员就能解决这个问题。在 Java 代码中经常出现这种写法。

#### 5.4.2 static 的含义

static 方法就是没有 this 的方法。在 static 方法的内部不能调用非静态方法，反过来倒是可以。而且可以在没有创建任何对象的前提下，仅仅通过类本身来调用 static 方法。这实际上正是 static 方法的主要用途。很像全局方法。

### 5.5 清理：终结处理和垃圾回收

程序员都了解初始化的重要性，但**清理**工作也同样重要。在使用程序库时，把一个对象用完之后就“弃之不顾”的做法**并非总是安全**。Java 有垃圾回收器负责回收无用对象占据的内存资源。但也有**特殊情况**：由于垃圾回收器只知道释放那些经由 new 分配的内存，如果你的对象不是通过 new 申请的内存空间，垃圾回收器就不会释放这个对象的内存。

为了应对这样的情况，Java 允许在类中定义一个名为 **finalize()** 的方法。他的工作原理**“假定”**是这样：一旦垃圾回收器准备释放对象占用的存储空间，将首先调用其 **finalize()** 方法，并且在下次垃圾回收时，才会真正回收对象占用的内存。所以如果打算用 **finalize()** 方法，就能在垃圾回收时刻做一些重要的清理工作。

这里有一个潜在的陷阱，有人会把 **finalize()** 方法当作 C++ 中的**析构函数**（C++ 销毁对象时必须用到这个函数）。有必要明确区分一下：在 C++ 中，对象一定会被销毁；而 Java 里的对象并非总是被垃圾回收。换句话说：

> 1、对象可能不被垃圾回收。
>
> 2、垃圾回收并不等于“析构”

这意味着不需要某个对象之前，如果必须执行某些动作，得自己动手去做。Java 并未提供“析构函数”或相似概念，要做类似的清理工作，必须自己动手创建一个执行清理工作的普通方法。

如果程序执行结束，且垃圾回收器一直都没有释放创建的任何对象的存储空间，那么随着程序的退出，那些资源也会全部交还给操作系统。

#### *5.5.1 finalize()用途

> 3、垃圾回收只与内存有关

即使用垃圾回收器的唯一原因是为了回收程序不再使用的内存。所以对于垃圾回收的任何行为（尤其是 **finalize()** 方法），它们也必须**同内存及其回收有关**。

但这并不意味着对象中含有其他对象，finalize() 就应该明确释放这些对象，无论对象如何创建，垃圾回收器都会负责释放对象占据的所有内存。这将对 finalize() 的需求限制到一种特殊情况，即**通过某种创建对象方式以外的方式为对象分配了存储空间**。

之所以要有 finalize() ，是由于在分配内存时可能采用了**类似 C 语言中的做法**。而非 Java 代码方式。本地方法目前支持 C 和 C++，但它们可以调用其他语言写的代码。在非 Java 代码中，也许会调用 C 的 **malloc()** 函数来分配存储空间，除非调用 **free()**  函数，否则存储空间将得不到释放，从而造成内存泄露。**free()** 是 C 和 C++ 中的函数，所以需要在 **finalize()** 中用本地方法调用它。 

#### *5.5.2 必须实施清理

Java 不允许创建局部对象，必须使用 **new** 创建。在 Java 中，也没有 C++ 中用于释放对象的 **delete**，因为垃圾回收器会帮助你释放存储空间。**甚至可以肤浅的认为：就是由于垃圾回收机制的存在，使得 Java 没有析构函数。**但是，垃圾回收器并不能完全替代析构函数。如果希望进行除释放空间之外的清理工作，还是得明确调用某个恰当的 Java 方法，这就等同于使用了析构函数，但是没有在 C++ 中方便。

**记住，无论是“垃圾回收”还是“终结”，都不保证会一定发生。**如果 Java 虚拟机并未面临内存耗尽的情况，是不会浪费时间去执行垃圾回收以恢复内存的。

#### *5.5.3 终结条件

通常不能指望 **finalize()** ，必须创建其他的“清理”方法，并且明确调用他们，**finalize()** 只能存在于程序员很难用到的一些晦涩用法里。但是，**finalize()** 还有一个有趣的用法，它并不依赖于每次都要对 **finalize()** 进行调用，这就是对象**终结条件**的验证。

当对某个对象不再感兴趣，即可以被清理了，这个对象应该处于某种状态，使它，使得它占用的内存可以被安全地释放。**只要对象中存在没有被适当清理的部分，程序就存在很隐晦的缺陷。** finalize() 可以用来最终发现这种缺陷情况。例子：

```java
class Book {
	boolean checkedOut = false;

	Book(boolean checkOut) {
		checkedOut = checkOut;
	}

	void checkIn() {
		checkedOut = false;
	}

	protected void finalize() {
		if (checkedOut) {
			System.out.println("Error: checked out");
			// Normally, you'll also do this:
			// super.finalize(); //Call the base-class version
		}
	}
}

public class Example505 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book novel = new Book(true);
		// Proper cleanup
		novel.checkIn();
		// Drop the reference, forget to clean up;
		new Book(true);
		// Force garbage collection & finalization
		System.gc();
	}

}/*
	 * Output: Error: checked out
	 */

```

上面例子的终结条件是：所有 **Book** 对象在被当做垃圾回收前都应该被签入（**check in**)。但是在 **main()** 方法中，由于程序员的错误，有一本书未被签入。要是没有 **finalize()** 来验证终结条件，则很难发现这种错误。

上面例子中 `System.gc()` 就是在 Java 虚拟机中运行垃圾收集器。

#### *5.5.4 垃圾回收器如何工作

在原来的程序语言中，在堆上分配对象的代价很高。但是 Java 中，**垃圾回收器对于提高对象的创建速度，有明显的效果**。或许或有点奇怪：存储空间的释放竟然会影响存储空间的分配。但这就是 JVM 的工作方式。也就是说，**Java 从堆分配空间的速度，可以和其他语言从堆栈分配空间的速度向媲美**。

（没写完）

### 5.6 成员初始化

Java 尽力保证：所有变量在使用之前都能得到初始化。对于方法的局部变量，Java 以编译时错误的形式来贯彻这种保证。如果类成员都是基本类型，情况还会有所不同，类的每个基本类型成员保证都会有一个初始值，例子：

```java
public class Example506 {
	boolean t;
	char c;
	byte b;
	short s;
	int i;
	long l;
	float f;
	double d;
	Example506 reference;

	void printInitialValues() {
		System.out.println("Data type    Initial value");
		System.out.println("boolean      " + t);
		System.out.println("char         " + c);
		System.out.println("byte         " + b);
		System.out.println("short        " + s);
		System.out.println("int          " + i);
		System.out.println("long         " + l);
		System.out.println("float        " + f);
		System.out.println("double       " + d);
		System.out.println("reference    " + reference);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example506 vi = new Example506();
		vi.printInitialValues();
	}

}/*
	 * Output: 
	 *Data type    Initial value
	 *boolean      false
	 *char         
	 *byte         0
	 *short        0
	 *int          0
	 *long         0
	 *float        0.0
	 *double       0.0
	 *reference    null
	 */

```

可见，虽然类成员初始值未给出，但是它们确实有初值（**char** 值为0，所以显示为空白）在类中定义一个对象引用时，如果不将其初始化，该引用就会获得一个 **null**。

#### 5.6.1 指定初始化

有一种给某个变量赋初值的直接方法：在定义成员变量的地方为其赋值（C++ 中不能这样做），对于对象可以用同样的方法。例子：

```java
class Depth{
    
}
public class Measurement{
    Depth d = new Depth();
    //...
}
```

如果没有给 **d** 指定初始值就尝试使用，就会出现运行时错误，告诉你产生了一个**异常**。

这种初始化的方式既简单又直观，但是却有**限制**：所有对象的初始值都一样。有时需要更大的**灵活性**。

### 5.7 构造器初始化

可以用构造器来初始化。但是要**注意**：无法阻止自动初始化的进行，它将在构造器调用之前发生。

#### 5.7.1 初始化顺序

在类内部，变量定义的先后顺序决定了初始化的顺序。即使变量散布在方法定义之间，它们仍旧会在任何方法被调用之前得到初始化。例子：

```java
class Window {
	Window(int marker) {
		System.out.println("Window(" + marker + ")");
	}
}

class House {
	Window w1 = new Window(1); // Before constructor

	House() {
		// show that we're in the constructor
		System.out.println("House()");
		w3 = new Window(33);
	}

	Window w2 = new Window(2);

	void f() {
		System.out.println("f()");
	}

	Window w3 = new Window(3);
}

public class Example507 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		House h = new House();
		h.f();
	}

}/*
	 * Output: 
	 * Window(1) 
	 * Window(2) 
	 * Window(3) 
	 * House() 
	 * Window(33) 
	 * f()
	 */
```

在 **House** 类中，故意把几个 **Window** 对象的定义分散在各处，以证明它们全都会在调用构造器或其他方法之前得到初始化。

#### 5.7.2 静态数据的初始化

无论创建多少对象，静态数据都只占用一份存储区域。**static** 关键字不能应用于局部变量，因此它只能作用于域。如果一个域是静态的基本类型，且没有对它初始化，那么它就会获得基本类型的标准初值；如果是一个对象引用，那么默认初始化值就是 **null**。

那么静态存储区域是什么时候初始化的？例子：

```java
class Bowl {
	Bowl(int marker) {
		System.out.println("Bowl(" + marker + ")");
	}

	void f1(int marker) {
		System.out.println("f1(" + marker + ")");
	}
}

class Table {
	static Bowl bowl1 = new Bowl(1);

	Table() {
		System.out.println("Table()");
		bowl2.f1(1);
	}

	void f2(int marker) {
		System.out.println("f2(" + marker + ")");
	}

	static Bowl bowl2 = new Bowl(2);
}

class Cupboard {
	Bowl bowl3 = new Bowl(3);
	static Bowl bowl4 = new Bowl(4);

	Cupboard() {
		System.out.println("Cupboard()");
		bowl4.f1(2);
	}

	void f3(int marker) {
		System.out.println("f3(" + marker + ")");
	}

	static Bowl bowl5 = new Bowl(5);
}

public class Example508 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Creating new Cupboard() in main");
		new Cupboard();
		System.out.println("Creating new Cupboard() in main");
		new Cupboard();
		table.f2(1);
		cupboard.f3(1);
	}

	static Table table = new Table();
	static Cupboard cupboard = new Cupboard();
}/*
	 * Output: 
	 * Bowl(1) 
	 * Bowl(2) 
	 * Table() 
	 * f1(1) 
	 * Bowl(4) 
	 * Bowl(5) 
	 * Bowl(3) 
	 * Cupboard()
	 * f1(2) 
	 * Creating new Cupboard() in main 
	 * Bowl(3) 
	 * Cupboard() 
	 * f1(2) 
	 * Creating new Cupboard() in main 
	 * Bowl(3) 
	 * Cupboard() 
	 * f1(2) 
	 * f2(1) 
	 * f3(1)
	 */
```

由输出可见，静态初始化只有在必要时才会进行。如果不创建 Table 对象，也不引用 Table.b1 或 Table.b2，那么静态的 Bowl b1 和 b2 永远都不会被创建。只有在第一个 Table 对象被创建的时候，他们才会被初始化。此后，静态对象不会再次被初始化。

初始化的顺序是先静态对象，然后是“非静态”对象。要执行 main 方法，必须加载 Example508 类，然后其静态域 table 和 cupboard 被初始化，这导致他们对应的类也被加载，由于它们都包含静态 Bowl 对象，所以 Bowl 随后也被加载。所有类在 main() 开始之前就都被加载了。但是实际中，不会将所有对象都通过 static 联系起来。

总结对象创建过程，假设有个名为 **Dog** 的类：

1. 即使没有显式地使用 **static** 关键字，构造器实际上也是静态方法。所以，当首次创建类型为 **Dog** 的对象时，或者 **Dog** 类的静态方法/静态域首次被访问时，Java 解释器必须查找类路径，以定位 **Dog.class** 文件
2. 然后载入 **Dog.class** ，有关静态初始化的所有动作都会执行。所以静态初始化只在 **Class** 对象首次加载时进行一次。
3. 当用 **new Dog()** 创建对象时，首先将在堆上为 **Dog** 对象分配足够的存储空间。
4. 这块存储空间会被清零，这就自动地将 **Dog** 对象中所有基本类型数据都设置成默认值，而引用则被置为 **null**。
5. 执行所有出现于字段定义处的初始化动作。
6. 执行构造器。

#### 5.7.3 显式的静态初始化

Java 允许将多个静态初始化动作组织成一个特殊的**“静态子句”**（有时也称作**“静态块”**）。例如：

```java
public class Spoon{
    static int i;
    static{
        i = 47;
    }
}
```

上面例子实际上是一段跟在 **static** 关键字后面的代码。与其他静态初始化动作一样，代码仅执行一次，当首次生成这个类的一个对象是，或者首次访问属于类的静态数据成员时。例子：

```java
class Cup {
	Cup(int marker) {
		System.out.println("Cup(" + marker + ")");
	}

	void f(int marker) {
		System.out.println("f(" + marker + ")");
	}
}

class Cups {
	static Cup cup1;
	static Cup cup2;
	static {
		cup1 = new Cup(1);
		cup2 = new Cup(2);
	}

	Cups() {
		System.out.println("Cups()");
	}
}

public class Example509 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inside main()");
		Cups.cup1.f(99);
	}

}/*
	 * Output: 
	 * Inside main() 
	 * Cup(1) 
	 * Cup(2) 
	 * f(99)
	 */

```

#### 5.7.4 非静态实例初始化

Java 中也有被称为**实例初始化**的语法，用来初始化每个对象的非静态变量。例子：

```java
class Mug {
	Mug(int marker) {
		System.out.println("Mug(" + marker + ")");
	}

	void f(int marker) {
		System.out.println("f(" + marker + ")");
	}
}

public class Example510 {
	Mug m1;
	Mug m2;
	{
		m1 = new Mug(1);
		m2 = new Mug(2);
		System.out.println("m1 & m2 initialized");
	}

	Example510() {
		System.out.println("Mugs");
	}

	Example510(int i) {
		System.out.println("Mugs(int)");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inside main()");
		new Example510();
		System.out.println("new Mugs() completed");
		new Example510(1);
		System.out.println("new Mugs(1) completed");
	}

}/*
	 * Output: 
	 * Inside main() 
	 * Mug(1) 
	 * Mug(2) 
	 * m1 & m2 initialized 
	 * Mugs 
	 * new Mugs() completed 
	 * Mug(1) 
	 * Mug(2) 
	 * m1 & m2 initialized 
	 * Mugs(int) 
	 * new Mugs(1) completed
	 */

```

看起来与静态初始化子句一样，只不过少了 **static**。这种语法对于支持**“匿名内部类”**的初始化是必须的，但它也使得你可以保证无论调用哪个显式构造器，某些操作都会发生。

### 5.8 数组初始化

定义一个数组：`int[] a1`或者`int a1[]`，后者更符合 C 和 C++ 的使用习惯，但是，前一种格式更加合理——“**一个 int 型数组**”。

**编译器不允许指定数组大小。**为了给数组创建相应的存储空间，必须写初始化表达式。对弈数组，初始化动作可以出现在代码任何地方，但也可以使用一种特殊的初始化表达方式，它必须在创建数组的地方出现。这种特殊化的初始化由一对花括号括起来的值组成。在这种情况下，存储空间的分配将由编译器负责。例子：

```java
public class Example511 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1 = { 1, 2, 3, 4, 5 };
		int[] a2;
		a2 = a1;
		for (int i = 0; i < a2.length; i++) {
			a2[i] = a2[i] + 1;
		}
		for (int i = 0; i < a1.length; i++) {
			System.out.println("a1[" + i + "]=" + a1[i]);
		}
	}

}/*
	 * Output: 
	 * a1[0]=2 
	 * a1[1]=3 
	 * a1[2]=4 
	 * a1[3]=5 
	 * a1[4]=6
	 */
```

由于 **a1** 和 **a2** 是相同数组的别名，所以通过 **a2** 所做的修改在 **a1** 中可以看到。

所有数组（无论元素是基本类型还是对象）都有一个固定成员 **length**，可以通过其获知数组内包含多少个元素，但是不能对其修改。Java 数组计数从第 0 个元素开始，所以能使用的最大下标数是 **length-1**。<u>要是超过这个边界，C 和 C++ 会“默默”地接受，并且允许你访问所有的内存。Java 能保护程序免受这一问题的困扰，一旦访问下标过界，就会出现异常。</u>

如果在写程序时，不能确定在数组中需要多少个元素，可以直接使用 new 在数组里创建元素。例子：

```java
import java.util.*;

public class Example512 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a;
		Random rand = new Random(47);
		a = new int[rand.nextInt(20)];
		System.out.println("length of a = " + a.length);
		System.out.println(Arrays.toString(a));
	}

}/*
	 * Output: 
	 * length of a = 18 
	 * [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	 */
```

上面例子说明：数组元素中的基本数据类型会自动初始化成空值。**Arrays.toString()** 方法属于 **java.util** 标准类库，用来产生一维数组可打印版本。当然上面的数组也可以在定义的同时进行初始化：`int[] a = new int[rand.nextInt(20)];`。如果可能的话，尽可能这么做。

如果创建的是一个非基本类型的数组，那么你就创建了一个引用数组。以整型包装器类 **Integer** 为例：

```java
import java.util.*;

public class Example513 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random(47);
		Integer[] a = new Integer[rand.nextInt(20)];
		System.out.println("length of a = " + a.length);
		System.out.println(Arrays.toString(a));
		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt(500);
		}
		System.out.println(Arrays.toString(a));
	}

}/*
	 * Output: 
	 * length of a = 18 
	 * [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null] 
	 * [55, 193, 361, 461, 429, 368, 200, 22, 207, 288, 128, 51, 89, 309, 278, 498, 361, 20]
	 */

```

即使通过 **new** 创建数组之后 `Integer[] a=new Integer[rand.nextInt(20)];`，它还只是一个引用数组，直到通过创建新的 **Integer** 对象，并且把对象值给引用，初始化才算结束：`a[i]=rand.nextInt(500);`。如果忘记创建对象，并且试图使用数组中的空引用，就会在运行时产生异常。

也可以用花括号括起来的列表初始化对象数组。例子：

```java
import java.util.*;

public class Example514 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = { 1, 2, 3 };
		Integer[] b = new Integer[] { 1, 2, 3, };
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}

}/*
	 * Output: 
	 * [1, 2, 3] 
	 * [1, 2, 3]
	 */
```

在这两种形式中，初始化列表的最后一个逗号都是可选的，这一特性使维护长列表变得更容易。第一种形式虽然很有用，但是它也更加受限，因为它只能用于数组被定义之处。

#### 5.8.1 可变参数列表



### 5.9 枚举类型

在 JDK1.5新增 **enum** 关键字，使得程序员在需要群组并使用枚举类型集时，可以很方便地处理。Java 中的 **enum** 功能比 C/C++ 更完备。例子：

```java
enum S {
	NOT, MILD, MEDIUM, HOT, FLAMING
}

public class Example515 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		S howHot = S.MEDIUM;
		System.out.println(howHot);

		for (S j : S.values()) {
			System.out.println(j + ", ordinal " + j.ordinal());
		}

		System.out.println("This burrito is ");
		S s = S.HOT;
		switch (s) {
		case NOT:
			System.out.println("not spicy at all.");
			break;
		case MILD:
		case MEDIUM:
			System.out.println("a little hot.");
			break;
		case HOT:
		case FLAMING:
		default:
			System.out.println("maybe too hot.");

		}
	}

}/*
	 * Output: 
	 * MEDIUM 
	 * NOT, ordinal 0 
	 * MILD, ordinal 1 
	 * MEDIUM, ordinal 2 
	 * HOT, ordinal 3 
	 * FLAMING, ordinal 4 
	 * This burrito is 
	 * maybe too hot.
	 */

```

在创建 **enum** 时，编译器会自动添加一些有用的特性。例如，会创建 **toString()** 方法，以便可以很方便地显示某个 **enum** 实例的名字，这正是上面打印语句如何产生输出的答案。编译器还会创建 **ordinal()** 方法，用来表示某个特定 **enum** 常量的声明顺序，以及 **static values()** 方法，用来按照 **enum** 常量的声明顺序。

**enum** 还有一个特别实用的属性，它可以在 **switch** 语句内实用。

大体上，可以将 **enum** 用作另一种创建数据类型的方式，然后直接将所得到的类型拿来使用。

### 5.10 总结

构造器，这种精巧的初始化机制，应该给人很强的暗示：初始化在 Java 中占有至关重要的地位。构造器能保证正确的初始化的清理（没有正确的构造器调用，编译器就不允许创建对象），所有有了完全的控制，也很安全。

在 Java 中，垃圾回收器会自动为对象释放内存，所以在很多场合下，类似的清理方法在 Java 中就不太需要了。在不需要类似析构函数的行为的时候，Java 的垃圾回收器可以极大地简化编程工作，而且在处理内存的时候也更安全。然而垃圾回收器确实也增加了运行时的开销。

## 第6章 访问权限控制

**访问控制（或隐藏具体实现）与“最初的实现并不恰当”有关。** 

所有优秀的作者，包括程序员，都清楚其著作的某些部分直至重新创作的时候才变得完美，有时甚至要反复重写很多次。如果把一个代码段放到某个位置，等过一会回头再看时，有可能会发现有更好的方式去实现相同的功能。这正是**重构**的原动力之一，**重构**即重写代码，以使得代码更可读，更易理解，并且因此而更具**可维护性**。

但是通常总会有一些消费者（客户端程序员）需要你的代码在某些方面保持不变。因此你想改变代码，而他们想让代码保持不变。所以产生一个问题：如何把变动的事物和保持不变的事物区分开来？

这对**类库（library）**而言尤为重要。该类库的消费者必须依赖他所使用的的那部分类库，并且能够知道如果类库出现了新版本，他们并不需要改写代码。从另一方面说，类库的开发者必须有权限进行修改和改进，并确保客户代码不会因为这些改动而受影响。

为解决这一问题，Java 提供了**访问权限修饰词**，以供类库开发人员向客户端程序员指明哪些是可用的，哪些是不可用的。访问权限控制的等级，从最大权限到最小权限依次为：**public**、**protected**、**包访问权限（无关键词）**和 **private**。

不过，构建类库的概念以及对于谁有权限用该类库构件的控制问题都不完善。其中仍旧存在如何将构件捆绑到一个内聚的类库单元中的问题。对于这一点，Java 用关键字 package 加以控制，访问权限修饰词会因为类是存在于一个相同的包，还是存在于一个单独的包而受到影响。

### 6.1 包：库单元

包内包含有一组类，它们在单一的名字空间之下被组织在一起。

例如在 Java 的标准发布中有一个工具库，它被组织在 **java.util** 名字空间之下。**java.util** 中有一个 **ArrayList** 的类，使用 **ArrayList** 的一种方式就是用其全名 **java.util.ArrayList** 来指定。但是这会让程序变得冗长，所以需要使用 import 关键字。如果想要导入某个类，可以使用 **import** 语句。并且，如果想导入 **java.util**  包中的所有类，可以使用 “*”。

之所以要导入，是要提供一个管理名字空间的机制。所有类成员的名称都是彼此隔离的。**A** 类中的方法 **f()** 和 **B** 类中具有相同特征标记（参数列表）的方法 **f()** 不会彼此冲突。

当编写一个 Java 源代码文件时，此文件通常被称为**编译单元**（有时也被称为**转译单元**）。每个编译单元都必须有一个后缀 **.java**，在编译单元内则可以有一个 **public** 类，该类的名称须与文件的名称相同（包括大小写，但不包括 **.java**）。每个编译单元只能有一个 **public** 类，否则编译器就不会接受。如果在该编译单元中还有额外的类，那么在包之外是无法看见这些类的，这是因为它们不是 **public** 类，而且它们主要用来为主 **public** 类提供支持。

#### 6.1.1 代码组织:star_of_david:

当编译一个 **.java** 文件时，在 **.java** 文件中的每个类都会有一个输出文件，该输出文件的名称与 **.java** 文件中每个类的名称相同，只是多了一个后缀 **.class**。所以，在编译少量 **.java** 文件后，会得到大量的 **.class** 文件。Java 可运行程序是一组可以打包并压缩为一个 Java 文档文件（**JAR**，使用 Java 的 jar 文档生成器）的 **.class** 文件。Java 解释器负责这些文件的查找、装载和解释。（Java 中并不强求必须使用解释器。因为存在用来生成一个单一的可执行文件的本地代码 Java 编译器）

类库实际上一组类文件。其中每个文件都有一个 **public** 类，以及任意数量的非 **public** 类。因此每个文件都有一个构件。如果希望这些构件（每个都有它们自己独立的 **.java** 和 **.class** 文件）从属于同一个群组，就可以使用关键字 **package**。

如果使用 **package** 语句，它必须是文件中除注释外的第一句程序代码：`package access`。就表示你在声明该编译单元是名为 **access** 的类库的一部分。或者说你正在声明该编译单元仲的 **public** 类名称是位于 **access** 名称的保护伞下。任何想要使用该名称的人都必须使用前面给出的选择，指定全名或者与 **access** 结合使用关键字 **import**。（注意，Java 包的命名规则全部使用小写字母，包括中间名也是如此。）

身为一名类库设计者，很有必要牢记：**package** 和 **import** 关键字允许你做的，是将单一的全局名字空间分割开，使得无论多少人使用 Internet 以及 Java 开始编写类，都不会出现名称冲突问题。

#### 6.1.2 创建独一无二的包名

既然一个包从未真正将被打包的东西包装成单一文件，并且一个包可以由许多 **.class** 文件构成，那么情况有点复杂。为避免这种情况发生，一种合乎逻辑的做法是将特定包的所有 **.class** 文件都置于一个目录下。也就是说，利用操作系统的层次化的文件结构来解决这一问题。

将所有文件收入一个子目录还可以解决另外两个问题：怎样创建独一无二的名称以及怎样查找有可能隐藏于目录结构中的类。这些任务是通过将 **.class** 文件所在的路径位置编码成 **package** 名称来实现。按照惯例，**package** 名称的第一部分是类的创建者的反顺序的 Internet 域名。如果按照惯例，Internet 域名应该是独一无二的，所以 **package** 名称也将是独一无二的，那么也就不会出现名称冲突的问题。当然，如果没有自己的域名，就需要构造一组不大可能与他人重复的组合，来创建独一无二的 **package** 名称。如果打算发布 Java 程序代码，稍微花点力气去取得一个域名，还是很有必要的。

此技巧的第二部分是把 **package** 名称分解为你机器上的一个目录。当 Java 程序运行并且需要加载 **.class** 文件时，它就可以确定 **.class** 文件在目录上所处的位置。

:star:Java 解释器的运行过程如下：首先，找出环境变量 **CLASSPATH** （可通过操作系统设置，有时也可通过安装程序来设置）。 **CLASSPATH** 包含一个或多个目录，用作查找 **.class** 文件的根目录。从根目录开始，解释器获取包的名称并将每个局点替换成反斜杠，以从 **CLASSPATH** 根中产生一个路径名称。得到的路径会与 **CLASSPATH** 中的各个不同的项相连接，解释器就在这些目录中查找与你所要创建的类名称相关的 **.class** 文件。

### 6.2 Java 访问权限修饰词

**public**、**protected** 和 **private** 这几个 Java 访问权限修饰词在使用时，是置于类中每个成员定义之前的。如果不提供任何访问控制权限修饰词，则意味着它是“包访问权限”。所以，无论如何，所有事物都具有某种形式的的访问权限控制。