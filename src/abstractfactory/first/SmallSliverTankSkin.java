package abstractfactory.first;

import abstractfactory.TankSkin;

import java.io.InputStream;

public class SmallSliverTankSkin extends TankSkin {

    public InputStream getSkin() {
        return SmallSliverTankSkin.class.getClassLoader().getResourceAsStream("images/tankU.gif");
    }
}