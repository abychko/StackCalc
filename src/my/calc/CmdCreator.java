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

/**
 * Created by nerff on 12.09.13.
 */
public class CmdCreator {
    Stack mStack;
    Map<String, Cmd> cmdMap;
    Map<String, Double> defines;
    private String config = "calc.properties";

    CmdCreator() {
        mStack = new Stack(10);
        cmdMap = new HashMap<String, Cmd>();
        defines = new HashMap<String, Double>();
    }

    Map<String, Cmd> getCmdMap() {
        return cmdMap;
    }

    Map<String, Double> getDefines() {
        return defines;
    }

    private void setResources(Object object) {
        Class<?> mClass = object.getClass();

        for (Field field : mClass.getDeclaredFields()) {
            Resource resource = field.getAnnotation(Resource.class);
            if (resource != null) {
                field.setAccessible(true);
                Object value = null;
                if (resource.type().equals("Stack")) {
                    //  System.out.println("Stack is required");
                    value = mStack;
                }
                if (resource.type().equals("DefMap")) {
                    //   System.out.println("Defmap is required");
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
