package com.geektech.lovecalculator.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.geektech.lovecalculator.App;
import com.geektech.lovecalculator.R;
import com.geektech.lovecalculator.databinding.FragmentFirstBinding;
import com.geektech.lovecalculator.network.LoveModel;
import com.geektech.lovecalculator.prefs.Prefs;
import com.geektech.lovecalculator.viewmodel.MainViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@AndroidEntryPoint
public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private MainViewModel viewModel;
    private String firstName, secondName;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding  = FragmentFirstBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        initClickers();

    }

    private void initClickers() {
        binding.btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataFromLoveApi();
            }
        });
    }

    private void getDataFromLoveApi() {

        NavController navController = Navigation.findNavController
                (requireActivity(), R.id.nav_host_fragment);

        if (binding.etFname.getText().toString().isEmpty()) {
            binding.etFname.setError("Enter name");
        }else{
            firstName = binding.etFname.getText().toString();
        }
        if (binding.etSname.getText().toString().isEmpty()){
            binding.etSname.setError("Enter name");
        }else {
            secondName = binding.etSname.getText().toString();
        }

        if (!binding.etFname.getText().toString().isEmpty() &&
                !binding.etSname.getText().toString().isEmpty())
            binding.progressBar.setVisibility(View.VISIBLE);


        viewModel.getLoveModelLiveData(firstName,secondName).observe(this, model -> {
            Log.e("ololo", "getDataFromLoveApi " + model.result);
            Bundle bundle = new Bundle();
            bundle.putSerializable("key",model);
            navController.navigate(R.id.secondFragment,bundle);


        });


//        App.api.loveCalculate(firstName,secondName, HOST, KEY).enqueue(new Callback<LoveModel>() {
//            @Override
//            public void onResponse(Call<LoveModel> call, Response<LoveModel> response) {
//                if (response.isSuccessful()){
//                    Log.e("ololo", "anFailure" + response.body());
//
//
//                    Bundle bundle = new Bundle();
//                    bundle.putSerializable("key",response.body());
//
//                    navController.navigate(R.id.secondFragment,bundle);
//
//                    binding.progressBar.setVisibility(View.GONE);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<LoveModel> call, Throwable t) {
//
//                Log.e("ololo", "anFailure" + t.getLocalizedMessage());
//            }
//        });

    }
}