package code.sudhir.annotationsExeperiments;

import java.lang.annotation.*;

/**
 * @author sudhir
 *         Date:1/12/16
 *         Time:8:05 AM
 *         Project:core-java-practise
 */
@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Port {
    public int port() default 8080;
}
