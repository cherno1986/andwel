package jp.co.musubisu.andwel.controller.logout;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.musubisu.andwel.dto.master.UserInfoDto;
import jp.co.musubisu.andwel.service.logout.LogoutService;

/**
 * ログアウトコントローラー
 * @author K.Yamaoka
 */
@Controller
public class LogoutController {

	/** ロガー **/
	private static final Logger log = LoggerFactory.getLogger(LogoutController.class);

	@Autowired
	private HttpSession session;

	@Autowired
    private MessageSource messageSource;

	/** ログアウトサービス **/
	@Autowired
	private LogoutService logoutService;

	/**
	 * ログアウト処理
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model, Locale locale) {
		log.info("ログアウト処理開始");

		// セッションからユーザ情報を取得
		UserInfoDto userInfo = (UserInfoDto) this.session.getAttribute("userInfo");
		if (userInfo == null) {
			// セッションからユーザ情報が取得できない場合
			log.error("セッションからユーザ情報が取得できませんでした。");
			// セッション破棄
			this.session.invalidate();
		}

		// ログアウト履歴登録
		try {
			this.logoutService.logoutHistoryInsert(userInfo.getUserId());
		} catch (Exception e) {
        	log.error("DBエラーが発生しました。", e);
			return "login/admin/index";
        }

		// セッション破棄
		this.session.invalidate();

		// メッセージ設定
		model.addAttribute("msg", messageSource.getMessage("msg.logout", new Object[]{}, locale));

		log.info("ログアウト処理終了");
		return "forward:/";
	}
}
