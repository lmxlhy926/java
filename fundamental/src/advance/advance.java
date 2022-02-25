package advance;

/**
 * @author shkstart
 * @create 2022-02-24 17:12
 */
public class advance {
    public static void main(String[] args){
        String[] str = new String[5];
        for(String mystr : str){
            mystr = "atguigu";
        }
        for(int i = 0; i < str.length; ++i){
            System.out.println(str[i]);
        }

    }


}
