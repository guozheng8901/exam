package test.buaa.test;

import buaa.park.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: guozheng
 * Date: 12-12-5
 * Time: 上午10:06
 * To change this template use File | Settings | File Templates.
 */
public class ParkingBoyTest_WhenHavingSeveralPakingPlace {
    private  Integer totalAmount;
    private ParkingBoy parkingBoy;
    private List<ParkPlace> parkPlaces;

    @Before
    public void init(){
        List<ParkPlace> parkPlaces=new ArrayList<ParkPlace>();
        Integer[] parkPlaceNums=new Integer[]{10,20};
        totalAmount=0;
        for(Integer parkNum:parkPlaceNums){
            parkPlaces.add(new ParkPlace(parkNum));
            totalAmount+=parkNum;
        }
       parkingBoy=new ParkingBoy(parkPlaces,new MaxAvailableParkingLotChooser()) ;
        this.parkPlaces=parkPlaces;
    }
    @Test
    public void should_park_sucess_when_park_is_empty() throws ParkFullExceprion {
        parkingBoy.park(new Car());
        Assert.assertEquals(new Integer(totalAmount-1),parkingBoy.getAvailableNum());

    }
    @Test(expected = buaa.park.NoCarException.class)
    public void should_fetch_sucess_when_park_is_empty(){
        parkingBoy.fetch(new Ticket());

    }

    @Test
    public void should_fetch_sucess_when_park_is_notempty() throws ParkFullExceprion {
        for(int i=0;i<totalAmount/2;i++){
            parkingBoy.park(new Car());
        }
        Car car =new Car();
        Ticket ticket=parkingBoy.park(car);
        Assert.assertEquals(car,parkingBoy.fetch(ticket));
    }

    @Test(expected = buaa.park.ParkFullExceprion.class)
    public void should_throwException_if_park_when_park_is_full() throws ParkFullExceprion {
        for(int i=0;i<totalAmount;i++){
            parkingBoy.park(new Car());
        }
        parkingBoy.park(new Car());

    }

    @Test
    public void should_park_in_the_more_empty_parkplace() throws ParkFullExceprion {
        parkingBoy.park(new Car());
        Assert.assertEquals(19,parkPlaces.get(1).getAvailableNum());

    }
    @Test
    public void should_park_in_the_first_parkplace_if_park_availableSize_same() throws ParkFullExceprion {
        for(int i=0;i<10;i++){
            parkingBoy.park(new Car());
        }
        parkingBoy.park(new Car());
        Assert.assertEquals(9,parkPlaces.get(0).getAvailableNum());
    }


}
