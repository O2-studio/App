package com.clever.ui.customized;

import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.clever.module.Doc;
import com.clever.ui.R;

public class ArticleViewAdapter extends ArrayAdapter<Doc> {

	private LayoutInflater inflater;
	private Context context = null;

	public ArticleViewAdapter(Context context, List<Doc> list) {
		super(context, 0, list);
		inflater = LayoutInflater.from(context);
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Doc doc = getItem(position);

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.article, null);
		}

		TextView article = (TextView) convertView
				.findViewById(R.id.article_body);
		
		
		Typeface face = Typefaces.get(context, "fonts/RobotoTTF/Roboto-Light.ttf");
		article.setTypeface(face);
		article.setText(doc.getContent());

		return convertView;
	}

}
