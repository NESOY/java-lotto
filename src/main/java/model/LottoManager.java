package model;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

// Lotto 가격을 정하는 의무
// Lotto 를 판매하는 의무
// Lotto 통계 낼 의무
// 총 수익률을 계산 할 의무
public class LottoManager {
	private int lottoPrice;

	public int getBuyLottoSize(int inputPrice) {
		return inputPrice / lottoPrice;
	}

	public void setLottoPrice(int lottoPrice) {
		this.lottoPrice = lottoPrice;
	}

	public List<Lotto> buyLotto(int buyLottoSize) {
		List<Lotto> buyedLottos = new ArrayList<>();

		for (int i = 0; i < buyLottoSize; i++) {
			buyedLottos.add(new Lotto());
		}

		return buyedLottos;
	}

	public List<PrizeInfo> getPrizeInfo(List<Lotto> buyedLotto, List<Integer> prizeLottoNos) {
		return buyedLotto.stream()
				.map(lotto -> lotto.getPrizeInfo(prizeLottoNos))
				.collect(toList());
	}
}
