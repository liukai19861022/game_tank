package tank.skinAbstractFactory;

import java.io.InputStream;

public abstract class SkinAbstractFactory {

    abstract InputStream createTank();
    abstract InputStream createBullet();
    abstract InputStream[] createExplodes();
}
