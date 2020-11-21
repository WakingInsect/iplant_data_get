package datamodel;

public class DetailData {
    public boolean hasdesc;
    public String t;
    public int tid;
    public String desc;
    public String spdescid;

    @Override
    public String toString() {
        return "\t\t{\n" +
                "\t\t\t\"hasdesc\":" + "\""+hasdesc + "\",\n"+
                "\t\t\t\"t\":" + "\""+t + "\",\n"+
                "\t\t\t\"tid\":" + "\""+tid + "\",\n"+
                "\t\t\t\"desc\":" + "\""+desc + "\",\n"+
                "\t\t\t\"spdescid\":" + "\""+spdescid + "\"\n"+
                "\t\t}";
    }
}

