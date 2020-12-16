package abstractfactory.fc;

import abstractfactory.TankSkin;

import java.io.InputStream;

public class SuperBigGrayTankSkin extends TankSkin {

    public InputStream getSkin() {
        return SuperBigGrayTankSkin.class.getClassLoader().getResourceAsStream("images/fc/gray-tank/4-2-1.gif");
    }
}
