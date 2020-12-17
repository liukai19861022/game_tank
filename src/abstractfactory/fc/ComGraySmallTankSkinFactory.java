package abstractfactory.fc;

import abstractfactory.BulletSkin;
import abstractfactory.ExplodeSkin;
import abstractfactory.SkinAbstractFactory;
import abstractfactory.TankSkin;
import abstractfactory.first.GreenTankSkin;

public class ComGraySmallTankSkinFactory extends SkinAbstractFactory {

    public ComGraySmallTankSkinFactory() {}

    private static final ComGraySmallTankSkinFactory INSTANCE = new ComGraySmallTankSkinFactory();
    private static final TankSkin TANKINSTANCE = new SmallGrayTankSkin();


    private static final BulletSkin BULLETINSTANCE = new SmallBulletSkin();
    private static final ExplodeSkin EXPINSTANCE = new ExpSkin();

    public static ComGraySmallTankSkinFactory getInstance() {
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