package jp.co.musubisu.andwel.controller.common;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jp.co.musubisu.andwel.dto.master.UserInfoDto;

/**
 * 共通コントローラー
 * @author K.Yamaoka
 */
@Controller
public class CommonController {

	/** セッション **/
	@Autowired
	protected HttpSession session;

	/**
	 * ユーザ情報取得（セッション）
	 * @return ユーザ情報Dto
	 */
	public UserInfoDto getSessionUserInfo() {
		return (UserInfoDto) this.session.getAttribute("userInfo");
	}

	/**
	 * セッション情報登録
	 * @param dto
	 */
	public void setSessionUserInfo(final UserInfoDto dto) {
		this.session.setAttribute("userInfo", dto);
	}

}
