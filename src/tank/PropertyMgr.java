package tank;

import java.io.IOException;
import java.util.IllegalFormatCodePointException;
import java.util.Properties;

public class PropertyMgr {

    private PropertyMgr() {}

    static class PropertyMgrHandler {

        private static Properties PROPERTIESINSTANCE = new Properties();
        private static PropertyMgr INSTANCE = new PropertyMgr();
    }

    public static PropertyMgr getInstance() {

        return PropertyMgrHandler.INSTANCE;
    }

    static {

        try {

            PropertyMgrHandler.PROPERTIESINSTANCE.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public Object get(String key){

        return PropertyMgrHandler.PROPERTIESINSTANCE.get(key);
    }

    public Integer getInteger(String key) {

        String str = (String) PropertyMgrHandler.PROPERTIESINSTANCE.get(key);
        return Integer.parseInt(str);
    }
}