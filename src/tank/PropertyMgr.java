package tank;

import java.io.IOException;
import java.util.IllegalFormatCodePointException;
import java.util.Properties;

public class PropertyMgr {

    private PropertyMgr() {}

    static class PropertyMgrHandler {
        private static Properties INSTANCE = new Properties();

    }

    public static Properties getInstance() {

        return PropertyMgrHandler.INSTANCE;
    }

    static {
        try {
            PropertyMgrHandler.INSTANCE.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Object get(String key){
        if (PropertyMgrHandler.INSTANCE == null) return  null;
        return PropertyMgrHandler.INSTANCE.get(key);
    }
}