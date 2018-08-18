package jp.co.musubisu.andwel.dto.master;

import jp.co.musubisu.andwel.dto.common.CommonDto;

/**
 * 会社マスタDto
 * @author K.Yamaoka
 */
public class MstCompanyDto extends CommonDto {

	/**
	 * 会社ID
	 */
	private Long companyId = null;

	/**
	 * メールアドレス
	 */
	private String mailAddress = null;

	/**
	 * パスワード（平文）
	 */
	private String password = null;

	/**
	 * 会社名
	 */
	private String companyName = null;

	/**
	 * 電話番号1
	 */
	private String phoneNumber1 = null;

	/**
	 * 電話番号2
	 */
	private String phoneNumber2 = null;

	/**
	 * 電話番号3
	 */
	private String phoneNumber3 = null;

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(final Long companyId) {
		this.companyId = companyId;
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

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(final String companyName) {
		this.companyName = companyName;
	}

	public String getPhoneNumber1() {
		return this.phoneNumber1;
	}

	public void setPhoneNumber1(final String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return this.phoneNumber2;
	}

	public void setPhoneNumber2(final String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getPhoneNumber3() {
		return this.phoneNumber3;
	}

	public void setPhoneNumber3(final String phoneNumber3) {
		this.phoneNumber3 = phoneNumber3;
	}
}
