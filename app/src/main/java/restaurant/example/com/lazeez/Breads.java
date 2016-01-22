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
public class Breads extends Activity {

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

        String[] bread = {"Plain Naan","Missi Roti","Garlic Naan","Keema Naan","Laccha Parantha","Pudina Parantha","Mirch Parantha","Onion Kulcha Parantha","Stuffed Parantha","Aloo Parantha","Aloo Oyaz Parantha","Gobi Parantha","Mix Parantha","Mix Parantha","Rumali Roti","Tandoori Roti","Butter Naan","Tawa Roti","Paneer Naan","Butter Roti"};
        Integer[] price = {20,24,32,48,24,32,40,40,40,28,32,32,40,8,10,24,10,40,12};
        listView = (ListView) findViewById(R.id.list);
//        final Button dec = (Button) findViewById(R.id.decrease);
//        final Button inc = (Button) findViewById(R.id.increase);
//        final TextView number = (TextView) findViewById(R.id.number);
        feedItems = new ArrayList<FeedItem>();
        listAdapter = new FeedListAdapter(this, feedItems);
        listView.setAdapter(listAdapter);

        for (int i = 0; i < price.length ; i++)
        {
            FeedItem item = new FeedItem();

            item.setDish(bread[i]);
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
