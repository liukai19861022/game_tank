package decorator;

import tank.GameObject;

import java.awt.*;

public class GODecorator extends GameObject {

    public GameObject go;

    public GODecorator(GameObject go) {
        this.go = go;
    }

    @Override
    public void paint(Graphics g) {

        this.x = go.x;
        this.y = go.y;
        go.paint(g);
    }

    @Override
    public int getWidth() {
        return go.getWidth();
    }

    @Override
    public int getHeight() {
        return go.getHeight();
    }
}
