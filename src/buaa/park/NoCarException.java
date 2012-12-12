package buaa.park;

/**
 * Created by IntelliJ IDEA.
 * User: guozheng
 * Date: 12-12-3
 * Time: 下午8:08
 * To change this template use File | Settings | File Templates.
 */
public class NoCarException  extends RuntimeException{
    public NoCarException(){

    }
    public NoCarException(String message)  {
        super(message);
    }
}
