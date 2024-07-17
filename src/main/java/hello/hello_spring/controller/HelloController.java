package hello.hello_spring.controller;

import hello.hello_spring.HelloSpringApplication;
import io.micrometer.observation.transport.Propagator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";

    }


    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }


    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();

        hello.setName(name);
        return hello;
    }


    static class Hello {        // HelloController.Hello 사용 가능
        private String name;

        public String getName() {       // Property접근 방식. Getter Setter라고 함. 단축키 : Alt+Insert
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
