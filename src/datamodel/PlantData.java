package datamodel;

import java.util.ArrayList;
import java.util.List;

public class PlantData {
    public String name;
    public String latinName;
    public String id;
    public String img_url;
    public List<DetailData> descList;
    
    public PlantData() {
        name = "";
        latinName = "";
        id = "";
        descList = new ArrayList<>();
    }

}
