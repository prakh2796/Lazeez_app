package restaurant.example.com.lazeez;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Prakhar Gupta on 30/11/2015.
 */
public class Tab3 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab3, container, false);
        SharedPreferences sp = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        final SharedPreferences.Editor ed = sp.edit();
        Button b = (Button) rootView.findViewById(R.id.proceed);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),MainActivity.class);
                ed.putString("value","launch");
                startActivity(i);
                getActivity().finish();
            }
        });
        return rootView;
    }
}
