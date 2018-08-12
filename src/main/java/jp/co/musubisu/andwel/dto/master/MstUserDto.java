package jp.co.musubisu.andwel.dto.master;

import jp.co.musubisu.andwel.dto.common.CommonDto;

public class MstUserDto extends CommonDto {

	/**
	 * ユーザID
	 */
	private Long userId = null;

	/**
	 * メールアドレス
	 */
	private String mailAddress = null;

	/**
	 * パスワード
	 */
	private String password = null;

	/**
	 * 姓
	 */
	private String firstName = null;

	/**
	 * 姓（カナ）
	 */
	private String firstNameKana = null;

	/**
	 * 名
	 */
	private String lastName = null;

	/**
	 * 名（カナ）
	 */
	private String lastNameKana = null;



	public Long getUserId() {
		return userId;
	}

	public void setUserId(final Long userId) {
		this.userId = userId;
	}

	public String getMailAddress() {
		return this.mailAddress;
	}

	public void setMailAddress(final String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getFirstNameKana() {
		return this.firstNameKana;
	}

	public void setFirstNameKana(final String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getLastNameKana() {
		return this.lastNameKana;
	}

	public void setLastNameKana(final String lastNameKana) {
		this.lastNameKana = lastNameKana;
	}
}
