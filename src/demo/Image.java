package demo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {

    public static void main(String[] args) {

        try {
            BufferedImage image = ImageIO.read(new File("/Library/Java/www/DesignPatterns/game_tank/src/images/0.gif"));
            BufferedImage image2 = ImageIO.read(Image.class.getClassLoader().getResourceAsStream("images/0.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
