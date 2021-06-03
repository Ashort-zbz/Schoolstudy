# **HBase**

 [HBase官方文档](https://www.w3cschool.cn/hbase_doc/)

![](https://www.w3cschool.cn/attachments/image/20180122/1516603094894042.png)

[TOC]



## HBase 历史

|   年份    |                     事件                     |
| :-------: | :------------------------------------------: |
| Nov 2006  |            谷歌公布 BigTable 文件            |
| Feb 2007  |      最初的HBase原型创建由 Hadoop 贡献       |
| Oct 2007  | 随着Hadoop 0.15.0，第一个可用的HBase也发布了 |
| Jan 2008  |          HBase成为 Hadoop 的子项目           |
| Oct 2008  |              HBase 0.18.1 发布               |
| Jan 2009  |               HBase 0.19 发布                |
| Sept 2009 |              HBase 0.20.0 发布               |
| May 2010  |         HBase 成为 Apache 的顶级项目         |

## HBase快速入门

### HBase 入门——独立式HBase

在一个独立的HBase实例中，它具有所有的HBase系统服务程序：Master、RegionServers 和 [ZooKeeper](https://www.w3cschool.cn/zookeeper/)（在一个持续到本地文件系统的单一 JVM 中运行）。这是最基本的部署配置文件。

#### **JDK要求**：HBase要求安装JDK。

#### **HBase下载与启动**

选择一个[Apache 下载镜像](http://www.apache.org/dyn/closer.cgi/hbase/)，下载 HBase Releases。点击stable目录，然后下载后缀为.tar.gz的二进制文件到本地文件系统；例如 hbase-0.95-SNAPSHOT.tar.gz。

解压下载的文件，然后进入到那个要解压的目录。

```shell
$ tar xfz hbase-0.95-SNAPSHOT.tar.gz
$ cd hbase-0.95-SNAPSHOT
```

在启动HBase之前，需要先设置 JAVA_HOME 环境变量。可以通过操作系统的常规机制来设置变量，但HBase提供了一个中心机制 conf/hbase-env.sh，编辑此文件，取消注释以下行`JAVA_HOME`，并将其设置为操作系统的适当位置，JAVA_HOME 变量应设置为包含可执行文件 bin/JAVA 的目录。大多数现代 Linux 操作系统都提供了一种机制，例如在 RHEL 或 CentOS 上的替代方法，用于在 Java 等可执行版本之间进行透明切换。在这种情况下，可以将 JAVA_HOME 设置为包含指向 bin/JAVA 的符号链接的目录，这通常是：/usr。

```shell
JAVA_HOME = / USR
```

编辑conf/hbase-site.xml，这是HBase的主要配置文件。此时，只需要在HBase和ZooKeeper写入数据的本地文件系统上指定目录即可。默认情况下，在/tmp下创建一个新目录。许多服务器被配置为在重启时删除/tmp的内容，所以应该在其他地方存储数据。以下配置将把HBase的数据存储在hbase目录下的`testuser`用户主目录中。将`<property>`标签粘贴到标签下`<configuration>`，在新的HBase安装中应该是空的。

独立HBase的hbase-site.xml：

```xml
<configuration>
  <property>
    <name>hbase.rootdir</name>
    <value>file:///home/testuser/hbase</value>
  </property>
  <property>
    <name>hbase.zookeeper.property.dataDir</name>
    <value>/home/testuser/zookeeper</value>
  </property>
</configuration>
```

不需要创建HBase数据目录，HBase会为你做这个。

注意：上述示例中的hbase.rootdir指向本地文件系统中的一个目录。'file：/'前缀是我们如何表示本地文件系统。要在现有的HDFS实例上安装HBase，请将hbase.rootdir设置为指向您实例上的目录：例如，hdfs：//namenode.example.org：8020/hbase。

提供了bin/start-hbase.sh脚本来方便的启动HBase。发出命令，如果一切正常，则会将消息记录到标准输出，显示HBase已成功启动。可以使用该jps命令来验证是否有一个名为 HMaster 的正在运行的进程。在独立模式下，HBase在单个JVM中运行所有守护进程，即HMaster，单个HRegionServer和ZooKeeper守护进程。

为此，打开HBase主文件夹，然后运行HBase启动脚本，如下所示：

```shell
$cd /usr/local/HBase/bin
$./start-hbase.sh
```

如果一切顺利，当运行HBase启动脚本，它会提示一条消息：HBase已经启动

```shell
starting master, logging to /usr/local/HBase/bin/../logs/hbase-tpmaster-localhost.localdomain.out
```

提示：Java需要安装并可用。如果得到一个错误，指示Java未安装，但它位于您的系统上（可能位于非标准位置），请编辑conf / hbase-env.sh文件，并将该`JAVA_HOME`设置修改为指向包含在你的系统上的bin/Java。

#### shell练习——首次使用HBase

1、连接到HBase。使用HBase shell命令连接到 HBase 运行实例，位于HBase安装的bin /目录中。在本例中，省略了启动HBase Shell时打印的一些用法和版本信息。

```shell
$ ./bin/hbase shell
hbase(main):001:0>
```

2、显示HBase Shell帮助文本。键入“help”并按“Enter”，以显示HBase Shell的一些基本用法信息以及几个示例命令。请注意，表名、行、列都必须用引号字符括起来。

3、创建一个表。使用该“create”命令来创建一个新的表。必须指定表名称和ColumnFamily名称。

```shell
hbase(main):001:0> create 'test', 'cf'
0 row(s) in 0.4170 seconds

=> Hbase::Table - test
```

4、列出关于表的信息，通过使用“list”命令来实现：

```shell
hbase(main):002:0> list 'test'
TABLE
test
1 row(s) in 0.0180 seconds

=> ["test"]
```

5、把数据放到表中。要将数据放入表中，请使用该“put”命令。

```shell
hbase(main):003:0> put 'test', 'row1', 'cf:a', 'value1'
0 row(s) in 0.0850 seconds

hbase(main):004:0> put 'test', 'row2', 'cf:b', 'value2'
0 row(s) in 0.0110 seconds

hbase(main):005:0> put 'test', 'row3', 'cf:c', 'value3' 
0 row(s) in 0.0100 seconds
```

在这里，我们插入三个值，一次一个。第一个插入是在row1，列cf:a，值为value1。HBase 中的列由列族前缀组成，在此示例中为cf（列簇），后跟一个冒号，然后是一个列限定符后缀（在本例中为 a）。

6、一次扫描表中的所有数据。从HBase获取数据的方法之一是扫描。使用该“scan”命令扫描表中的数据。你可以限制你的扫描，但现在，所有的数据都被提取。

```shell
hbase(main):006:0> scan 'test'
ROW                                      COLUMN+CELL
 row1                                    column=cf:a, timestamp=1421762485768, value=value1
 row2                                    column=cf:b, timestamp=1421762491785, value=value2
 row3                                    column=cf:c, timestamp=1421762496210, value=value3
3 row(s) in 0.0230 seconds
```

7、获取一行的数据。要一次获取一行数据，请使用该“get”命令。

```shell
hbase(main):007:0> get 'test', 'row1'
COLUMN                                   CELL
 cf:a                                    timestamp=1421762485768, value=value1
1 row(s) in 0.0350 seconds
```

8、禁用表格。如果您想删除表格或更改其设置以及其他一些情况，则需要先使用“disable”命令禁用表格。可以使用该“enable”命令重新启用它。

```shell
hbase(main):008:0> disable 'test'
0 row(s) in 1.1820 seconds

hbase(main):009:0> enable 'test' 
0 row(s) in 0.1770 seconds
```

如果测试了上面的“enable”命令，请再次禁用表格：

```shell
hbase(main):010:0> disable 'test'
0 row(s) in 1.1820 seconds
```

9、删除表。要删除表，请使用该“drop”命令。

```shell
hbase(main):011:0> drop 'test'
0 row(s) in 0.1370 seconds
```

10、退出 HBase Shell。要退出HBase Shell并断开与群集的连接，请使用该“quit”命令。**HBase仍然在后台运行。**

#### 停止HBase

1、与提供bin / start-hbase.sh脚本以便方便地启动所有HBase守护进程相同，可以使用bin/stop-hbase.sh脚本停止它们。

```shell
$ ./bin/stop-hbase.sh
stopping hbase....................
$
```

2、发出命令后，进程关闭可能需要几分钟的时间。使用jps要确保HMASTER和HRegionServer进程被关闭。

以上向您展示了如何启动和停止一个独立的HBase实例。

## HBase 数据模型

### HBase数据模型相关概念

- 表（Table）

  HBase 会将数据组织进一张张的表里面，一个 HBase 表由多行组成。

- 行（Row）

  HBase 中的一行包含一个行键和一个或多个与其相关的值的列，每行由行键（Row Key）来标识。

  访问表中的行有3种方式：通过单个行键访问；通过一个行键的区间访问；全表扫描。

  行键可以是任意字符串（最大长度64KB，实际应用长度一般为10~100字节）

  在存储行时，行按字母顺序排序。出于这个原因，行键的设计非常重要。目标是以相关行相互靠近的方式存储数据。常用的行键模式是网站域。如果你的行键是域名，则你可能应该将它们存储在相反的位置（org.apache.www，org.apache.mail，org.apache.jira）。这样，表中的所有 Apache 域都彼此靠近，而不是根据子域的第一个字母分布。

- 列（Column）

  HBase 中的列由一个列族和一个列限定符组成，它们由`:`（冒号）字符分隔。

- 列族（Column Family）

  一个HBase表被分组成许多“列族”的集合，它是基本的访问控制单元。

  出于性能原因，列族在物理上共同存在一组列和它们的值。在 HBase 中每个列族都有一组存储属性，例如其值是否应缓存在内存中，数据如何压缩或其行编码是如何编码的等等。表中的每一行都有相同的列族，但给定的行可能不会在给定的列族中存储任何内容。

  列族一旦确定后，就不能轻易修改，因为它会影响到 HBase 真实的物理存储结构，但是列族中的列标识(Column Qualifier)以及其对应的值可以动态增删。 

  在HBase中，访问控制、磁盘和内存的使用统计都是在列族层面进行。在实际应用中我们可以借助列族上的控制权限帮助实现特定的目的。比如，我们可以允许一些应用能够向表中添加新的数据，而另一些应用只允许浏览数据。HBase列族可以被配置成支持不同类型的访问模式。比如一个列族也可以被设置成放入内存中，以消耗内存为代价，从而换取更好的响应性能。

- 列限定符（Column Qualifier）

  列限定符被添加到列族中，以提供给定数据段的索引，即列族里的数据通过列限定符（或列）来定位。

  鉴于列族的`content`，列限定符可能是`content:html`，而另一个可能是`content:pdf`。虽然列族在创建表时是固定的，但列限定符是可变的，并且在行之间可能差别很大。

  列限定符没有数据类型，总被视为字节数组`byte[]`。

- 单元格（Cell）

  单元格是行、列族和列限定符的组合，并且包含值和时间戳，时间戳表示值的版本。

  单元格中存储的数据没有数据类型，总被视为字节数组`byte[]`。

- 时间戳（Timestamp）

  时间戳与每个值一起编写，并且是给定版本的值的标识符，一般是64位整形。

  默认情况下，时间戳表示写入数据时 RegionServer 上的时间，但可以在将数据放入单元格时指定不同的时间戳值，即用户自己赋值（自己生成唯一时间戳可以避免应用程序中出现数据版本冲突）。一个单元格不同版本是根据时间戳降序的顺序进行存储，最新的版本可以被最先读取。

下面以一个实例来阐释HBase数据模型。下图是一个用来存储学生信息的HBase表，学号作为行键唯一标识每个学生，表中设计列族Info用来保存学生相关信息。列族Info包含3个列——name、major和email。学号为“201505003”的学生存在两个版本的电子邮件，时间戳分别为 ts1=1174184619081 和 ts2=1174184620720，时间戳较大的数据版本是最新的数据。

![image.png](https://upload-images.jianshu.io/upload_images/19680844-836568498298c118.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 数据坐标

HBase中需要根据行键、列族、列限定符和时间戳来确定一个单元格，因此，可以视为一个“四维坐标”，即[行键, 列族, 列限定符, 时间戳]

如果把所有坐标看作一个整体，视为“键”，把四维坐标对应的单元格中的数据视为“值”，HBase也可以看成一个键值数据库。

| 键                                            | 值            |
| --------------------------------------------- | ------------- |
| [“201505003”, “Info”, “email”, 1174184619081] | “xie@qq.com”  |
| [“201505003”, “Info”, “email”, 1174184620720] | “you@163.com” |

### 概念视图

在HBase概念视图中，一个表可视为一个稀疏、多维的映射关系。下面的webtable就是一个HBase存储数据的概念视图，它是一个存储网页的HBase表片段。

示例是根据  BigTable 论文进行稍微修改后的示例。在示例中有一个名为表 webtable，其中包含两行（com.cnn.www 和 com.example.www）以及名为 contents、anchor 和 people 的三个列族。

contents:html 列限定符包含给定网站的整个 HTML。锚（anchor）列族的限定符每个包含与该行所表示的站点链接的外部站点以及它在其链接的锚点（anchor）中使用的文本。people 列族代表与该网站相关的人员。

对于第一行（com.cnn.www）， anchor 包含两列（anchor:cssnsi.com，anchor:my.look.ca），并且 contents 包含一列（contents:html）。本示例包含具有行键 com.cnn.www 的行的5个版本，以及具有行键 com.example.www 的行的一个版本。

列名称：按照约定，列名由其列族前缀和限定符组成。例如，列内容: html 由列族`contents`和`html`限定符组成。冒号字符（`:`）从列族限定符分隔列族。

 webtable 表如下所示：

|  行键（Row Key）  | 时间戳（Time Stamp） |  ColumnFamily`contents`  |     ColumnFamily`anchor`      |   ColumnFamily `people`    |
| :---------------: | :------------------: | :----------------------: | :---------------------------: | :------------------------: |
|   “com.cnn.www”   |          T9          |                          |   anchor：cnnsi.com =“CNN”    |                            |
|   “com.cnn.www”   |          T8          |                          | anchor：my.look.ca =“CNN.com” |                            |
|   “com.cnn.www”   |          T6          | 内容：html =“<html> ...” |                               |                            |
|   “com.cnn.www”   |          T5          | 内容：html =“<html> ...” |                               |                            |
|   “com.cnn.www”   |          T3          | 内容：html =“<html> ...” |                               |                            |
| “com.example.www” |          T5          | 内容：html =“<html> ...” |                               | people:author = "John Doe" |

**此表中显示为空的单元格在 HBase 中不占用空间或实际上存在。这正是使 HBase “稀疏”的原因。**表格视图并不是查看 HBase 数据的唯一可能的方法，甚至是最准确的。以下代表与多维地图相同的信息。这只是用于说明目的的模拟，可能并不严格准确。

```json
{
  "com.cnn.www": {
    contents: {
      t6: contents:html: "<html>..."
      t5: contents:html: "<html>..."
      t3: contents:html: "<html>..."
    }
    anchor: {
      t9: anchor:cnnsi.com = "CNN"
      t8: anchor:my.look.ca = "CNN.com"
    }
    people: {}
  }
  "com.example.www": {
    contents: {
      t5: contents:html: "<html>..."
    }
    anchor: {}
    people: {
      t5: people:author: "John Doe"
    }
  }
}
```

### 物理视图

尽管在 HBase 概念视图中，表格被视为一组稀疏的行的集合，但在物理存储层面，是按列族进行存储的，这也是HBase和传统关系数据库的重要区别。可以随时将新的列限定符（column_family：column_qualifier）添加到现有的列族。 

ColumnFamily `anchor 表：`

| 行键（Row Key） | 时间戳（Time Stamp） |     ColumnFamily `anchor`     |
| :-------------: | :------------------: | :---------------------------: |
|  “com.cnn.www”  |          T9          |   anchor:cnnsi.com = "CNN"    |
|  “com.cnn.www”  |          T8          | anchor:my.look.ca = "CNN.com" |

ColumnFamily contents 表：

| 行键（Row Key） | 时间戳（Time Stamp） | ColumnFamily `contents:`  |
| :-------------: | :------------------: | :-----------------------: |
|  “com.cnn.www”  |          T6          | contents:html = "<html>…" |
|  “com.cnn.www”  |          T5          | contents:html = "<html>…" |
|  “com.cnn.www”  |          T3          | contents:html = "<html>…" |

HBase 概念视图中显示的空单元在物理视图中根本不存储。因此，对时间戳为 t8 的 contents:html 列值的请求将不返回任何值。同样，在时间戳为 t9 中一个anchor:my.look.ca 值的请求也不会返回任何值。但是，如果未提供时间戳，则会返回特定列的最新值。给定多个版本，最近的也是第一个找到的，因为时间戳按降序存储。因此，如果没有指定时间戳，则对行 com.cnn.www 中所有列的值的请求将是: 时间戳 t6 中的 contents:html，时间戳 t9 中 anchor:cnnsi.com 的值，时间戳 t8 中 anchor:my.look.ca 的值。

