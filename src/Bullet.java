import java.awt.*;

public class Bullet {

    private int x,y;
    private static int WID=10,HEI=10;
    private static final int SPEED = 10;
    private Dir dir;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g){

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
            case LEFT: x+=SPEED;break;
            case RIGHT: x-=SPEED;break;
            default: break;
        }

    }
}
