package restaurant.example.com.lazeez;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prakhar Gupta on 22/12/2015.
 */
public class Tikka_Roll extends Activity {

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

        String[] roll = {"Oaneer Tikka Roll","Chicken Tikka Roll","Kali Mirch CHicken Tikka Roll","Chicken Seekh Roll","Malai Chaap Roll","Mutton Seek Roll","Tandoori Chaap Roll"};
        Integer[] price = {80,104,120,80,88,88,80};
        listView = (ListView) findViewById(R.id.list);
        feedItems = new ArrayList<FeedItem>();
        listAdapter = new FeedListAdapter(this, feedItems);
        listView.setAdapter(listAdapter);

        for (int i = 0; i < price.length ; i++)
        {
            FeedItem item = new FeedItem();

            item.setDish(roll[i]);
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
    }

}
