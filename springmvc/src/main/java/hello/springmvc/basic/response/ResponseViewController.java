package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");
// <p th:text="${data}">empty</p> 에서 data 에 hello가 들어가서 empty -> hello로 바뀜
        return mav;
    }


    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model){
        model.addAttribute("data", "hello!");
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");
        return "response/hello";
        // @Controller면서 String으로 반환하면 view의 논리적 이름으로 바뀜
        // → /WEB-INF/views/response/hello.html
        // jsp뿐만 아니라 html로도 갈 수 있음
    }

    @RequestMapping("/response/hello")
    public void responseViewV3(Model model){
        model.addAttribute("data", "hello!");
    }
    // 뷰 이름을 없애고(void) 경로의 이름이랑 위의 return이랑 똑같으면 그냥 경로의 이름을 반환함
    // 이건 비추천 너무 불명확함
}
