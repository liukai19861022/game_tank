package abstractfactory.first;

import abstractfactory.BulletSkin;
import abstractfactory.ExplodeSkin;
import abstractfactory.SkinAbstractFactory;
import abstractfactory.TankSkin;

public class GoodTankSkinFactory extends SkinAbstractFactory {

    private GoodTankSkinFactory() {}

    private static final GoodTankSkinFactory INSTANCE = new GoodTankSkinFactory();
    private static final TankSkin TANKINSTANCE = new GreenTankSkin();
    private static final BulletSkin BULLETINSTANCE = new Bullet1Skin();
    private static final ExplodeSkin EXPINSTANCE = new Explode1Skin();

    public static GoodTankSkinFactory getInstance() {
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
