package com.paging.listview.sample;

import android.*;
import android.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.paging.listview.PagingBaseAdapter;

/**
 * Created by nicolas on 8/25/13.
 */
public class MyPagingAdaper extends PagingBaseAdapter<String> {

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public String getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView textView;
		String text = getItem(position);

		if(convertView != null) {
			textView = (TextView)convertView;
		}else {
			textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_list_item_1, null);
		}
		textView.setText(text);
		return textView;
	}
}
