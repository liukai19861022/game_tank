package tank.skinAbstractFactory;

import java.io.InputStream;

public abstract class SkinAbstractFactory {

    abstract TankSkin createTank();
    abstract BulletSkin createBullet();
    abstract ExplodeSkin createExplodes();
}
