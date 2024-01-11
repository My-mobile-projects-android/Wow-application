package wow.startup.ci.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wow.startup.ci.model.ApiResponse;
import wow.startup.ci.model.BodyRegisters;
import wow.startup.ci.model.Todo;
import wow.startup.ci.network.ApiServices;

public class ApiReository {
    private ApiServices apiServices;

    public ApiReository(ApiServices apiServices) {
        this.apiServices = apiServices;
    }
   public LiveData<ApiResponse> register(BodyRegisters bodyRegisters){
       MutableLiveData<ApiResponse> data = new MutableLiveData<>();
       this.apiServices.register(bodyRegisters).enqueue(new Callback<ApiResponse>() {
           @Override
           public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
               Log.i("Remorte call", response.body().toString());
              if(response.isSuccessful()) {
                  Log.i("API", response.body().toString());
                  data.setValue(response.body());
              }
           }

           @Override
           public void onFailure(Call<ApiResponse> call, Throwable t) {
               Log.i("API error", t.toString());
           }
       });
       return  data ;
    }
}
