package com.example.yashkrishan.saafpaani;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView3;
    Button button90;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        button90 = (Button)findViewById(R.id.buty);
        textView1 = (TextView) findViewById(R.id.to);
        textView2 = (TextView)findViewById(R.id.too);
        textView3 = (TextView)findViewById(R.id.para);
        textView3.setText("Can cause severe skin diseases." + " \n" + "Negative impact on reproductive processes."+" \n"
                + "Can cause hypertension; and diabetes.");
        textView1.setText("Location: Gariyaband");
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "http://maps.google.com/maps/search/?api=1&query=" + "Gariyaband";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
        textView2.setText("Location Rajnandgaon");
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "http://maps.google.com/maps/search/?api=1&query=" + "Rajnandgaon";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
        button90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ki = new Intent(Details.this, Details1.class);
                startActivity(ki);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent ko = new Intent(Details.this, ContaminationAllert.class);
                startActivity(ko);
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Intent ki = new Intent(Details.this, Details1.class);
                startActivity(ki);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
