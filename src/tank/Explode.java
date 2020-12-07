package tank;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Explode {

    private int x,y;
    public static int WID;
    public static int HEI;
    private GameModel gm;
    private int step = 0;
    private boolean living = true;
    private Group group;

    public Explode(int x, int y, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.group = group;
        this.gm = gm;

        if (this.group == Group.GOOD) {
            setHEI(ResourceManger.goodExplodes[0].getHeight());
            setWID(ResourceManger.goodExplodes[0].getWidth());
        }else if (this.group == Group.BAD) {
            setHEI(ResourceManger.badExplodes[0].getHeight());
            setWID(ResourceManger.badExplodes[0].getWidth());
        }
        //播放声音、卡顿
        //new Audio("audio/explode.wav").play();
    }

    public void setHEI(int hei) {
        HEI = hei;
    }

    public void setWID(int wid) {
        WID = wid;
    }

    public int getX() {
        return x;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
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

        BufferedImage[] images = this.group == Group.GOOD ? ResourceManger.goodExplodes : ResourceManger.badExplodes;
        g.drawImage(images[step++], x, y, null);
        if (step >= images.length){
            step =0;
            living = false;
        }
    }
}
