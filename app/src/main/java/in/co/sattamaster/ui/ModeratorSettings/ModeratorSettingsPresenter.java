package in.co.sattamaster.ui.ModeratorSettings;

import android.content.SharedPreferences;

import com.google.gson.JsonObject;

import javax.inject.Inject;

import in.co.sattamaster.data.DataManager;
import in.co.sattamaster.retrofit.ANError;
import in.co.sattamaster.ui.AddCoins.AddModeratorCoinsResponse;
import in.co.sattamaster.ui.base.BasePresenter;
import in.co.sattamaster.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class ModeratorSettingsPresenter<V extends ModeratorSettingsMvpView> extends BasePresenter<V>
        implements ModeratorSettingsMvpPresenter<V> {

    @Inject
    public ModeratorSettingsPresenter(DataManager dataManager,
                                      SchedulerProvider schedulerProvider,
                                      CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

}
