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
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 46;

	private List<Integer> lottoNumbers;

	public Lotto() {
		List<Integer> allLottoNumbers = IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).boxed().collect(toList());

		Collections.shuffle(allLottoNumbers);

		lottoNumbers = allLottoNumbers.stream().limit(LOTTO_SIZE).collect(toList());
	}

	public Lotto(List<Integer> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public boolean isPrize(List<Integer> lottoNumbers) {
		return this.lottoNumbers.containsAll(lottoNumbers);
	}

	public PrizeInfo getPrizeInfo(List<Integer> prizeLottoNos, int bonusNo) {
		return PrizeInfo.getPrizeInfo(
				(int) lottoNumbers.stream()
						.map(prizeLottoNos::contains)
						.filter(matchingLottoNo -> matchingLottoNo)
						.count()
				, lottoNumbers.contains(bonusNo)
		);
	}

	@Override
	public String toString() {
		return lottoNumbers.toString();
	}
}
