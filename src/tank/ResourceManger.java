package tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceManger {

    //坦克上下左右
    public static BufferedImage tankL,tankR,tankU,tankD;
    //子弹上下左右
    public static BufferedImage bulletL,bulletR,bulletU,bulletD;

    //ResourceManger.CLASS加载到内存时，静态语句块将会被执行
    static {
        try {
            tankU = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankD = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            tankL = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankR = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/tankR.gif"));

            bulletL = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletR = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletU = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletD = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
