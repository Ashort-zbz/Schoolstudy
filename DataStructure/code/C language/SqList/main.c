#define MaxSize 50

//�������ݽṹ
typedef struct{
    ElemType data[MaxSize];
    int length;
}SqList;

/*��������*/
//�������
bool ListInsert(SqList &L, int i, ElemType e){
    if(i < 1 || i > L.length + 1)//���Ա���Ԫ��λ���1��ʼ�������±��0��ʼ
        return false;
    if(L.length >= MaxSize)     //��ǰ�ռ�����
        return false;
    for(int j = L.length; j >= i; j--)      //����i��Ԫ�غ��Ԫ�غ���
        L.data[j] = L.data[j-1];
    L.data[i-1]=e;
    L.length++;
    return true;
}

//ɾ������
bool ListDelete(SqList &L, int i, ElemType &e){
    if(i<1 || i>L.length)
        return false;
    e=L.data[i-1];//����ɾ��Ԫ��ֵ����e
    for(int j=i; j<L.length; j++)
        L.data[j-1] = L.data[j];
    L.length--;
    return true;
}

//˳�����
int LocateElem(SqList L, ElemType e){
    for(int i=0; i<L.length; i++){
        if(L.data[i] == e){
            return i+1;
        }
    }
    return 0;
}
