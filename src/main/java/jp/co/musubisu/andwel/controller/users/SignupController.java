package jp.co.musubisu.andwel.controller.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.musubisu.andwel.common.Constants;
import jp.co.musubisu.andwel.controller.common.CommonController;
import jp.co.musubisu.andwel.dto.master.MstCompanyDto;
import jp.co.musubisu.andwel.dto.master.MstUserDto;
import jp.co.musubisu.andwel.dto.master.UserInfoDto;
import jp.co.musubisu.andwel.form.users.SignupForm;
import jp.co.musubisu.andwel.service.company.CompanyService;
import jp.co.musubisu.andwel.service.user.UserService;

/**
 * サインアップコントロール
 * @author K.Yamaoka
 */
@Controller
public class SignupController extends CommonController {

	/** ロガー **/
	private static final Logger log = LoggerFactory.getLogger(SignupController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private CompanyService companyService;

	/**
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/users/signup")
	public String index(Model model) {
		log.info("事業所登録初期表示処理開始");
		SignupForm form = new SignupForm();
		form.setTermsOfServiceChkFlg("1");
		model.addAttribute("signupForm", form);
		log.info("事業所登録初期表示処理終了");
		return "users/sign_up";
   }

	/**
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/users/signup/regist", method = RequestMethod.POST)
	public String regist(@ModelAttribute("signupForm") @Validated(SignupForm.All.class) SignupForm form, BindingResult result, Model model) {
		log.info("事業所登録処理開始");

		if (result.hasErrors()) {
			log.error("入力チェックエラー");
			return "users/sign_up";
		}

		// パスワードと確認パスワードの同一チェック
		if (!form.getPassword().equals(form.getPasswordConfirm())) {
			log.error("パスワードと確認パスワードが異なります。");
			result.reject("password_and_confirmation_password.different.error", new Object[]{}, "fielderrMsg");
			return "users/sign_up";
		}

		final String mailAddress = form.getMailAddress();
		// メールアドレス重複チェック（会社マスタ）
		MstUserDto resultMstUserDto = this.userService.findByMailAddress(mailAddress);
		if (resultMstUserDto != null) {
			log.error("メールアドレスは既に使用済みです。（会社マスタ）");
			result.reject("mailaddress.use.error", new Object[]{}, "fielderrMsg");
			return "users/sign_up";
		}

		// メールアドレス重複チェック（ユーザマスタ）
		MstCompanyDto resultMstCompanyDto = this.companyService.findByMailAddress(mailAddress);
		if (resultMstCompanyDto != null) {
			log.error("メールアドレスは既に使用済みです。（ユーザマスタ）");
			result.reject("mailaddress.use.error", new Object[]{}, "fielderrMsg");
			return "users/sign_up";
		}

		// 登録処理
		try {
			this.companyService.insert(Constants.DUMMY_USER_ID, mailAddress, form.getPassword(),
					form.getCompanyName(), form.getPhoneNumber1(), form.getPhoneNumber2(), form.getPhoneNumber3());
		} catch (Exception e) {
        	log.error("DBエラーが発生しました。", e);
        	result.reject("db.error", new Object[]{"003"}, "fielderrMsg");
			return "users/sign_up";
        }

		UserInfoDto userInfo = new UserInfoDto();
		userInfo.setMailAddress(mailAddress);
		userInfo.setCompanyName(form.getCompanyName());
		super.setSessionUserInfo(userInfo);

		log.info("事業所登録処理終了");
		return "redirect:/top/admin/";
	}
}
