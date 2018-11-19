package model;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

// 로또 번호가 맞는지 확인할 의무
// 로또 번호를 스스로 만들어내는 의무
// 스스로_당첨정보를_얻을수있는 의무
public class Lotto {
	private static final int LOTTO_SIZE = 6;

	private List<LottoNo> lottoNos;

	public Lotto() {
		List<LottoNo> allLottoNumbers = IntStream.range(LottoNo.getMinLottoNo(), LottoNo.getMaxLottoNo()+1)
				.mapToObj(LottoNo::new)
				.collect(toList());

		Collections.shuffle(allLottoNumbers);

		lottoNos = allLottoNumbers.stream().limit(LOTTO_SIZE).collect(toList());
	}

	public Lotto(List<LottoNo> lottoNumbers) {
		this.lottoNos = lottoNumbers;
	}

	public boolean isPrize(List<LottoNo> lottoNumbers) {
		return this.lottoNos.containsAll(lottoNumbers);
	}

	public PrizeInfo getPrizeInfo(List<LottoNo> prizeLottoNos, LottoNo bonusNo) {
		return PrizeInfo.getPrizeInfo(
				(int) lottoNos.stream()
						.map(prizeLottoNos::contains)
						.filter(matchingLottoNo -> matchingLottoNo)
						.count()
				, lottoNos.contains(bonusNo)
		);
	}

	@Override
	public String toString() {
		return lottoNos.toString();
	}
}
