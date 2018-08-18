package jp.co.musubisu.andwel.form.users;

import java.io.Serializable;

import javax.validation.GroupSequence;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author K.Yamaoka
 *
 */
public class SignupForm implements Serializable {

	public interface Group1 {}
	public interface Group2 {}
	public interface Group3 {}

	@GroupSequence({Group1.class,Group2.class,Group3.class})
	public interface All {}

	/**
	 * 会社名
	 */
	@NotEmpty(groups = Group1.class)
	@Size(groups = Group2.class, max = 512)
	private String companyName = null;

	/**
	 * メールアドレス
	 */
	@NotEmpty(groups = Group1.class)
//	@Max(groups = Group2.class, value = 256)
	@Email(groups = Group2.class)
	private String mailAddress = null;

	/**
	 * パスワード
	 */
	@NotEmpty(groups = Group1.class)
	@Size(min=6, max=20,groups = Group2.class)
	@Pattern(regexp="^[a-zA-Z0-9 -/:-@\\[-\\`\\{-\\~]+$",groups = Group3.class)
	private String password = null;

	/**
	 * パスワード（確認）
	 */
	@NotEmpty(groups = Group1.class)
	@Size(min=6, max=20,groups = Group2.class)
	@Pattern(regexp="^[a-zA-Z0-9 -/:-@\\[-\\`\\{-\\~]+$",groups = Group3.class)
	private String passwordConfirm = null;

	/**
	 * 電話番号1
	 */
	@NotEmpty(groups = Group1.class)
	@Size(groups = Group2.class, max = 5)
	@Pattern(regexp="^[0-9]+$", groups = Group3.class)
	private String phoneNumber1 = null;

	/**
	 * 電話番号2
	 */
	@NotEmpty(groups = Group1.class)
	@Size(groups = Group2.class, max = 5)
	@Pattern(regexp="^[0-9]+$", groups = Group3.class)
	private String phoneNumber2 = null;

	/**
	 * 電話番号3
	 */
	@NotEmpty(groups = Group1.class)
	@Size(groups = Group2.class, max = 5)
	@Pattern(regexp="^[0-9]+$", groups = Group3.class)
	private String phoneNumber3 = null;

	/**
	 * 利用規約チェックフラグ
	 */
	@NotEmpty(groups = Group1.class, message = "利用規約及びプライバシーポリシーに同意して下さい。")
	private String termsOfServiceChkFlg = null;

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(final String companyName) {
		this.companyName = companyName;
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

	public String getPasswordConfirm() {
		return this.passwordConfirm;
	}

	public void setPasswordConfirm(final String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
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

	public String getTermsOfServiceChkFlg() {
		return this.termsOfServiceChkFlg;
	}

	public void setTermsOfServiceChkFlg(final String termsOfServiceChkFlg) {
		this.termsOfServiceChkFlg = termsOfServiceChkFlg;
	}
}
