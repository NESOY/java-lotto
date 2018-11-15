package model;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LottoManagerTest {
	private LottoManager manager;

	@Before
	public void setUp(){
		manager = new LottoManager();
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
		List<Integer> prizeLottoNos = Arrays.asList(1,2,3,4,5,6);
		int bonusNo = 7;

		List<PrizeInfo> prizeInfos = manager.getPrizeInfo(buyedLotto, prizeLottoNos, bonusNo);

		assertEquals(buyLottoSize, prizeInfos.size());
	}

	@Test
	public void 매니저를_통해_수익률을_얻을수있다(){
		List<Integer> prizeLottoNos = Arrays.asList(1,2,3,4,5,6);
		Lotto buyedLotto = manager.buyManualLotto(prizeLottoNos);
		List<Lotto> buyedLottos = Arrays.asList(buyedLotto);
		int bonusNo = 7;
		double mockIncomingPercentPerLotto = (PrizeInfo.FIRST.getPrize()/(double)1000)*100;

		double incomingPercent = manager.getIncomingPercent(buyedLottos, prizeLottoNos, bonusNo);

		assertEquals(0, Double.compare(mockIncomingPercentPerLotto, incomingPercent));
	}

	@Test
	public void 매니저를_통해_수동_로또를_얻을수있다(){
		List<Integer> manualLottoNo = Arrays.asList(1,2,3,4,5,6);

		Lotto manualLotto = manager.buyManualLotto(manualLottoNo);

		assertTrue(manualLotto.isPrize(manualLottoNo));
	}
}
