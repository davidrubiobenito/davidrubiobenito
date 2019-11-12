package es.babel.security.test.securitytest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("custom.security")
public class CustomSecurityProperties {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
