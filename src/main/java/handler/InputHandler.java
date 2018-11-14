package handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
	private static final String SPLITTER = ", ";
	private static final Scanner input = new Scanner(System.in);

	public static int getInputPrice(){
		return getNumber();
	}

	public static int getManualLottoSize() {
		return getNumber();
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

		String[] tokens = line.split(SPLITTER);

		for (String numberOfString : tokens) {
			numbers.add(Integer.parseInt(numberOfString));
		}

		return numbers;
	}

	private static int getNumber(){
		int result = input.nextInt();
		input.nextLine();
		return result;
	}
}
