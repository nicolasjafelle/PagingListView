package com.paging.listview.sample;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;

import com.paging.listview.PagingBaseAdapter;
import com.paging.listview.PagingListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

	private PagingListView listView;
	private MyPagingAdaper adapter;

	private List<String> firstList;
	private List<String> secondList;
	private List<String> thirdList;

	private int pager = 0;

	private ProgressDialog loadingDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (PagingListView) findViewById(R.id.paging_list_view);
		adapter = new MyPagingAdaper();

		initData();
		createProgressDialog();

		listView.setHasMoreItems(true);
		listView.setPagingableListener(new PagingListView.Pagingable() {
			@Override
			public void onLoadMoreItems() {
				if(pager < 3) {
					new CountryAsyncTask(false).execute();
				}else {
					listView.onFinishLoading(false, null);
				}
			}
		});
	}

	public void createProgressDialog() {
		loadingDialog = new ProgressDialog(this);
		loadingDialog.setIndeterminate(true);
		loadingDialog.setMessage(getString(R.string.loading_countries));
	}

	private void clearData() {
		if(listView.getAdapter() != null) {
			pager = 0;
			adapter = (MyPagingAdaper)((HeaderViewListAdapter)listView.getAdapter()).getWrappedAdapter();
			adapter.removeAllItems();
			listView = null;
			listView = (PagingListView) findViewById(R.id.paging_list_view);
			adapter = new MyPagingAdaper();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.options_menu, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.start_demo:
				clearData();
				new CountryAsyncTask(true).execute();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}



	private void initData() {
		firstList = new ArrayList<String>();
		firstList.add("Afghanistan");
		firstList.add("Albania");
		firstList.add("Algeria");
		firstList.add("Andorra");
		firstList.add("Angola");
		firstList.add("Antigua and Barbuda");
		firstList.add("Argentina");
		firstList.add("Armenia");
		firstList.add("Aruba");
		firstList.add("Australia");
		firstList.add("Austria");
		firstList.add("Azerbaijan");

		secondList = new ArrayList<String>();
		secondList.add("Bahamas, The");
		secondList.add("Bahrain");
		secondList.add("Bangladesh");
		secondList.add("Barbados");
		secondList.add("Belarus");
		secondList.add("Belgium");
		secondList.add("Belize");
		secondList.add("Benin");
		secondList.add("Bhutan");
		secondList.add("Bolivia");
		secondList.add("Bosnia and Herzegovina");
		secondList.add("Botswana");
		secondList.add("Brazil");
		secondList.add("Brunei");
		secondList.add("Bulgaria");
		secondList.add("Burkina Faso");
		secondList.add("Burma");
		secondList.add("Burundi");

		thirdList = new ArrayList<String>();
		thirdList.add("Denmark");
		thirdList.add("Djibouti");
		thirdList.add("Dominica");
		thirdList.add("Dominican Republic");
	}


	private class CountryAsyncTask extends SafeAsyncTask<List<String>> {
		private boolean showLoading;
		public CountryAsyncTask(boolean showLoading) {
			this.showLoading = showLoading;
		}

		@Override
		protected void onPreExecute() throws Exception {
			super.onPreExecute();
			if(showLoading) {
				loadingDialog.show();
			}
		}

		@Override
		public List<String> call() throws Exception {
			List<String> result = null;
			switch(pager) {
				case 0:
					result = firstList;
				break;
				case 1:
					result = secondList;
				break;
				case 2:
					result = thirdList;
				break;
			}
			Thread.sleep(3000);
			return result;
		}

		@Override
		protected void onSuccess(List<String> newItems) throws Exception {
			super.onSuccess(newItems);
			pager++;
			if(listView.getAdapter() == null) {
				listView.setAdapter(adapter);
			}
			listView.onFinishLoading(true, newItems);
		}

		@Override
		protected void onFinally() throws RuntimeException {
			super.onFinally();
			if(loadingDialog.isShowing()) {
				loadingDialog.dismiss();
			}
		}
	}

}
