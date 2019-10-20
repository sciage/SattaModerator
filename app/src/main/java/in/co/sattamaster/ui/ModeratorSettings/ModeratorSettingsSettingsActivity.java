package in.co.sattamaster.ui.ModeratorSettings;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.co.sattamaster.R;
import in.co.sattamaster.ui.AddCoins.AddModeratorCoinsResponse;
import in.co.sattamaster.ui.base.BaseActivity;

public class ModeratorSettingsSettingsActivity extends BaseActivity implements ModeratorSettingsMvpView, View.OnClickListener {

    @BindView(R.id.combination_name_value) EditText moderator_name_value;

    @BindView(R.id.add_button) Button add_button;
    @BindView(R.id.addmoderator_progressbar) View progressFrame;


    @Inject
    ModeratorSettingsMvpPresenter<ModeratorSettingsMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_moderator);

      /*  if (!isLoggedIn){
            Intent intent = new Intent(ModeratorSettingsSettingsActivity.this, LoginScreenActivity.class);
            startActivity(intent);
        }
       */

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(ModeratorSettingsSettingsActivity.this);

        toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle("Moderator Settings");


        add_button.setOnClickListener(this);
        progressFrame.setVisibility(View.INVISIBLE);


    }

    @Override
    protected void setUp() {

    }

    @Override
    public void onClick(View v) {
         if (v.getId() == R.id.add_button){
            progressFrame.setVisibility(View.VISIBLE);

           // mPresenter.addModerator(addModerator(), preferences);
        }
    }

    private JsonObject addModerator(){
        JsonObject balance = new JsonObject();
        try {
            balance.addProperty("jodi_bid_max_length", moderator_name_value.getText().toString());

        } catch (JsonIOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return balance;
    }

    @Override
    public void addModeratorResponse(AddModeratorCoinsResponse response) {

        if (response.isStatus()){
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();

        }
        progressFrame.setVisibility(View.INVISIBLE);
    }
}
