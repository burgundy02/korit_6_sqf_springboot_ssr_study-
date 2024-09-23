package com.study.ssr.controller;

import com.study.ssr.model.Dvd;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
public class DvdController {

    // 자동으로 mvc 패턴을 가지게 만듦, 밑의 코드를 줄일 수 있음 / 리턴이 String이면 무조건 view
    @GetMapping("/dvds")    // serlvet처럼 주소창에 엔터치면 출력,실행됨
    public String dvdListPage(Model model) {
        Dvd dvd = Dvd.builder()
                .title("테스트")
                .producer("테스트 제작사")
                .publisher("테스트 발행사")
                .build();

        Dvd dvd2 = Dvd.builder()
                .title("테스트")
                .producer("테스트 제작사2")
                .publisher("테스트 발행사2")
                .build();

        Dvd dvd3 = Dvd.builder()
                .title("테스트")
                .producer("테스트 제작사3")
                .publisher("테스트 발행사3")
                .build();

        model.addAttribute(dvd);  // 객체

                            // names: 변수명
        model.addAttribute("names", List.of("김준일", "김준이", "김준삼"));   // 리스트
        model.addAttribute("dvdList", List.of(dvd, dvd2, dvd3));   // 리스트
                            // key,   value
        model.addAttribute("title", "테스트 제목");  // 리터럴

        return "views/dvd_list";
    }

//    // 객체를 만들어서 사용하는 방법
//    public ModelAndView dvdListPage() {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("/views/dvd_list");
//        return mav;
//    }


    @ResponseBody   // c(클라이언트) -> ds -> hm -> 돌아옴(ds) -> count -> c(응답)으로 돌아옴 => 응답 데이터가 바로 리턴 됨
    @GetMapping("/dvds/body")
    public String getViewName() {
        return "views/dvd_list";
    }

    @ResponseBody  // * 리턴값을 화면에 그대로 보여줌
    @GetMapping("/dvd")
    // 리턴값이 객체이기 때문에 리턴타입이 String이 아니라 Dvd / object(업캐스팅됨)
    public Object getDvd() {   // * 타입이 Object이니까 리턴을 Object타입으로 반환,
                               // * 얘는 리스트니까 리스트로 화면에 띄움(JSON형태로 배열안에 객체가 들어 있는 형태로 보여줌)
      Dvd dvd = Dvd.builder().title("테스트").producer("테스트 제작자").publisher("테스트 발행사").build();
      Dvd dvd2 = Dvd.builder().title("테스트2").producer("테스트 제작자2").publisher("테스트 발행사2").build();
      Dvd dvd3 = Dvd.builder().title("테스트3").producer("테스트 제작자3").publisher("테스트 발행사3").build();

        return List.of(dvd, dvd2, dvd3);
    }
}
