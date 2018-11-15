package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrizeLottoTest {
	@Test
	public void 매칭수를_입력하면_상금정보를_얻을수있다(){
		int matchingLottoSize = PrizeInfo.SECOND.getMatchingSize();
		boolean matchBonus = true;

		PrizeInfo result = PrizeInfo.getPrizeInfo(matchingLottoSize, matchBonus);

		assertEquals(PrizeInfo.SECOND, result);
	}

	@Test
	public void 매칭이_없다면_0을_반환한다(){
		int countOfMatch = 2;
		boolean matchBonus = true;

		PrizeInfo result = PrizeInfo.getPrizeInfo(countOfMatch, matchBonus);

		assertEquals(PrizeInfo.NONE, result);
	}

	@Test
	public void 매칭이_5개이면서_Bonus번호가_당첨인경우_2등을_반환한다(){
		int countOfMatch = 5;
		boolean matchBonus = true;

		PrizeInfo result = PrizeInfo.getPrizeInfo(countOfMatch, matchBonus);

		assertEquals(PrizeInfo.SECOND, result);
	}

	@Test
	public void 매칭이_5개이면서_Bonus번호가_당첨이아닌경우_3등을_반환한다(){
		int countOfMatch = 5;
		boolean matchBonus = false;

		PrizeInfo result = PrizeInfo.getPrizeInfo(countOfMatch, matchBonus);

		assertEquals(PrizeInfo.THIRD, result);
	}

	@Test
	public void 매칭이_6개이면_1등을_반환한다(){
		int countOfMatch = 6;
		boolean matchBonus = true;

		PrizeInfo result = PrizeInfo.getPrizeInfo(countOfMatch, matchBonus);

		assertEquals(PrizeInfo.FIRST, result);
	}
}
