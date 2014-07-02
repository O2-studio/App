package com.clever.ui.fragments;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.clever.module.Doc;
import com.clever.net.communicate.GetRequest;
import com.clever.net.communicate.JsonUtils;
import com.clever.ui.R;
import com.clever.ui.customized.ArticleViewAdapter;

//Color panels on right side
@SuppressLint("ValidFragment")
public class RightContentF extends Fragment implements
		SwipeRefreshLayout.OnRefreshListener {
	private int mColorRes = -1;
	private SwipeRefreshLayout swipeLayout;
	private Handler handler;

	// private String result="";

	// ListView to contain articles.
	private ListView listView;
	// ListView adapter
	private ArticleViewAdapter adapter;
	// All articles
	private List<Doc> contentList;

	public RightContentF(int colorRes) {
		mColorRes = colorRes;
		setRetainInstance(true);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.articles, container, false);
		swipeLayout = (SwipeRefreshLayout) view
				.findViewById(R.id.swipe_refresh);
		swipeLayout.setOnRefreshListener(this);

		// top refresh style
		swipeLayout.setColorScheme(android.R.color.holo_red_light,
				android.R.color.holo_green_light,
				android.R.color.holo_blue_bright,
				android.R.color.holo_orange_light);

		contentList = new ArrayList<Doc>();
		Doc info = new Doc();
		info.setContent("a knowledge");
		contentList.add(info);
		listView = (ListView) view.findViewById(R.id.listview);
		adapter = new ArticleViewAdapter(getActivity(), contentList);
		listView.setAdapter(adapter);

		// set background color
		if (savedInstanceState != null)
			mColorRes = savedInstanceState.getInt("mColorRes");
		int color = getResources().getColor(mColorRes);
		view.setBackgroundColor(color);

		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}

	public void onRefresh() {
		// new Handler().postDelayed(new Runnable() {
		// public void run() {
		//
		// swipeLayout.setRefreshing(false);
		// Doc info = new Doc();
		// info.setContent("another knowledge");
		// contentList.add(info);
		// adapter.notifyDataSetChanged();
		// }
		// }, 500);

		handler = new Handler() {
			public void handleMessage(Message msg) {

				int msgCode = msg.what;
				String recentDoc = msg.getData().getString("recentDoc");
				if (msgCode == 0x101 && recentDoc != "") {
					List<Doc> docs = JsonUtils.parseDocs(recentDoc);
					for (Doc doc : docs) {
						contentList.add(doc);
					}
					adapter.notifyDataSetChanged();

					swipeLayout.setRefreshing(false);
				}
				super.handleMessage(msg);
			}
		};

		GetRequest get = new GetRequest(handler);
		Thread thread = new Thread(get);
		thread.start();
	}
}
