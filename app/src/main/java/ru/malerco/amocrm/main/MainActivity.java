package ru.malerco.amocrm.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.malerco.amocrm.R;
import ru.malerco.amocrm.adapter.RecyclerAdapter;
import ru.malerco.amocrm.login.LoginActivity;
import ru.malerco.amocrm.login.LoginPresenter;
import ru.malerco.amocrm.login.LoginPresenterImpl;
import ru.malerco.amocrm.models.CookieSaver;


import ru.malerco.amocrm.models.auth.AuthModel;
import ru.malerco.amocrm.models.account.AccountDataModel;
import ru.malerco.amocrm.models.leads.LeadsAndStatusModel;
import ru.malerco.amocrm.models.leads.LeadsModel;
import ru.malerco.amocrm.models.leads.Lead;
import ru.malerco.amocrm.models.leads.LeadsStatus;



public class MainActivity extends AppCompatActivity implements MainView{

    private MainPresenter presenter;


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.progress)
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter = new MainPresenterImpl(this);

        presenter.onLoad();

    }

    @Override
    public void showProgress() { progressBar.setVisibility(View.VISIBLE);}

    @Override
    public void hideProgress() { progressBar.setVisibility(View.GONE);}

    @Override
    public void onLoadError() {
        Toast.makeText(getBaseContext(), "Loading error", Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void onSuccessLoad(LeadsAndStatusModel zipModel) {
        recyclerView.setAdapter(new RecyclerAdapter(this, zipModel.getLeads(), zipModel.getLeadsStatus()));
    }
}
