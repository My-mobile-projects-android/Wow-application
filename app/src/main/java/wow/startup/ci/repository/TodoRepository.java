package wow.startup.ci.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wow.startup.ci.model.Todo;
import wow.startup.ci.network.TodoServices;

public class TodoRepository {
    public TodoRepository(TodoServices todoService) {
        this.todoService = todoService;
    }

    private TodoServices todoService ;
   public LiveData<Todo> getAllTodos(){
       MutableLiveData<Todo> todoList = new MutableLiveData<>();
       todoService.getAllTodos().enqueue(new Callback<Todo>() {
           @Override
           public void onResponse(Call<Todo> call, Response<Todo> response) {
               Log.i("API", "REQUEST OK");
               if (response.code() == 200 && response.code() == 304) {
                   todoList.setValue(response.body());
               }
           }

           @Override
           public void onFailure(Call<Todo> call, Throwable t) {
               Log.e("ERROR API", "REQUEST NOK");
           }
       });
       return  todoList;
   }
}
