package my.calc.cmd;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by nerff on 13.09.13.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Resource {
    String type();
}
