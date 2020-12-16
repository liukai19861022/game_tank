package abstractfactory.fc;

import abstractfactory.TankSkin;

import java.io.InputStream;

public class SuperBigRedTankSkin extends TankSkin {

    public InputStream getSkin() {
        return SuperBigRedTankSkin.class.getClassLoader().getResourceAsStream("images/fc/red-tank/4-2-1.gif");
    }
}
