package com.ll.basic1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //개발자가 스프링부트에게 말한다. 아래있는 HomeController는 컨트롤러다
public class HomeController {
   private int con;
    //만약 /home/main 이런 요청오면 아래 메서드 실행해
    public HomeController() {
        con = -1;
    }
    @GetMapping("/home/main")
    //responsebody 아래 메서드를 실행한후 그 리턴값을 응답으로 삼아줘
    @ResponseBody
    public String showMain() {
        return "안녕하세요^^";
    }

    @GetMapping("/home/main2")
    //responsebody 아래 메서드를 실행한후 그 리턴값으 응답으로 삼아줘
    @ResponseBody
    public String showMain1() {
        return "반갑습니다.";
    }

    @GetMapping("/home/main3")
    //responsebody 아래 메서드를 실행한후 그 리턴값으 응답으로 삼아줘
    @ResponseBody
    public String showMain3() {
        return "즐거웠습니다.";
    }

    @GetMapping("/home/increase")
    //responsebody 아래 메서드를 실행한후 그 리턴값으 응답으로 삼아줘
    @ResponseBody
    public int showincrease() { //리턴되는 int 값은 String화 되서 고객(브라우저)에게 전달된다.
        con++;
        return con;

    }

    @GetMapping("/home/plus")

    @ResponseBody
    //RequestParam 의미
    //int a는 쿼리스트링에서 a 파라미터의 값을 얻은 후 정수화 한 값이어야 한다.
    //생략 가능
    public int showplus(@RequestParam(defaultValue = "0") int a, @RequestParam int b) { //리턴되는 int 값은 String화 되서 고객(브라우저)에게 전달된다.

        return a + b;

    }


}
