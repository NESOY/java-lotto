package model;

// 상금을 알려줄 의무
public enum PrizeLotto {
	FIRST(6, 2000000000),
	SECOND(5, 1500000),
	THIRD(4, 50000),
	FOURTH(3, 5000);

	private int matchSize;
	private int prize;

	PrizeLotto(int matchSize, int prize){
		this.matchSize = matchSize;
		this.prize = prize;
	}

	public static int getPrizePrice(int matchSize){
		for(PrizeLotto prize : PrizeLotto.values()){
			if(prize.isMatching(matchSize)){
				return prize.getPrize();
			}
		}

		return 0;
	}

	private boolean isMatching(int matchSize){
		return this.matchSize == matchSize;
	}

	private int getPrize(){
		return prize;
	}
}
