package abstractfactory.fc;

import abstractfactory.BulletSkin;

import java.io.InputStream;

public class SmallBulletSkin extends BulletSkin {

    public InputStream getSkin() {

        return SmallBulletSkin.class.getClassLoader().getResourceAsStream("images/fc/bullet-1.gif");
    }
}
