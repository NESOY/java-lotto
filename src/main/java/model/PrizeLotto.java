package model;

// 상금을 알려줄 의무
public enum PrizeLotto {
	FIRST(6, 2000000000),
	SECOND(5, 1500000),
	THIRD(4, 50000),
	FOURTH(3, 5000),
	NONE(0, 0);

	private int matchSize;
	private int prize;

	PrizeLotto(int matchSize, int prize){
		this.matchSize = matchSize;
		this.prize = prize;
	}

	public static PrizeLotto getPrize(int matchSize){
		for(PrizeLotto prize : PrizeLotto.values()){
			if(prize.isMatching(matchSize)){
				return prize;
			}
		}

		return NONE;
	}

	private boolean isMatching(int matchSize){
		return this.matchSize == matchSize;
	}
}
