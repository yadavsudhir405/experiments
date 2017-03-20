package github.com.yadavsudhir405.experiments.coreJavaPractise.annotationsExeperiments;

import java.lang.annotation.*;

/**
 * @author sudhir
 *         Date:1/12/16
 *         Time:8:04 AM
 *         Project:core-java-practise
 */
@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Host {
    public String host() default "localhost";
}
