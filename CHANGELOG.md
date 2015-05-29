Change Log
==========

Version 1.3 *(2015-05-29)*
----------------------------

 * Merged: Add addMoreItems(int, List<T>) to the PagingBaseAdapter.

Version 1.2 *(2014-12-28)*
----------------------------

 * Merged: PagingListView can now reload if requested. Before, after clearing the list, setting hasMoreItems to true had no
effect on reloading. This removes the item count check and re-adds the
footer view if hasMoreItems is set to true.

Version 1.1 *(2014-05-13)*
----------------------------

 * Merged: Reserve the setOnScrollListener() method for PagingListView.


Version 1.0.0 *(2014-04-15)*
----------------------------

Initial release.

