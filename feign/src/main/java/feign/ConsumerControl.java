package feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/9 0009.
 */
@RestController
public class ConsumerControl {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value={"/feignConsumer"}, method= RequestMethod.GET)
    public String consumerHello(){
        return  helloService.hello();
    }
}
