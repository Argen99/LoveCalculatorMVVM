package com.geektech.lovecalculator.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.lovecalculator.R;
import com.geektech.lovecalculator.databinding.FragmentStartBinding;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StartFragment extends Fragment {

    private FragmentStartBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStartBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController
                (requireActivity(), R.id.nav_host_fragment);

        binding.tvStart.animate().translationY(-1700).setDuration(2700).setStartDelay(0);
        binding.lottieAnim.animate().translationX(2000).setDuration(2000).setStartDelay(2900);

        binding.lottieAnim.postDelayed(new Runnable() {
            @Override
            public void run() {
                navController.navigate(R.id.firstFragment);
            }
        }, 4000);

    }
}