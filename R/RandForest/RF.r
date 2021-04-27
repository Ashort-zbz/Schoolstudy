#使用sample函数抽取样本，将数据集分为两个子集
ind<-sample(2,nrow(iris),replace = TRUE,prob = c(0.7,0.3))
trainData<-iris[ind==1,]
testData<-iris[ind==2,]
#导入randomForest包
library(randomForest)
for (i in 1:4) {
  #建立随机森林，mtry参数指定每颗决策树在划分结点时用到的随机属性的数目，mtry可以取1到属性总数的任意值
  rf<-randomForest(Species~.,data = trainData,mtry = i,proximity=TRUE)
  #训练错误率
  train_err<-mean(rf$err.rate)
  #训练正确率
  train_accuracy<-1-train_err
  print(train_accuracy)
}
