import handler.InputHandler;
import model.Lotto;
import model.LottoManager;
import model.PrizeInfo;
import view.View;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		LottoManager manager = new LottoManager();
		manager.setLottoPrice(1000);

		View.getInputPriceView();

		int inputPrice = InputHandler.getInputPrice();
		int buyLottoSize = manager.getBuyLottoSize(inputPrice);
		View.getBuyedLottoSizeView(buyLottoSize);

		List<Lotto> buyedLottos = manager.buyLotto(buyLottoSize);
		View.getLottoInfoView(buyedLottos);

		View.getInputPrizeLottoNosView();
		List<Integer> prizeLottoNos = InputHandler.getPrizeLottos();
		List<PrizeInfo> prizeInfos = manager.getPrizeInfo(buyedLottos, prizeLottoNos);

		View.getResultView(prizeInfos);
	}
}

