package io.hifii.drawertest;

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
import androidx.transition.Fade;
import androidx.transition.Transition;
import com.google.android.material.color.DynamicColors;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.snackbar.Snackbar;
import io.hifii.drawertest.MainActivity;
import io.hifii.drawertest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

  private AppBarConfiguration mAppBarConfiguration;
  private ActivityMainBinding binding;
  public ImageView iv;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // ImageView iv;

    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    /**
     * TO DO!!
     *
     * <p>I NEED TO OPEN THIS IN ANDROID STUDIO AND FIX UP SOME DEPRECATED STUFF!! *
     */

    // make the status bar transparent

    //   getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

    setSupportActionBar(binding.appBarMain.toolbar);
    binding.appBarMain.fab.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show();
          }
        });

    float radius = getResources().getDimension(R.dimen.roundcorner);
    NavigationView navigationView2 = findViewById(R.id.nav_view);
    // iv = (ImageView) findViewById(R.id.te);
    final ImageView iv = (ImageView) findViewById(R.id.te);

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

    Transition fade = new Fade();
    fade.excludeTarget(android.R.id.statusBarBackground, true);
    fade.excludeTarget(android.R.id.navigationBarBackground, true);
    getWindow().setExitTransition(null);
    getWindow().setEnterTransition(null);

    // DynamicColors.applyToActivitiesIfAvailable(this);
    MaterialShapeDrawable navViewBackground =
        (MaterialShapeDrawable) navigationView2.getBackground();
    navViewBackground.setShapeAppearanceModel(
        navViewBackground.getShapeAppearanceModel().toBuilder()
            .setTopRightCorner(16, radius)
            .setBottomRightCorner(16, radius)
            .build());
    DrawerLayout drawer = binding.drawerLayout;
    NavigationView navigationView = binding.navView;
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    mAppBarConfiguration =
        new AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
            .setOpenableLayout(drawer)
            .build();
    NavController navController =
        Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
    NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
    NavigationUI.setupWithNavController(navigationView, navController);
  }

  public static void setWindowFlag(Activity activity, final int bits, boolean on) {

    Window win = activity.getWindow();
    WindowManager.LayoutParams winParams = win.getAttributes();
    if (on) {
      winParams.flags |= bits;
    } else {
      winParams.flags &= ~bits;
    }
    win.setAttributes(winParams);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onSupportNavigateUp() {
    NavController navController =
        Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
    return NavigationUI.navigateUp(navController, mAppBarConfiguration)
        || super.onSupportNavigateUp();
  }

  @Override
  public String toString() {
    return "MainActivity[mAppBarConfiguration=" + mAppBarConfiguration + "]";
  }
}
