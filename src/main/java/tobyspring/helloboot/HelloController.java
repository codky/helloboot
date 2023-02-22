package tobyspring.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;


@RequestMapping("/hello")
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping// 예전에는 @RequestMapping
    @ResponseBody // @RestController 를 위에 붙였다면 모든 메소드에 @ResponseBody가 붙었다고 가정한다.
    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
