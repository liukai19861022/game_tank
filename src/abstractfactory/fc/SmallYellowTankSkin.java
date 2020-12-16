package abstractfactory.fc;

import abstractfactory.TankSkin;

import java.io.InputStream;

public class SmallYellowTankSkin extends TankSkin {

    public InputStream getSkin() {
        return SmallYellowTankSkin.class.getClassLoader().getResourceAsStream("images/fc/0Player/m0-1-1.gif");
    }
}
