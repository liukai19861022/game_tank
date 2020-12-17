package decorator;

import tank.GameObject;

import java.awt.*;

public class RectDecorator extends GODecorator {

    public RectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Color color = g.getColor();
        g.setColor(Color.white);
        g.drawRect(x, y, getWidth(), getHeight());
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
