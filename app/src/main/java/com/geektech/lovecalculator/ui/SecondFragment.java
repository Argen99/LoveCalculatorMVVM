package com.geektech.lovecalculator.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.geektech.lovecalculator.R;
import com.geektech.lovecalculator.databinding.FragmentSecondBinding;
import com.geektech.lovecalculator.databinding.FragmentStartBinding;
import com.geektech.lovecalculator.network.LoveModel;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Bundle bundle = getArguments();
        if (bundle != null) {
            LoveModel loveModel = (LoveModel) bundle.getSerializable("key");

//            String fname = bundle.getString("key1");
//            String sname = bundle.getString("key2");
//            String percentage = bundle.getString("key3");
//            String result = bundle.getString("key4");
            binding.tvResFname.setText(loveModel.firstName);
            binding.tvResSname.setText(loveModel.secondName);
            binding.textView.setText(loveModel.percentage + "%");
            binding.tvResult.setText(loveModel.result);
        }else
            Toast.makeText(requireContext(), "null", Toast.LENGTH_SHORT).show();
    }

}