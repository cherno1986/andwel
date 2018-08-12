package jp.co.musubisu.andwel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.musubisu.andwel.dao.transaction.TrnLoginLogoutHistoryDao;
import jp.co.musubisu.andwel.entity.transaction.TrnLoginLogoutHistory;

/**
 * ログインログアウト履歴サービス
 * @author K.Yamaoka
 *
 */
@Service
public class LoginLogoutHistoryService {

	@Autowired
	private TrnLoginLogoutHistoryDao trnLoginLogoutHistoryDao;

	/**
	 * ログインログアウト履歴登録
	 * @param userId
	 * @param loginLogoutDiv
	 */
	public void insert(final Long userId, final String loginLogoutDiv) {
		TrnLoginLogoutHistory entity = new TrnLoginLogoutHistory();
		entity.setUserId(userId);
		entity.setLoginLogoutDiv(loginLogoutDiv);
		entity.setInsertUserId(userId);
		entity.setUpdateUserId(userId);
		this.trnLoginLogoutHistoryDao.insert(entity);
	}

}
