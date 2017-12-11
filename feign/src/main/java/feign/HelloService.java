package feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/12/9 0009.
 */
@FeignClient("helloService")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

}
