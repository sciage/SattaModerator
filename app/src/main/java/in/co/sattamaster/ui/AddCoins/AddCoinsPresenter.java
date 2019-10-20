package in.co.sattamaster.ui.AddCoins;


import android.content.SharedPreferences;

import com.google.gson.JsonObject;

import java.util.List;

import javax.inject.Inject;

import in.co.sattamaster.data.DataManager;
import in.co.sattamaster.retrofit.ANError;
import in.co.sattamaster.ui.Homepage.GetAllUsers;
import in.co.sattamaster.ui.Homepage.ModeratorProfile;
import in.co.sattamaster.ui.base.BasePresenter;
import in.co.sattamaster.ui.login.AllModerators;
import in.co.sattamaster.ui.login.UserProfile;
import in.co.sattamaster.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class AddCoinsPresenter<V extends AddCoinsMvpView> extends BasePresenter<V>
        implements AddCoinsMvpPresenter<V> {

    @Inject
    public AddCoinsPresenter(DataManager dataManager,
                             SchedulerProvider schedulerProvider,
                             CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void getAllUsers(String moderator_id, SharedPreferences sharedPreferences, int page) {
        getCompositeDisposable().add(getDataManager()
                .getAllUsers(moderator_id, sharedPreferences, String.valueOf(page))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<GetAllUsers>() {
                    @Override
                    public void accept(GetAllUsers response) throws Exception {

                        getMvpView().getAllUsers(response);

                        // todo add data and loop to get all friends list
                     /*   getDataManager().updateUserInfo(

                                response.info.getId(),
                                response.info.getUser_token(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER
                        );
                        */

                        //getMvpView().hideLoading();
                        // getMvpView().openMainActivity();

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }


    @Override
    public void addUserCoin(String userId, JsonObject coinBalance, SharedPreferences sharedPreferences) {
        getCompositeDisposable().add(getDataManager()
                .addUserCoin(userId, coinBalance, sharedPreferences)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<AddUserCoinsResponse>() {
                    @Override
                    public void accept(AddUserCoinsResponse response) throws Exception {

                        getMvpView().AddUserCoinResponse(response);

                     /*   getDataManager().updateUserInfo(

                                response.info.getId(),
                                response.info.getUser_token(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER
                        );
                        */



                        //   getMvpView().openMainActivity();

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }
}
