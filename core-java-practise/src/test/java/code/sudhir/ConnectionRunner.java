package code.sudhir;

import code.sudhir.annotationsExeperiments.Connection;

/**
 * @author sudhir
 *         Date:1/12/16
 *         Time:8:09 AM
 *         Project:core-java-practise
 */
public class ConnectionRunner {
    public static void main(String[] args) {
        Connection connection=new Connection("RabbitConnection");
        System.out.println(connection);
    }
}
