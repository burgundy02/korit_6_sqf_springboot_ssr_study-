package com.study.ssr.controller;

import com.study.ssr.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/*
    static: 객체를 생성하지않고도 사용할 수 있다.

    싱글톤: 싱글톤 패턴화한 클래스의 객체를 하나만 만들어서 사용, 싱글톤 패턴의 객체를 불러오는 메소드가 getInstance()
    싱글톤 객체는 getInstance()말고는 접근할 수 없다. 생성할 때도 무조건 getInstance()로 생성해야 됨
    예) Student.getInstance();     // static은 참조할 때 클래스명.getInstance(); 해야 됨
    Student.getInstance().name;    // 저 객체의 name에 접근할 수 있다.(getInstance까지가 객체이니까)

    builder : 전체 생성자(객체만들려면필요한놈) AllArgs로 변수에 값을 넣으면서 생성할 수 있다, 근데 이렇게 넣으면 그냥 넣을 값들만 나열 돼 있기
    때문에 어느 변수에 어느 값이 들어가는지 보기 불편, 무조건 생성자틀(매개변수로 받을 수 있는 String name, int age같은 놈들)에 맞춰서
    순서대로 변수에 넣을 값을 넣어야 함(첫 번째는 무조건 name이고 ...)
    근데 builder를 쓰면 어느 변수에 어떤 값을 넣을지 알 수 있다, 순서를 안지켜도 됨, builder쓰려면 어노테이션 써야 됨

 */
@Controller
public class NameController {

    @GetMapping("/name")
    public ModelAndView namePage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("views/name");
        // 객체를 여기에 넣을 것임
        mav.addObject(Student.builder().name("김지현").age(23).build());  // builder로 객체를 만듦 / 만약 builder()가 staic이 아니라면
        // Student객체를 생성한 다음에 그 객체.builder()를 해서 객체 생성 후 그 객체에 값을 넣어야해서 번거롭다.
        // => 하지만 builder()가 static이기때문에 Student객체 생성과 동시에 값을 넣을 수 있다.(static은 객체 생성 없이 사용할 수 있기 때문에
        // Student 객체를 생성하지 않고도 객체 생성과 동시에 값을 넣을 수 있게 Student 클래스안에 들어있는 builder()메소드를 사용할 수 있다.)
        return mav;
    }
}
