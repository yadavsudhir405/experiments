package test.sudhir.web;

/**
 * @author sudhir
 *         Date:11/12/16
 *         Time:5:43 PM
 *         Project:testing-spring-boot-applications
 */
public class UserNameNotFoundException extends RuntimeException {

    private String username;

    public UserNameNotFoundException(String message){
        this(message,null);
    }

    public UserNameNotFoundException(String username, Throwable cause) {
        super(username,cause);
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }
}
