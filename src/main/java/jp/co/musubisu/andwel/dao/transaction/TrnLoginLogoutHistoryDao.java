package jp.co.musubisu.andwel.dao.transaction;

import org.apache.ibatis.annotations.Mapper;

import jp.co.musubisu.andwel.entity.transaction.TrnLoginLogoutHistory;

@Mapper
public interface TrnLoginLogoutHistoryDao {

	/**
	 * 登録
	 * @param entity
	 * @return
	 */
	void insert(final TrnLoginLogoutHistory entity);

}
