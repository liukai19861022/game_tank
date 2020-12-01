package abstractfactory;

public class GoodTankSkinFactory extends SkinAbstractFactory {

    private GoodTankSkinFactory() {}

    private static final GoodTankSkinFactory INSTANCE = new GoodTankSkinFactory();
    private static final TankSkin TANKINSTANCE = new SmallSliverTankSkin();
    private static final BulletSkin BULLETINSTANCE = new Bullet2Skin();
    private static final ExplodeSkin EXPINSTANCE = new Explode2Skin();

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
