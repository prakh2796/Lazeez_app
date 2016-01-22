package restaurant.example.com.lazeez;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by Prakhar Gupta on 25/12/2015.
 */
public class Custom_Dialog extends Dialog {

    public Activity c;
    public String title,content;
    public Custom_Dialog(Activity a, String title, String content) {
        super(a);
        this.c = a;
        this.title = title;
        this.content = content;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_box);
        TextView title = (TextView) findViewById(R.id.title);
        TextView content = (TextView) findViewById(R.id.content);
        title.setText((CharSequence) title);
        title.setText((CharSequence) content);
    }

}
