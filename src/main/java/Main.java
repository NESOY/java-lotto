import handler.InputHandler;
import lang.Korean;
import model.Lotto;
import model.LottoManager;
import model.PrizeInfo;
import view.View;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		LottoManager manager = new LottoManager();
		List<Lotto> userLottos = new ArrayList<>();

		View.getInputView(Korean.buyingAmount.toString());
		int inputPrice = InputHandler.getInputPrice();

		View.getInputView(Korean.countOfManualLotto.toString());
		int manualLottoSize = InputHandler.getManualLottoSize();

		View.getInputView(Korean.ManualLotto.toString());
		for(int i=0; i<manualLottoSize; i++) {
			List<Integer> manualLottoNos = InputHandler.getManualLottoNos();
			Lotto buyedManualLotto = manager.buyManualLotto(manualLottoNos);
			userLottos.add(buyedManualLotto);
		}

		int totalLottoSize = manager.getBuyTotalLottoSize(inputPrice);

		int autoLottoSize = totalLottoSize - manualLottoSize;
		List<Lotto> buyedAutoLottos = manager.buyAutoLotto(autoLottoSize);
		userLottos.addAll(buyedAutoLottos);

		View.getBuyedLottoSizeView(Korean.buyingLotto.toString(), manualLottoSize, autoLottoSize);
		View.getLottoInfoView(userLottos);

		View.getInputView(Korean.prizeLottoNos.toString());
		List<Integer> prizeLottoNos = InputHandler.getPrizeLottos();

		View.getInputView(Korean.bonusNo.toString());
		int bonusNo = InputHandler.getBonusNo();

		List<PrizeInfo> prizeInfos = manager.getPrizeInfo(userLottos, prizeLottoNos, bonusNo);
		View.getResultView(Korean.PrizelottoTitle.toString(), prizeInfos);
		double incomingPercent = manager.getIncomingPercent(userLottos, prizeLottoNos, bonusNo);
		View.getIncomingPercentView(Korean.incomingPercent.toString(), incomingPercent);
	}
}

