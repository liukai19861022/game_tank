package abstractfactory.fc;

import abstractfactory.*;
import abstractfactory.first.Bullet1Skin;

public class Player1TankSkinFactory extends SkinAbstractFactory {

    private Player1TankSkinFactory() {}

    private static final Player1TankSkinFactory INSTANCE = new Player1TankSkinFactory();
    private static final TankSkin TANKINSTANCE = new SmallYellowTankSkin();
    private static final BulletSkin BULLETINSTANCE = new SmallBulletSkin();
    private static final ExplodeSkin EXPINSTANCE = new ExpSkin();

    public static Player1TankSkinFactory getInstance() {
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