package model;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LottoManagerTest {
	private LottoManager manager;

	@Before
	public void setUp(){
		manager = new LottoManager();
	}

	@Test
	public void 입력금액에_해당하는_로또장수를_반환한다(){
		manager.setLottoPrice(1000);

		Assert.assertEquals(14, manager.getBuyLottoSize(14000));
	}

	@Test
	public void 매니저를_통해_로또를_구입할수있다(){
		manager.setLottoPrice(1000);
		int buyLottoSize = manager.getBuyLottoSize(14000);

		List<Lotto> buyedLotto = manager.buyLotto(buyLottoSize);

		Assert.assertFalse(buyedLotto.isEmpty());
	}

	@Test
	public void 매니저를_통해_당첨정보를_얻을수있다(){
		manager.setLottoPrice(1000);
		int buyLottoSize = manager.getBuyLottoSize(14000);
		List<Lotto> buyedLotto = manager.buyLotto(buyLottoSize);
		List<Integer> prizeLottoNos = Arrays.asList(1,2,3,4,5,6);

		List<PrizeInfo> prizeInfos = manager.getPrizeInfo(buyedLotto, prizeLottoNos);

		Assert.assertEquals(buyLottoSize, prizeInfos.size());
	}

	@Test
	public void 매니저를_통해_수익률을_얻을수있다(){
		manager.setLottoPrice(1000);
		int buyLottoSize = manager.getBuyLottoSize(140000);
		List<Integer> prizeLottoNos = Arrays.asList(1,2,3,4,5,6);
		List<Lotto> buyedLotto = manager.buyLotto(buyLottoSize);

		double incomingPercent = manager.getIncomingPercent(buyedLotto, prizeLottoNos);

		System.out.println(incomingPercent);
	}
}
