package github.com.yadavsudhir405.experiments.coreJavaPractise.annotationsExeperiments;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author sudhir
 *         Date:1/12/16
 *         Time:8:06 AM
 *         Project:core-java-practise
 */
public class Connection {
    public static final String HOST_FIELD="host";
    public static final String PORT_FIELD="port";
    private String connectionName;
    @Host(host = "172.25.1.77")
    private String host;
    @Port
    private  int port;

    public Connection(String connectionName){
        this.connectionName=connectionName;
        populateHostAndPortFromAnnotation();
    }

    private void populateHostAndPortFromAnnotation() {
        Class<? extends Connection> aClass=this.getClass();
        populateHostFromAnnotation(aClass);
        populatePortFromAnnotation(aClass);
    }

    private void populatePortFromAnnotation(Class<? extends Connection> aClass) {
        try {
            Field portFiled=aClass.getDeclaredField(PORT_FIELD);
            if (portFiled.isAnnotationPresent(Port.class)){
                Port port=(Port) portFiled.getAnnotation(Port.class);
                portFiled.setInt(this,port.port());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }
    private static <T> boolean isFiledAnnotatedWith(Field f ,T field){
        return true;
    }
    private void populateHostFromAnnotation(Class<? extends Connection> classObj) {
        try {
            Field host=classObj.getDeclaredField(HOST_FIELD);
            if (host.isAnnotationPresent(Host.class)){
                Annotation annotation=host.getAnnotation(Host.class);
                Host hostAnnotation=(Host) annotation;
                host.set(this,hostAnnotation.host());
                //this.host=hostAnnotation.host();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Connection{" +
                "connection='" + connectionName + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                '}';
    }
}
