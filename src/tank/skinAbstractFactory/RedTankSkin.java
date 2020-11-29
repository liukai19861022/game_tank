package tank.skinAbstractFactory;

import java.io.InputStream;

public class RedTankSkin extends TankSkin {

    public InputStream getSkin() {
        return RedTankSkin.class.getClassLoader().getResourceAsStream("images/BadTank1.png");
    }
}
