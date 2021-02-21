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