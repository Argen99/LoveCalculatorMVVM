package com.geektech.lovecalculator.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    private final String HOST = "love-calculator.p.rapidapi.com";
    public static String KEY = "2611949ba1msha3bd1bac2be828cp1e93bejsn05be3f998e60";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding  = FragmentFirstBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initClickers();

    }

    private void initClickers() {
        binding.btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.progressBar.setVisibility(View.VISIBLE);
                getDataFromLoveApi();
            }
        });
    }

    private void getDataFromLoveApi() {

        NavController navController = Navigation.findNavController
                (requireActivity(), R.id.nav_host_fragment);

        String firstName = binding.etFname.getText().toString();
        String secondName = binding.etSname.getText().toString();

        App.api.loveCalculate(firstName,secondName, HOST, KEY).enqueue(new Callback<LoveModel>() {
            @Override
            public void onResponse(Call<LoveModel> call, Response<LoveModel> response) {
                if (response.isSuccessful()){
                    Log.e("ololo", "anFailure" + response.body());


                    Bundle bundle = new Bundle();
                    bundle.putSerializable("key",response.body());

                    navController.navigate(R.id.secondFragment,bundle);

                    binding.progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<LoveModel> call, Throwable t) {

                Log.e("ololo", "anFailure" + t.getLocalizedMessage());
            }
        });

    }
}