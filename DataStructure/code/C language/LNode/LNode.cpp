#include <stdio.h>
#include <stdlib.h>
#include <iostream>

using namespace std;

typedef int ElemType;

/*-----单链表的存储结构-----*/
typedef struct LNode
{
    ElemType data;      //结点数据域
    struct LNode *next;     //结点指针域
}LNode, *LinkList;      //LinkList 为指向结构体 LNode 的指针类型

//王道考研复习指导头插法
LinkList List_HeadInsert(LinkList &L){
    //头插法
    //逆序输入 n 个元素值，建立带头结点的单链表 L
    LinkList s;
    int x;
    L = (LinkList)malloc(sizeof(LNode));        //创建头结点
    L->next = NULL;     //初始为空链表
    scanf("%d",&x);
    while(x!=9999){     //若输入9999，表示结束
        s = (LinkList)malloc(sizeof(LNode));
        s->data = x;
        s->next = L->next;      //关键操作
        L->next = s;        //关键操作
        scanf("%d",&x);
    }
    return L;
}

//课本头插法
void CreateList_H(LinkList &L, int n){
    L = new LNode;
    L->next = NULL;
    for(int i=0; i<n; ++i){
        LinkList p = new LNode;
        cin>>p->data;
        p->next = L->next;
        L->next = p;
    }
}

//王道考研复习指导尾插法
LinkList List_TailInsert(LinkList &L){
    //尾插法
    //正序输入 n 个元素值
    int x;
    L = (LinkList)malloc(sizeof(LNode));
    LinkList s, r=L;
    scanf("%d",&x);
    while(x!=9999){
        s = (LinkList)malloc(sizeof(LNode));
        s->data = x;
        s->next = NULL;
        r->next = s;
        r = s;
    }
    return L;
}

//课本尾插法
void CreateList_T(LinkList &L, int n){
    L = new LNode;
    L->next = NULL;
    LinkList r = L;
    for(int i=0; i<n; ++i){
        LinkList p = new LNode;
        cin>>p->data;
        p->next = NULL;     //p 为最后一个结点，所以 p 的指针域赋空值
        r->next = p;        //r 先指向倒数第二个结点，将倒数第二个结点的指针域指向 p
        r = p;      //最后 r 指向链表的最后一个结点 p
    }
}

//王道考研复习指导————按序号查找结点
LinkList GetElem(LinkList L, int i){
    //如果 i 为0，返回头结点
    if(i == 0){
        return L;
    }
    //如果 i 为无效值，返回 NULL
    if(i < 1){
        return NULL;
    }
    int j = 1;      //计数，初始为1
    LinkList p = L->next;       //头结点指针赋给 p
    while(p && j<i){
        p = p->next;
        j++;
    }
    return p;       //返回第 i 个结点的指针， 若 i 大于表长，则会返回 NULL
}

//课本————单链表按序号查找
bool GetElem(LinkList L, int i, ElemType &e){
    LinkList p = L->next;       //初始化，p 指向首元结点
    int j = 1;      //计数器初值赋为 1
    while(p && j<i){
        p = p->next;
        ++j;
    }
    if(!p || j>i){      //i 值不合法
        return false;
    }
    e = p->data;
    return true;
}

//王道考研复习指导&&课本————按值查找
LinkList LocateElem(LinkList L, ElemType e){
    LinkList p = L->next;
    while(p!=NULL && p->data!=e){
        p = p->next;
    }
    return p;
}

//在 i 处插入值为 e 的新结点
bool ListInsert(LinkList &L, int i, ElemType e){
//带头结点的单链表 L 中第 i 个位置插入值为 e 的新结点
    LinkList p = L;
    int j = 0;
    while(p && (j<i-1)){
        p = p->next;
        ++j;
    }
    if(!p || j>i-1){
        return false;
    }
    LinkList s = new LNode;
    s->data = e;
    s->next = p->next;
    p->next = s;
    return true;
}

//在 i 处删除结点
bool ListDelete(LinkList &L, int i){
    //在带头结点的单链表 L 中，删除第 i 个元素
    LinkList p = L;
    int j = 0;
    /*
    删除算法中的循环条件和插入的是有区别的，
    因为插入操作中合法的插入位置有 n+1 个，
    而删除操作中合法的删除位置只有 n 个。
    */
    while((p->next) && (j<i-1)){
        p = p->next;
        ++j;
    }
    if(!(p->next) || (j>i-1)){      //当 i>n 或者 i<1时，删除位置非法
        return false;
    }
    LinkList q = p->next;       //临时保存被删除结点的地址
    p->next = q->next;      //改变删除结点前驱结点的指针域
    delete q;       //释放被删除结点的空间
    return true;
}