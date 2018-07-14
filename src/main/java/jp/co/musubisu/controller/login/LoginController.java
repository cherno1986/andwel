package jp.co.musubisu.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {


	@RequestMapping(value="/login")
    private String index(Model model){
		model.addAttribute("name", "aaaaaa");
        return "login/index";
    }
}
