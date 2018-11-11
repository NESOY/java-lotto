package view;

import model.Lotto;

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

	public static void getResultView(){
		printMessage("당첨 통계");
		printMessage("----------");
	}

	private static void printMessage(String msg) {
		System.out.println(msg);
	}
}
