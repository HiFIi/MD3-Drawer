-keep class io.hifii.wiki.ui.model.** { *; }
-optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*
-optimizationpasses 5
# Firebase Authentication
-keep class com.google.firebase.auth.** { *; }
-dontwarn com.google.firebase.auth.**
# Google Sign-In
-keep class com.google.android.gms.auth.api.signin.** { *; }
-dontwarn com.google.android.gms.auth.api.signin.**
-keep class com.google.android.gms.common.api.** { *; }
-dontwarn com.google.android.gms.common.api.**

-dontwarn com.bumptech.glide.**
# Firebase Analytics
-keep class com.google.firebase.analytics.** { *; }
-dontwarn com.google.firebase.analytics.**

# Firebase Common
-keep class com.google.firebase.** { *; }
-dontwarn com.google.firebase.**

# Firebase Firestore
-keep class com.google.firebase.firestore.** { *; }
-dontwarn com.google.firebase.firestore.**

# Firebase Remote Config
-keep class com.google.firebase.remoteconfig.** { *; }
-dontwarn com.google.firebase.remoteconfig.**

# General Firebase
-keep class com.google.firebase.** { *; }
-dontwarn com.google.firebase.**

# Prevent stripping of Firebase components
-keepattributes Signature
-keepattributes *Annotation*

-keep class com.google.** { *; }
-dontwarn com.google.**

-keep class androidx.multidex.** { *; }
-dontwarn androidx.multidex.**

-keepclassmembers class androidx.viewpager.widget.ViewPager {
    void setAdapter(androidx.viewpager.widget.PagerAdapter);
}

-keep class androidx.viewpager.widget.ViewPager {
    *;
}

-keep class androidx.work.** { *; }
-dontwarn androidx.work.**
