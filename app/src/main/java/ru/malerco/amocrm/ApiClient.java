package ru.malerco.amocrm;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ru.malerco.amocrm.models.account.AccountDataModel;
import ru.malerco.amocrm.models.auth.AuthModel;
import ru.malerco.amocrm.models.leads.LeadsModel;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


public class ApiClient {

    private static RetrofitInterface mRetrofitInterface;

    public static RetrofitInterface getInstance(){
        if (mRetrofitInterface == null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://malerco.amocrm.ru/")
                    .client(HttpClient.getInstance())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            mRetrofitInterface = retrofit.create(RetrofitInterface.class);
        }

        return mRetrofitInterface;
    }

    public interface RetrofitInterface {
        @POST("/private/api/auth.php")
        Observable<AuthModel> signIn(@Query("USER_LOGIN") String login,
                                     @Query("USER_HASH") String hash,
                                     @Query("type") String type);

        @GET("/private/api/v2/json/leads/list")
        Observable<LeadsModel> getLeads();

        @GET("/private/api/v2/json/accounts/current")
        Observable<AccountDataModel> getCurrentAccountData();
    }

}
