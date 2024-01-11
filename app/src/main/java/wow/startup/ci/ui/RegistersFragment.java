package wow.startup.ci.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wow.startup.ci.R;
import wow.startup.ci.databinding.FragmentRegistersBinding;
import wow.startup.ci.model.BodyRegisters;
import wow.startup.ci.network.ApiServices;
import wow.startup.ci.network.RetrofitClient;
import wow.startup.ci.viewModel.ApiViewModel;


public class RegistersFragment extends Fragment {
private ApiViewModel apiViewModel ;
private FragmentRegistersBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Initialisation de viewModel
        apiViewModel = new ViewModelProvider(this).get(ApiViewModel.class);
        apiViewModel.init(RetrofitClient.getInstance().create(ApiServices.class));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRegistersBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BodyRegisters registerBody = new BodyRegisters("Lou", "1234", "0554309857");
        apiViewModel.register(registerBody);}


}