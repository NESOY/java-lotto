package lang;

public enum Korean {
	// input Desc
	buyingAmount("구입급액을 입력해주세요."),
	prizeLottoNos("지난 주 당첨 번호를 입력해 주세요."),
	countOfManualLotto("수동으로 구매할 로또의 수를 입력해 주세요."),
	ManualLotto("수동으로 구매할 번호를 입력해 주세요."),
	bonusNo("보너스 볼을 입력해 주세요."),

	// result Desc
	buyingLotto("수동으로 %d장, 자동으로 %d개를 구매하셨습니다."),
	PrizelottoTitle("당첨 통계"),
	incomingPercent("총 수익률은 %.2f %%입니다."),

	// Lotto Desc
	FIRST("%d개 일치 (%d 원) - %d 개"),
	SECOND("%d개 일치, 보너스 볼 일치(%d 원) - %d 개"),
	THIRD("%d개 일치 (%d 원) - %d 개"),
	FOURTH("%d개 일치 (%d 원) - %d 개"),
	FIFTH("%d개 일치 (%d 원) - %d 개");

	private String desc;

	Korean(String desc){
		this.desc = desc;
	}

	@Override
	public String toString(){
		return desc;
	}
}
