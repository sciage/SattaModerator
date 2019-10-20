package in.co.sattamaster.ui.ModeratorSettings;

import in.co.sattamaster.ui.AddCoins.AddModeratorCoinsResponse;
import in.co.sattamaster.ui.base.MvpView;

public interface ModeratorSettingsMvpView extends MvpView {

    void addModeratorResponse(AddModeratorCoinsResponse response);
}
