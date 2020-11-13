package tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceManger {

    //主战坦克上下左右
    public static BufferedImage goodTankL, goodTankR, goodTankU, goodTankD;
    //敌方坦克上下左右
    public static BufferedImage badTankL, badTankR, badTankU, badTankD;
    //子弹上下左右
    public static BufferedImage bulletL,bulletR,bulletU,bulletD;
    //爆炸特效
    public static BufferedImage[] explodes = new BufferedImage[16];

    //ResourceManger.CLASS加载到内存时，静态语句块将会被执行
    static {
        try {
            goodTankU = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankR = ImageUtil.rotateImage(goodTankU, 90);
            goodTankD = ImageUtil.rotateImage(goodTankU, 180);
            goodTankL = ImageUtil.rotateImage(goodTankU, -90);

            badTankU = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankR = ImageUtil.rotateImage(badTankU, 90);
            badTankD = ImageUtil.rotateImage(badTankU, 180);
            badTankL = ImageUtil.rotateImage(badTankU, -90);

            bulletU = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletR = ImageUtil.rotateImage(bulletU, 90);
            bulletD = ImageUtil.rotateImage(bulletU, 180);
            bulletL = ImageUtil.rotateImage(bulletU, -90);

            for (int i=0; i<16; i++) {
                explodes[i] = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
