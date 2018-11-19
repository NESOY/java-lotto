package model;

import exception.InvalidLottoNoException;

public class LottoNo {
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;

	private int lottoNo;

	public LottoNo(int lottoNo) {
		if(lottoNo > MAX_LOTTO_NUMBER || lottoNo < MIN_LOTTO_NUMBER)
			throw new InvalidLottoNoException();
		this.lottoNo = lottoNo;
	}

	public static int getMaxLottoNo() {
		return MAX_LOTTO_NUMBER;
	}

	public static int getMinLottoNo(){
		return MIN_LOTTO_NUMBER;
	}

	@Override
	public boolean equals(Object object){
		if(object == null)
			return false;

		return this.hashCode() == object.hashCode();
	}

	@Override
	public int hashCode(){
		return lottoNo;
	}

	@Override
	public String toString(){
		return String.valueOf(lottoNo);
	}
}
