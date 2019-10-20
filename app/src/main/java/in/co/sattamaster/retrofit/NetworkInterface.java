package in.co.sattamaster.retrofit;

import com.google.gson.JsonObject;

import in.co.sattamaster.data.network.ApiEndPoint;
import in.co.sattamaster.dto.Bid;
import in.co.sattamaster.ui.AddCoins.AddUserCoinsResponse;
import in.co.sattamaster.ui.AllBids.HistoryDetailsResponse;
import in.co.sattamaster.ui.AllBids.HistoryPojo;
import in.co.sattamaster.ui.Homepage.GetAllUsers;
import in.co.sattamaster.ui.Homepage.UserObject;
import in.co.sattamaster.ui.Withdraw.WithdrawPojo;
import in.co.sattamaster.ui.login.LoginResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NetworkInterface {

    @POST(ApiEndPoint.BIDSET)
    Single<Bid> sendBidset(@Body JsonObject bids);

    @GET(ApiEndPoint.BIDSET)
    Single<HistoryPojo> getBids(@Query("page") String page);

   // @Headers("Content-Type: application/x-www-form-urlencoded")

   @POST(ApiEndPoint.LOGIN_USER)
    Single<LoginResponse> loginUser(@Body JsonObject object);

    @POST(ApiEndPoint.ADD_USER_COIN)
    Single<AddUserCoinsResponse> addUserCoin(@Path("user_id") String user_id,
                                             @Body JsonObject object);

    @GET(ApiEndPoint.BIDSET_ID)
    Single<HistoryDetailsResponse> getBidDetails(@Path("id") String id);


    @GET(ApiEndPoint.GET_ALL_USERS)
    Single<GetAllUsers> getAllUsers(@Path("moderator_id") String moderator_id, @Query("page") String page);


    @GET(ApiEndPoint.GET_USER_PROFILE)
    Single<UserObject> getUserProfile();

    @GET(ApiEndPoint.WITHDRAW_REQUEST)
    Single<WithdrawPojo> withdrawRequest(@Query("page") String page);
}
