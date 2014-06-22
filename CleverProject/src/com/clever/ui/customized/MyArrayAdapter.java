package com.clever.ui.customized;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class MyArrayAdapter<T> extends ArrayAdapter<String> {

	public MyArrayAdapter(Context context, int textViewResourceId) {
		super(context, textViewResourceId);
		// TODO Auto-generated constructor stub
	}

	public MyArrayAdapter(FragmentActivity activity, int simpleListItem1,
			int text1, String[] colors) {
		// TODO Auto-generated constructor stub
		super(activity,simpleListItem1,text1,colors);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        return createViewFromResource(position, convertView, parent, mResource);
    }

}
