package com.ll.basic1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //개발자가 스프링부트에게 말한다. 아래있는 HomeController는 컨트롤러다
public class HomeController {
    //만약 /home/main 이런 요청오면 아래 메서드 실행해
    @GetMapping("/home/main")
    //responsebody 아래 메서드를 실행한후 그 리턴값으 응답으로 삼아줘
    @ResponseBody
    public String showMain() {
        return "안녕하세요~~";
    }

}
