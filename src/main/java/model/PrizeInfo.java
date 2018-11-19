package model;

// 상금을 알려줄 의무
public enum PrizeInfo {
	FIRST(6, 2000000000),
	SECOND(5, 300000000),
	THIRD(5, 1500000),
	FOURTH(4, 50000),
	FIFTH(3, 5000),
	NONE(0, 0);

	private int matchSize;
	private int prize;

	PrizeInfo(int matchSize, int prize){
		this.matchSize = matchSize;
		this.prize = prize;
	}

	public static PrizeInfo getPrizeInfo(int matchSize, boolean matchBonus) {
		for(PrizeInfo prize : PrizeInfo.values()){
			if(PrizeInfo.SECOND.isMatching(matchSize) && matchBonus){
				return PrizeInfo.SECOND;
			}
			else if(PrizeInfo.THIRD.isMatching(matchSize) && !matchBonus){
				return PrizeInfo.THIRD;
			}
			else if(prize.isMatching(matchSize)){
				return prize;
			}
		}

		return NONE;
	}

	private boolean isMatching(int matchSize){
		return this.matchSize == matchSize;
	}

	public int getMatchingSize(){
		return matchSize;
	}

	public int getPrize(){
		return prize;
	}
}
