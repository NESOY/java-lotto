package model;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LottoTest {
	@Test
	public void 주어진6개의번호_로또6개의번호_일치하는_경우(){
		List<Integer> prizeOfLotto = Arrays.asList(1,2,3,4,5,6);

		Lotto newLotto = new Lotto(prizeOfLotto);

		Assert.assertTrue(newLotto.isPrize(prizeOfLotto));
	}

	@Test
	public void 주어진6개의번호_로또6개의번호_일치하지_않는_경우(){
		List<Integer> prizeLottoNos = Arrays.asList(1,2,3,4,5,6);
		List<Integer> wrongLottoNos = Arrays.asList(1,2,3,4,5,7);

		Lotto buyedLotto = new Lotto(wrongLottoNos);

		Assert.assertFalse(buyedLotto.isPrize(prizeLottoNos));
	}

	@Test
	public void 로또는_스스로_로또번호를_생성할수있다(){
		Lotto newLotto = new Lotto();

		Assert.assertNotNull(newLotto.toString());
	}
}