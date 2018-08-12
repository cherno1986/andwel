package jp.co.musubisu.andwel.dto.common;

import java.io.Serializable;
import java.sql.Timestamp;

public class CommonDto implements Serializable{

	/**
	 * バージョンナンバー
	 */
	private int versionNo = -1;

	/**
	 * 削除フラグ
	 */
	private String defFlg = null;

	/**
	 * 登録ユーザID
	 */
	private Long insertUserId = null;

	/**
	 * 登録日時
	 */
	private Timestamp insertDatetime = null;

	/**
	 * 更新ユーザID
	 */
	private Long updateUserId = null;

	/**
	 * 更新日時
	 */
	private Timestamp updateDatetime = null;

	public int getVersionNo() {
		return this.versionNo;
	}

	public void setVersionNo(final int versionNo) {
		this.versionNo = versionNo;
	}

	public String getDefFlg() {
		return this.defFlg;
	}

	public void setDefFlg(final String defFlg) {
		this.defFlg = defFlg;
	}

	public Timestamp getInsertDatetime() {
		return this.insertDatetime;
	}

	public void setInsertDatetime(final Timestamp insertDatetime) {
		this.insertDatetime = insertDatetime;
	}

	public Timestamp getUpdateDatetime() {
		return this.updateDatetime;
	}

	public void setUpdateDatetime(final Timestamp updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public Long getInsertUserId() {
		return this.insertUserId;
	}

	public void setInsertUserId(final Long insertUserId) {
		this.insertUserId = insertUserId;
	}

	public Long getUpdateUserId() {
		return this.updateUserId;
	}

	public void setUpdateUserId(final Long updateUserId) {
		this.updateUserId = updateUserId;
	}
}
