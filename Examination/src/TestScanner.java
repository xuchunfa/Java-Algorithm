import java.util.Scanner;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2019-04-05 13:02
 **/
public class TestScanner {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //int a = in.nextInt();//后面如果接的String话则需要吸收换行符
        //System.out.println(a);
        //in.nextLine();
        //String b = in.nextLine();
        //System.out.println(b);
        //while (in.hasNextLine()){
        //    String line = in.nextLine();
        //    if(line.isEmpty()){//换车行直接结束
        //        break;
        //    }
        //    System.out.println(line);
        //}

        //输入"adacs"直接结束因为in.hasNextInt()为false
        while (in.hasNextInt()){
            int line = in.nextInt();
            System.out.println(line);
            in.nextLine();//读取nextInt()后的换行符
            String str = in.nextLine();
            System.out.println(str);
        }
        System.out.println("over");
    }
}
