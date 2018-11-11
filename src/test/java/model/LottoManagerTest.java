package model;

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
}
