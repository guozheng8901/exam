package buaa.park.origin;

import buaa.park.Car;
import buaa.park.NoCarException;
import buaa.park.ParkPlace;
import buaa.park.Ticket;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: guozheng
 * Date: 12-12-3
 * Time: 下午8:56
 * To change this template use File | Settings | File Templates.
 */
public class GeneralParkingBoy {
    private Collection<ParkPlace> parkPlaces;
    private ParkStrategy parkStrategy;
    public GeneralParkingBoy(Collection<ParkPlace> parkPlaces){
        this.parkPlaces=parkPlaces;
    }
    public GeneralParkingBoy(Collection<ParkPlace> parkPlaces,ParkStrategy parkStrategy){
        this.parkPlaces=parkPlaces;
        this.parkStrategy=parkStrategy;
    }
    public Ticket   park(Car car){
        return parkStrategy.getAvailablePark(parkPlaces) .parkCar(car);
    }
    public Integer getAvailableNum(){
        int availableNum=0;
        for(ParkPlace parkPlace:parkPlaces){
            availableNum+=parkPlace.getAvailableNum();
        }
        return availableNum;
    }
    public Car fetch(Ticket ticket){
        Car fetchedCar=null;
        for(ParkPlace parkPlace:parkPlaces){
            fetchedCar=parkPlace.fetchCar(ticket);
        }
        if(fetchedCar!=null){
                return fetchedCar;
            }
         throw new NoCarException("没有此车");
    }
    public ParkStrategy getParkStrategy(){
        return parkStrategy;
    }
    public void setParkStrategy(ParkStrategy parkStrategy){
        this.parkStrategy=parkStrategy;
    }

}
