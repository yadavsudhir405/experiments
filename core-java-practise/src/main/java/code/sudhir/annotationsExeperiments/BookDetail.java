package code.sudhir.annotationsExeperiments;

import java.lang.annotation.*;

/**
 * @author sudhir
 *         Date:1/12/16
 *         Time:7:02 AM
 *         Project:core-java-practise
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BookDetail {
    public String author() default "Sudhir";
    public String publisher() default "Oreially";
}
