package buaa.park.origin;

import buaa.park.ParkPlace;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: guozheng
 * Date: 12-12-3
 * Time: 下午8:55
 * To change this template use File | Settings | File Templates.
 */
public interface ParkStrategy {
    ParkPlace getAvailablePark(Collection<ParkPlace> parks);
}
