package ale.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView text_header = findViewById(R.id.text_header);

        Intent receivedIntent = getIntent();

        Bundle bundleReceived = receivedIntent.getExtras().getBundle("FirstActivity");
        if (bundleReceived != null){
            String text = bundleReceived.getString("text");
            text_header.setText(text);
        }else{
            finish();
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
