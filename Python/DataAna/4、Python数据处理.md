# 4、Python数据处理

[TOC]

## 4.1、numpy数组操作 

### 4.1.1、numpy库概述

Python中用**列表(list)**保存一组值，可用来当作数组使用，由于列表的元素可以是任何对象，因此列表中所保存的是对象的指针。为保存一个简单的[1,2,3]，需要有3个指针和三个整数对象。对于数值运算来说这种结构显然比较浪费内存和CPU计算时间。

此外Python还提供了一个**array模块**，array对象和列表不同，它直接保存数值，和C语言的一维数组比较类似。但是由于它不支持多维，也没有各种运算函数，因此也不适合做数值运算。

**numpy** 的诞生弥补了这些不足，numpy 提供 ndarray（N-dimensional array object）对象：ndarray 是存储单一数据类型的多维数组。

一、numpy 库概述

1、numpy（Numerical Python 的简称）是高性能科学计算和数据分析的基础包，支持维度数组与矩阵运算。包括：

- 一个强大的N维数组对象 ndarray，具有矢量算术运算和复杂广播能力的快速且节省空间的多维数组。

- 用于对整组数据进行快速运算的标准数学函数（无需编写循环）。

- 用于读写磁盘数据的工具以及用于操作内存映射文件的工具。

- 线性代数、随机数生成以及傅里叶变换等功能。

- 用于集成由 C 、C++ 、Fortran等语言编写的代码的工具。

2、numpy 库提供了大量的库函数和操作，可以帮助程序员轻松地进行数值计算。这类数值计算广泛用于以下任务：

- 机器学习模型：在编写机器学习算法时，需要对矩阵进行各种数值计算。例如矩阵乘法、加法等。使用 numpy 库可进行简单(在编写代码方面)和快速(在速度方面)计算。numpy 数组用于存储训练数据和机器学习模型的参数。

- 图像处理和计算机图形学：计算机中的图像表示为多维数字数组，numpy 提供了一些优秀的库函数来快速处理图像。例如，镜像图像、按特定角度旋转图像等。

- 数学任务：numpy 可进行数值积分、微分、内插、外推等操作。numpy 库形成了一种基于Python的MATLAB的快速替代。

### 4.1.2、ndarray数组操作

一、ndarray 概述

N 维数组对象 ndarray 是用于存放同类型元素的多维数组。

ndarray 中的每个元素在内存中都有相同存储大小的区域，每个元素是数据类型对象的对象 （ 称为 dtype）。与 Python 中的其他容器对象一样，可以通过对数组进行索引或切片。 可通过 ndarray 的方法和属性来访问和修改 ndarray 的内容 。

二、创建数组

创建ndarray：创建数组最简单的办法就是使用array函数。它接受一切序列型的对象，然后产生一个含有传入数据的 numpy 数组。其中，嵌套序列（比如由一组等长列表组成的列表）将会被转换为一个多维数组

```python
numpy.array(object, dtype = None, copy = True, order = None, subok = False, ndmin = 0)

>>> import numpy as np
>>> a = [1, 2, 3, 4] # 创建简单的列表
>>> b = np.array(a) # 将列表转换为数组
>>> b
array([1, 2, 3, 4])
>>> c = np.array([[1, 2], [3, 4]])
>>>c
[[1, 2]
[3, 4]]
```

<img src="https://upload-images.jianshu.io/upload_images/19680844-9a02abd5239d8d61.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240" alt="image.png" style="zoom:80%;" />

除了 np.array 之外，还有一些函数也可以新建数组： `zeros`和`ones`分别可以创建指定长度或者形状的全0或全1数组。`empty`可以创建一个没有任何具体值的数组

```python
>>> np.zeros(3) # 全0一维数组
array([ 0., 0., 0.])
>>> np.ones(3) # 全1一维数组
array([ 1., 1., 1.])
>>> np.zeros((3,3)) # 全0二维数组，3行3列
array([[ 0., 0., 0.],
[ 0., 0., 0.],
[ 0., 0., 0.]])
>>> np.zeros((3,1)) # 全0二维数组，3行1列
array([[ 0.],
[ 0.],
[ 0.]])
>>> np.zeros((1,3)) # 全0二维数组，1行3列
array([[ 0., 0., 0.]])
>>> np.ones((3,3)) # 全1二维数组，3行3列
array([[ 1., 1., 1.],
[ 1., 1., 1.],
[ 1., 1., 1.]])
>>> np.ones((1,3)) # 全1二维数组，1行3列
array([[ 1., 1., 1.]])
>>> np.identity(3) # 单位矩阵，3行3列
array([[ 1., 0., 0.],
[ 0., 1., 0.],
[ 0., 0., 1.]])
```

创建随机数组

```python
# 均匀分布
np.random.rand(10, 10) #创建指定形状(示例为10行10列)的数组(范围在0至1之间)
np.random.uniform(0, 100) #创建指定范围内的一个数
np.random.randint(0, 100) #创建指定范围内的一个整数

#正态分布
np.random.normal(1.75, 0.1, (2, 3)) #给定均值/标准差/维度的正态分布

>>> np.random.randint(0, 50, 5) # 随机数组，5个0到50之间的数字
array([13, 47, 31, 26, 9])
>>> np.random.randint(0, 50, (3,5)) # 3行5列，共15个随机整数，都介于[0,50]
array([[44, 34, 35, 28, 18],
[24, 24, 26, 4, 21],
[30, 40, 1, 24, 17]])
>>> np.random.rand(10) # 10个介于[0,1)的随机数
array([ 0.58193552, 0.11106142, 0.13848858, 0.61148304, 0.72031503,
0.12807841, 0.49999167, 0.24124012, 0.15236595, 0.54568207])
>>> np.random.standard_normal(5) # 从标准正态分布中随机采样5个数字
array([2.82669067, 0.9773194, -0.72595951, -0.11343254, 0.74813065])
```

三、数组属性

查看数组属性的用法

<img src="https://upload-images.jianshu.io/upload_images/19680844-7d9ec797f10554c0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240" alt="image.png" style="zoom:80%;" />

```python
import numpy as np

x = np.array([(1,2,3),(4,5,6)])
print(x)
print(x.size)
print(x.ndim)
print(x.shape)
print(x.itemsize)
print(x.dtype,'\n')

y = x.reshape(3,2)
print(y,'\n')
print(y.shape)
```

三、数组和标量之间的运算

数组很重要，因为它可以使我们不用编写循环即可对数据执行批量运算。这通常叫做**矢量化**（vectorization）。大小相等的数组之间的任何算术运算都会将运算应用到元素级。同样，数组与标量的算术运算也会将那个标量值传播到各个元素。

```python
>>> arr = np.array([[1., 2., 3.], [4., 5., 6.]])
>>> arr
array([[1., 2., 3.],
[4., 5., 6.]])

>>> arr - arr
array([[0., 0., 0.],
[0., 0., 0.]])

>>> arr * arr
array([[ 1., 4., 9.],
[16., 25., 36.]])

>>> 1 / arr
array([[1. , 0.5 , 0.33333333],
[0.25 , 0.2 , 0.16666667]])

>>> arr ** 0.5
array([[1. , 1.41421356, 1.73205081],
[2. , 2.23606798, 2.44948974]])
```

四、基本的索引和切片

选取数据子集或的单个元素的方式有很多。一维数组很简单，从表面上看，它们跟Python列表的功能差不多。 一维数组跟列表最重要的区别在于，**数组切片是原始数组的视图。这意味着数据不会被复制，数组视图上的任何修改都会直接反映到原始数组上**。 将一个标量值赋值给一个切片时，该值会自动传播到整个选区。

```python
>>> arr = np.arange(10)
>>> arr
array([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
>>> arr[5]
5
>>> arr[5:8]
array([5, 6, 7])
>>> arr[5:8] = 12
>>> arr
array([ 0, 1, 2, 3, 4, 12, 12, 12, 8, 9])
>>> arr_slice = arr[5:8]
>>> arr_slice[1] = 12345
>>> arr
array([ 0, 1, 2, 3, 4, 12, 12345, 12, 8, 9])
>>> arr_slice[:] = 64
>>> arr
array([ 0, 1, 2, 3, 4, 64, 64, 64, 8, 9])
```

 在二维数组中，各索引位置上的元素不再是标量**而是一维数组**。可以对各个元素进行递归访问，但是这样有点麻烦。还有一种方式是传入一个以逗号隔开的索引列表来选取单个元素。 在多维数组中，如果省略了后面的索引，则返回对象会是一个维度低一点的ndarray。

```python
>>> arr3d = np.array([[[1, 2, 3], [4, 5, 6]], [[7, 8, 9], [10, 11, 12]]])
>>> arr3d
array([[[ 1, 2, 3],
[ 4, 5, 6]],
[[ 7, 8, 9],
[10, 11, 12]]])

>>> arr3d[0]
array([[1, 2, 3],
[4, 5, 6]])

>>> arr3d[0][1]
array([4, 5, 6])
```

五、数学和统计方法

基本数组统计方法：可以通过数组上的一组数学函数对整个数组或某个轴向的数据进行统计计算

![image.png](https://upload-images.jianshu.io/upload_images/19680844-559bf2eb62eafdac.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

 sum、mean以及标准差 std 等聚合计算既可以当做数组的实例方法调用，也可以当做顶级 numpy 函数使用

```python
>>> arr = np.random.randn(5, 4) # 5行4列正态分布的随机数据
>>> arr
[[-0.60229958 -0.92406191  0.09197369 -0.91053619]
 [-0.72041789  0.94189353  0.42806243 -0.39083685]
 [-1.90479946 -1.87341081 -0.51652843 -0.23153911]
 [ 0.11257244  0.35318805 -0.10814888  1.99341926]
 [-0.97445142  0.6588353   1.06432084 -0.17708965]]
>>> arr.mean()
-0.022341797127577216
>>> np.mean(arr)
-0.022341797127577216
>>> arr.sum()
-0.44683594255154435
```

mean 和 sum 这类的函数可以接受一个 axis 参数（用于计算该轴向上的统计值）。

```python
>>> arr.mean(axis=1)'''axis=1，表示按水平方向计算，计算每一行的统计值,相反axis=0，表示按垂直方向计算，计算每一列的统计值'''
array([-0.11320162, -0.032351 , -0.24522299, 0.13275031, 0.14631631])
>>> arr.sum(0)
array([-1.71093252, 3.4431099 , -1.78081725, -0.39819607])
```

`cumsum`：按照所给定的轴参数返回元素的梯形累计和，axis=0，按照行累加。axis=1，
按照列累加。

`cumprod`：按照所给定的轴参数返回元素的梯形累计乘积，axis=0，按照行累积。
axis=1，按照列累积。

```python
>>> arr = np.array([[0, 1 ,2], [3, 4, 5], [6, 7, 8]])
>>> arr.cumsum(0)
array([[ 0, 1, 2],
[ 3, 5, 7],
[ 9, 12, 15]], dtype=int32)
>>> arr.cumprod(1)
array([[ 0, 0, 0],
[ 3, 12, 60],
[ 6, 42, 336]], dtype=int32)
```

## 4.2、numpy矩阵操作

### 4.2.1、矩阵生成

一、numpy矩阵库(Matrix)

NumPy 中包含了一个矩阵库 numpy.matlib，该模块中的函数**返回的是一个矩阵**，而不是 ndarray 对象。

一个 𝑛x𝑜 的矩阵是一个由 𝑛行（row）𝑜 列（column）元素排列成的矩形阵列。矩阵里的元素可以是数字、符号或数学式。NumPy 和 Matlab 不一样 ， 对于多维数组的运算 ， 缺省情况下并不使用矩阵运算 ，如果你希望对数组进行矩阵运算的话 ， 可以调用ndarry对象相应的函数。

二、numpy 矩阵生成

1、常规方式生成

```python
import numpy as np

x = np.matrix([[1,2,3], [4,5,6]])
y = np.matrix([1,2,3,4,5,6])
# x[0,0]返回行下标和列下标都为0的元素
# 注意，对于矩阵x来说，x[0,0]和x[0][0]的含义不一样
print(x, y, x[0,0],x[0][0],sep='\n\n')
```

2、numpy 矩阵生成：`numpy.matlib.empty(shape, dtype, order)`， shape: 定义新矩阵形状的整数或整数元组； Dtype: 可选，数据类型；order: C（行序优先） 或者 F（列序优先）

```python
import numpy.matlib
import numpy as np
print (np.matlib.empty((2,2)))
# 填充为随机数据

[[ 0.00000000e+000 -7.70820675e-313]
[ 1.23331308e-311 6.83927731e-309]]
```

`numpy.matlib.zeros()`——创建一个以0填充的矩阵。

`numpy.matlib.ones()`——创建一个以1填充的矩阵。

`numpy.matlib.eye(n, M, k, dtype)`——返回一个矩阵，**对角线元素为 1，其他位置为零**。 n: 返回矩阵的行数。M: 返回矩阵的列数，默认为 n。 k: 对角线的索引。dtype: 数据类型。

`numpy.matlib.identity()`——返回给定大小的**单位矩阵**。单位矩阵是个方阵，从左上角到右下角的对角线（称为主对角线）上的元素均为 1，除此以外全都为 0。

`numpy.matlib.rand()`——创建一个给定大小的矩阵，**数据是随机填充的**。

### 4.2.2、常用矩阵操作 

一、numpy 矩阵常用操作

1、矩阵与二维数组相互转换，。

矩阵总是二维的，而 ndarray 是一个 n 维数组。 两个对象都是可互换的。

```python
import numpy.matlib
import numpy as np

i = np.matrix('1,2;3,4')
print(i)
j = np.asarray(i)
print(j)
k = np.asmatrix (j)
print (k)
```

2、矩阵转置

```python
import numpy as np

x = np.matrix([[1,2,3], [4,5,6]])
y = np.matrix([1,2,3,4,5,6])
print(x.T, y.T, sep='\n\n')
```

3、查看矩阵特征

```python
import numpy as np
x = np.matrix([[1,2,3], [4,5,6]])
print(x.mean(), end='\n====\n') # 所有元素平均值

print(x.mean(axis=0), end='\n====\n') # 纵向平均值
print(x.mean(axis=0).shape, end='\n====\n')
print(x.mean(axis=1), end='\n====\n') # 横向平均值
print(x.sum(), end='\n====\n') # 所有元素之和
print(x.max(axis=1), end='\n====\n') # 横向最大值
print(x.argmax(axis=1), end='\n====\n') # 横向最大值的下标
print(x.diagonal(), end='\n====\n') # 对角线元素
```

4、矩阵乘法

```python
import numpy as np
x = np.matrix([[1,2,3], [4,5,6]])
y = np.matrix([[1,2], [3,4], [5,6]])
print(x*y)
```

### 4.2.3、矩阵运算

numpy.linalg  中有一组标准的矩阵分解运算以及诸如求逆和行列式之类的东西。它们跟 MATLAB 和 R 等语言所使用的是相同的行业标准级 Fortran 库。下边为常用的 numpy.linalg 函数：

<img src="https://upload-images.jianshu.io/upload_images/19680844-1e6b586333531f25.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240" alt="image.png" style="zoom:60%;" />

`numpy.dot(a, b, out)`： **两个数组的点积**，即**元素对应相乘**。 a：ndarray 数组。 b : ndarray 数组。 out : ndarray, 可选，用来保存dot()的计算结果。 对于两个一维的数组，计算的是这两个数组对应下标元素的乘积和(数学上称之为内积)； 对于二维数组，计算的是两个数组的矩阵乘积；对于多维数组，它的通用计算公式如下，即结果数组中的每个元素都是：数组a的最后一维上的所有元素与数组b的倒数第二位上的所有元素的乘积和：

` dot(a, b)[i,j,k,m] = sum(a[i,j,:] * b[k,:,m])`

```python
import numpy.matlib
import numpy as np

a = np.array([[1,2],[3,4]])
b = np.array([[11,12],[13,14]])
print(np.dot(a,b))

[[1*11+2*13, 1*12+2*14],[3*11+4*13, 3*12+4*14]]
[[37 40]
[85 92]]
```

`numpy.vdot()`： 返回**两个向量的点积**。如果第一个参数是复数，那么它的共轭复数会用于计算。 如果参数是多维数组，它会被展开。

```python
import numpy as np
a = np.array([[1,2],[3,4]])
b = np.array([[11,12],[13,14]])
# vdot 将数组展开计算内积
print (np.vdot(a,b))

1*11 + 2*12 + 3*13 + 4*14 = 130
```

`numpy.linalg.inv()`： 计算**逆矩阵**。逆矩阵（inverse matrix）：设A是数域上的一个n阶矩阵，若在相同数域上存在另一个n阶矩阵B，使得： AB=BA=E ，则我们称B是A的逆矩阵，而A则被称为可逆矩阵。注：E为单位矩阵。

```python
import numpy as np

x = np.array([[1,2],[3,4]])
y = np.linalg.inv(x)
print (x)
print (y)
print (np.dot(x,y))
```

`numpy.linalg.solve() `： 求矩阵形式的线性方程的解。

```python
import numpy as np

a = np.array([[1,1,1], [0,2,5],[2,5,-1]]) # 系数矩阵
b = np.array([6,-4,27]) # 系数矩阵
x = np.linalg.solve(a, b) # 求解
print(x)
print(np.dot(a, x)) # 验证
```

## 4.3、pandas数据结构

### 4.3.1、pandas概述

Pandas 是**基于 NumPy** 的一种工具 ， 该工具是为了**解决数据分析任务**而创建的。 Pandas 纳入了大量库和一些**标准的数据模型** ，提供了高效地操作大型数据集所需的工具。 Pandas 提供了大量能使我们**快速便捷地处理数据的函数和方法**。 Pandas 是 Python 的一个数据分析包 ，最初于2008 年4 月开发 ，2009 年底开源 ，目前由 PyData 开发团队继续开发和维护。Pandas 最初被作为金融数据分析工具而开发出来，也为时间序列分析提供了很好的支持。

一、pandas 库介绍

pandas 是 python 第三方库，提供高性能易用数据类型和分析工具。基于 numpy 实现，常与 numpy 和 matplotlib 一同使用。pandas 中有两大核心数据结构：**Series**（一维数据） 和 **DataFrame**（多特征数据，既有行索引，又有列索引）

<img src="https://upload-images.jianshu.io/upload_images/19680844-59533769a26b5834.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240" alt="image.png" style="zoom:60%;" />

Series： 一维数组 ， 与 Numpy 中的一维 array 类似 。Series、numpy 中的一维 array 与 Python 基本的数据结构 List 也很相近 ， 其区别是： List 中的元素可以是不同的数据类型 ， 而 array 和 Series 中则只允许存储相同的数据类型 。Series 可以更有效的使用内存 ，提高运算效率。

Time- Series：以时间为索引的Series。

DataFrame ：带标签且大小可变的二维表格型数据结构， 可以将 DataFrame 理解为 Series 的容器。

Panel ：三维的数组，可以理解为 DataFrame 的容器。

### 4.3.2、Series 

Series是一种类似于一维数组的对象，它由一维数组（各种numpy数据类型）以及一组与之相关的数据标签（即索引）组成。

Series创建函数：`pandas.Series( data, index, dtype, copy)`

![image-20200122100004015](C:\Users\12970\AppData\Roaming\Typora\typora-user-images\image-20200122100004015.png)

可使用 Python 数组、numpy 数组创建、python 字典创建。

**注意**：与字典不同的是：Series**允许索引重复**

Series的字符串表现形式为：索引在左边，值在右边。如果没有为数据指定索引，则自动创建一个0到N-1（N为数据的长度）的整数型索引。可以通过Series的values和index属性获取其数组表示形式和索引对象。

```python
>>> obj = pd.Series([4, 7, -5, 3])
>>> obj.values
array([ 4, 7, -5, 3], dtype=int64)
>>> obj.index
RangeIndex(start=0, stop=4, step=1)
>>> obj[2]
-5
>>> obj[1] = 8
>>> obj[[0, 1, 3]]
0 4
1 8
3 3
dtype: int64
```

通常希望所创建的 Series 带有一个可以对各个数据点进行标记的索引。与普通 NumPy 数组相比 ， 可以通过索引的方式选取 Series 中的单个或一组值。

```python
>>> obj2 =pd.Series([4,2,-5, 3 ],index=['a','b','c','d’])
>>> obj2
a 4
b 2
c -5
d 3
dtype: int64
>>> obj2['a']
4
>>> obj2['d'] = 6
>>> obj2
a 4
b 2
c -5
d 6
dtype: int64
>>> obj2[['a','b','d']]
a 4
b 2
d 6
dtype: int64
```

Series中很重要的一个功能是：它会**在算术运算中自动对齐不同索引的数据**

```python
>>> obj2 = pd.Series({"Ohio": 35000, "Oregon": 16000, "Texas": 71000, "Utah": 5000})
>>> obj3 = pd.Series({"California": np.nan, "Ohio": 35000, "Oregon": 16000, "Texas": 71000})

>>> obj2 + obj3
California NaN
Ohio 70000.0
Oregon 32000.0
Texas 142000.0
Utah NaN
dtype: float64
```

Series 对象本身及其索引都有一个 name 属性。Series 的索引可以通过赋值的方式就地修改。

```python
>>> obj3.name= 'population'
>>> obj3.index.name = 'state'
>>> obj3
state
California NaN
Ohio 35000.0
Oregon 16000.0
Texas 71000.0
Name: population, dtype: float64

>>> obj = pd.Series([4, 7, -5, 3])
>>> obj.index = ['Bob', 'Steve', 'Jeff', 'Ryan']
>>> obj
Bob 4
Steve 7
Jeff -5
Ryan 3
dtype: int64
```

### 4.3.3、DataFrame 

DataFrame 是一个**表格型的数据结构**，它含有一组有序的列，每列可以是不同的值类型（数值、字符串、布尔值等）。DataFrame 既有行索引也有列索引，它可以被看做由 Series 组成的字典（共用同一个索引）。跟其他类似的数据结构相比（如R语言的 data.frame ），DataFrame 中面向行和面向列的操作基本上是平衡的。DataFrame 中的数据是以一个或多个二维块存放的（而不是列表、字典或别的一维数据结构）

![image.png](https://upload-images.jianshu.io/upload_images/19680844-d50892a605fc6ea9.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

DataFrame特点：

1）潜在的列是不同的类型

2）大小可变

3）标记轴( ( 行和列) )

4）可以对行和列执行算术运算

DataFrame构造函数：`pandas.DataFrame( data, index, columns, dtype, copy)`

![image.png](https://upload-images.jianshu.io/upload_images/19680844-f66dda5d8483f4d0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

创建一个空的DataFrame：函数不指定参数返回空DataFrame

```python
# 创建一个空的DataFrame
import pandas as pd
df = pd.DataFrame()
print(df)
```

从列表创建DataFrame

```python
# 从单个列表创建DataFrame
data = [1,2,3,4]
df = pd.DataFrame(data)
print(df)

# 从嵌套列表创建DataFrame、并指定数据类型
data = [['Alex',10],['Bob',12],['Clarke',13]]
df = pd.DataFrame(data,columns=['Name','Age'],dtype=float)
print(df)
```

由等长列表或 numpy 数组组成的字典创建 DataFrame。DataFrame 结果会自动加上索引（跟Series 一样），且全部会被有序排列。

```python
>>> data = {'state': ['Ohio', 'Ohio', 'Ohio', 'Nevada', 'Nevada'], 'year': [2000
, 2001, 2002, 2001, 2002], 'pop': [1.5, 1.7, 3.6, 2.4, 2.9]}
>>> frame = pd.DataFrame(data)
>>> frame

 state year pop
0 Ohio 2000 1.5
1 Ohio 2001 1.7
2 Ohio 2002 3.6
3 Nevada 2001 2.4
4 Nevada 2002 2.9
```

如果指定了列顺序，则 DataFrame 的列就会按照指定顺序进行排列。跟原Series一样，如果传入的列在数据中找不到，就会产生NAN值

```python
>>> pd.DataFrame(data,
columns=['year', 'state', 'pop'])

 year state pop
0 2000 Ohio 1.5
1 2001 Ohio 1.7
2 2002 Ohio 3.6
3 2001 Nevada 2.4
4 2002 Nevada 2.9

>>> frame2 = pd.DataFrame(data, columns=['year', 'state', 'pop', 'debt'],
index=['one', 'two', 'three', 'four', 'five'])
>>> frame2

year state pop debt
one 2000 Ohio 1.5 NaN
two 2001 Ohio 1.7 NaN
three 2002 Ohio 3.6 NaN
four 2001 Nevada 2.4 NaN
five 2002 Nevada 2.9 NaN

>>> frame2.columns
Index(['year', 'state', 'pop', 'debt'], dtype='object')
```

通过类似字典标记的方式或属性的方式，可以将 DataFrame 的列获取为一个 Series 。返回的 Series拥有原 DataFrame 相同的索引，且其 name 属性也已经被相应地设置好了。

```python
>>> frame2['state']
one Ohio
two Ohio
three Ohio
four Nevada
five Nevada
Name: state, dtype: object
        
>>> frame2['year']
one 2000
two 2001
three 2002
four 2001
five 2002
Name: year, dtype: int64
```

列可以通过赋值的方式进行修改。例如，给那个空的 “delt” 列赋上一个标量值或一组值

```python
>>> frame2['debt'] = 16.5
>>> frame2

   year state pop debt
one 2000 Ohio 1.5 16.5
two 2001 Ohio 1.7 16.5
three 2002 Ohio 3.6 16.5
four 2001 Nevada 2.4 16.5
five 2002 Nevada 2.9 16.5

>>> frame2['debt'] = np.arange(5.)
>>> frame2

   year state pop debt
one 2000 Ohio 1.5 0.0
two 2001 Ohio 1.7 1.0
three 2002 Ohio 3.6 2.0
four 2001 Nevada 2.4 3.0
five 2002 Nevada 2.9 4.0
```

将列表或数组赋值给某个列时，其长度必须跟 DataFrame 的**长度相匹配**。如果赋值的是一个 Series ，就会精确匹配 DataFrame 的索引，所有空位都将被填上缺失值。

```python
>>> val = pd.Series([-1.2, -1.5, -1.7], index=['two', 'four', 'five'])
>>> frame2['debt'] = val
>>> frame2

  year state pop debt
one 2000 Ohio 1.5 NaN
two 2001 Ohio 1.7 -1.2
three 2002 Ohio 3.6 NaN
four 2001 Nevada 2.4 -1.5
five 2002 Nevada 2.9 -1.7
```

为不存在的列赋值会创建出一个新列，关键字 del 用于删除列。

```python
>>> frame2['eastern'] = frame2.state == 'Ohio'
>>> frame2

 year state pop debt eastern
one 2000 Ohio 1.5 NaN True
two 2001 Ohio 1.7 -1.2 True
three 2002 Ohio 3.6 NaN True
four 2001 Nevada 2.4 -1.5 False
five 2002 Nevada 2.9 -1.7 False

>>> del frame2['eastern']
>>> frame2.columns
Index(['year', 'state', 'pop', 'debt'], dtype='object')
```

将嵌套字典（也就是字典的字典）传给 DataFrame ，它就会被解释为：**外层字典的键作为列，内层键则作为行索引**。也可以对上述结果进行转置

```python
>>> pop = {'Nevada': {2001: 2.4, 2002: 2.9}, 'Ohio':
{2000: 1.5, 2001: 1.7, 2002: 3.6}}
>>> frame3 = pd.DataFrame(pop)
>>> frame3
   Nevada Ohio
2000 NaN 1.5
2001 2.4 1.7
2002 2.9 3.6

>>> frame3.T
   2000 2001 2002
Nevada NaN 2.4 2.9
Ohio 1.5 1.7 3.6
```

如果设置了 DataFrame 的 index 和 columns 的 name 属性，则这些信息也会被显示出来

```python
>>> frame3.index.name = 'year'
>>> frame3.columns.name = 'state'
>>> frame3
state Nevada Ohio
year
2000 NaN 1.5
2001 2.4 1.7
2002 2.9 3.6
```

跟 Series 一样，values 属性也会以二维 ndarray 的形式返回 DataFrame 中的数据。如果 DataFrame 各列的数据类型不同，则数组的数据类型就会选用能兼容所有列的数据类型。

```python
>>> frame3.values
array([[nan, 1.5],
[2.4, 1.7],
[2.9, 3.6]])

>>> frame2.values
array([[2000, 'Ohio', 1.5, nan],
[2001, 'Ohio', 1.7, -1.2],
[2002, 'Ohio', 3.6, nan],
[2001, 'Nevada', 2.4, -1.5],
[2002, 'Nevada', 2.9, -1.7]], dtype=object)
```

## 4.4、pandas常用方法 

### 4.4.1、数据读取与写入

Pandas 支持常用的文本格式数据(csv、json、html、剪贴板)、二进制数据(excel、hdf5 格式、Feather 格式、Parquet 格式、Msgpack、Stata、SAS、pkl)、SQL 数据(SQL、谷歌 BigQuery 云数据)等.

 一般情况下 ， 读取文件的方法以 pd.read_ 开头 ， 而写入文件的方法以 pd.to_开头.

![image.png](https://upload-images.jianshu.io/upload_images/19680844-1121b5645e3d83e8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

数据读取函数 read_csv 示例

自定义索引：可以指定 csv 文件中的一列来使用 index_col 定制索引。dtype：数据类型转换。 skiprows：跳过指定的行数。

```python
df=pd.read_csv("temp.csv")
print(df)

df = pd.read_csv("temp.csv", dtype={'Salary':
np.float64})
print(df)
print(df.dtypes)

df=pd.read_csv("temp.csv", names=['a', 'b',
'c','d','e'])
print(df)

df=pd.read_csv("temp.csv", skiprows=2)
print (df)
```

### 4.4.2、描述性统计方法

 Pandas 提供 了几个统计和描述性方法，方便你从宏观的角度去了解数据集，例如 count()  用于统计非空数据的数量。

除了统计类的方法，Pandas 还提供了很多计算类的方法，比如 sum() 用于计算数值数据的总和；mean() 用 于 计 算 数 值 数 据 的 平 均 值 ；median()  用于计算数值数据的算术中值。

<img src="https://upload-images.jianshu.io/upload_images/19680844-b4df1e19ed27412c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240" alt="image.png" style="zoom:67%;" />

示例：

sum()：求和；mean() ：求中值；std()：求标准差；describe()：描述性统计信息摘要。

```python
d = {'Name':pd.Series(['Tom','James','Ricky','Vin','Steve','Minsu','Jack',
'Lee','David','Gasper','Betina','Andres']),
'Age':pd.Series([25,26,25,23,30,29,23,34,40,30,51,46]),
'Rating':pd.Series([4.23,3.24,3.98,2.56,3.20,4.6,3.8,3.78,2.98,4.80,4.10,3.65])}

#Create a DataFrame
df = pd.DataFrame(d)
print(df, '\n')
print(df.sum(), '\n') # 列求和， 默认axis=0
print(df.sum(1), '\n') # 行求和，axis=1
print(df.mean(), '\n') # 求均值
print(df.std(), '\n') # 标准差
print(df.describe(include=['number'])) # 统计信息摘要
```

### 4.4.3、迭代与遍历

pandas对象之间的基本迭代的行为取决于类型。当迭代一个系列时，它被视为数组式，基本迭代产生这些值。其他数据结构，如：DataFrame，遵循类似惯例迭代对象的键。

简而言之，基本迭代（对于 i 在对象中）产生： Series - 值； DataFrame - 列标签

要遍历数据帧 ( DataFrame ) 中的行，可以使用以下函数：iteritems() —— 迭代 ( key，value ) 对； iterrows() ——将行迭代为(索引，系列)对； itertuples() —— 以 namedtuples 的形式迭代行

迭代 DataFrame

```python
N=5
df = pd.DataFrame({
'D': pd.date_range(start='2019-01-01',periods=N,freq='M'),
'x': np.linspace(0,stop=N-1,num=N),
'y': np.random.rand(N),
'z': np.random.choice(['Low','Medium','High'],N).tolist(),
})
print(df,'\n')
for col in df:
print(col)
```

遍历 Dataframe 

1） iteritems（）:将索引和值作为键和列值迭代为Series对象。 2）iterrows()返回迭代器，产生每个索引值以及包含每行数据的序列。 3）itertuples() 方法将为 DataFrame 中的每一行返回一个产生一个命名元组的迭代器。元组的第一个元素将是行的相应索引值，而剩余的值是行值。

```python
df = pd.DataFrame(np.random.randn(4,3),columns=['col1','col2','col3’])
for key,value in df.iteritems():
	print (key,value)
  
for row_index,row in df.iterrows():
	print (row_index,row)
  
for row in df.itertuples():
	print (row)
```

### 4.4.4、排序

按索引排序：使用`sort_index()`方法，通过传递axis参数和排序顺序，可以对DataFrame进行排序。 默认情况下，按照升序对行标签进行排序。

按数值排序：sort_values() 是按值排序的方法。它接受一个by参数，它将使用要与其排序值的DataFrame 的列名称。

排序顺序：通过将布尔值传递给升序参数 ascending ，可以控制排序顺序。

按行或列排序：通过设置 axis 参数为 0 或 1，为 0 时逐行排序，为 1 时逐列排序，默认为 0 。

```python
unsorted_df = pd.DataFrame(np.random.rand(10,2),index=[1,4,6,2,3,5,9,8,0,7],columns =
['A','B'])
print(unsorted_df,'\n')

sorted_df=unsorted_df.sort_index(ascending = True) #按索引排序
print (sorted_df,'\n')

sorted_df = unsorted_df.sort_values(by='B') # 按'B'列的值进行排序
print (sorted_df,'\n')
```

### 4.4.5、缺失值处理

缺失值主要是指数据丢失的现象 ， 也就是数据集中的某一块数据不存在。除了原始数据集就已经存在缺失值以外 ，当我们用到索引对齐（ reindex () ，选择等 ）方法时 ，也容易人为导致缺失值的产生。

缺失值处理包括：缺失值标记； 缺失值填充；缺失值插值

Pandas 为了更方便地检测缺失值 ， 将不同类型数据的缺失均采用 NaN 标记 。 这里的 NaN 代表t Not a Number ， 它仅仅是作为一个标记。

Pandas 中用于标记缺失值主要用到两个方法 ，分别是：`isnull () `和 `notnull ()` ，顾名思义就是「 是缺失值 」和「 不是缺失值 」。默认会返回布尔值用于判断。

```python
# 使用reindex()人为生成缺失值
df = pd.DataFrame(np.random.rand(4, 3), index=['a', 'c', 'e', 'f'],columns=['one', 'two', 'three'])

df = df.reindex(['a', 'b', 'c', 'd', 'e', 'f', 'g'])

print (df,'\n')
print(df['one'].isnull(),'\n') # 缺失值标记
print (df['one'].notnull(),'\n')
```

Pandas 提供了各种方法来清除缺失的值。`fillna()`函数可以通过几种方法用非空数据“填充”NaN值。

 用标量值替换NaN`print (df.fillna(0))`

 向前填充：pad/fill， 向后填充：bfill/backfill

`print (df.fillna(method='pad’))`；`print (df.fillna(method='backfill'))`

丢弃缺少的值：如果只想排除缺少的值，则使用 dropna 函数和 axis 参数。 默认情况下，axis = 0，如果行内的任何值是 NaN，那么整个行被删除。

```python
#丢弃含NaN值的行
print(df.dropna())
#丢弃含NaN值的列
print (df.dropna(axis=1)) 
```

替换缺失（或通用）值：用一些具体的值取代一个通用的值或缺失值。用标量替换 NaN 和使用fillna() 函数等效。

```python
df = pd.DataFrame({'one':[10,20,30,40,50,2000],'two':[1000,0,30,40,50,60]})
print(df,'\n')
print(df.replace({1000:10,2000:60}))
```

