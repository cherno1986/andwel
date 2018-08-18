package jp.co.musubisu.andwel.service.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.musubisu.andwel.dao.master.MstUserDao;
import jp.co.musubisu.andwel.dto.master.MstUserDto;
import jp.co.musubisu.andwel.dto.master.UserInfoDto;


/**
 * ユーザサービス
 * @author K.Yamaoka
 */
@Service
public class UserService {

	@Autowired
	private MstUserDao mstUserDao;

	/**
	 * 認証処理
	 * @param mailAddress メールアドレス
	 * @param password パスワード（平文）
	 * @return ユーザ情報Dto
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
	 * メールアドレス検索
	 * @param mailAddress メールアドレス
	 * @return ユーザマスタDto
	 */
	public MstUserDto findByMailAddress(final String mailAddress) {
		return this.mstUserDao.findByMailAddress(mailAddress);
	}
}
