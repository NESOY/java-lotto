package exception;

public class InvalidLottoNoException extends RuntimeException{
	public InvalidLottoNoException(){
		super("LottoNo is invalid");
	}
}
