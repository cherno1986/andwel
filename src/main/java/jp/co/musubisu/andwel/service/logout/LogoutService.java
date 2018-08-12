package jp.co.musubisu.andwel.service.logout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.musubisu.andwel.service.LoginLogoutHistoryService;
import jp.co.musubisu.andwel.values.LoginLogoutDiv;

/**
 * ログアウトサービスクラス
 * @author K.Yamaoka
 */
@Service
public class LogoutService {

	@Autowired
	private LoginLogoutHistoryService loginLogoutHistoryService;

	/**
	 * ログアウト履歴登録
	 * @param userId
	 */
	public void logoutHistoryInsert(final Long userId) {
		this.loginLogoutHistoryService.insert(userId, LoginLogoutDiv.LOGOUT.getValue());
	}

}
