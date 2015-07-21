package com.paging.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


public class LoadingView extends LinearLayout {

    public ProgressBar  progressBar;
    public TextView     loadingLabel;

    public LoadingView(Context context) {
        super(context);
        init();
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        View view = inflate(getContext(), R.layout.loading_view, this);

        progressBar = (ProgressBar) view.findViewById(R.id.video_item_image);
        loadingLabel = (TextView) view.findViewById(R.id.video_item_label);
    }


}
