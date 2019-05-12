import java.util.*;

/**
 * @description: 华为笔试
 * @author: Xu chunfa
 * @create: 2019-04-03 18:57
 **/
public class HuaweiTest1 {

    public static void main(String[] args) {
        List<ArrayList<Integer>> allList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int defaultLen = in.nextInt();
        System.out.println("defaultLen="+defaultLen);
        String space = in.nextLine();//去除空行
        StringBuffer sb = new StringBuffer();
        LinkedList<LinkedList> allLink = new LinkedList<>();

        //怎么结束Scanner输入
        while (in.hasNextLine()){
            String str = in.nextLine();
            if(str.isEmpty()){//换行结束
                break;
            }
            System.out.println(str);
            LinkedList<String> link = new LinkedList<>();
            String[] strs = str.split(",");
            for(String s : strs){
                link.offer(s);
            }
            allLink.offer(link);
            //if(link.size() >= defaultLen){
            //    for (int i = 0;i < defaultLen;i++){
            //        sb.append(link.poll()+",");
            //    }
            //}else {
            //    for(int i = 0;i < link.size();i++){
            //        sb.append(link.poll()+",");
            //    }
            //}
            ////
            //if(!link.isEmpty()){
            //    allLink.offer(link);
            //}
        }

        while (!allLink.isEmpty()){
            LinkedList<String> link = allLink.poll();
            if(link.size() >= defaultLen){
                for (int i = 0;i < defaultLen;i++){
                    sb.append(link.poll()+",");
                }
            }else {
                int size = link.size();
                for(int i = 0;i < size;i++){
                    sb.append(link.poll()+",");
                }
            }
            if(!link.isEmpty()){
                allLink.offer(link);
            }
        }

        String result = sb.toString();
        if(result.length() > 0){
            System.out.println(result.substring(0,result.length()-1));
        }
        System.out.println("over");
    }
}
