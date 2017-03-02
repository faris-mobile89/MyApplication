package abudhabi.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faris on 2/28/17.
 */

public class HomeMenuAdapter extends BaseAdapter {
    private Context context; //context
    private List<HomeMenuItem> items; //data source of the list adapter

    //public constructor
    public HomeMenuAdapter(Context context, List<HomeMenuItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_list_view_row_menu_items, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        HomeMenuItem currentItem = (HomeMenuItem) getItem(position);
        viewHolder.itemName.setText(currentItem.getTitle());
        viewHolder.imageView.setImageResource(currentItem.getImageResourceId());

        return convertView;
    }

    private class ViewHolder {
        TextView itemName;
        ImageView imageView;

        public ViewHolder(View view) {
            itemName = (TextView)view.findViewById(R.id.text_view_item_name);
            imageView = (ImageView) view.findViewById(R.id.thumb);
        }
    }
}