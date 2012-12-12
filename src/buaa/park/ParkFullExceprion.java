package buaa.park;

/**
 * Created by IntelliJ IDEA.
 * User: guozheng
 * Date: 12-12-3
 * Time: 下午7:44
 * To change this template use File | Settings | File Templates.
 */
public class ParkFullExceprion extends Throwable {
    public ParkFullExceprion(){

    }
    public ParkFullExceprion(String message) {
        super(message);
    }
}
