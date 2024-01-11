package wow.startup.ci.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import wow.startup.ci.model.ApiResponse;
import wow.startup.ci.model.BodyRegisters;
import wow.startup.ci.model.Todo;
import wow.startup.ci.network.ApiServices;
import wow.startup.ci.repository.ApiReository;
import wow.startup.ci.repository.TodoRepository;

public class ApiViewModel extends ViewModel {
    private ApiReository apiRepository ;
    public void init(ApiServices apiServices){
        this.apiRepository = new ApiReository(apiServices);
    }
    public LiveData<ApiResponse> register(BodyRegisters bodyRegisters){
        return this.apiRepository.register(bodyRegisters);
    }
}
