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
public class Thali extends Activity {

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

        String[] thali = {"Veg Thali","Non-Veg Thali"};
        Integer[] price = {160,190};
        listView = (ListView) findViewById(R.id.list);
        feedItems = new ArrayList<FeedItem>();
        listAdapter = new FeedListAdapter(this, feedItems);
        listView.setAdapter(listAdapter);

        for (int i = 0; i < price.length ; i++)
        {
            FeedItem item = new FeedItem();

            item.setDish(thali[i]);
            item.setPrice(price[i]);
            item.setType(0);
            feedItems.add(item);
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                String content ;

                String dish = feedItems.get(position).getDish();
                Integer price = feedItems.get(position).getPrice();
                Integer quantity = feedItems.get(position).getQuantity();
                content = "VEG";

//                if(dish == "Veg Thali")
//                {
//                    content = "VEG";
//                }
//                else
//                {
//                    content = "NON VEG";
//                }
                Custom_Dialog cd = new Custom_Dialog(Thali.this,dish,content);
                cd.show();

            }
        });
    }

}
