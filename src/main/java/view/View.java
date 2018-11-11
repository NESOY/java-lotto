package view;

import model.Lotto;
import model.PrizeLotto;

import java.util.Arrays;
import java.util.List;

public class View {
	public static void getInputPriceView(){
		printMessage("구입급액을 입력해주세요.");
	}

	public static void getBuyedLottoSizeView(int buyedLottoSize){
		printMessage(buyedLottoSize + " 개를 구매하셨습니다.");
	}

	public static void getLottoInfoView(List<Lotto> lottos){
		lottos.forEach(System.out::println);
	}

	public static void getInputPrizeLottoNosView(){
		printMessage("지난 주 당첨 번호를 입력해 주세요.");
	}

	public static void getResultView(List<PrizeLotto> prizeInfos){
		printMessage("당첨 통계");
		printMessage("----------");

		List<PrizeLotto> printPrizeInfos = Arrays.asList(
				PrizeLotto.FOURTH,
				PrizeLotto.THIRD,
				PrizeLotto.SECOND,
				PrizeLotto.FIRST
				);

		for(PrizeLotto prizeLotto : printPrizeInfos) {
			printPrizeInfo(prizeLotto, prizeInfos);
		}
	}

	private static void printPrizeInfo(PrizeLotto prizeInfoForPrint, List<PrizeLotto> prizeInfos){
		int matchingSize = (int) prizeInfos.stream().map(prizeInfo -> prizeInfo == prizeInfoForPrint).filter(result -> result).count();
		printMessage(prizeInfoForPrint.getMatchingSize() + " 개 일치 (" + prizeInfoForPrint.getPrize() + " 원 )- " + matchingSize + " 개");
	}

	private static void printMessage(String msg) {
		System.out.println(msg);
	}
}
