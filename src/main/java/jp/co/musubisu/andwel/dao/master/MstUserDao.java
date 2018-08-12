package jp.co.musubisu.andwel.dao.master;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import jp.co.musubisu.andwel.dto.master.UserInfoDto;



@Mapper
public interface MstUserDao {

	/**
	 * 認証検索
	 * @param param
	 * @return
	 */
	UserInfoDto auth(Map<String,String> param);

}
