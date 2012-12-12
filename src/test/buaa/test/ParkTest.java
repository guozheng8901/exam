package test.buaa.test;

import buaa.park.Car;
import buaa.park.ParkFullExceprion;
import buaa.park.ParkPlace;
import buaa.park.Ticket;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: guozheng
 * Date: 12-12-3
 * Time: 下午9:26
 * To change this template use File | Settings | File Templates.
 */
public class ParkTest {
    private ParkPlace park;
    @Before
    public void init(){
        park=new ParkPlace(50);
    }
    @Test
    public void should_carplaceNum_Minus_1_if_have_empty_Carplace_when_park(){
        park.parkCar(new Car());
        Assert.assertEquals(49,park.getAvailableNum());
    }
    @Test(expected = ParkFullExceprion.class)
    public void should_throw_ParkFullException_if_park_full_when_park(){
        for(int i=0;i<=50;i++){
            park.parkCar(new Car()) ;
        }
    }
    @Test
    public void should_get_ticket_if_park_success_when_park (){
        Ticket ticket=park.parkCar(new Car());
        Assert.assertNotNull(ticket);
    }
    @Test
    public void should_fetchSuccess_and_carplaceNum_add_1_if_have_fetched_this_car(){
        park.parkCar(new Car());
        park.parkCar(new Car());
        Ticket ticket=park.parkCar(new Car());
        Car c=park.fetchCar(ticket);
        Assert.assertEquals(park.getAvailableNum(),48);

    }
    @Test
    public void should_fetch_the_correct_car_if_ticket_correct_when_fetch(){
        Car mycar=new Car();
        Ticket ticket=park.parkCar(mycar);
        Car fetchedCar=park.fetchCar(ticket);
        Assert.assertSame(mycar,fetchedCar);
    }
}