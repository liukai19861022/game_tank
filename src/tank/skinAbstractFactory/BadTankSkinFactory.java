package tank.skinAbstractFactory;

import java.io.InputStream;

public class BadTankSkinFactory extends SkinAbstractFactory {

    private BadTankSkinFactory() {}

    private static final BadTankSkinFactory INSTANCE = new BadTankSkinFactory();
    private static final TankSkin TANKINSTANCE = new RedTankSkin();
    private static final BulletSkin BULLETINSTANCE = new Bullet1Skin();
    private static final ExplodeSkin EXPINSTANCE = new Explode1Skin();

    public static BadTankSkinFactory getInstance() {
        return INSTANCE;
    }

    public InputStream createTank() {

        return TANKINSTANCE.getSkin();
    }

    public InputStream createBullet() {

        return BULLETINSTANCE.getSkin();
    }

    public InputStream[] createExplodes() {

        return EXPINSTANCE.getSkins();
    }

}
