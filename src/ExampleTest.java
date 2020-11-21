import datamodel.PlantData;
import exception.NonDataException;
import network.SearchPlant;

public class ExampleTest {
    public static void main(String[] args) {
        SearchPlant searchPlant = new SearchPlant("迷迭香");
        try {
            PlantData plantData = searchPlant.getData();
            DataOperation.WriteData(plantData);
        }catch (NonDataException e){
            System.out.println("当前关键字无法找到结果");
        }
    }
}


