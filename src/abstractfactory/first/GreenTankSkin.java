package abstractfactory.first;

import abstractfactory.TankSkin;

import java.io.InputStream;

public class GreenTankSkin extends TankSkin {

    public InputStream getSkin() {
        return GreenTankSkin.class.getClassLoader().getResourceAsStream("images/GoodTank1.png");
    }
}
