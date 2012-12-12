package buaa.park;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: guozheng
 * Date: 12-12-3
 * Time: 下午7:46
 * To change this template use File | Settings | File Templates.
 */
//更多选择的接口
public interface ParkingLotChooser {
    ParkPlace getAvailablePark(List<ParkPlace> parkPlaceList) throws ParkFullExceprion;
}
