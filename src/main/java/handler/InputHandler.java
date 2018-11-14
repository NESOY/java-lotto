package handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
	private static final String SPLITTER = ",";
	private static final Scanner input = new Scanner(System.in);

	public static int getInputPrice(){
		return input.nextInt();
	}

	public static int getManualLottoSize() {
		return input.nextInt();
	}

	public static List<Integer> getPrizeLottos(){
		return getNumbers();
	}

	public static List<Integer> getManualLottoNos() {
		return getNumbers();
	}

	private static List<Integer> getNumbers(){
		List<Integer> numbers = new ArrayList<>();

		String line = input.nextLine();

		String[] prizeLottoNosOfString = line.split(SPLITTER);

		for (String prizeLottoNo : prizeLottoNosOfString) {
			numbers.add(Integer.parseInt(prizeLottoNo));
		}

		return numbers;
	}
}
