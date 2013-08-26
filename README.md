PagingListView
==============

PagingListView has the ability to add more items on it like Gmail does. Basically is a ListView with the ability to add more items on it when reaches the end of the list.<br>
While "pull to refresh" pattern works at the top of the List and show the latest added items, the PagingListView works at the bottom of the List and shows the first added items.﻿


Instructions 1
============

1. Clone the git repo
2. Import the "PagingListView" module into your Android-gradle project.
3. Add "PagingListView" module in your settings.gradle
4. DONE


Instructions 2
============

1. Add Nicolas Jafelle's Maven repo to your build.gradle
2. add this dependency: 'com.paginglistview:paging-listview:1.0'
3. DONE


How to Use it
================

Simple create your PagingAdapter and add it to com.paging.listview.PagingListView.<br>
You have to implements the new Pagingable interface and its onLoadMoreItems() method. For example:<br>
``` java
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
```

Finally you can use the onFinishLoading(boolean hasMoreItems, List newItems) method to update the list.
``` java
listView.onFinishLoading(true, newItems);
```
Also remember to use this package in your layout files: 

	<com.paging.listview.PagingListView
        	android:id="@+id/paging_list_view"
        	android:layout_width="match_parent"
        	android:layout_height="match_parent"/>


Developed By
================

* Nicolas Jafelle - <nicolasjafelle@gmail.com>


License
================

    Copyright 2013 Nicolas Jafelle

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
