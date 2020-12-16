package abstractfactory.fc;

import abstractfactory.BulletSkin;
import abstractfactory.ExplodeSkin;
import abstractfactory.SkinAbstractFactory;
import abstractfactory.TankSkin;

public class ComRedSmallTankSkinFactory extends SkinAbstractFactory {

    public ComRedSmallTankSkinFactory() {}

    private static final ComRedSmallTankSkinFactory INSTANCE = new ComRedSmallTankSkinFactory();
    private static final TankSkin TANKINSTANCE = new SmallRedTankSkin();
    private static final BulletSkin BULLETINSTANCE = new SmallBulletSkin();
    private static final ExplodeSkin EXPINSTANCE = new ExpSkin();

    public static ComRedSmallTankSkinFactory getInstance() {
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
