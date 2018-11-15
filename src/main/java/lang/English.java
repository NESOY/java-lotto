package lang;

public enum English  {
	// input Desc
	buyingAmount("Please enter the purchase amount."),
	prizeLottoNos("Please enter last week's winning number."),
	countOfManualLotto("Enter number of PrizelottoTitle to purchase manually."),
	ManualLotto("Please enter a number to purchase manually."),
	bonusNo("Enter bonus ball."),

	// result Desc
	buyingLotto("수동으로 %d장, 자동으로 %d개를 구매하셨습니다."),
	lotto("당첨 통계"),
	incomingPercent("총 수익률은 %.2f %입니다."),

	// Lotto Desc
	first("%d개 일치 (%d 원) - %d 개"),
	second("%d개 일치, 보너스 볼 일치(%d 원) - %d 개"),
	third("%d개 일치 (%d 원) - %d 개"),
	fourth("%d개 일치 (%d 원) - %d 개"),
	fifth("%d개 일치 (%d 원) - %d 개");

	private String desc;

	English(String desc){
		this.desc = desc;
	}
}
