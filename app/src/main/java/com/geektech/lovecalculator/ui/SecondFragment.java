package com.geektech.lovecalculator.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.geektech.lovecalculator.R;
import com.geektech.lovecalculator.databinding.FragmentSecondBinding;
import com.geektech.lovecalculator.databinding.FragmentStartBinding;
import com.geektech.lovecalculator.network.LoveApi;
import com.geektech.lovecalculator.network.LoveModel;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private LoveModel loveModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController
                (requireActivity(), R.id.nav_host_fragment);

        Bundle bundle = getArguments();
        if (bundle != null) {
            loveModel = (LoveModel) bundle.getSerializable("key");
            setText();
        }else {
            Toast.makeText(requireContext(), "null", Toast.LENGTH_SHORT).show();
        }

        binding.btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigateUp();
            }
        });
    }

    private void setText() {
        binding.tvResFname.setText(loveModel.firstName);
        binding.tvResSname.setText(loveModel.secondName);
        binding.textView.setText(loveModel.percentage + "%");
        binding.tvResult.setText(loveModel.result);
    }

}