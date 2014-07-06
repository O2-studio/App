package com.clever.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.clever.module.dao.ObjectDao;
import com.clever.ui.fragments.LeftMenuF;
import com.clever.ui.fragments.RightContentF;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class FragmentChangeActivity extends BaseActivity {
	private Fragment leftPanel;
	private Fragment rightPanel;
	private ObjectDao objDao;

	public FragmentChangeActivity() {
		super(R.string.changing_fragments);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// Instance Dao
		objDao = new ObjectDao(this);

		// modify default left icon.
		getSupportActionBar().setIcon(R.drawable.header);
		super.onCreate(savedInstanceState);

		// set the Above View
		if (savedInstanceState != null)
			rightPanel = getSupportFragmentManager().getFragment(
					savedInstanceState, "rightPanel");
		if (rightPanel == null)
			rightPanel = new RightContentF(R.color.Health_C, objDao);

		setContentView(R.layout.content_frame);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, rightPanel).commit();

		// set the Behind View
		leftPanel = new LeftMenuF(objDao);
		setBehindContentView(R.layout.menu_frame);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame, leftPanel).commit();

		// customize the SlidingMenu
		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

		// customize the left icon

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
