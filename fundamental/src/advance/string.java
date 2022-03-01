package advance;




/*
    string:
        1. 代表不可变的字符序列
        2. 所有字符串字面值都作为此类的实例实现
        3. String对象的字符内容存储在一个字符数组value[]中
 */
public class string {

    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char ch[]){
        str = "test ok";
        ch[0] = 'b';
    }

    public void test(){
        change(str, ch);
        System.out.println("s.str: " + str);
        System.out.println("s.ch: " + new String(ch));
    }

    public static void main(String[] arg){
        string s = new string();
        s.test();


    }
}
