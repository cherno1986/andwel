package jp.co.musubisu.andwel.controller.users;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.musubisu.andwel.form.login.LoginForm;

/**
 * サインアップコントロール
 * @author K.Yamaoka
 */
public class SignupController {



	/**
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/users/signUp/")
   public String index(Model model) {
       model.addAttribute("SignupForm", new LoginForm());
       return "users/signUp/index";
   }

}
