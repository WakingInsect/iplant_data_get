package datamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常量类.
 * 包含一些程序中常用的常量数据.
 */
public class Constant {
    /*
    中国植物志百科地址，用于URL的拼接。
     */
    public final static String baseUrl = "http://www.iplant.cn/";

    /*
    获取表单参数，根据不同的tid来获取相应的特征数据。
     */
    public final static Map<String,String> form = new HashMap<>(){{
        put("1","0");
        put("21","9");
        put("11","18");
        put("12","7");
        put("20","4");
        put("42","6");
        put("48","0");
    }};

    /*
    迭代获取所有数据。
     */
    public final static List<String> typeList = new ArrayList<>(){{
        add("1");
        add("21");
        add("11");
        add("12");
        add("20");
        add("42");
        add("48");
    }};

    public final static Map<String,String> header = new HashMap<>(){{
        put("Connection","keep-alive");
        put("Accept-Language","zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6,no;q=0.5");
        put("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36 Edg/86.0.622.69");
        put("Accept","application/json, text/javascript, */*; q=0.01");
        put("X-Requested-With","XMLHttpRequest");
    }};

}
