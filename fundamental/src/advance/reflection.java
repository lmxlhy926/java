package advance;


import java.lang.reflect.Field;
import java.security.spec.ECField;

class test{
    public String name;
    public String age;

    public test(){
        name = "tom";
        age = "20";
    }
    public void showMessage(){
        System.out.println("==>name: " + name + ", age: " + age);
    }
}


public class reflection {

    public void test1(){
        String str = "advance.test";
        try {
            Class clazz = Class.forName(str);
            test obj = (test)clazz.newInstance();
            obj.showMessage();

            Field field = clazz.getField("name");
            field.set(obj, "peter");
            obj.showMessage();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args){
        

    }
}
