package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LottoManagerTest {
	private LottoManager manager;
	private List<LottoNo> prizeLottoNos;

	@Before
	public void setUp(){
		manager = new LottoManager();
		prizeLottoNos = Stream.of(1,2,3,4,5,6).map(LottoNo::new).collect(toList());
	}

	@Test
	public void 입력금액에_해당하는_로또장수를_반환한다(){
		manager.setLottoPrice(1000);

		assertEquals(14, manager.getBuyTotalLottoSize(14000));
	}

	@Test
	public void 매니저를_통해_로또를_구입할수있다(){
		int buyLottoSize = manager.getBuyTotalLottoSize(14000);

		List<Lotto> buyedLotto = manager.buyAutoLotto(buyLottoSize);

		Assert.assertFalse(buyedLotto.isEmpty());
	}

	@Test
	public void 매니저를_통해_당첨정보를_얻을수있다(){
		int buyLottoSize = manager.getBuyTotalLottoSize(14000);
		List<Lotto> buyedLotto = manager.buyAutoLotto(buyLottoSize);
		LottoNo bonusNo = new LottoNo(7);

		List<PrizeInfo> prizeInfos = manager.getPrizeInfo(buyedLotto, prizeLottoNos, bonusNo);

		assertEquals(buyLottoSize, prizeInfos.size());
	}

	@Test
	public void 매니저를_통해_수익률을_얻을수있다(){
		Lotto buyedLotto = manager.buyManualLotto(prizeLottoNos);
		List<Lotto> buyedLottos = Arrays.asList(buyedLotto);
		LottoNo bonusNo = new LottoNo(7);
		double mockIncomingPercentPerLotto = (PrizeInfo.FIRST.getPrize()/(double)1000)*100;

		double incomingPercent = manager.getIncomingPercent(buyedLottos, prizeLottoNos, bonusNo);

		assertEquals(0, Double.compare(mockIncomingPercentPerLotto, incomingPercent));
	}

	@Test
	public void 매니저를_통해_수동_로또를_얻을수있다(){
		List<LottoNo> manualLottoNo = Stream.of(1,2,3,4,5,6).map(LottoNo::new).collect(toList());

		Lotto manualLotto = manager.buyManualLotto(manualLottoNo);

		assertTrue(manualLotto.isPrize(manualLottoNo));
	}

	@Test
	public void 수익률이_0이면_0을반환한다(){
		List<LottoNo> wrongLotto = Stream.of(13,14,15,16,17,18).map(LottoNo::new).collect(toList());
		Lotto buyedLotto = manager.buyManualLotto(wrongLotto);
		List<Lotto> buyedLottos = Arrays.asList(buyedLotto);
		LottoNo bonusNo = new LottoNo(7);

		double result = manager.getIncomingPercent(buyedLottos, prizeLottoNos, bonusNo);

		assertEquals(0, Double.compare(0.0, result));
	}
}
