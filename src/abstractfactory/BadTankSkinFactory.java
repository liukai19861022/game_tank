package abstractfactory;

public class BadTankSkinFactory extends SkinAbstractFactory {

    private BadTankSkinFactory() {}

    private static final BadTankSkinFactory INSTANCE = new BadTankSkinFactory();
    private static final TankSkin TANKINSTANCE = new RedTankSkin();
    private static final BulletSkin BULLETINSTANCE = new Bullet1Skin();
    private static final ExplodeSkin EXPINSTANCE = new Explode1Skin();

    public static BadTankSkinFactory getInstance() {
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
