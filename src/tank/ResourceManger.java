package tank;

import abstractfactory.SkinAbstractFactory;
import abstractfactory.fc.ComRedSmallTankSkinFactory;
import abstractfactory.fc.Player1TankSkinFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ResourceManger {

    //主战坦克上下左右
    public static BufferedImage[] player1TankImgs = new BufferedImage[4];
    public static BufferedImage[] player1BulImgs = new BufferedImage[4];
    public static BufferedImage[] player1Explodes, com1Explodes;

    public static BufferedImage[] com1TankImgs = new BufferedImage[4];
    public static BufferedImage[] com11BulImgs = new BufferedImage[4];
    public static List<List<BufferedImage[]>> computerTankImages = new ArrayList<List<BufferedImage[]>>();


    //ResourceManger.CLASS加载到内存时，静态语句块将会被执行
    static {
        try {

            SkinAbstractFactory skinFac = Player1TankSkinFactory.getInstance();
            player1TankImgs[0] = ImageIO.read(skinFac.createTank().getSkin());
            player1TankImgs[1] = ImageUtil.rotateImage(player1TankImgs[0], 90);
            player1TankImgs[2] = ImageUtil.rotateImage(player1TankImgs[0], 180);
            player1TankImgs[3] = ImageUtil.rotateImage(player1TankImgs[0], -90);

            player1BulImgs[0] = ImageIO.read(skinFac.createBullet().getSkin());
            player1BulImgs[1] = ImageUtil.rotateImage(player1BulImgs[0], 90);
            player1BulImgs[2] = ImageUtil.rotateImage(player1BulImgs[0], 180);
            player1BulImgs[3] = ImageUtil.rotateImage(player1BulImgs[0], -90);

            InputStream[] explodes = skinFac.createExplodes().getSkins();
            player1Explodes = new BufferedImage[explodes.length];
            for (int i=0; i<explodes.length; i++) {
                player1Explodes[i] = ImageIO.read(explodes[i]);
            }


            String computerTankSkinsString = (String) PropertyMgr.getInstance().get("computerTankSkins");
            String[] computerTankSkinsStringArray = computerTankSkinsString.split(",");
            for (int i=0; i<computerTankSkinsStringArray.length; i++) {

                SkinAbstractFactory instance = (SkinAbstractFactory) Class.forName(computerTankSkinsStringArray[i]).getDeclaredConstructor().newInstance();
                ArrayList<BufferedImage[]> bufferedImages = new ArrayList<>();

                BufferedImage[] images = new BufferedImage[4];
                images[0] = ImageIO.read(instance.createTank().getSkin());
                images[1] = ImageUtil.rotateImage(images[0], 90);
                images[2] = ImageUtil.rotateImage(images[0], 180);
                images[3] = ImageUtil.rotateImage(images[0], -90);
                bufferedImages.add(images);

                BufferedImage[] images1 = new BufferedImage[4];
                images1[0] = ImageIO.read(instance.createBullet().getSkin());
                images1[1] = ImageUtil.rotateImage(images1[0], 90);
                images1[2] = ImageUtil.rotateImage(images1[0], 180);
                images1[3] = ImageUtil.rotateImage(images1[0], -90);
                bufferedImages.add(images1);

                InputStream[] expSkins = instance.createExplodes().getSkins();
                BufferedImage[] images2 = new BufferedImage[expSkins.length];
                for (int j=0; j<expSkins.length; j++) {
                    images2[j] = ImageIO.read(expSkins[j]);
                }
                bufferedImages.add(images2);

                computerTankImages.add(bufferedImages);
            }

            SkinAbstractFactory instance = ComRedSmallTankSkinFactory.getInstance();
//            com1TankImgs[0] = ImageIO.read(instance.createTank().getSkin());
//            com1TankImgs[1] = ImageUtil.rotateImage(com1TankImgs[0], 90);
//            com1TankImgs[2] = ImageUtil.rotateImage(com1TankImgs[0], 180);
//            com1TankImgs[3] = ImageUtil.rotateImage(com1TankImgs[0], -90);
//
//            com11BulImgs[0] = ImageIO.read(instance.createBullet().getSkin());
//            com11BulImgs[1] = ImageUtil.rotateImage(com11BulImgs[0], 90);
//            com11BulImgs[2] = ImageUtil.rotateImage(com11BulImgs[0], 180);
//            com11BulImgs[3] = ImageUtil.rotateImage(com11BulImgs[0], -90);
//
//            InputStream[] explodes1 = instance.createExplodes().getSkins();
//            com1Explodes = new BufferedImage[explodes1.length];
//            for (int i=0; i<explodes1.length; i++) {
//                com1Explodes[i] = ImageIO.read(explodes1[i]);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}