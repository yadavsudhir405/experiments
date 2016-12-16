package test.sudhir.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author sudhir
 *         Date:11/12/16
 *         Time:2:53 PM
 *         Project:testing-spring-boot-applications
 */
@Configuration
@ConfigurationProperties(prefix = "testMail")
public class MailServerConfiguration {

    private String host;
    private int port;
    private Smtp smtp;

    public Smtp getSmtp() {
        return smtp;
    }

    public void setSmtp(Smtp smtp) {
        this.smtp = smtp;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    public static class Smtp{
        private boolean auth;
        private boolean isSslEnabled;

        public boolean isAuth() {
            return auth;
        }

        public void setAuth(boolean auth) {
            this.auth = auth;
        }

        public boolean isSslEnabled() {
            return isSslEnabled;
        }

        public void setSslEnabled(boolean sslEnabled) {
            isSslEnabled = sslEnabled;
        }
    }
}
