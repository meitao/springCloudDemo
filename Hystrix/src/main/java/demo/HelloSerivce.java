package demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloSerivce {
    @Autowired
    RestTemplate restTemplate ;

    @HystrixCommand(fallbackMethod = "fallbackHello")
    public String helloService(){
        System.out.println("开始 》》》》》》》》");
        long start = System.currentTimeMillis();
        String result = restTemplate.getForEntity("http://HELLOSERVICE/hello",String.class).getBody();
        long end = System.currentTimeMillis();
        System.out.println(">>>>>>>>>"+(end-start)+"  result:"+result);
        return result;
    }

    public String fallbackHello(){
        return "error";
    }
}
