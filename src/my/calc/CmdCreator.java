package my.calc;

import my.calc.cmd.Cmd;
import my.calc.cmd.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CmdCreator {

    Stack mStack = new Stack(10);
    Map<String, Cmd> cmdMap = new HashMap<String, Cmd>();
    Map<String, Double> defines = new HashMap<String, Double>();
    private String config = "calc.properties";

    Map<String, Cmd> getCmdMap() {
        return cmdMap;
    }

    Map<String, Double> getDefines() {
        return defines;
    }

    private void setResources(Object object) {

        for (Field field : object.getClass().getDeclaredFields()) {
            Resource resource = field.getAnnotation(Resource.class);
            if (resource != null) {
                field.setAccessible(true);
                Object value = null;
                if (resource.type().equals("Stack")) {
                    value = mStack;
                }
                if (resource.type().equals("DefMap")) {
                    value = defines;
                }
                try {
                    field.set(object, value);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                field.setAccessible(false);
            }
        }
    }

    void createCommands() {
        Properties mProp = new Properties();
        InputStream in = getClass().getResourceAsStream(config);
        try {
            mProp.load(in);
            Set<Object> keys = mProp.keySet();
            for (Object key : keys) {
                try {
                    Class mClass = Class.forName(mProp.get(key).toString());
                    Object instance = mClass.newInstance();
                    setResources(instance);
                    cmdMap.put(key.toString(), (Cmd) instance);
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
