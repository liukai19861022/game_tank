package tank;


import java.awt.*;

public class Wall extends GameObject{

    public static int WIDTH = PropertyMgr.getInstance().getInteger("wallWidth");
    public static int HEIGHT = PropertyMgr.getInstance().getInteger("wallHeight");

    public Rectangle rect = new Rectangle();
    public GameModel gm;

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    public Wall(int x, int y, GameModel gm) {

        this.x = x;
        this.y = y;
        this.gm = gm;

        //init rect
        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

    }

    public void paint(Graphics g){

        Color c = g.getColor();
        g.setColor(Color.orange);
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.setColor(Color.WHITE);
        g.drawRect(x, y, WIDTH, HEIGHT);
        g.setColor(c);
    }

    public void die(){
        gm.remove(this);
    }
}