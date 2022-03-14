package advance;




/*
    String:
        1. 代表不可变的字符序列
        2. 所有字符串字面值都作为此类的实例实现
        3. String对象的字符内容存储在一个字符数组value[]中

    StringBuffer
        1. 可变的字符序列，对字符内容进行增删，不会产生新的对象
        2. 其对象必须使用构造器生成
 */
public class string {

    public void test(){
        String s = "hello|world|java";
        String[] strs = s.split("\\|");
        for(int i = 0; i < strs.length; ++i){
            System.out.println(strs[i]);
        }
    }

    public void transform(){
    //字符串数字的转换
        int i500 = Integer.parseInt("500");
        String s500 = String.valueOf(500);
    //字符数组和字符串之间的转换
        char[] ch = {'t', 'e', 's', 't'};
        String sch = new String(ch);
        char[] chs = sch.toCharArray();
    }

    public void stringbuffer() {
        String s = new String("我喜欢学习");
        StringBuffer sb = new StringBuffer(s);
        sb.append(100);
        System.out.println("==>1: " + sb.toString());
        sb.insert(0, 100);
        System.out.println("==>2: " +sb.toString());

    }
    public static void main(String[] arg){

        string s = new string();
        s.stringbuffer();

    }
}
