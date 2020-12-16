package abstractfactory.fc;

import abstractfactory.TankSkin;

import java.io.InputStream;

public class SmallRedTankSkin extends TankSkin {

    public InputStream getSkin() {
        return SmallRedTankSkin.class.getClassLoader().getResourceAsStream("images/fc/red-tank/1-2-1.gif");
    }
}
