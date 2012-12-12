package buaa.park;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: guozheng
 * Date: 12-12-3
 * Time: 下午7:49
 * To change this template use File | Settings | File Templates.
 */
//获得停车位数
public class FirstAvailableParkingLotChooser implements ParkingLotChooser {
    public ParkPlace getAvailablePark(List<ParkPlace> parkPlaceList) throws ParkFullExceprion {
        for(ParkPlace parkPlace:parkPlaceList){
            if(parkPlace.getAvailableNum()>0)
                return parkPlace;
        }
        throw new ParkFullExceprion("所有的停车场都已满"); //To change body of implemented methods use File | Settings | File Templates.
    }
}
