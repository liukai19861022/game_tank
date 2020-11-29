package tank.skinAbstractFactory;

import java.io.InputStream;

public class Explode2Skin extends ExplodeSkin{

    public InputStream[] getSkins() {

        InputStream[] streams = new InputStream[11];
        for (int i=0; i<11; i++) {
            streams[i] = Explode2Skin.class.getClassLoader().getResourceAsStream("images/"+ i +".gif");
        }
        return streams;
    }

}
