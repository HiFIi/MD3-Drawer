package io.hifii.drawertest.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import androidx.appcompat.app.*;
import androidx.activity.*;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.color.DynamicColors;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.snackbar.Snackbar;

import com.google.android.material.color.DynamicColors;
import com.google.android.material.color.MaterialColors;
import io.hifii.drawertest.R;

import io.hifii.drawertest.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

  private FragmentHomeBinding binding;
  ConstraintLayout cs;

  public View onCreateView(
      @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

    binding = FragmentHomeBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

    final TextView textView = binding.textHome;
    homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
    ConstraintLayout ci = (ConstraintLayout) root.findViewById(R.id.csTest);

    return root;
  }

  // public static int harmonizeWithPrimary(@NonNull Context context, int colorToHarmonize) {
  //    return harmonize(
  //        colorToHarmonize,
  //        // getColor(context, R.attr.primaryColor, MaterialColors.class.getCanonicalName()));
  //
  //
  //  public static int harmonize(int colorToHarmonize, int colorToHarmonizeWith) {
  //    return Blend.harmonize(colorToHarmonize, colorToHarmonizeWith);
  //  }
  
  
  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}
