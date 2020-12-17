package tank;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Explode extends GameObject {

    public int width;
    public int height;
    private int step = 0;
    private boolean living = true;
    public BufferedImage[] images;

    public Explode(int x, int y, BufferedImage[] images) {

        this.x = x;
        this.y = y;
        this.images = images;

        height = images[0].getHeight();
        width = images[0].getWidth();
        //播放声音、卡顿
        //new Audio("audio/explode.wav").play();
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paint(Graphics g){

        g.drawImage(images[step++], x, y, null);
        if (step >= images.length){

            step =0;
            GameModel.getInstance().objects.remove(this);
        }
    }
}
