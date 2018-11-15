package model;

import exception.InvalidLottoNoException;

import org.junit.Test;

public class LottoNoTest {
	@Test(expected = InvalidLottoNoException.class)
	public void 로또번호는_제한된숫자보다_큰_경우_에러를반환한다(){
		int overLottoNo = LottoNo.getMaxLottoNo() + 1;
		new LottoNo(overLottoNo);
	}

	@Test(expected = InvalidLottoNoException.class)
	public void 로또번호는_제한된숫자보다_작은_경우_에러를반환한다(){
		int overLottoNo = LottoNo.getMinLottoNo() - 1;
		new LottoNo(overLottoNo);
	}
}
