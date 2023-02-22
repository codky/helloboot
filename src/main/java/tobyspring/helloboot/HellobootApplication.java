package tobyspring.helloboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan
public class HellobootApplication {
    public static void main(String[] args) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();

                ServletWebServerFactory webServerFactory = new TomcatServletWebServerFactory();
                WebServer webServer = webServerFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet",
                                new DispatcherServlet(this)
                            ).addMapping("/*");

                });
                webServer.start();
            }
        };
//        applicationContext.registerBean(HelloController.class); // 빈 등록
//        applicationContext.registerBean(SimpleHelloService.class);
        applicationContext.register(HellobootApplication.class);
        applicationContext.refresh();
    }

}
