package abstractfactory.fc;

import abstractfactory.BulletSkin;
import abstractfactory.ExplodeSkin;
import abstractfactory.SkinAbstractFactory;
import abstractfactory.TankSkin;

public class ComRedSuperBigTankSkinFactory extends SkinAbstractFactory {

    public ComRedSuperBigTankSkinFactory() {}

    private static final ComRedSuperBigTankSkinFactory INSTANCE = new ComRedSuperBigTankSkinFactory();
    private static final TankSkin TANKINSTANCE = new SuperBigRedTankSkin();
    private static final BulletSkin BULLETINSTANCE = new SmallBulletSkin();
    private static final ExplodeSkin EXPINSTANCE = new ExpSkin();

    public static ComRedSuperBigTankSkinFactory getInstance() {
        return INSTANCE;
    }

    public TankSkin createTank() {

        return TANKINSTANCE;
    }

    public BulletSkin createBullet() {

        return BULLETINSTANCE;
    }

    public ExplodeSkin createExplodes() {

        return EXPINSTANCE;
    }
}
