library(nnet)
set.seed(1234)#设置随机数种子
#用iris数据集中的一部分作为训练集（7/10）训练几种不同的分类器，用剩余的数据样本作为测试集（3/10）
ind<-sample(2,nrow(iris),replace = TRUE,prob = c(0.7,0.3))
trainData<-iris[ind==1,]
testData<-iris[ind==2,]

#使用训练集进行ANN模型训练
iris_nnet<-nnet(Species~.,size=10,decay=0.01,maxit=1000,trace=F,data = trainData)
pre=predict(iris_nnet,testData,type = 'class')#对测试集进行魔性训练
tab<-table(pre,testData$Species)
tab#显示结果
sum(diag(prop.table(tab)))#计算准确率

#构造新的数据进行预测
newiris<-data.frame(Sepal.Length=6.0,Sepal.Width=2.8,Petal.Length=4.5,Petal.Width=2.5)
test_Pred<-predict(iris_nnet,newiris)#预测结果
test_Pred#显示结果