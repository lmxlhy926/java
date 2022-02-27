package advance;

import java.util.*;

/**
 * @author shkstart
 * @create 2022-02-24 17:12
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
        list接口的操作：
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
    }

    public void linkedlistInterface(){
        LinkedList list = new LinkedList();
        list.add("hello");
        list.addFirst("first");
        list.addLast("last");
        for(Object o : list){
            System.out.println(o);
        }
    }

}




public class advance {
    public static void main(String[] args){
      listTest lt = new listTest();
      lt.linkedlistInterface();
    }


}
