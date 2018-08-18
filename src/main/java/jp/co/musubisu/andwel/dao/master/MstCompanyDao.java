package jp.co.musubisu.andwel.dao.master;

import org.apache.ibatis.annotations.Mapper;

import jp.co.musubisu.andwel.dto.master.MstCompanyDto;
import jp.co.musubisu.andwel.entity.master.MstCompany;

/**
 * 会社マスタDao
 * @author K.Yamaoka
 */
@Mapper
public interface MstCompanyDao {

	/**
	 * メールアドレス検索
	 * @param mailAddress メールアドレス
	 * @return 会社マスタDto
	 */
	MstCompanyDto findByMailAddress(String mailAddress);

	/**
	 * 登録処理
	 * @param entity
	 */
	void insert(MstCompany entity);
}
