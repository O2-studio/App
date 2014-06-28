package com.clever.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.clever.ui.FragmentChangeActivity;
import com.clever.ui.R;
import com.clever.ui.customized.TagArrayAdapter;

//colors on the left side
public class LeftMenuF extends ListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.left_menu, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// All tags belongs to one people.
		String[] colors = getResources().getStringArray(R.array.tag_names);
		ArrayAdapter<String> colorAdapter = new TagArrayAdapter<String>(
				getActivity(), android.R.layout.simple_list_item_1,
				android.R.id.text1, colors);
		setListAdapter(colorAdapter);
	}

	@Override
	public void onListItemClick(ListView lv, View v, int position, long id) {
		Fragment newContent = null;
		switch (position) {
		case 0:
			newContent = new RightContentF(R.color.Health_C);
			break;
		case 1:
			newContent = new RightContentF(R.color.History_C);
			break;
		case 2:
			newContent = new RightContentF(R.color.Computer_C);
			break;
		case 3:
			newContent = new RightContentF(R.color.Art_C);
			break;
		case 4:
			newContent = new RightContentF(R.color.black);
			break;
		}
		if (newContent != null)
			switchFragment(newContent);
	}

	// the meat of switching the above fragment
	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;

		if (getActivity() instanceof FragmentChangeActivity) {
			FragmentChangeActivity fca = (FragmentChangeActivity) getActivity();
			fca.switchContent(fragment);
			// } else if (getActivity() instanceof ResponsiveUIActivity) {
			// ResponsiveUIActivity ra = (ResponsiveUIActivity) getActivity();
			// ra.switchContent(fragment);
		}
	}

}
