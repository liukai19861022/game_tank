import java.awt.*;

public class Tank {

    private int x,y;
    private Dir dir;
    private static final int SPEED = 10;
    private boolean moving = false;

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g){

        g.fillRect(x, y, 30, 30);
        move();
    }

    public void move(){
        if (!moving) return;
        switch (dir){
            case LEFT: x -= SPEED;
                break;
            case RIGHT: x += SPEED;
                break;
            case UP: y -= SPEED;
                break;
            case DOWN: y += SPEED;
                break;
            case LEFTUP: x -= SPEED;y -= SPEED;
                break;
            case RIGHTUP: x += SPEED;y -= SPEED;
                break;
            case LEFTDOWN: x -= SPEED;y += SPEED;
                break;
            case RIGHTDOWN: y += SPEED;x += SPEED;

                break;
        }
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
}
