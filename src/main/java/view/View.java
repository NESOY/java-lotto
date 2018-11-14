package view;

import model.Lotto;
import model.PrizeInfo;

import java.util.Arrays;
import java.util.List;

public class View {
	public static void getInputPriceView(){
		printMessage("구입급액을 입력해주세요.");
	}

	public static void getBuyedLottoSizeView(int manualLottoSize, int autoLottoSize){
		printMessage("수동으로 "+manualLottoSize+"장, 자동으로 "+autoLottoSize + " 개를 구매하셨습니다.");
	}

	public static void getLottoInfoView(List<Lotto> lottos){
		lottos.forEach(System.out::println);
	}

	public static void getInputPrizeLottoNosView(){
		printMessage("지난 주 당첨 번호를 입력해 주세요.");
	}

	public static void getResultView(List<PrizeInfo> prizeInfos){
		printMessage("당첨 통계");
		printMessage("----------");

		List<PrizeInfo> printPrizeInfos = Arrays.asList(
				PrizeInfo.FOURTH,
				PrizeInfo.THIRD,
				PrizeInfo.SECOND,
				PrizeInfo.FIRST
				);

		for(PrizeInfo prizeLotto : printPrizeInfos) {
			printPrizeInfo(prizeLotto, prizeInfos);
		}
	}

	private static void printPrizeInfo(PrizeInfo prizeInfoForPrint, List<PrizeInfo> prizeInfos){
		int matchingSize = (int) prizeInfos.stream().map(prizeInfo -> prizeInfo == prizeInfoForPrint).filter(result -> result).count();
		printMessage(prizeInfoForPrint.getMatchingSize() + " 개 일치 (" + prizeInfoForPrint.getPrize() + " 원 )- " + matchingSize + " 개");
	}

	public static void getIncomingPercentView(double incomingPercent) {
		printMessage("총 수익률은 "+ String.format("%.2f", incomingPercent) + "%입니다.");
	}

	public static void getInputManualLottoSizeView() {
		printMessage("수동으로 구매할 로또의 수를 입력해 주세요.");
	}

	public static void getInputManualLottoNosView(){
		printMessage("수동으로 구매할 번호를 입력해 주세요.");
	}

	public static void getInputBonusNoView() {
		printMessage("보너스 볼을 입력해 주세요.");
	}

	private static void printMessage(String msg) {
		System.out.println(msg);
	}
}
