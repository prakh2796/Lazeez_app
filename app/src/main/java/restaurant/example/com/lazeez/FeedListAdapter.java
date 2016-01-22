package restaurant.example.com.lazeez;

/**
 * Created by Pewds on 20-Nov-15.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;

public class FeedListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private FeedListAdapter listAdapter;
    private List<FeedItem> feedItems;
    static Integer[] quantity = new Integer[1];

    public FeedListAdapter(Activity activity, List<FeedItem> feedItems) {
        this.activity = activity;
        this.feedItems = feedItems;
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        return feedItems.get(position).getType();
    }

    @Override
    public int getCount() {
        return feedItems.size();
    }

    @Override
    public Object getItem(int location) {
        return feedItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        int type = getItemViewType(position);
        FeedItem item = feedItems.get(position);

        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (type == 0)
        {
            convertView = inflater.inflate(R.layout.feed_item, null);

            TextView dish = (TextView) convertView.findViewById(R.id.dish);
            TextView price = (TextView) convertView.findViewById(R.id.price);
            final TextView number = (TextView) convertView.findViewById(R.id.number);
            Button dec = (Button) convertView.findViewById(R.id.decrease);
            Button inc = (Button) convertView.findViewById(R.id.increase);

            dish.setText(item.getDish());
            price.setText(String.valueOf(item.getPrice()));
            number.setText(" "+String.valueOf(item.getQuantity()));

            quantity[0] = feedItems.get(position).getQuantity();
            if(quantity[0] == 0)
            {
                dec.setEnabled(false);
            }
            else
            {
                dec.setEnabled(true);
                inc.setEnabled(true);
            }
            dec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    quantity[0] = quantity[0] - 1;
                    feedItems.get(position).setQuantity(quantity[0]);
                    number.setText(" " + String.valueOf(feedItems.get(position).getQuantity()));
                }
            });
            inc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    quantity[0] = quantity[0] + 1;
                    feedItems.get(position).setQuantity(quantity[0]);
                    number.setText(" " + String.valueOf(feedItems.get(position).getQuantity()));
                }
            });
        }


        return convertView;
    }
}
