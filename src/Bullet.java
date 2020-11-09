import java.awt.*;

public class Bullet {

    private int x,y;
    private static int WID=10,HEI=10;
    private static final int SPEED = 8;
    private Dir dir;
    private boolean live = true;
    private TankFrame tf = null;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g){

        if (live == false) this.tf.bullets.remove(this);


        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,WID,HEI);
        g.setColor(c);

        move();
    }

    public void move(){

        switch (dir){
            case UP: y-=SPEED;break;
            case DOWN: y+=SPEED;break;
            case LEFT: x-=SPEED;break;
            case RIGHT: x+=SPEED;break;
            default: break;
        }
        if (x<0 || y <0 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT) live = false;
    }
}
