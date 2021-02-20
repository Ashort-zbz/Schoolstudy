#define MaxSize 50

//定义数据结构
typedef struct{
    ElemType data[MaxSize];
    int length;
}SqList;

/*基本操作*/
//插入操作
bool ListInsert(SqList &L, int i, ElemType e){
    if(i < 1 || i > L.length + 1)//线性表中元素位序从1开始，数组下标从0开始
        return false;
    if(L.length >= MaxSize)     //当前空间已满
        return false;
    for(int j = L.length; j >= i; j--)      //将第i个元素后的元素后移
        L.data[j] = L.data[j-1];
    L.data[i-1]=e;
    L.length++;
    return true;
}

//删除操作
bool ListDelete(SqList &L, int i, ElemType &e){
    if(i<1 || i>L.length)
        return false;
    e=L.data[i-1];//将被删除元素值赋给e
    for(int j=i; j<L.length; j++)
        L.data[j-1] = L.data[j];
    L.length--;
    return true;
}

//顺序查找
int LocateElem(SqList L, ElemType e){
    for(int i=0; i<L.length; i++){
        if(L.data[i] == e){
            return i+1;
        }
    }
    return 0;
}
