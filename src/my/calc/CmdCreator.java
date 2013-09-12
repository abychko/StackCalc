package my.calc;

import my.calc.cmd.Cmd;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by nerff on 12.09.13.
 */
public class CmdCreator {

    private String config = "calc.properties";

    void createCommands(Map<String, Cmd> map, Stack mStack) {
        Properties mProp = new Properties();
        InputStream in = getClass().getResourceAsStream(config);
        try {
            mProp.load(in);
            Set<Object> keys = mProp.keySet();
            for (Object key : keys) {
                try {
                    Class<?> mClass = Class.forName(mProp.get(key).toString());
                    for (Annotation ann : mClass.getAnnotations()) {
                        System.out.println(ann.toString());
                    }
                    map.put(key.toString(), (Cmd) mClass.newInstance());
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
