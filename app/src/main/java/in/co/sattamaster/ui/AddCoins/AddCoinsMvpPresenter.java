package in.co.sattamaster.ui.AddCoins;


import android.content.SharedPreferences;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import in.co.sattamaster.di.PerActivity;
import in.co.sattamaster.ui.base.MvpPresenter;

@PerActivity
public interface AddCoinsMvpPresenter<V extends AddCoinsMvpView> extends MvpPresenter<V> {

    void getAllUsers(String moderator_id, SharedPreferences sharedPreferences, int page);

    void addUserCoin(String userId, JsonObject coinBalance, SharedPreferences sharedPreferences);

}
