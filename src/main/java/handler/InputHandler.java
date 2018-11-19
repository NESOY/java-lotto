package handler;

import model.LottoNo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputHandler {
	private static final String SPLITTER = ", ";
	private static final Scanner input = new Scanner(System.in);

	public static int getInputPrice(){
		return getNumber();
	}

	public static int getManualLottoSize() {
		return getNumber();
	}

	public static LottoNo getBonusNo(){
		return new LottoNo(getNumber());
	}

	public static List<LottoNo> getPrizeLottos(){
		return getNumbers();
	}

	public static List<LottoNo> getManualLottoNos() {
		return getNumbers();
	}

	private static List<LottoNo> getNumbers(){
		List<Integer> numbers = new ArrayList<>();

		String line = input.nextLine();

		String[] tokens = line.split(SPLITTER);

		for (String numberOfString : tokens) {
			numbers.add(Integer.parseInt(numberOfString));
		}

		return numbers.stream().map(LottoNo::new).collect(toList());
	}

	private static int getNumber(){
		int result = input.nextInt();
		input.nextLine();
		return result;
	}
}
