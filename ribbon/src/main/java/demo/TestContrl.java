package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping(value={"/test"})
public class TestContrl {

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value={"/ribbon"}, method= RequestMethod.GET)
    public String ribbon(){
        System.out.println("开始 》》》》》》》》");
        String result = restTemplate.getForEntity("http://HELLOSERVICE/hello",String.class).getBody();
        System.out.println(result);
        return result;
    }
}
