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
public class Main_Course_Veg extends Activity {

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

        String[] course = {"Shahi Paneer","Palak Paneer","Malai Kofta","Kadhai Paneer","Dal Makhani",
                "Mix Veg","Tawa Paneer","Paneer Lababdar","Mutter Paneer","Dal Fry","Paneer Taka Tak",
        "Kadhai Chaap","Masala Chaap","Paneer Do Pyaza","Paneer Tikka Masala","Paneer Butter Masala",
        "Mutter Mushroom","Mushroom Do Pyaza","Aloo Jeera","MutterMethi Malai","Dum Aloo","Chana Masala",
        "Shahi Chaap","Lazeez Special Paneer","Masala Paneer"};
        Integer[] price = {128,136,144,136,120,128,144,144,136,104,144,136,128,136,144,136,136,144,112,144,120,128,144,152,144};
        listView = (ListView) findViewById(R.id.list);
        feedItems = new ArrayList<FeedItem>();
        listAdapter = new FeedListAdapter(this, feedItems);
        listView.setAdapter(listAdapter);

        for (int i = 0; i < price.length ; i++)
        {
            FeedItem item = new FeedItem();

            item.setDish(course[i]);
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
