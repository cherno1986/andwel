package jp.co.musubisu.andwel.form.login;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class LoginForm implements Serializable {

	/**
	 * メールアドレス
	 */
	@NotEmpty
	private String mailAddress = null;

	/**
	 * パスワード
	 */
	@NotEmpty
	private String password = null;

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(final String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
