package person.kim.regexandgame.regex;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
	public static void main(String[] args) {
        String[] arr= {"oocl","香港","ita"};
        String str="DBHIJFCIEOOCLDHHUIFS香港ndxifshitaooclsduhfiojfcoidITAFCHDNKItaoocloocl";
        findWorld(arr,str);
    }
    public static void findWorld(String[] arr,String world) {
        int count=0;//保存次数
        StringBuilder index=new StringBuilder(); //保存出现的位置
//        保存结果集合
        Map<String, ObjFun> map=new HashMap<String, ObjFun>();
        for (int i = 0; i < arr.length; i++) {
            count=0;
            index=new StringBuilder();//清空字符串
            Pattern pattern=Pattern.compile(arr[i],Pattern.CASE_INSENSITIVE);
            Matcher matcher=pattern.matcher(world);
//            找到并且保存次数和位置
            while(matcher.find()) {
                count++;
                index.append(matcher.start()+"-"+matcher.end()+" ");
            }
            ObjFun obj=new ObjFun(count,index);
            map.put(arr[i],obj);
        }
//        循环输出结果
        for(String key:map.keySet()) {
            System.out.println(key+"\t\t"+"出现的次数："+map.get(key).count+"\t\t"+"出现的位置："+map.get(key).pos+"\n");
        }
    }
}
//构造对象的类
class ObjFun{
    public int count=0;
    public StringBuilder pos;
    ObjFun(int count,StringBuilder pos){
        this.count=count;
        this.pos=pos;
    }
}

