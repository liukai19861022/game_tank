package abstractfactory;

import java.io.InputStream;

public class Bullet2Skin extends BulletSkin {

    public InputStream getSkin() {

        return Bullet2Skin.class.getClassLoader().getResourceAsStream("images/bulletU.gif");
    }
}
