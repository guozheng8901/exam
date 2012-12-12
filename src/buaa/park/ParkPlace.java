package buaa.park;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: guozheng
 * Date: 12-12-3
 * Time: 下午7:12
 * To change this template use File | Settings | File Templates.
 */
public class ParkPlace {
    private int capacity;   //车库中能用的停车位
    private Map<Ticket ,Car> placeCarMaps=new HashMap<Ticket,Car>();
    public ParkPlace(int capacity){
        this.capacity=capacity;

    }
    public int getAvailableNum(){
        return capacity;
    }
    //停车方法，如果车库没有满，将车停进去，并且给车凭证，车库能用位数减1
    public Ticket parkCar(Car car){
        if(capacity<=0) try {
            throw new ParkFullExceprion("车库已满！！") ;
        } catch (ParkFullExceprion parkFullExceprion) {
            parkFullExceprion.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        Ticket ticket=new Ticket();
        placeCarMaps.put(ticket,car);
        capacity--;
        return ticket;
    }
    //取车方法，如果车凭证正确，那么将车开走，车库能用位数加1
    public Car fetchCar(Ticket ticket){
        Car car =placeCarMaps.get(ticket);
        if(car!=null){
            placeCarMaps.remove(ticket);
            capacity++;

        }
        return car;
    }

}
