package model;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

// Lotto 가격을 정하는 의무
// Lotto 를 판매하는 의무
// Lotto 통계 낼 의무
// 총 수익률을 계산 할 의무
public class LottoManager {
	private int lottoPrice = 1000;

	public int getBuyTotalLottoSize(int inputPrice) {
		return inputPrice / lottoPrice;
	}

	public void setLottoPrice(int lottoPrice) {
		this.lottoPrice = lottoPrice;
	}

	public List<Lotto> buyAutoLotto(int buyLottoSize) {
		List<Lotto> buyedLottos = new ArrayList<>();

		for (int i = 0; i < buyLottoSize; i++) {
			buyedLottos.add(new Lotto());
		}

		return buyedLottos;
	}

	public List<PrizeInfo> getPrizeInfo(List<Lotto> buyedLotto, List<LottoNo> prizeLottoNos, LottoNo bonusNo) {
		return buyedLotto.stream()
				.map(lotto -> lotto.getPrizeInfo(prizeLottoNos, bonusNo))
				.collect(toList());
	}

	public double getIncomingPercent(List<Lotto> buyedLotto, List<LottoNo> prizeLottoNos, LottoNo bonusNo) {
		int investPrice = buyedLotto.size() * lottoPrice;
		int IncomingPrice = buyedLotto.stream()
				.mapToInt(lotto -> lotto.getPrizeInfo(prizeLottoNos, bonusNo).getPrize())
				.sum();

		return  IncomingPrice == 0 ? 0 : (IncomingPrice / (double) investPrice) * 100;
	}

	public Lotto buyManualLotto(List<LottoNo> manualLottoNo) {
		return new Lotto(manualLottoNo);
	}
}
