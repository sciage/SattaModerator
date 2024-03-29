package in.co.sattamaster.ui.AllBids;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.co.sattamaster.R;
import in.co.sattamaster.ui.base.BaseActivity;
import in.co.sattamaster.ui.base.Constants;

public class BidsDetailsActivity extends BaseActivity implements BidsDetailsMvpView {
    @Inject
    BidsDetailsMvpPresenter<BidsDetailsMvpView> mPresenter;

    String BIDSET_ID;
    private HistoryDetailsAdapter mHistoryDetailsAdapter;
    private LinearLayoutManager mLinearLayoutManager;


    List<HistoryBidHeader> myCommentList = null;



    @BindView(R.id.historydetails_progressbar) View progressFrame;
    @BindView(R.id.detail_rv_messages) protected RecyclerView mMessageRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bids_details);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(BidsDetailsActivity.this);

        toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle("History Bidding");

        Intent intent = getIntent();
        BIDSET_ID = intent.getStringExtra(Constants.BIDSET_ID);

        initRecyclerView();

        progressFrame.setVisibility(View.VISIBLE);

        mPresenter.getBidDetails(BIDSET_ID, preferences);
    }

    private void initRecyclerView() {
        /**code edited by nirmal
         * Replacing the linearlayout manager
         */

        //    geocoder = new Geocoder(PostsDetailsActivity.this, Locale.getDefault());


        //    mLinearLayoutManager = new LinearLayoutManager(PostsDetailsActivity.this,LinearLayoutManager.VERTICAL,true);

        mHistoryDetailsAdapter = new HistoryDetailsAdapter(BidsDetailsActivity.this, myCommentList);

        mLinearLayoutManager = new LinearLayoutManager(BidsDetailsActivity.this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mLinearLayoutManager.setStackFromEnd(true);
//        mLinearLayoutManager.setReverseLayout(true);

        mMessageRecyclerView.setLayoutManager(mLinearLayoutManager);
        mMessageRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        mMessageRecyclerView.setAdapter(mHistoryDetailsAdapter);

    }

    @Override
    protected void setUp() {

    }

    @Override
    public void getBidDetails(HistoryDetailsResponse response) {


        showComments(response);
        progressFrame.setVisibility(View.GONE);

    }

    private void showComments(final HistoryDetailsResponse myList) {

        this.myCommentList = myList.getBids();
        mHistoryDetailsAdapter = new HistoryDetailsAdapter(BidsDetailsActivity.this, myList.getBids());
        mMessageRecyclerView.setAdapter(mHistoryDetailsAdapter);


    }
}
