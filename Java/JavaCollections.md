## java链表实现

一个简单链表结点的java实现：

```java
//为满足泛用性，也可设计成ListNode<AnyType>，int改为AnyType，双链表的实现同理
public class ListNode{
	prviate int data;
	ListNode next;
	
	ListNode(int data){
		this.data = data;
		ListNode next = null;
	}
	
	ListNode(int data, ListNode next){
		this.data = data;
		this.next = next;
	}
}
```







## Stack

## Queue

## List

### ArrayList

### LinkedList

## HashMap实现

### 问题

1. 数据结构：数组+链表+红黑树，什么时候转红黑树
2. put
3. get
4. 相同hash值，元素添加到链表的尾部还是头部
5. 1.8是尾插法.还有链表长度大于8且桶容量大于64才转成红黑树，而且节点数是少于6才由红黑树转为链表，而不是文中说的链表长度大于8转红黑树，小于8转链表

## Comparator



## Enumeration





## 反射

[unicode](https://unicode-table.com/en/#basic-latin)

