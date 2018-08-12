package jp.co.musubisu.andwel.dto.master;

/**
 * ユーザ情報Dto
 * @author K.Yamaoka
 */
public class UserInfoDto extends MstUserDto {

	/**
	 * 会社ID
	 */
	private Long companyId = null;

	/**
	 * 会社名
	 */
	private String companyName = null;

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(final Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(final String companyName) {
		this.companyName = companyName;
	}
}
