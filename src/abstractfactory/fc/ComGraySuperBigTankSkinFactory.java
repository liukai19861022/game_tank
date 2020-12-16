package abstractfactory.fc;

import abstractfactory.BulletSkin;
import abstractfactory.ExplodeSkin;
import abstractfactory.SkinAbstractFactory;
import abstractfactory.TankSkin;

public class ComGraySuperBigTankSkinFactory extends SkinAbstractFactory {

    public ComGraySuperBigTankSkinFactory() {}

    private static final ComGraySuperBigTankSkinFactory INSTANCE = new ComGraySuperBigTankSkinFactory();
    private static final TankSkin TANKINSTANCE = new SuperBigGrayTankSkin();
    private static final BulletSkin BULLETINSTANCE = new SmallBulletSkin();
    private static final ExplodeSkin EXPINSTANCE = new ExpSkin();

    public static ComGraySuperBigTankSkinFactory getInstance() {
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