package buaa.park;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: guozheng
 * Date: 12-12-3
 * Time: 下午7:58
 * To change this template use File | Settings | File Templates.
 */
public class MaxAvailableParkingLotChooser implements ParkingLotChooser {
    public ParkPlace getAvailablePark(List<ParkPlace> parkPlaceList) throws ParkFullExceprion {
        int maxsizeIndex=0;
        for(int i=1;i<parkPlaceList.size();i++){
            if(parkPlaceList.get(i).getAvailableNum()>parkPlaceList.get(maxsizeIndex).getAvailableNum()){
                maxsizeIndex=i;
            }
            if(parkPlaceList.get(maxsizeIndex).getAvailableNum()==0)   throw    new ParkFullExceprion("所有的停车场都满了")   ;

        }

           return parkPlaceList.get(maxsizeIndex);
    }
}
