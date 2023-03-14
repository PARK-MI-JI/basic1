package com.ll.basic1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller //개발자가 스프링부트에게 말한다. 아래있는 HomeController는 컨트롤러다
public class HomeController {
   private int con;
    //만약 /home/main 이런 요청오면 아래 메서드 실행해
    //Map<String, Object> map
    private List<Person> people;

    public HomeController() {
        con = -1;
        people = new ArrayList<>();
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

    @GetMapping("/home/returnBoolean")
    //responsebody 아래 메서드를 실행한후 그 리턴값으 응답으로 삼아줘
    @ResponseBody
    public int[] showaddretrunBoolean() {
        int[] arr =new int[] {10, 20, 30};
        return arr;
    }

    @GetMapping("/home/addPerson")
    //responsebody 아래 메서드를 실행한후 그 리턴값으 응답으로 삼아줘
    @ResponseBody
    public String addPerson(String name, int age) {
        Person p = new Person( name, age);

        System.out.println(p);
        people.add(p);
        return "%d번 사람이 추가되었습니다.".formatted(p.getId());

    }
    @GetMapping("/home/people")
    @ResponseBody
    public List<Person> showPeople() {
        return people;
    }
    @GetMapping("/home/removePerson")
    @ResponseBody
    public String removePerson(int id) {
        // person -> person.getId() == id
        // 위 함수가 참인 엘리먼트(요소) 경우가 존재하면, 해당 요소를 삭제한다.
        // removed 에는 삭제수행여부가 저장된다.
        // 조건에 맞는걸 찾았고 삭제까지 되었다면 true, 아니면 false
        boolean removed = people.removeIf(person -> person.getId() == id);

        if (removed == false) {
            return "%d번 사람이 존재하지 않습니다.".formatted(id);
        }

        return "%d번 사람이 삭제되었습니다.".formatted(id);
    }


}
@Getter
@AllArgsConstructor
@ToString
class Person {
    private static int lastId;
    private final int id;

    private final String name;
    private final int age;

    static {
        lastId =0;
    }

    Person(String name, int age ){
        this(++lastId, name, age);
    }
}