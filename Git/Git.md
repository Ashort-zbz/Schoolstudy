# Git

[TOC]



## 1. 使用GitHub

### 1.1 目的

借助 GitHub 托管项目代码。

### 1.2 基本概念

![截图1](https://upload-images.jianshu.io/upload_images/19680844-049c62ff697210d5.png?imageMogr2/auto-orient/strip|imageView2/2/w/1240)

fork 示意图：

![fork示意图](https://upload-images.jianshu.io/upload_images/19680844-42d7f6da9ed8cbb2.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

注意：fork 的项目是独立存在的。fork 来的仓库中新增的代码、文件等在原仓库中是不会存在的。

![截图2](https://upload-images.jianshu.io/upload_images/19680844-94617112a72cb7bb.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

pull request示意图：

![pull request示意图：](https://upload-images.jianshu.io/upload_images/19680844-9f8ca4788e5c2088.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![截图3](https://upload-images.jianshu.io/upload_images/19680844-8dc3a8933d6e4b8a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

GitHub 主页：分几个部分，左边是全部仓库，中间是关注的项目、用户的动态，右边是推荐。

![GitHub 主页](https://upload-images.jianshu.io/upload_images/19680844-5386b35038a08129.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 1.3 注册 GitHub 账号

官网：https://github.com/

![注册1](https://upload-images.jianshu.io/upload_images/19680844-793f644fcd0265fd.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

注意：其中的邮箱非常重要，需要接受邮件。否则可能会造成无法创建仓库。

![注册2](https://upload-images.jianshu.io/upload_images/19680844-169586595af7045b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

第三部是一个用户调查问卷页面，直接跳过。

![注册3](https://upload-images.jianshu.io/upload_images/19680844-46042ab8616152fa.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

注册成功后会跳转到下面的页面：

![注册成功](https://upload-images.jianshu.io/upload_images/19680844-f0521926da6c8790.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

:star:注意：

1. 因为 GitHub 服务器在国外，所以访问比较慢或者无法访问，需要翻墙。（Shadowsocks）
2. 私有仓库只能自己或指定朋友才有权限操作（私有仓库收费）
3. 新注册的用户必须验证邮箱才可以创建 git 仓库。

当这时点击 start a project 时，因为你还没有验证你的邮箱，所以会跳出下面的页面让你去邮箱验证：

![提示验证](https://upload-images.jianshu.io/upload_images/19680844-bb7a5bec74ad49ae.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

这里需要在 QQ 邮箱设置白名单才能收到 GitHub 的邮件。

### 1.4 创建仓库/新项目

一个 git 仓库对应一个开源项目，可以通过 git 管理 git 库。

![创建项目](https://upload-images.jianshu.io/upload_images/19680844-b29be28520f1f570.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![创建仓库2](https://upload-images.jianshu.io/upload_images/19680844-ed84cf6c87f95e16.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 1.5 仓库管理

#### 1.5.1 新建文件

点击 Add file ——> create new file 创建文件 

![新建1](https://upload-images.jianshu.io/upload_images/19680844-4d6f589257d8d853.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![新建2](https://upload-images.jianshu.io/upload_images/19680844-efcbec157d5e27e6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 1.5.2 修改文件

![修改](https://upload-images.jianshu.io/upload_images/19680844-9d2f04d5358dec81.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

注意：点击 GitHub 项目主页的 commits 查看所有你执行过的操作。

![commits](https://upload-images.jianshu.io/upload_images/19680844-b84e8492cc35ec1b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 1.5.3 上传文件

点击 Add file ——> upload files，上传文件。

![上传文件](https://upload-images.jianshu.io/upload_images/19680844-2b7708290c13288a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 1.5.4 查找文件

在项目主页中点击 go to file 进行查询。也可以按快捷键 t 进入查找页面。

![查找文件](https://upload-images.jianshu.io/upload_images/19680844-ddd3ed198b85b222.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 1.5.5 下载文件

![下载](https://upload-images.jianshu.io/upload_images/19680844-50923ab3a631a584.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 1.6 GitHub Issues

作用：发现代码 bug，但是目前没有成型代码，需要讨论时用：或者使用开源项目时出现问题是使用。

![issues1](https://upload-images.jianshu.io/upload_images/19680844-787397e27765b471.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![issue2](https://upload-images.jianshu.io/upload_images/19680844-87870b3c08ae3c3d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

git1 给 git2 提交一个 issue ，git2 可以在自己的主页看到。

### 1.7 开源项目贡献流程

1) 新建 issue

提交试用问题或者建议或者想法。

2）pull request

步骤：

1. fork 项目
2. 修改自己仓库的代码
3. 发起 pull request
4. 等待开源项目作者审核

## 2.使用 Git

目的：通过 Git 管理 GitHub 托管项目代码

### 2.1 下载安装

1）Git 官网：https://www.git-scm.com

2）双击安装

![image.png](https://upload-images.jianshu.io/upload_images/19680844-ec8009f4efb2f732.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![image.png](https://upload-images.jianshu.io/upload_images/19680844-6c000544f6510b90.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

之后选择组件

![image.png](https://upload-images.jianshu.io/upload_images/19680844-405cdd80b323dbf6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![image.png](https://upload-images.jianshu.io/upload_images/19680844-a22c11126bd46487.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![image.png](https://upload-images.jianshu.io/upload_images/19680844-828e906e29c6161c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

然后直接默认 next 即可。

#### 2.1.1 验证是否安装成功

在桌面点击右键，如果出现下面情况，就是安装成功：

![image.png](https://upload-images.jianshu.io/upload_images/19680844-d26bf7937ef02bdd.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 2.2 Git 工作流程

![image.png](https://upload-images.jianshu.io/upload_images/19680844-b38208e226ab4196.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

git status——查看文件状态

git add +“文件名”——将工作区文件添加到暂存区

git commit -m “提交描述”——暂存区文件添加到 git 仓库

![image.png](https://upload-images.jianshu.io/upload_images/19680844-f15be78e503e94aa.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)