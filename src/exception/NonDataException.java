package exception;

public class NonDataException extends Exception{
    public NonDataException(){
        super("未找到相关数据，请尝试更换关键字！");
    }
}
