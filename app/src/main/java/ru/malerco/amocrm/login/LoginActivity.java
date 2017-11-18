package ru.malerco.amocrm.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.malerco.amocrm.R;
import ru.malerco.amocrm.main.MainActivity;


public class LoginActivity extends Activity implements LoginView {

    private LoginPresenter presenter;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    @BindView(R.id.logEmail)
    EditText emailEdit;

    @BindView(R.id.logHash)
    EditText hash;

    @BindView(R.id.signin)
    TextView btnSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        ButterKnife.bind(this);

        presenter = new LoginPresenterImpl(this);

        btnSignIn.setOnClickListener(f -> {
            if (hasConnection(this)) {
                presenter.validateCredentials(emailEdit.getText().toString().trim(), hash.getText().toString());
            }else{
                Toast.makeText(getBaseContext(), "Connection error", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setEmailError() {
        emailEdit.setError(getString(R.string.email_error));
    }

    @Override
    public void setLoginError(String error) {Toast.makeText(getBaseContext(), "Login error: " + error, Toast.LENGTH_LONG).show();}

    @Override
    public void setPasswordError() {
        hash.setError(getString(R.string.hash_error));
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private boolean hasConnection(final Context context)
    {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        wifiInfo = cm.getActiveNetworkInfo();
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        return false;
    }
}
