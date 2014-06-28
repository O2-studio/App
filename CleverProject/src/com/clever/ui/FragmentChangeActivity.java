package com.clever.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.clever.ui.fragments.LeftMenuF;
import com.clever.ui.fragments.RightContentF;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class FragmentChangeActivity extends BaseActivity {

	private Fragment rightPanel;

	public FragmentChangeActivity() {
		super(R.string.changing_fragments);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// set the Above View
		if (savedInstanceState != null)
			rightPanel = getSupportFragmentManager().getFragment(
					savedInstanceState, "rightPanel");
		if (rightPanel == null)
			rightPanel = new RightContentF(R.color.red);

		setContentView(R.layout.content_frame);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, rightPanel).commit();

		// set the Behind View
		setBehindContentView(R.layout.menu_frame);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame, new LeftMenuF()).commit();

		// customize the SlidingMenu
		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		getSupportFragmentManager().putFragment(outState, "rightPanel",
				rightPanel);
	}

	public void switchContent(Fragment fragment) {
		rightPanel = fragment;
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, fragment).commit();
		getSlidingMenu().showContent();
	}

}
