package jp.co.musubisu.andwel.service.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.musubisu.andwel.dao.master.MstCompanyDao;
import jp.co.musubisu.andwel.dto.master.MstCompanyDto;
import jp.co.musubisu.andwel.entity.master.MstCompany;


/**
 * 会社サービス
 * @author K.Yamaoka
 */
@Service
public class CompanyService {

	@Autowired
	private MstCompanyDao mstCompanyDao;

	/**
	 * メールアドレス検索
	 * @param mailAddress メールアドレス
	 * @return 会社マスタDto
	 */
	public MstCompanyDto findByMailAddress(final String mailAddress) {
		return this.mstCompanyDao.findByMailAddress(mailAddress);
	}

	/**
	 * 登録処理
	 * @param userId
	 * @param mailAddress
	 * @param password
	 * @param companyName
	 * @param phoneNumber1
	 * @param phoneNumber2
	 * @param phoneNumber3
	 */
	@Transactional
	public void insert(final Long userId, final String mailAddress, final String password,
			final String companyName, final String phoneNumber1, final String phoneNumber2, final String phoneNumber3) {
		MstCompany entity = new MstCompany();
		entity.setMailAddress(mailAddress);
		entity.setPassword(password);
		entity.setCompanyName(companyName);
		entity.setPhoneNumber1(phoneNumber1);
		entity.setPhoneNumber2(phoneNumber2);
		entity.setPhoneNumber3(phoneNumber3);
		entity.setInsertUserId(userId);
		entity.setUpdateUserId(userId);

		this.mstCompanyDao.insert(entity);
	}

}
