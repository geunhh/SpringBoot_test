package jpabook.jpashop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping("/test")
    @ResponseBody
    public String index() {
        System.out.println("index");
        return "테스트 성공";
    }

    @GetMapping("/test2")
    public String root() {
        return "redirect:/question/list";
    }
}
