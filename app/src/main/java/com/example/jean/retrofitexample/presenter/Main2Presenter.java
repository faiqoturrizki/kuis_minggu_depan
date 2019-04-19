package com.example.jean.retrofitexample.presenter;

import com.example.jean.retrofitexample.model.History;
import com.example.jean.retrofitexample.model.RestResponseHistory;
import com.example.jean.retrofitexample.service.BaseService;
import com.example.jean.retrofitexample.view.Main2View;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Presenter {
    private Main2View main2View;
    private BaseService baseService;

    public Main2Presenter(Main2View main2View) {
        this.main2View = main2View;
        if (this.baseService == null) {
            this.baseService = new BaseService();
        }
    }
    public void getDetail(){
        baseService.getAPI().getHistory().enqueue(new Callback<RestResponseHistory>() {
            @Override
            public void onResponse(Call<RestResponseHistory> call, Response<RestResponseHistory> response) {
                if (response.isSuccessful()){
                    RestResponseHistory data=response.body();
                    List<History> hasil = data.getResult();
                    main2View.updateDetailPlayer(hasil);
                }
            }

            @Override
            public void onFailure(Call<RestResponseHistory> call, Throwable t) {

            }
        });
    }
}
