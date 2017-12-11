package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    HelloSerivce helloSerivce ;

    @RequestMapping(value={"/hystrix"}, method= RequestMethod.GET)
    public String ribbon(){
        System.out.println("开始 》》》》》》》》");
        String result = helloSerivce.helloService();
        System.out.println(result);
        return result;
    }
}
