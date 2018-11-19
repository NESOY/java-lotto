package model;

import exception.InvalidLottoNoException;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

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

	@Test
	public void 컬렉션을_통해_로또번호의_존재유무를_알수있다(){
		List<LottoNo> collection = new ArrayList<>();
		collection.add(new LottoNo(9));
		collection.add(new LottoNo(10));
		collection.add(new LottoNo(11));

		assertTrue(collection.contains(new LottoNo(9)));
	}
}
