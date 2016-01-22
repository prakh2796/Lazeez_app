package restaurant.example.com.lazeez;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prakhar Gupta on 22/12/2015.
 */
public class Rice extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView listView;
    private FeedListAdapter listAdapter;
    private List<FeedItem> feedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dish_list);
        TextView tv = (TextView) findViewById(R.id.option);
        Intent intent = getIntent();
        String option = intent.getExtras().getString("option");
        tv.setText(option);

        String[] rice = {"Chicken Biryani Hyderabadi","Veg Pulao","Jeera Rice","Egg Biryani","Plain Rice","Peas Rice","Mutton Biryani Hyderabadi","Veg Biryani"};
        Integer[] price = {152,104,96,102,80,104,168,128};
        listView = (ListView) findViewById(R.id.list);
        feedItems = new ArrayList<FeedItem>();
        listAdapter = new FeedListAdapter(this, feedItems);
        listView.setAdapter(listAdapter);

        for (int i = 0; i < price.length ; i++)
        {
            FeedItem item = new FeedItem();

            item.setDish(rice[i]);
            item.setPrice(price[i]);
            item.setType(0);
            feedItems.add(item);
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                String dish = feedItems.get(position).getDish();
                Integer price = feedItems.get(position).getPrice();
                Integer quantity = feedItems.get(position).getQuantity();
            }
        });

        listAdapter.notifyDataSetChanged();
    }

}
