package github.com.yadavsudhir405.experiments.coreJavaPractise;

import github.com.yadavsudhir405.experiments.coreJavaPractise.annotationsExeperiments.Connection;

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
