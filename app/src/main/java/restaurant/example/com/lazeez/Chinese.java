package restaurant.example.com.lazeez;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prakhar Gupta on 22/12/2015.
 */
public class Chinese extends Activity {

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

        String[] chinese = {"Chicken Garlic Noodles","Special Chicken Fried Rice","Honey Potato",
                "Chilly Chaap","Veg Noodles","Veg Fried Rice","Chilly Potato","Chilly Paneer Dry",
                "Chilly Paneer Gravy","Veg Manchurian Dry","Veg Manchurian Gravy","Chilly CHicken Dry",
                "Chilly Chicken Gravy","Chicken Manchurian Gravy","Chicken Lollypop","Drums of Heaven",
                "Veg Garlic Noodles","Honey Chilli Potato","Chilly Mushroom","Chicken Fried Rice",
                "Egg Fried Rice","Egg Noodles","Chicken Noodles","Spring Noodles","Chicken Manchurian Dry"};
        Integer[] price = {128,136,80,136,88,104,88,80,88,128,136,152,160,208,216,232,112,104,152,120,104,104,112,104,200};
        listView = (ListView) findViewById(R.id.list);
        feedItems = new ArrayList<FeedItem>();
        listAdapter = new FeedListAdapter(this, feedItems);
        listView.setAdapter(listAdapter);

        for (int i = 0; i < price.length ; i++)
        {
            FeedItem item = new FeedItem();

            item.setDish(chinese[i]);
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
