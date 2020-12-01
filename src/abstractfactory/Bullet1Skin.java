package abstractfactory;

import java.io.InputStream;

public class Bullet1Skin extends BulletSkin {

    public InputStream getSkin() {

        return Bullet1Skin.class.getClassLoader().getResourceAsStream("images/bulletU.png");
    }
}
