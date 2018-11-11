package handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
	private static final Scanner input = new Scanner(System.in);

	public static int getInputPrice(){
		return input.nextInt();
	}

	public static List<Integer> getPrizeLottos(){
		List<Integer> prizeLottoNos = new ArrayList<>();

		input.nextLine();
		String line = input.nextLine();

		String[] prizeLottoNosOfString = line.split(",");

		for (String prizeLottoNo : prizeLottoNosOfString) {
			prizeLottoNos.add(Integer.parseInt(prizeLottoNo));
		}

		return prizeLottoNos;
	}
}
