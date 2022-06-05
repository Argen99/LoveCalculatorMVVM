package com.geektech.lovecalculator.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.lovecalculator.R;
import com.geektech.lovecalculator.databinding.FragmentBoardBinding;

public class BoardFragment extends Fragment {

    private FragmentBoardBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBoardBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BoardAdapter adapter = new BoardAdapter();
        binding.viewPager.setAdapter(adapter);
        binding.viewPager.setAdapter(adapter);
        binding.wormDotsIndicator.setViewPager2(binding.viewPager);


    }

}