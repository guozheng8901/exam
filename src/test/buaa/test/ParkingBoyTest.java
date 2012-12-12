package test.buaa.test;

import buaa.park.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: guozheng
 * Date: 12-12-5
 * Time: 上午9:41
 * To change this template use File | Settings | File Templates.
 */
public class ParkingBoyTest {
    @Test
    public void ParkBoy_ShouldParkCar(){
        Car car =new Car();
        int  maxParkingNum=20;
        ParkPlace parkPlace=new ParkPlace(maxParkingNum);
        ArrayList<ParkPlace> parkPlaces=new ArrayList<ParkPlace>();
        parkPlaces.add(parkPlace);
        ParkingBoy parkingBoy=new ParkingBoy(parkPlaces,new FirstAvailableParkingLotChooser());
        try {
            Ticket ticket=parkingBoy.park(car);
        } catch (ParkFullExceprion parkFullExceprion) {
            parkFullExceprion.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        Assert.assertEquals(new Integer(maxParkingNum-1),parkingBoy.getAvailableNum());


    }
    @Test
    public void parkBoy_ShouldfetchCar() throws ParkFullExceprion {
        Car car = new Car();
        int maxParkingNum = 20;
        ParkPlace parkPlace = new ParkPlace(maxParkingNum);
        ArrayList<ParkPlace> parkPlaces = new ArrayList<ParkPlace>();
        parkPlaces.add(parkPlace);
        ParkingBoy parkingBoy = new ParkingBoy(parkPlaces, new FirstAvailableParkingLotChooser());
        Ticket
            ticket = parkingBoy.park(car);

        Assert.assertEquals(car, parkingBoy.fetch(ticket));


    }
}
