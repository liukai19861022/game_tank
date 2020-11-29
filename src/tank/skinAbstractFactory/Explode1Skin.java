package tank.skinAbstractFactory;

import java.io.InputStream;

public class Explode1Skin extends ExplodeSkin{

    public InputStream[] getSkins() {

        InputStream[] streams = new InputStream[16];
        for (int i=1; i<17; i++) {
            streams[i-1] = Explode1Skin.class.getClassLoader().getResourceAsStream("images/e"+ i +".gif");
        }

        return streams;
    }



}
