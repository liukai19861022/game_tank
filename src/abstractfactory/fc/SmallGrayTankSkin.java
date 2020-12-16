package abstractfactory.fc;

import abstractfactory.TankSkin;

import java.io.InputStream;

public class SmallGrayTankSkin extends TankSkin {

    public InputStream getSkin() {
        return SmallGrayTankSkin.class.getClassLoader().getResourceAsStream("images/fc/gray-tank/1-2-1.gif");
    }
}
