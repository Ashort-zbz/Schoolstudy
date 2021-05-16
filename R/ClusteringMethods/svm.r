library(e1071)#导入包e1071
set.seed(1234)#设置随机数种子
ind<-sample(2,nrow(iris),replace = TRUE,prob = c(0.7,0.3))#抽样函数,replace为T表示采取有重复的抽样
trainData<-iris[ind==1,]#训练集
testData<-iris[ind==2,]#测试集

iris_svm<-svm(Species~.,data=trainData)#训练模型
pre=predict(iris_svm,testData,type='class')#用测试集做预测
table<-table(pre,testData$Species)
table#显示结果
sum(diag(prop.table(table)))#计算准确率，输出

#创建数据框
newiris<-data.frame(Sepal.Length=6.0,Sepal.Width=2.8,Petal.Length=4.5,Petal.Width=2.5)
test_Pred<-predict(iris_svm,newiris)
test_Pred#显示结果