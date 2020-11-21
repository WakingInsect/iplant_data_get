package network;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import datamodel.Constant;
import datamodel.DetailData;
import datamodel.PlantData;
import exception.NonDataException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 搜索植物数据.
 */
public class SearchPlant {

    // 用于搜索的关键字
    String name;

    /**
     * 获取植物特征数据的ID.
     * @return 中国植物志网站中该植物的ID.
     */
    private  String getId(PlantData plantData) throws NonDataException{
        try{
            Document document = Jsoup.connect(Constant.baseUrl+"info/"+name).get();
            // 获取植物的名称
            plantData.name = name;
            // 获取植物的拉丁名
            plantData.latinName  = document.body().select("div[class=infolatin]").first().text();
            if(plantData.latinName==null||plantData.latinName.length()==0){
                throw new NonDataException();
            }
            plantData.img_url = document.body().select("div[class=barcodeimg]").first().selectFirst("img").attr("src");
            return plantData.img_url.substring(plantData.img_url.length()-5);
        }catch (IOException e){
            e.printStackTrace();
        }
        return "未找到ID";

    }

    /**
     * 按关键字搜索信息并返回植物数据.
     * @throws NonDataException 如果没有搜索到相关植物信息则抛出异常.
     */
    public PlantData getData() throws NonDataException{
        PlantData plantData = new PlantData();

        // 用于访问数据的表单模板
        Map<String,String> map = new HashMap<>(){{
            put("spid" ,getId(plantData));
            put("type","descjarr");
            put("typeid","1");
            put("subcount","0");
        }};

        String url = "ashx/plantinfo.ashx";

        try {

            for(String key: Constant.typeList){
                // 将模板中的数据替换
                map.replace("typeid",key);
                map.replace("subcount", Constant.form.get(key));

                // 获取连接并取得返回的数据
                Connection.Response response = Jsoup.connect(Constant.baseUrl+url)
                        .headers(Constant.header)
                        .data(map)
                        .followRedirects(true)
                        .execute();

                // 通过反射机制来讲获取到的数据转换为Java对象
                Type type = new TypeToken<ArrayList<DetailData>>(){}.getType();
                List<DetailData> detailData = (new Gson()).fromJson(response.body(),type);

                // 原数据以BASE64形式加密，将数据解密
                for (DetailData data : detailData) {
                    if(data.hasdesc){
                        data.desc = new String(Base64.getDecoder().decode(data.desc),StandardCharsets.UTF_8);
                        data.desc = data.desc.replaceAll("\n","");
                        plantData.descList.add(data);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return plantData;
    }


    /**
     * 只包含一个参数的构造方法.
     * @param name 植物名称.
     */
    public SearchPlant(String name){
        this.name = name;
    }
}
