package in.co.sattamaster.ui.ModeratorSettings;

import android.content.SharedPreferences;

import com.google.gson.JsonObject;

import in.co.sattamaster.di.PerActivity;
import in.co.sattamaster.ui.base.MvpPresenter;

@PerActivity
public interface ModeratorSettingsMvpPresenter<V extends ModeratorSettingsMvpView> extends MvpPresenter<V> {
}
