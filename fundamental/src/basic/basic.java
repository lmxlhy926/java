package basic;
import java.util.Arrays;
/**
 * @author shkstart
 * @create 2022-02-22 14:01
 */


/*
语言环境搭建：
    JRE = JVM + Java SE标准类库
    JDK = JRE + 开发工具集（javac编译工具等）
一个源文件中最多只能有一个public类.其它类的个数不限，如果源文件包含一个public类，则文件名必须按该类名命名。
 */


/*
数组：
    数组是引用数据类型，声明数组时不能指定其长度
    定义并用运算符new为之分配空间后，才可以引用数组中的每个元素
    基本类型默认初始化值：各不相同，和具体的类型有关
    引用数据类型初始化值：默认初始化值为null。

多维数组：
    java中多维数组不必都是规则矩阵形式

Arrays工具类：
    java.util.Arrays类即为操作数组的工具类，包含了用来操作数组的各种方法
 */

/*
参数传值机制：
    基本数据类型：传递值
    引用数据类型：传递值（值为指针）
 */

class marray{
    public void singleArray(){
        int[] a = new int[]{1, 2, 3, 4, 5};
        for(int i = 0; i < a.length; ++i){
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }

   public void multiArray(){
        int[][] arr = new int[3][];
        arr[0] = new int[]{1, 2, 3};
        arr[1] = new int[]{4, 5};
        arr[2] = new int[]{6};
        for(int i = 0; i < arr.length; ++i){
            for(int j = 0; j < arr[i].length; ++j){
                System.out.println("a[" + i + "]" + "[" + j + "] = " + arr[i][j]);
            }
        }
    }

    public void arrayTest(){
        int[] numbers = new int[]{1, 3, 2};
        Arrays.sort(numbers);
        for(int i : numbers){
            System.out.println(i);
        }
        System.out.println("----------");
        Arrays.fill(numbers, 100);
        for(int i : numbers){
            System.out.println(i);
        }

    }

}

public class basic {
    public static void main(String[] args){
        marray a = new marray();
        a.arrayTest();
    }

}
