## 泛型
泛型（generics）是 JDK1.5 中引入的新特新，泛型提供了编译时类型安全检测机制，该机制









### 集合面试汇总

1. Java 的集合框架有几种？

   两种，Collection 和 Map，其中 Collection 分为 Set 和 List 。

2. List 使用过哪些？

   ArraryList 和 LinkedList 使用的最多。

3. ArrayList 、LinkedList 和 vector 的区别？

   ArraryList 是基于可变数组实现的，默认初始化长度 10。也可以设置容量。但是没有设置的时候是默认空数组，只有第一步 add 的时候会进行扩容（重新创建了数组），后续扩容按照 3/2 的大小进行扩容，是线程不安全的，适用多读取，少插入的情况。

   LinkedList 是基于双向链表实现的，使用了尾插法的方式，内部维护了链表的长度，以及节点和尾节点，所以获取长度不需要遍历，适合插入删除平凡的情况。

   Vector 是线程安全的，也是基于数组实现的，但是方法上都有 Synchronized 关键字修饰。扩容方式是原来的两倍。

   

4. HashMap、hashTable 和 ConcurrentHashMap 的区别？

   

   