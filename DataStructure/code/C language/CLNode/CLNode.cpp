#include <stdio.h>

typedef int ElemType;

/*
循环链表的结构和单链表结构一样
将单链表中的终端点的指针由空指针改为指向头结点，使整个单链表形成一个环
这种头尾相接的单链表称为循环单链表，简称循环链表。
*/

typedef struct CLNode
{
    ElemType data;
    struct CLNode *next;
}CLNode, *CLinkList;

//初始化
bool InitCList(CLinkList &L){
    L = new CLNode;
    if(L = NULL){
        return false;
    }
    L->next = L;
    return true;
}