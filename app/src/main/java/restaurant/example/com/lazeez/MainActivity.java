package restaurant.example.com.lazeez;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Prakhar Gupta on 21/12/2015.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = (ListView) findViewById(R.id.listView);
        String[] category = getResources().getStringArray(R.array.category);
        final ArrayAdapter<String>aa = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,category);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = (String)aa.getItem(position);
                try {
                    Class myclass = Class.forName("restaurant.example.com.lazeez."+value);
                    Intent intent = new Intent(MainActivity.this,myclass);
                    intent.putExtra("option",value);
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}

