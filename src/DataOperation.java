import datamodel.DetailData;
import datamodel.PlantData;

import java.io.FileWriter;
import java.io.IOException;

/*
对植物的数据进行操作，写入json文件.
 */
public class DataOperation {
    /**
     * 将数据写入文件.
     * @param plantData 保存植物数据的类.
     */
    public static void WriteData(PlantData plantData){
        try {
            FileWriter writer = new FileWriter(plantData.name+".json");
            writer.write("{\n");
            writer.write(formatWrite("name",plantData.name));
            writer.write(formatWrite("latinName", plantData.latinName));
            writer.write("\t\"desc\":[\n");
            for(int x = 0;x < plantData.descList.size();x++){
                DetailData data = plantData.descList.get(x);
                writer.write(data.toString());
                if(x == plantData.descList.size()-1){
                    writer.write("\n");
                    break;
                }
                writer.write(",\n");
            }
            writer.write("\t]\n");
            writer.write("}");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 格式化写入json文件.
     * @param type 目标属性的名称.
     * @param value 目标属性的值.
     * @return 格式化的字符串.
     */
    private static String formatWrite(String type,String value){
        return "\t\""+ type +"\":\""+value+"\",\n";
    }
}
