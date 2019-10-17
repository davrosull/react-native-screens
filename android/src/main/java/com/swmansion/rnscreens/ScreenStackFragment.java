package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.appbar.AppBarLayout;

public class ScreenStackFragment extends ScreenFragment {

  private AppBarLayout mAppBarLayout;
  private Toolbar mToolbar;

  @SuppressLint("ValidFragment")
  public ScreenStackFragment(Screen screenView) {
    super(screenView);
  }

  public void removeToolbar() {
    if (mAppBarLayout != null) {
      ((CoordinatorLayout) getView()).removeView(mAppBarLayout);
    }
  }

  public void setToolbar(Toolbar toolbar) {
    if (mAppBarLayout != null) {
      mAppBarLayout.addView(toolbar);
    }
    mToolbar = toolbar;
    AppBarLayout.LayoutParams params = new AppBarLayout.LayoutParams(
            AppBarLayout.LayoutParams.MATCH_PARENT, AppBarLayout.LayoutParams.WRAP_CONTENT);
    params.setScrollFlags(0);
    mToolbar.setLayoutParams(params);
  }

  @Override
  public View onCreateView(LayoutInflater inflater,
                           @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
    CoordinatorLayout view = new CoordinatorLayout(getContext());
    CoordinatorLayout.LayoutParams params = new CoordinatorLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
    params.setBehavior(new AppBarLayout.ScrollingViewBehavior());
    mScreenView.setLayoutParams(params);
    view.addView(mScreenView);

    mAppBarLayout = new AppBarLayout(getContext());
    mAppBarLayout.setLayoutParams(new AppBarLayout.LayoutParams(
            AppBarLayout.LayoutParams.MATCH_PARENT, AppBarLayout.LayoutParams.WRAP_CONTENT));
    view.addView(mAppBarLayout);

    if (mToolbar != null) {
      mAppBarLayout.addView(mToolbar);
    }

    return view;
  }
}
