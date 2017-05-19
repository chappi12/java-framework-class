package kr.ac.jejunu.spring;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created by SeungChan on 2017-05-19.
 */
@Controller
@RequestMapping
public class RequestController {
    @RequestMapping("/request")
    public String aaa() {
        return "request";
    }
}
