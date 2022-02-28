package advance;

import java.util.*;

/**
 * @author shkstart
 * @create 2022-02-24 17:12
 */


/*
    ArrayList: 相当于c++中的vector, 线程不安全
    LinkedList: 双向链表，适用于频繁插入，线程不安全。
 */
class listTest{
    /*
        collection接口的常用操作：
            1. 元素的增加，删除，是否含有某个元素
            2. 大小，是否为空，清空
            3. 迭代器
     */
    public void collectionInterface(){
        Collection collection = new ArrayList();

    //增加元素
        collection.add("first");
        collection.add("second");
        collection.add("third");
    //删除元素
        collection.remove("first");
        for(Object a : collection){
            System.out.println(a);
        }
    //元素有效个数
        System.out.println("collection.size(): " + collection.size());

    //是否包含某个元素
        if(collection.contains("second")){
            System.out.println("contain the element 'second'==>");
        }

    //迭代器：
        Iterator iterator = collection.iterator();
        System.out.println("===============>");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    /*
        List接口新增操作：
            1. 指定位置增加元素，删除元素，修改元素
            2. 获取指定位置的元素
            3. 获取元素首次，末次出现的位置
     */
    public void arraylistInterface(){
        List list = new ArrayList();
        list.add("first");
        list.add("second");
    //在指定位置增加元素
        list.add(0, "beforeFirst");
        list.add(3, "afterSecond");
        System.out.println("=========>1");
        for(Object o :list){
            System.out.println(o);
        }

    //移除指定位置的元素，修改指定位置的元素值
        list.remove(0);
        list.set(2, "newAfterSecond");
        System.out.println("=========>2");
        for(Object o :list){
            System.out.println(o);
        }

    //获取指定位置的元素
        System.out.println("the 3th element is: " + list.get(2));
        System.out.println("the 'newAfterSecond' fisrt occurence position: " + list.indexOf("newAfterSecond"));
    }


    /*
        LinkedList新增操作：
            1. 首尾增加元素
            2. 移除首尾元素
            3. 获得首尾元素
     */
    public void linkedlistInterface(){
        LinkedList list = new LinkedList();
        list.add("hello");
        list.add("world");
        list.addFirst("first");
        list.addLast("last");
        list.add(1, "new");
        for(Object o : list){
            System.out.println(o);
        }

        list.removeFirst();
        list.removeLast();
        System.out.println("==>first element: " + list.getFirst());
        System.out.println("==>last element: " + list.getLast());
    }

}


/*
    set接口的实现类:
        1. HashSet: 元素无序，不可重复
                1. 集合的自定义对象需要重写hashCode, equals()方法，可用IDE构造。
                2. 相等的对象必须具有相等的hashcode值
                3. hashcode值决定在数组中的位置，equals方法决定是否添加该对象

        2. LinkedHashSet:
                派生自HashSet，在HashSet的基础上，采用双向链表维护元素次序。
                迭代访问全部元素时有很好的性能，迭代时按插入顺序迭代

        3. TreeSet: 集合元素处于排序状态
               1. 自然排序： 集合元素实现Comparable接口
                        TreeSet集合中的元素必须实现Comparable接口，即实现Comparable接口中的compareTo(Object obj)方法。
               2. 定制排序： 通过构造器传参来指定排序方法
                        实现Comparator接口的实例作为形参传递给TreeSet的构造器
                        实现Comparator接口，即实现该接口的int compare(T o1, T o2)方法。
 */
class setTest{
    public void hashSet(){
        HashSet hs = new HashSet();
        hs.add("first");
        hs.add("second");
        hs.add("third");
        hs.add("fourth");
        hs.add("fifth");
        hs.remove("first");
        System.out.println("hashSet hs contains 'second': " + hs.contains("second"));
        System.out.println("hs.size(): " + hs.size());
        for(Object o : hs){     //迭代时顺序是任意的
            System.out.println(o);
        }
    }

    public void linkedHashSet(){
        LinkedHashSet hs = new LinkedHashSet();
        hs.add("first");
        hs.add("second");
        hs.add("third");
        hs.add("fourth");
        hs.add("fifth");
        hs.remove("first");
        System.out.println("hashSet hs contains 'second': " + hs.contains("second"));
        System.out.println("hs.size(): " + hs.size());
        for(Object o : hs){     //迭代时按顺序迭代
            System.out.println(o);
        }
    }

}


/*
    map：保存具有映射关系的数据：key-value
        HashMap:
            1. key构成的集合是Set, key所在的类要重写hashCode()和equals()方法。
            2. map中添加元素的过程：
                    1. 计算entry中的key的哈希值，哈希值经过散列算法处理后，得到底层Entry[]数组中要存储的位置i。
                    2. 按下列方式进行判断
                        如果位置i没有元素，则直接添加成功。
                        如果位置i已经存在其它entry，则需要通过循环的方式依次比较此entry的key和其它entry的key。
                            如果key对应的hash值不同，则直接添加成功。
                            如果key对应的hash值相同，则调用key对象的equals()方法进行比较。
                                不同则添加此新entry。
                                相同则用新entry的value值替换之前entry对应的value值

        TreeMap: 保证key-value对处于有序状态
            1. 自然排序： TreeMap中的key需要实现Comparable接口
            2. 定制排序： TreeMap的构造器需要接收一个Comparator接口的实现对象，该对象负责对TreeMap中的所有key进行排序
                         TreeMap的key不再需要实现Comparable接口

        Properties:
            用于处理属性文件
            Properties里的key和value都是字符串类型
 */
class mapTest{
    public void map(){
        HashMap hm = new HashMap();
    //添加key-value对
        hm.put("first", 1);
        hm.put("second", 2);
        hm.put("third", 3);
        hm.put("fourth", 4);
        hm.put("fifth", 5);
    //通过Key移除key-value对
        hm.remove("first");
    //map包含的元素数量，某个key对应的值，是否包含某个key，是否包含某个value.
        System.out.println("hm.size(): " + hm.size());
        System.out.println("hm.isEmpty(): " + hm.isEmpty());
        System.out.println("hm.get(second): " + hm.get("second"));
        System.out.println("hm.containsKey(second): " + hm.containsKey("second"));
        System.out.println("hm.containsValue(2): " + hm.containsValue(2));
    }


    public void mapkeyValue(){
        Map hm = new HashMap();
        hm.put("first", 1);
        hm.put("second", 2);
        hm.put("third", 3);
        hm.put("fourth", 4);
        hm.put("fifth", 5);

    //返回所有key构成的Set集合
        System.out.println("map的所有key: ");
        Set keys = hm.keySet();
        for(Object key : keys){
            System.out.println(key + "->" + hm.get(key));
        }

    //返回所有value构成的Collection集合
        System.out.println("map的所有value method1: ");
        Collection values = hm.values();
        for(Object value : values){
            System.out.println(value);
        }
        System.out.println("map的所有value method2: ");
        Iterator iterator = values.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    //返回所有key-value对构成的Set集合
        System.out.println("map的所有映射关系: ");
        Set mappings = hm.entrySet();
        for(Object mapping : mappings){
            Map.Entry entry = (Map.Entry) mapping;
            System.out.println("key: " + entry.getKey() + "--> value: " + entry.getValue());
        }
    }

    public void properties() {
        Properties pros = new Properties();
        pros.setProperty("user", "root");
        String user = pros.getProperty("user");
        System.out.println(user);
    }

}

/*
    Collections工具类：
        操作Set, List, Map等集合的工具类
        提供了一系列静态方法对集合元素进行排序、查询、修改等操作
 */
class collectionUtil{
    public void test(){
        List list = new ArrayList();
        list.add(3);
        list.add(1);
        list.add(2);
        System.out.println("==>before sorted: ");
        for(Object o : list){
            System.out.println(o);
        }
        System.out.println("==>after sorted: ");
        Collections.sort(list);
        for(Object o : list){
            System.out.println(o);
        }

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
        Collections.sort(list, comparator);
        System.out.println("==>after sorted with comparator: ");
        for(Object o : list){
            System.out.println(o);
        }
    }

}






public class collection {
    public static void main(String[] args){
        collectionUtil mt = new collectionUtil();
        mt.test();
    }


}
