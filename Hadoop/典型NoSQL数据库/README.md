# 典型NoSQL数据库

## Redis 安装和使用

在下面的网址下选择自己需要的版本：

https://download.redis.io/releases/?_ga=2.107615234.1093729106.1623140181-342859476.1623140181

下载好文件后，解压在 /usr/local/ 目录下，并且重命名为 redis：

```shell
sudo tar -zxvf redis-3.2.7.tar.gz 
sudo mv ./redis-3.2.7 ./redis
```

将redis目录的权限赋给普通用户：

```
sudo chown -R admin ./redis
```

接下来进入 redis  目录，输入下面命令进行编译和安装Redis：

```shell
sudo make
sudo make install
```

安装完成，执行下面命令开启Redis服务器：

```shell
cd /usr/local/redis
./src/redis-server
```

如果出现下面的命令，那么表示安装成功

![image.png](https://upload-images.jianshu.io/upload_images/19680844-a80362e3c8beb26c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

此时不要关闭该终端，打开一个新的终端，进入/usr/local/redis 目录，并开启Redis服务器：

```shell
cd /usr/local/redis
./src/redis-cli
```

出现下面的情况就可以进行进一步的Redis数据库操作

![image.png](https://upload-images.jianshu.io/upload_images/19680844-c8ccc74f686a8075.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## MongoDB 的安装和使用

### 启动MongoDB

```shell
service mongod start
或
systemctl start mongod
或
/usr/bin/mongod -f /etc/mongod.conf
```

启动成功后打开shell界面，在命令行中，运行mongo, 就可以启动shell

```shell
mongo
```



## MySQL 安装和使用

### MySQL安装

（1）检查系统中是否已安装 MySQL。

```shell
rpm -qa | grep mysql
```

![image.png](https://img-blog.csdn.net/20180725234952780?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3BlbmdqdW5sZWU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70) 

返回空值的话，就说明没有安装 MySQL （上面的情况就是没有安装）。

**注意：在新版本的CentOS7中，默认的数据库已更新为了Mariadb，而非 MySQL，所以执行 yum install mysql 命令只是更新Mariadb数据库，并不会安装 MySQL 。**

（2）查看已安装的 Mariadb 数据库版本。

```shell
rpm -qa|grep -i mariadb
```


（3）卸载已安装的 Mariadb 数据库。

```shell
rpm -qa|grep mariadb|xargs rpm -e --nodeps
```


（4）再次查看已安装的 Mariadb 数据库版本，确认是否卸载完成。

```shell
rpm -qa|grep -i mariadb
```


 （5）下载安装包文件。

```shell
wget http://repo.mysql.com/mysql-community-release-el7-5.noarch.rpm
```


（6）安装mysql-community-release-el7-5.noarch.rpm包

```shell
rpm -ivh mysql-community-release-el7-5.noarch.rpm
```


安装完成之后，会在 /etc/yum.repos.d/ 目录下新增 mysql-community.repo 、mysql-community-source.repo 两个 yum 源文件。

![image.png](https://upload-images.jianshu.io/upload_images/19680844-bb10def703c9f667.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

（6）安装mysql。

```shell
yum install mysql-server
```

![image.png](https://upload-images.jianshu.io/upload_images/19680844-5a13bcebac62e2e4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

（7）检查mysql是否安装成功。

```shell
rpm -qa | grep mysql
```

![image.png](https://upload-images.jianshu.io/upload_images/19680844-bdde9c304c92762e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

（8）启动 mysql 服务 。

```shell
systemctl start mysqld.service #启动 mysql
#其他有关MySQL启动的命令
systemctl restart mysqld.service #重启 mysql
systemctl stop mysqld.service #停止 mysql
systemctl enable mysqld.service #设置 mysql 开机启动
```

MySQL默认文件路径：　　

/etc/my.cnf 　　这是mysql的主配置文件

/var/lib/mysql 　　mysql数据库的数据库文件存放位置

/var/logs/mysqld.log　　数据库的日志输出存放位置

（9）设置密码 。

mysql5.6 安装完成后，它的 root 用户的密码默认是空的，我们需要及时用 mysql 的 root 用户登录（第一次直接回车，不用输入密码），并修改密码。

```shell
# mysql -u root

mysql> use mysql;
mysql> update user set password=PASSWORD("这里输入root用户密码") where User='root';
mysql> flush privileges; 
```

![image.png](https://upload-images.jianshu.io/upload_images/19680844-0145502e386899fc.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

然后MySQL就安装成功了 ::end:

### MySQL for Java API

在下面的链接中选择 mysql-connector-java 版本，推荐安装8.x版本，选择mysql-connector-java-8.0.11.jar  下载

https://repo1.maven.org/maven2/mysql/mysql-connector-java/

在eclipse中的Java工程配置中

![image.png](https://upload-images.jianshu.io/upload_images/19680844-429228b863246808.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

选择Java build Path

![image.png](https://upload-images.jianshu.io/upload_images/19680844-d8083383a4636fcf.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

选中Classpath ，然后点击Add External JARs，将刚刚下载好的jar包加入

![image.png](https://upload-images.jianshu.io/upload_images/19680844-d3a6646975ea171c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

至此Java API 环境配置完成

