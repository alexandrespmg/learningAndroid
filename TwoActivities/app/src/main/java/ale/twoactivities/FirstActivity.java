package ale.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {
    private EditText editText;
    private static int TEXT_REQUEST = 1;
    private TextView replyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        editText = findViewById(R.id.editText_Main);
        replyTextView = findViewById(R.id.textViewReply);
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        String msg = editText.getText().toString();

        intent.putExtra("FirstActivity", msg);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == TEXT_REQUEST){
            if (resultCode == RESULT_OK){
                String replyText = intent.getStringExtra("reply");
                replyTextView.setText(replyText);
                replyTextView.setVisibility(View.VISIBLE);
            }

        }


    }
}
