package abstractfactory.fc;

import abstractfactory.ExplodeSkin;

import java.io.InputStream;

public class ExpSkin extends ExplodeSkin {

    public InputStream[] getSkins() {

        InputStream[] streams = new InputStream[5];
        for (int i=0; i<5; i++) {
            streams[i] = ExpSkin.class.getClassLoader().getResourceAsStream("images/fc/blast/"+ i +".gif");
        }
        return streams;
    }

}
