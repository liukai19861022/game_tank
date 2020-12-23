package observer;

import fireStrategy.TwoDirFireStrategy;
import tank.Tank;

public class TankFireHandle implements TankFireObserver {

    @Override
    public void actionOnFire(TankFireEvent e) {
        Tank t = e.getSource();
        t.fire(TwoDirFireStrategy.getInstance());

    }
}
