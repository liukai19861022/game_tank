package tank;

import tank.Tank;
import tank.TankFrame;

public interface FireStrategy {
    void fire(TankFrame tf, Tank tank);
}
