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

    package
        package语句作为java源文件的第一条语句，指明该文件中定义的类所在的包。格式为：package 顶层包名.子包名
        包对应于文件系统的目录，用“.”来指明包的层次
    import
        为了使用定义在不同包中的java类，需要使用import语句来引入指定包层次下所需要的类或者全部类（.*）
        声明在包的声明和类的声明之间
        如果已经导入java.a包下的类，如果需要使用a包的子包下的类的话，仍然需要导入。
        不同包下的同名类，需要使用类的全类名的方式指定
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

/*
类和对象；
    当一个对象被创建时，会对其中各种类型的成员变量自动进行初始化赋值。成员变量的类型：基本数据类型，引用数据类型
    对象数组
    this:
        在方法内部使用：即这个方法所属对象的引用
        构造器内部使用：表示构造器正在初始化的对象，this(形参列表)必须声明在类的构造器的首行
        this可以调用类的属性、方法和构造器
    super:
        1. 用于访问父类中定义的属性，成员方法
        2. 用于在子类构造器中调用父类的构造器

    继承：java只支持单继承和多层继承

    程序中成员变量的赋值执行顺序：
        1. 声明成员变量的默认初始化
        2. 显示初始化，多个初始化块依次被执行. 显示初始化先于代码块
        3. 执行构造器

    子类对象实例化过程；
        1. 所有成员变量的默认初始化
        2. 父类的初始化块，构造器。子类的初始化块，构造器。
 */

/*
包装类：
    针对8种基本数据类型定义相应的引用类型--->包装类
    利用包装类实现基本类型和字符串之间的转换
 */

/*
static: 可修饰属性，方法，代码块，内部类
    1. 随着类的加载而加载
    2. 优先于对象存在
    3. 修饰的成员，被所有对象所共享
    4. 访问权限允许时，可不创建对象，直接被类调用

代码块：对java类或对象进行初始化。只能被static修饰
    静态代码块：
        1. 若存在多个静态代码块，按照从上到下的顺序依次执行
        2. 静态代码块的执行优先于非静态代码块
        3. 静态代码块随着类的加载而加载，且只执行一次
    非静态代码块：
        1. 存在多个，按照从上到下的顺序执行
        2. 每次创建对象的时候都会执行一次。且优先于构造器执行。

final:
    1. final标记的类不能被继承
    2. final标记的方法不能被子类重写
    3. final标记的变量（成员变量或局部变量）即称为常量。
        final标记的成员变量，必须在声明时，或构造器代码，或代码块中显示赋值，才能被使用

abstract:
    1. 修饰类，这个类为抽象类
    2. 修饰方法，这个方法为抽象方法。只有方法的声明没有方法的实现。

接口：抽象方法和常量值定义的集合
    1. 接口中所有成员变量都默认是由public static final修饰的
    2. 接口中所有抽象方法都默认是由public abstract修饰的
    3. 接口采用多继承机制
 */


//数组测试
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

/*
    可变参数：
        方法参数部分指定类型的参数个数是可变多个：0，1...
        需要放在形参声明的最后
        一个方法的形参位置，最多只能声明一个可变个数形参
 */
class varArgs{
    public void test(String str){
        System.out.println("in test(String str)");
    }

    public void test(String... str){
        System.out.println("in test(String... str)");
        for(int i = 0; i < str.length; ++i){
            System.out.println(str[i]);
        }
    }

    public void methodtest(){
        String[] str = new String[]{"aa", "bb"};
        test();     //可变参数：指定的参数为可变多个：0个，1个或多个。
        test("hello");
        test("hello", "world");
        test(str);  //可变参数：接收数组形式的参数
    }
}

//包装类测试
class wrapper{
    public void baseWrapper(){
        Integer a = 1;                           //自动装箱
        Integer b = Integer.parseInt("2");    //转换后，自动装箱

        int c = a.intValue();   //函数转换
        int d = b;              //自动拆箱
    }

    public void wrapperString(){
        Integer a = 100;
        System.out.println(a.toString());           //调用成员方法
        System.out.println(Integer.toString(a));    //调用类方法，自动拆箱

        String s = "100";
        Integer b = Integer.valueOf("100");
    }

    //基本数据类型和字符串之间的转换
    public void baseString(){
        //字符串到基本数据类型
        int i = Integer.parseInt("100");
        float f = Float.parseFloat("3.5f");

        //基本数据类型到字符串
        String s1 = Integer.toString(i);
        String s2 = Float.toString(f);
    }
}


interface skillbase1{
    public abstract void run();
}

interface skillbase2{
    public abstract void fly();
}

//接口之间可以是多继承
interface skill extends skillbase1, skillbase2{
    public static final int flyid = 1;
}

interface favorite{
    void sing();
    void eat();
}

class memStr{
    public memStr(){
        System.out.println("memStr constructor");
    }
}

class memInt{
    public memInt(){
        System.out.println("memInt constructor");
    }
}

abstract class base{
    private memStr ms;
    public base(){
        ms = new memStr();
        System.out.println("base constructor");
    }
    {
        System.out.println("in base code block");
    }
    public void virtual(){    //不需要声明为virtual
        System.out.println("in base virtual");
    }
    public abstract void everyonedo();  //抽象方法声明，拥有抽象方法的类为抽象类
}

class inherit extends base implements skill, favorite{  //继承一个类，实现多个接口
    private int flyid = 1;
    private memInt mi;
    private  String str = "first";
    public inherit(){
        mi = new memInt();
        System.out.println("inherit constructor");
    }
    //代码块优先于构造器执行，且只在对象被调用时调用一次。
    {
        System.out.println("in inherit code block str = " + str);
        str = "second";
    }
    public void show(){
        System.out.println("in inherit show i = " + str);
    }

    public void virtual(){  //不需要声明override
        System.out.println("in inherit virtual");
    }

    public void everyonedo(){
        System.out.println("in inherit everyonedo");
    }

    public void fly(){
        System.out.println("flyid = " + skill.flyid);
    }

    public void run(){
        System.out.println("run");
    }

    public void sing(){
        System.out.println("sing");
    }

    public void eat(){
        System.out.print("eat");
    }

}


public class basic {
    public static void main(String[] args){

       base i = new inherit();
       i.virtual();
    }

}
