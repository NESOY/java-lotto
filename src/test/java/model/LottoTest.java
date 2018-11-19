package model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LottoTest {
	private List<LottoNo> prizeOfLotto;
	private List<LottoNo> wrongLottoNos;

	@Before
	public void setUp(){
		prizeOfLotto = Stream.of(1,2,3,4,5,6).map(LottoNo::new).collect(Collectors.toList());
		wrongLottoNos = Stream.of(2,3,4,5,6,7).map(LottoNo::new).collect(Collectors.toList());
	}
	@Test
	public void 주어진6개의번호_로또6개의번호_일치하는_경우(){
		Lotto newLotto = new Lotto(prizeOfLotto);

		Assert.assertTrue(newLotto.isPrize(prizeOfLotto));
	}

	@Test
	public void 주어진6개의번호_로또6개의번호_일치하지_않는_경우(){
		Lotto buyedLotto = new Lotto(wrongLottoNos);

		Assert.assertFalse(buyedLotto.isPrize(prizeOfLotto));
	}

	@Test
	public void 로또는_스스로_로또번호를_생성할수있다(){
		Lotto newLotto = new Lotto();

		Assert.assertNotNull(newLotto.toString());
	}

	@Test
	public void 로또는_스스로_당첨정보를_얻을수있다(){
		List<LottoNo> lottoNos = Stream.of(1,2,3,4,5,8).map(LottoNo::new).collect(Collectors.toList());
		LottoNo bonusNo = new LottoNo(8);

		Lotto buyedLotto = new Lotto(lottoNos);

		PrizeInfo prizeLotto = buyedLotto.getPrizeInfo(prizeOfLotto, bonusNo);

		assertEquals(PrizeInfo.SECOND, prizeLotto);
	}
}
