package abudhabi.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import abudhabi.com.myapplication.widget.CircularListView;
import abudhabi.com.myapplication.widget.CircularListViewContentAlignment;
import abudhabi.com.myapplication.widget.CircularListViewListener;

public class MainActivity extends Activity {

    private CircularListView mCircularListView;
    private boolean mIsAdapterDirty = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCircularListView = (CircularListView) findViewById(R.id.circularListView);

        List<HomeMenuItem> items = new ArrayList<>();
        items.add(new HomeMenuItem("tewet1", R.drawable.dash_arc1));
        items.add(new HomeMenuItem("tewet2", R.drawable.dash_arc1));
        items.add(new HomeMenuItem("tewet3", R.drawable.dash_arc1));
        items.add(new HomeMenuItem("tewet4", R.drawable.dash_arc1));
        items.add(new HomeMenuItem("tewet5", R.drawable.dash_arc1));
        items.add(new HomeMenuItem("tewet6", R.drawable.dash_arc1));
        items.add(new HomeMenuItem("tewet7", R.drawable.dash_arc1));
        items.add(new HomeMenuItem("tewet8", R.drawable.dash_arc1));
        items.add(new HomeMenuItem("tewet9", R.drawable.dash_arc1));
        items.add(new HomeMenuItem("tewet10", R.drawable.dash_arc1));
        items.add(new HomeMenuItem("tewet11", R.drawable.dash_arc1));
        items.add(new HomeMenuItem("tewet12", R.drawable.dash_arc1));
        HomeMenuAdapter adapter = new HomeMenuAdapter(this, items);

        Display display = getWindowManager().getDefaultDisplay();
        mCircularListView.setRadius(Math.min(450, display.getWidth() / 2));
        mCircularListView.setAdapter(adapter);
        mCircularListView.scrollFirstItemToCenter();

        mCircularListView.setCircularListViewListener(new CircularListViewListener() {
            @Override
            public void onCircularLayoutFinished(CircularListView circularListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                refreshCircular();
            }
        });
        mCircularListView.setCircularListViewContentAlignment(CircularListViewContentAlignment.Left);
    }

    void refreshCircular() {
        if (mIsAdapterDirty) {
            mCircularListView.scrollFirstItemToCenter();
            mIsAdapterDirty = false;
        }
    }


}