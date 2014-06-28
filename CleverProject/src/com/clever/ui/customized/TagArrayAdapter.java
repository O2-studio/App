package com.clever.ui.customized;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.clever.ui.R;

public class TagArrayAdapter<T> extends ArrayAdapter<String> {

	private FragmentActivity tActivity = null;

	public TagArrayAdapter(FragmentActivity activity, int simpleListItem1,
			int text1, String[] colors) {
		// TODO Auto-generated constructor stub
		super(activity, simpleListItem1, text1, colors);
		// mContext = null;
		tActivity = activity;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = super.getView(position, convertView, parent);

		switch (position) {
		case 0:
			view.setBackgroundColor(tActivity.getResources().getColor(
					R.color.Health_C));
			// view.setBackgroundColor(Color.RED);
			break;
		case 1:
			view.setBackgroundColor(tActivity.getResources().getColor(
					R.color.History_C));
			// view.setBackgroundColor(Color.GREEN);
			break;
		case 2:
			view.setBackgroundColor(tActivity.getResources().getColor(
					R.color.Computer_C));
			// view.setBackgroundColor(Color.BLUE);
			break;
		case 3:
			view.setBackgroundColor(tActivity.getResources().getColor(
					R.color.Art_C));
			// view.setBackgroundColor(Color.WHITE);
			break;
		case 4:
			view.setBackgroundColor(tActivity.getResources().getColor(
					R.color.black));
			// view.setBackgroundColor(Color.BLACK);
			break;
		}
		return view;
	}

}
