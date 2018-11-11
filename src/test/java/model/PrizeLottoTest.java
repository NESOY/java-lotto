package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrizeLottoTest {
	@Test
	public void 매칭수를_입력하면_상금정보를_얻을수있다(){
		int matchingLottoSize = PrizeLotto.SECOND.getMatchingSize();
		PrizeLotto expectPrizeLotto = PrizeLotto.SECOND;

		PrizeLotto result = PrizeLotto.getPrizeLotto(matchingLottoSize);

		assertEquals(expectPrizeLotto, result);
	}

	@Test
	public void 매칭이_없다면_0을_반환한다(){
		int matchingLottoSize = 2;
		PrizeLotto expectPrizeLotto = PrizeLotto.NONE;

		PrizeLotto result = PrizeLotto.getPrizeLotto(matchingLottoSize);

		assertEquals(expectPrizeLotto, result);
	}
}
