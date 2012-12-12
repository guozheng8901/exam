package buaa.park;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: guozheng
 * Date: 12-12-3
 * Time: 下午8:16
 * To change this template use File | Settings | File Templates.
 */
public class ParkingBoy {
    protected List<ParkPlace> parkPlaces;
    protected List<ParkingBoy> parkingBoys;
    private final ParkingLotChooser parkingLotChooser;


    public ParkingBoy(List<ParkPlace> parkPlaces,ParkingLotChooser parkingLotChooser) {
        this.parkPlaces=parkPlaces;
        this.parkingLotChooser = parkingLotChooser;
    }
    public Ticket park(Car car) throws ParkFullExceprion {
      return parkingLotChooser.getAvailablePark(parkPlaces) .parkCar(car);
    }
    public Integer getAvailableNum(){
        int availableNum=0;
        for(ParkPlace parkPlace:parkPlaces){
            availableNum+=parkPlace.getAvailableNum();
        }
        return availableNum;
    }

    public Car fetch(Ticket ticket){
        Car fetchedCar =    null;
        for(ParkPlace parkPlace:parkPlaces){
            fetchedCar =parkPlace.fetchCar(ticket);
            if(fetchedCar!=null){
                return fetchedCar;
            }

        }
        throw new NoCarException("没有此车");
    }

}
