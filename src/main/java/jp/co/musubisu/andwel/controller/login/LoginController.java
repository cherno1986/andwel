package jp.co.musubisu.andwel.controller.login;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.musubisu.andwel.dto.master.UserInfoDto;
import jp.co.musubisu.andwel.form.login.LoginForm;
import jp.co.musubisu.andwel.service.login.LoginService;


@Controller
public class LoginController {

	/** ロガー **/
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	/** セッション **/
	@Autowired
	private HttpSession session;

	/** ログインサービス **/
	@Autowired
	private LoginService loginService;

	/**
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login/admin/index";
    }

	/**
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginForm") @Valid LoginForm form, BindingResult result, Model model) {
		log.info("ログイン処理開始");

		if (result.hasErrors()) {
			log.error("入力チェックエラー");
			return "login/admin/index";
		}

		// 認証処理
		UserInfoDto userDto = null;
        try {
        	userDto = this.loginService.authentication(form.getMailAddress(), form.getPassword());
        } catch (Exception e) {
        	log.error("DBエラーが発生しました。", e);
        	result.reject("db.error", new Object[]{"001"}, "fielderrMsg");
			return "login/admin/index";
        }

		if (userDto == null) {
			log.error("認証処理失敗");
			result.reject("authentication.error", new Object[]{}, "fielderrMsg");
			return "login/admin/index";
		}
		log.info("ログイン情報 --------------------");
		log.info("会社ID：" + userDto.getCompanyId());
		log.info("ユーザID：" + userDto.getUserId());

		// ログイン履歴登録
		try {
			this.loginService.loginHistoryInsert(userDto.getUserId());
		} catch (Exception e) {
        	log.error("DBエラーが発生しました。", e);
        	result.reject("db.error", new Object[]{"002"}, "fielderrMsg");
			return "login/admin/index";
        }

		// ユーザ情報をセッションに保持する。
		this.session.setAttribute("userInfo", userDto);

		log.info("ログイン処理終了");
        return "redirect:/top/admin/";
    }

}
