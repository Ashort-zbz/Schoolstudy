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

输出结果显示，第二个测试产生了一个 false 结果，这意味着整个结果肯定是 false，所以没必要计算剩余的式子，不论这个式子后面还有多少个 test，都会直接跳过。这样可以获得潜在的性能提升。