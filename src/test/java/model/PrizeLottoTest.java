package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrizeLottoTest {
	@Test
	public void 매칭수를_입력하면_상금을_얻을수있다(){
		int matchingLottoSize = 5;
		int expectPrize = 1500000;

		int result = PrizeLotto.getPrizePrice(matchingLottoSize);

		assertEquals(expectPrize, result);
	}

	@Test
	public void 매칭이_없다면_0을_반환한다(){
		int matchingLottoSize = 2;
		int expectPrize = 0;

		int result = PrizeLotto.getPrizePrice(matchingLottoSize);

		assertEquals(expectPrize, result);
	}
}
