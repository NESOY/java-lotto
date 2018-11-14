import handler.InputHandler;
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

		View.getInputPriceView();
		int inputPrice = InputHandler.getInputPrice();

		View.getInputManualLottoSizeView();
		int manualLottoSize = InputHandler.getManualLottoSize();

		View.getInputManualLottoNosView();
		for(int i=0; i<manualLottoSize; i++) {
			List<Integer> manualLottoNos = InputHandler.getManualLottoNos();
			Lotto buyedManualLotto = manager.buyManualLotto(manualLottoNos);
			userLottos.add(buyedManualLotto);
		}

		int totalLottoSize = manager.getBuyTotalLottoSize(inputPrice);

		int autoLottoSize = totalLottoSize - manualLottoSize;
		List<Lotto> buyedAutoLottos = manager.buyAutoLotto(autoLottoSize);
		userLottos.addAll(buyedAutoLottos);

		View.getBuyedLottoSizeView(manualLottoSize, autoLottoSize);
		View.getLottoInfoView(userLottos);

		View.getInputPrizeLottoNosView();
		List<Integer> prizeLottoNos = InputHandler.getPrizeLottos();

		View.getInputBonusNoView();
		int bonusNo = InputHandler.getBonusNo();

		List<PrizeInfo> prizeInfos = manager.getPrizeInfo(buyedAutoLottos, prizeLottoNos);
		View.getResultView(prizeInfos);
		double incomingPercent = manager.getIncomingPercent(buyedAutoLottos, prizeLottoNos);
		View.getIncomingPercentView(incomingPercent);
	}
}

