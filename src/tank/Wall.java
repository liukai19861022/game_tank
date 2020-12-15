package tank;


import java.awt.*;

public class Wall extends GameObject{

    private int x,y;
    public static int WEIGHT = PropertyMgr.getInstance().getInteger("wallWeight");
    public static int HEIGHT = PropertyMgr.getInstance().getInteger("wallHeight");

    public Rectangle rect = new Rectangle();
    public GameModel gm;

    public Wall(int x, int y, GameModel gm) {

        this.x = x;
        this.y = y;
        this.gm = gm;

        //init rect
        rect.x = x;
        rect.y = y;
        rect.width = WEIGHT;
        rect.height = HEIGHT;

    }

    public void paint(Graphics g){

        Color c = g.getColor();
        g.setColor(Color.orange);
        g.fillRect(x, y, WEIGHT, HEIGHT);
        g.setColor(Color.WHITE);
        g.drawRect(x, y, WEIGHT, HEIGHT);
        g.setColor(c);
    }

    public void die(){
        gm.remove(this);
    }
}