package wow.startup.ci.network;

import retrofit2.Call;
import retrofit2.http.GET;
import wow.startup.ci.model.Todo;

public interface TodoServices {
@GET("todos" )
    Call<Todo> getAllTodos() ;
}
