library(kknn)#导入knn
set.seed(1234)#设置随机数种子
#用iris数据集中的一部分作为训练集（7/10）训练几种不同的分类器，用剩余的数据样本作为测试集（3/10）
ind<-sample(2,nrow(iris),replace = TRUE,prob = c(0.7,0.3))
trainData<-iris[ind==1,]
testData<-iris[ind==2,]

#进行聚类
iris_kknn<-kknn(Species~.,trainData,testData,distance = 5,kernel = "triangular")
#描述性统计
summary(iris_kknn)
pre<-fitted(iris_kknn)
tab<-table(pre,testData$Species)
tab#显示结果
sum(diag(prop.table(tab)))#计算准确率

#对新的观测数据进行分类
newiris<-data.frame(Sepal.Length=6.0,Sepal.Width=2.8,Petal.Length=4.5,Petal.Width=2.5)
niris_kknn<-kknn(Species~.,trainData,newiris,distance = 5,kernel = "triangular")
test_Pred<-fitted(niris_kknn)
test_Pred