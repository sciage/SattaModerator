package in.co.sattamaster.ui.Homepage;

import in.co.sattamaster.di.PerActivity;
import in.co.sattamaster.ui.base.MvpPresenter;

@PerActivity
public interface MainActivityMvpPresenter <V extends MainActivityMvpView> extends MvpPresenter<V> {
}
