package jp.co.musubisu.andwel.service.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.musubisu.andwel.dao.master.MstUserDao;
import jp.co.musubisu.andwel.dto.master.UserInfoDto;
import jp.co.musubisu.andwel.service.LoginLogoutHistoryService;
import jp.co.musubisu.andwel.values.LoginLogoutDiv;

/**
 * ログインサービスクラス
 * @author K.Yamaoka
 *
 */
@Service
public class LoginService {

	@Autowired
	private MstUserDao mstUserDao;

	@Autowired
	private LoginLogoutHistoryService loginLogoutHistoryService;

	/**
	 * 認証処理
	 * @param mailAddress メールアドレス
	 * @param password パスワード（平文）
	 */
	public UserInfoDto authentication(final String mailAddress, final String password) {

		Map<String,String> param = new HashMap<String,String>();
        param.put("mailAddress", mailAddress);
        param.put("password", password);
        UserInfoDto userDto = this.mstUserDao.auth(param);
        if (userDto == null) {
        	return null;
        }
        return userDto;
	}

	/**
	 * ログイン履歴登録
	 * @param userId
	 */
	public void loginHistoryInsert(final Long userId) {
		this.loginLogoutHistoryService.insert(userId, LoginLogoutDiv.LOGIN.getValue());
	}

}
