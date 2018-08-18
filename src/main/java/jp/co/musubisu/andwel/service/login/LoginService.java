package jp.co.musubisu.andwel.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.musubisu.andwel.dto.master.UserInfoDto;
import jp.co.musubisu.andwel.service.LoginLogoutHistoryService;
import jp.co.musubisu.andwel.service.user.UserService;
import jp.co.musubisu.andwel.values.LoginLogoutDiv;

/**
 * ログインサービスクラス
 * @author K.Yamaoka
 *
 */
@Service
public class LoginService {

	@Autowired
	private UserService userService;

	@Autowired
	private LoginLogoutHistoryService loginLogoutHistoryService;

	/**
	 * 認証処理
	 * @param mailAddress メールアドレス
	 * @param password パスワード（平文）
	 */
	public UserInfoDto authentication(final String mailAddress, final String password) {
        return this.userService.authentication(mailAddress, password);
	}

	/**
	 * ログイン履歴登録
	 * @param userId
	 */
	@Transactional
	public void loginHistoryInsert(final Long userId) {
		this.loginLogoutHistoryService.insert(userId, LoginLogoutDiv.LOGIN.getValue());
	}

}
