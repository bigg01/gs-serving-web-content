package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OcpController {

    @RequestMapping("/ocp")
    public String listpods( String name, Model model) {
        model.addAttribute("name", "pods");
        return "greeting";
    }

}
