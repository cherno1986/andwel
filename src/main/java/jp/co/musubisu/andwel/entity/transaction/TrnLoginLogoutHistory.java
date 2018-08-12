package jp.co.musubisu.andwel.entity.transaction;

import jp.co.musubisu.andwel.entity.common.CommonEntity;

public class TrnLoginLogoutHistory extends CommonEntity {

	/**
	 * ユーザID
	 */
	private Long userId = null;

	/**
	 * ログインログアウト区分
	 */
	private String loginLogoutDiv = null;

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(final Long userId) {
		this.userId = userId;
	}

	public String getLoginLogoutDiv() {
		return this.loginLogoutDiv;
	}

	public void setLoginLogoutDiv(final String loginLogoutDiv) {
		this.loginLogoutDiv = loginLogoutDiv;
	}

}
