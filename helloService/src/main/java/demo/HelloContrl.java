package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class HelloContrl {
    @Autowired
    private DiscoveryClient client;

    public static  void main(String args[]){
        SpringApplication.run(HelloContrl.class, args);
    }
    @RequestMapping(value={"/hello"}, method= RequestMethod.GET)
    public String hello(){
        ServiceInstance instance =client.getLocalServiceInstance();
        System.out.println(instance.getHost()+">>>"+instance.getUri());
        return "hello";
    }

    @RequestMapping(value={"/hystrix"}, method= RequestMethod.GET)
    public String hystrix(){
        try {
            int i = new Random().nextInt(3000);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }
}
