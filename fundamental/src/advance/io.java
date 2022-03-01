package advance;

import javax.imageio.IIOException;
import javax.xml.crypto.Data;
import java.io.*;

/**
 * @author shkstart
 * @create 2022-03-01 9:18
 */

/*
    File:  文件和文件目录的抽象表示形式，与平台无关
        1. 能新建、删除、重命名文件和目录，单不能访问文件内容本身
        2. 可以获取文件或目录的一些相关属性
        3. 属性的判断功能
        4. File对象可以作为参数传递给流的构造器
 */
class fileTest{
    //File.separator: 根据操作系统，动态的提供分隔符号，增加可移植性
    private final String path = "D:" + File.separator + "ownProject" + File.separator + "java" + File.separator + "test";

    public void createFileDirectory(){
        //字符串指定路径
        File dir1 = new File(path + File.separator + "dir1");
        if(!dir1.exists()){
            dir1.mkdir();
        }

        //用File对象指定父目录
        File dir2 = new File(dir1, "dir2");
        if(!dir2.exists()){
            dir2.mkdir();     //上层文件目录不存在，或者此目录存在则不创建
        }

        File dir4 = new File(dir1, "dir3/dir4");
        if(!dir4.exists()){
            dir4.mkdirs();    //如果上层文件目录不存在，一并创建
        }

        File file = new File(dir2, "test.txt");
        if(!file.exists()){
            try{
                file.createNewFile();   //创建文件，如果文件存在则不创建
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    /*
        没有真实的文件或目录对应时，除了指定的目录和路径外，其它属性都取成员变量的默认值
     */
    public void getFileProperty(){
        File file = new File(path + File.separator + "dir1" + File.separator + "dir2" + File.separator + "test.txt");
        if(file.exists() & file.isFile()){
            System.out.println("file.getAbsolutePath(): " + file.getAbsolutePath());
            System.out.println("file.getPath(): " + file.getPath());
            System.out.println("file.getName(): " + file.getName());
            System.out.println("file.getParent(): " + file.getParent());
            System.out.println("file.length(): " + file.length());
            System.out.println("file.lastModified(): " + file.lastModified());
        }

        System.out.println("--------------------------");
        File fileNotExist = new File(path + File.separator + "dir1" + File.separator + "dir2" + File.separator + "noExist.txt");
        System.out.println("fileNotExist.getAbsolutePath(): " + fileNotExist.getAbsolutePath());
        System.out.println("fileNotExist.getPath(): " + fileNotExist.getPath());
        System.out.println("fileNotExist.getName(): " + fileNotExist.getName());
        System.out.println("fileNotExist.getParent(): " + fileNotExist.getParent());
        System.out.println("fileNotExist.length(): " + fileNotExist.length());
        System.out.println("fileNotExist.lastModified(): " + fileNotExist.lastModified());
    }
}


class iotest{
    private final String path = "D:" + File.separator + "ownProject" + File.separator + "java" + File.separator + "test";
    private final File source = new File(path + File.separator + "source.txt");
    private final File dest = new File(path + File.separator + "destination.txt");

    public void filereader(){
        FileReader fr = null;
        try{
            fr = new FileReader(source);
            char[] buf = new char[5];
            int len;
            while((len = fr.read(buf)) != -1){
                System.out.println(new String(buf, 0, len));
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(fr != null){
                try{
                    fr.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        CharArrayReader: 数据的来源为指定的数组
     */
    public void arrayStream(){
        String str = "abcdehello";
        char[] readBuffer = str.toCharArray();
        char[] buffer = new char[1024];
        CharArrayReader car = new CharArrayReader(readBuffer);

        int len;
        try{
            while((len = car.read(buffer, 0, 5)) != -1){
                System.out.println("len: " + len);
                System.out.println("buffer: " + String.valueOf(buffer, 0, len));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        car.close();
    }


    /*
        在使用这些流类时，会创建一个内部缓冲区数组，缺省使用8kb的缓冲区
        读取时先将数据读取到缓冲区，写入时先将数据写入到缓冲区
        flush()可以强制将缓冲区的内容全部写入输出流
        关闭最外层的流也会相应关闭内层节点流
     */
    public void bufferedStream(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            br = new BufferedReader(new FileReader(source));
            bw = new BufferedWriter(new FileWriter(dest));
            String str;
            while((str = br.readLine()) != null){   //读取时读取并抛弃换行符
                bw.write(str);
                bw.newLine();
            }
            bw.flush();
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(br != null)  br.close();;
                if(bw != null)  bw.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    /*
        转换流：
            1. 将输入的字节流转换为字符流
            2. 将输出字符流转换为字节流
            3. 可以指定字符集。
     */
    public void transStream(){
        try{
            //输入字节流
            FileInputStream fis = new FileInputStream(source);
            //输出字节流
            FileOutputStream fos = new FileOutputStream(dest);

            //输入字符流
            InputStreamReader isr = new InputStreamReader(fis, "GBK");   //按GBK字符集将字节转换为字符
            //输出字符流
            OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK"); //按GBK字符集将字符转换为字节

            //缓冲流
            BufferedReader br = new BufferedReader(isr);
            BufferedWriter bw = new BufferedWriter(osw);

            String str = null;
            while((str = br.readLine()) != null){
                bw.write(str);
                bw.newLine();
            }
            bw.flush();

            br.close();
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /*
        System.in的类型是InputStream
        System.out的类型是PrintStream, 是OutputStream的子类FilterOutputStream的子类
     */
    public void stdin(){
        //将System.in这个字节流转换为字符流，再包装为缓冲流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try{
            while((s = br.readLine()) != null){
                if("exit".equalsIgnoreCase(s)){
                    System.out.println("安全退出");
                    break;
                }
                System.out.println("===>: " + s.toUpperCase());
                System.out.println("请继续输入信息");
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try{
                br.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public void stdout(){
        PrintStream ps = null;
        try{
            FileOutputStream fos = new FileOutputStream(source);
            //创建打印流，设置为自动刷新模式
            ps = new PrintStream(fos, true);
            System.setOut(ps);  //将标准输出流改为文件
            for(int i = 0; i <= 255; i++){
                System.out.print(i);
                if(i % 10 == 0){
                    System.out.println();
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            ps.close();
        }
    }


    /*
        数据流：用于读取和写出基本数据类型，String类的数据
     */
    public void dataTypestream(){
        DataOutputStream dos = null;
        try{
            dos = new DataOutputStream(new FileOutputStream(source));
            dos.writeUTF("北京天安门");
            dos.writeBoolean(false);
            dos.writeLong(123456789L);
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try{
                dos.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        DataInputStream dis = null;
        try{
            dis = new DataInputStream(new FileInputStream(source));
            String info = dis.readUTF();
            boolean flag = dis.readBoolean();
            long value = dis.readLong();
            System.out.println("info: " + info);
            System.out.println("flag: " + flag);
            System.out.println("value: " + value);

        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try{
                dis.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    /*
        RandomAccessFile声明在java.io包下，但是直接继承于java.lang.Object类。
        支持随机访问，程序可以跳到文件的任意地方来读、写文件
     */
    public void randomAccessFile(){
        try{
            RandomAccessFile raf = new RandomAccessFile(source, "rw");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[5];
            byte[] outbuf = new byte[1024];
            int size = 0, readlen;
            while((readlen = raf.read(buffer)) != -1){
                System.out.println("len: " + readlen);
                size += readlen;
                baos.write(outbuf, 0, readlen);
            }
            System.out.println("final: " + new String(outbuf, 0, size));

        }catch(IOException e){
            e.printStackTrace();
        }


    }


}


public class io {
    public static void main(String[] arg){
        iotest ft = new iotest();
        ft.randomAccessFile();
    }
}




