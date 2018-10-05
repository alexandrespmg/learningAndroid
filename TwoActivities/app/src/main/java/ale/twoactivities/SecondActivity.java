package ale.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView receivedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        receivedTextView = findViewById(R.id.receivedTextView);

        Intent receivedIntent = getIntent();

        String msgReceived = receivedIntent.getStringExtra("FirstActivity");

        receivedTextView.setText(msgReceived);



    }

    public void sendReply(View view) {

        EditText etextReply = findViewById(R.id.text_reply);
        String textReply = etextReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra("reply", textReply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
