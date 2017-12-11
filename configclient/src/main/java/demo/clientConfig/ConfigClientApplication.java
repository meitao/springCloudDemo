package demo.clientConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);


    }

    @Value("${sck.user}")
    String sckUser;
    @Value("${sck.password}")
    String sckPassword;

    @RequestMapping("/hello")
    public String showUserAndPassword() {
        String sb = "username is " + sckUser + "," + "password is " + sckPassword;
        return sb;
    }
}