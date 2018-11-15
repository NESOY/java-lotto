package view;

import lang.Korean;
import model.Lotto;
import model.PrizeInfo;

import java.util.*;

public class View {
	public static void getInputView(String desc){
		printMessage(desc);
	}

	public static void getBuyedLottoSizeView(String format, int manualLottoSize, int autoLottoSize){
		printMessage(String.format(format, manualLottoSize, autoLottoSize));
	}

	public static void getLottoInfoView(List<Lotto> lottos){
		lottos.forEach(System.out::println);
	}

	public static void getResultView(String desc, List<PrizeInfo> prizeInfos){
		printMessage(desc);
		printMessage("----------");

		Map<PrizeInfo, String> printPrizeInfos = new LinkedHashMap<>();
		printPrizeInfos.put(PrizeInfo.FIFTH, Korean.FIFTH.toString());
		printPrizeInfos.put(PrizeInfo.FOURTH, Korean.FOURTH.toString());
		printPrizeInfos.put(PrizeInfo.THIRD, Korean.THIRD.toString());
		printPrizeInfos.put(PrizeInfo.SECOND, Korean.SECOND.toString());
		printPrizeInfos.put(PrizeInfo.FIRST, Korean.FIRST.toString());


		for(PrizeInfo prizeLottoForPrint : printPrizeInfos.keySet()) {
			printPrizeInfo( prizeInfos, prizeLottoForPrint, printPrizeInfos.get(prizeLottoForPrint));
		}
	}

	private static void printPrizeInfo(List<PrizeInfo> prizeInfos, PrizeInfo prizeInfoForPrint, String format){
		int matchingSize = (int) prizeInfos.stream()
				.map(prizeInfo -> prizeInfo == prizeInfoForPrint)
				.filter(result -> result)
				.count();
		printMessage(String.format(format, prizeInfoForPrint.getMatchingSize(), prizeInfoForPrint.getPrize(), matchingSize));
	}

	public static void getIncomingPercentView(String format, double incomingPercent) {
		printMessage(String.format(format, incomingPercent));
	}

	private static void printMessage(String msg) {
		System.out.println(msg);
	}
}
