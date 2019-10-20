/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package in.co.sattamaster.data.network;


import android.content.SharedPreferences;

import com.google.gson.JsonObject;

import in.co.sattamaster.dto.Bid;
import in.co.sattamaster.ui.AddCoins.AddUserCoinsResponse;
import in.co.sattamaster.ui.AllBids.HistoryDetailsResponse;
import in.co.sattamaster.ui.AllBids.HistoryPojo;
import in.co.sattamaster.ui.Homepage.GetAllUsers;
import in.co.sattamaster.ui.Homepage.UserObject;
import in.co.sattamaster.ui.Withdraw.WithdrawPojo;
import in.co.sattamaster.ui.login.LoginResponse;
import io.reactivex.Single;

/**
 * Created by janisharali on 27/01/17.
 */

public interface ApiHelper {

    ApiHeader getApiHeader();

    Single<Bid> sendBidset(JsonObject bidset, SharedPreferences sharedPreferences);
    Single<LoginResponse> loginUser(JsonObject bids, SharedPreferences sharedPreferences);
    Single<UserObject> getUserProfile(SharedPreferences sharedPreferences);
    Single<GetAllUsers> getAllUsers(String moderator_id, SharedPreferences sharedPreferences, String currentPage);
    Single<AddUserCoinsResponse> addUserCoin(String userId, JsonObject coinBalance, SharedPreferences sharedPreferences);
    Single<HistoryPojo> getBids( String page);

    Single<HistoryDetailsResponse> getBidDetails(String id, SharedPreferences sharedPreferences);

    Single<WithdrawPojo> withdrawRequest(SharedPreferences sharedPreferences, String currentPage);

  //  Single<List<PostsModel>> getImagePosts(String user_id, String onlyImages, String page);


}
