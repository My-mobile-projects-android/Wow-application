package wow.startup.ci.network;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import wow.startup.ci.model.ApiResponse;
import wow.startup.ci.model.BodyRegisters;
import wow.startup.ci.model.Todo;

public interface ApiServices {
    @POST("register" )
    Call<ApiResponse> register(@Body BodyRegisters bodyRegisters) ;
}
