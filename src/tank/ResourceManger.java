package tank;

import demo.Image;
import tank.skinAbstractFactory.BadTankSkinFactory;
import tank.skinAbstractFactory.GoodTankSkinFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ResourceManger {

    //主战坦克上下左右
    public static BufferedImage goodTankL, goodTankR, goodTankU, goodTankD;
    //敌方坦克上下左右
    public static BufferedImage badTankL, badTankR, badTankU, badTankD;
    //好子弹上下左右
    public static BufferedImage goodBulletL,goodBulletR,goodBulletU,goodBulletD;
    //坏子弹上下左右
    public static BufferedImage badBulletL,badBulletR,badBulletU,badBulletD;
    //爆炸特效
//    public static BufferedImage[] goodExplodes = new BufferedImage[16];
    public static BufferedImage[] goodExplodes;
    public static BufferedImage[] badExplodes;

    //ResourceManger.CLASS加载到内存时，静态语句块将会被执行
    static {
        try {

//            goodTankU = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankU = ImageIO.read(GoodTankSkinFactory.getInstance().createTank());
            goodTankR = ImageUtil.rotateImage(goodTankU, 90);
            goodTankD = ImageUtil.rotateImage(goodTankU, 180);
            goodTankL = ImageUtil.rotateImage(goodTankU, -90);

            badTankU = ImageIO.read(BadTankSkinFactory.getInstance().createTank());
            badTankR = ImageUtil.rotateImage(badTankU, 90);
            badTankD = ImageUtil.rotateImage(badTankU, 180);
            badTankL = ImageUtil.rotateImage(badTankU, -90);

            goodBulletU = ImageIO.read(GoodTankSkinFactory.getInstance().createBullet());
            goodBulletR = ImageUtil.rotateImage(goodBulletU, 90);
            goodBulletD = ImageUtil.rotateImage(goodBulletU, 180);
            goodBulletL = ImageUtil.rotateImage(goodBulletU, -90);

            badBulletU = ImageIO.read(BadTankSkinFactory.getInstance().createBullet());
            badBulletR = ImageUtil.rotateImage(badBulletU, 90);
            badBulletD = ImageUtil.rotateImage(badBulletU, 180);
            badBulletL = ImageUtil.rotateImage(badBulletU, -90);

            InputStream[] explodes = GoodTankSkinFactory.getInstance().createExplodes();
            goodExplodes = new BufferedImage[explodes.length];
            for (int i=0; i<explodes.length; i++) {
                goodExplodes[i] = ImageIO.read(explodes[i]);
            }


            InputStream[] explodes1 = BadTankSkinFactory.getInstance().createExplodes();
            badExplodes = new BufferedImage[explodes1.length];
            for (int i=0; i<explodes1.length; i++) {
                badExplodes[i] = ImageIO.read(explodes1[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
