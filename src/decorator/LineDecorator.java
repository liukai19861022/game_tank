package decorator;

import tank.GameObject;

import java.awt.*;

public class LineDecorator extends GODecorator {

    public LineDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int wid = 30;
        int offsetX = (wid-getWidth())/2;
        int startX = x-offsetX;
        int endX = startX + wid;

        Color color = g.getColor();
        g.setColor(Color.GREEN);
        g.drawLine(startX, y, endX, y);
        g.setColor(color);


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
