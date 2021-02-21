#include <stdio.h>
#include <stdlib.h>
#include <iostream>

using namespace std;

typedef int ElemType;

/*----------双向链表的存储结构----------*/
typedef struct DuLNode
{
    ElemType data;      //
    struct DuLNode *pripr;      //
    struct DuLNode *next;       //
}DuLNode, *DuLinkList;


/*
在双向链表中，有些操作（如 ListLength、GetElem 和 LocateElem）仅涉及一个方向的指针，它们的算法描述与单链表相似。
但是在插入、删除操作时有很大不同，在双向链表总需要同时修改两个方向上的指针。
*/

DuLinkList GetElem_DuL(DuLinkList &L, int i){
    //如果 i 为0，返回头结点
    if(i == 0){
        return L;
    }
    //如果 i 为无效值，返回 NULL
    if(i < 1){
        return NULL;
    }
    int j = 1;      //计数，初始为1
    DuLinkList p = L->next;       //头结点指针赋给 p
    while(p && j<i){
        p = p->next;
        j++;
    }
    return p;       //返回第 i 个结点的指针， 若 i 大于表长，则会返回 NULL
}

//双向链表的插入
bool ListInsert_Dul(DuLinkList &L, int i, ElemType e){
    //带头结点的双向链表 L 中第 i 个位置前插入元素 e
    DuLinkList p=GetElem_DuL(L,i);
    //L 中确定第 i 个元素的位置指针 p
    if(!(p)){
        return false;
    }
    DuLinkList s = new DuLNode;     //生成新结点 s
    s->data = e;
    s->pripr = p->pripr;        //将结点 s 插入 L 中，s 的前驱指向 p 的前驱
    p->pripr->next = s;     //原来 p 的前驱结点的 next 指针域指向新插入的结点s
    s->next = p;        //新插入的结点 s 的 next 指针域指向 p
    p->pripr = s;       //p 的前驱指针域指向新插入的结点 s
    return true;
}

//双向链表的删除
bool ListDelete_DuL(DuLinkList &L, int i){
    //
    DuLinkList p=GetElem_DuL(L,i);      //L 中确定第 i 个元素的位置指针 p
    if(!(p)){
        return false;
    }
    p->pripr->next = p->next;       //修改被删结点的前驱结点的后继指针
    p->next->pripr = p->pripr;      //修改被删结点的后驱结点的前驱指针
    delete p;
    return true;
}