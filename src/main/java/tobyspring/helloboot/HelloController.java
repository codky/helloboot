package tobyspring.helloboot;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloController {

    private final HelloService helloService;
    private ApplicationContext applicationContext;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;

    }

    @GetMapping("/hello")// 예전에는 @RequestMapping
    public String hello(String name) {
        if (name == null || name.length() == 0) throw new IllegalArgumentException();

        return helloService.sayHello(name);
    }

}
