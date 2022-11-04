package io.hifii.drawertest.ui.home;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.*;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import io.hifii.drawertest.R;
import io.hifii.drawertest.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    ConstraintLayout cs;

    public int l = 0;
    private static final int addL = 350;

    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ImageView iv = (ImageView) root.findViewById(R.id.te);

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1.1f, 1.65f);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(
                new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        iv.setScaleX((Float) animation.getAnimatedValue());
                        iv.setScaleY((Float) animation.getAnimatedValue());
                    }
                });
        valueAnimator.setRepeatCount(Animation.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.start();
        valueAnimator.start();

        RelativeLayout rl = (RelativeLayout) root.findViewById(R.id.rlOne);

        l = ViewGroup.LayoutParams.MATCH_PARENT;

        rl.getLayoutParams().height = l + addL;

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        ConstraintLayout ci = (ConstraintLayout) root.findViewById(R.id.csTest);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
