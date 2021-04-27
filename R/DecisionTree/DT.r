#查看iris数据集（系统自带）
str(iris)
#设置随机种子为1234
set.seed(1234)
#使用sample函数抽取样本，将数据集中观测值分为两个子集
ind<-sample(2,nrow(iris),replace = TRUE,prob = c(0.7,0.3))
#一部分为训练集，一部分为测试集
trainData<-iris[ind==1,]
testData<-iris[ind==2,]

#加载rpart包
library(rpart)
#说明模型中的因变量和自变量
myFormula<-Species~Sepal.Length+Sepal.Width+Petal.Length+Petal.Width#或myFormual<-Species~.
#建立决策树
dtree=rpart(myFormula,method = "class",trainData)

#用测试集做预测
test_Pre=predict(dtree,testData,type = "class")
#显示结果
tt=table(test_Pre,testData$Species);tt
#计算准确率并输出
test_accuracy=round((tt[1,1]+tt[2,2]+tt[3,3])/sum(tt),2)
test_accuracy

#对新的观测数据进行分类
newiris<-data.frame(Sepal.Length=6.0,Sepal.Width=3.5,Petal.Length=4.5,Petal.Width=2.5)
test_Pred<-predict(dtree,newiris)
test_Pred