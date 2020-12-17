package decorator;

import tank.GameObject;
import tank.ResourceManger;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ProtectiveCoverDecorator extends GODecorator {

    private int step;

    public ProtectiveCoverDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        BufferedImage[] images = ResourceManger.ringImages;
        int imageWidth = images[0].getWidth();
        int offsetX = (imageWidth-getWidth())/2;
        int startX = x-offsetX;
        int imageHeight = images[0].getHeight();
        int offsetY = (imageHeight-getHeight())/2;

        int startY = y-offsetY;


        g.drawImage(images[step++], startX, startY, null);
        if (step >= images.length){

            step =0;
        }
    }

    @Override
    public int getWidth() {
        return super.getWidth();
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }
}
