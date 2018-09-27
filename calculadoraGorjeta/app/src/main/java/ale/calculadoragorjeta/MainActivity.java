package ale.calculadoragorjeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText inputValue;
    private SeekBar inputBar;
    private TextView gorjetaText;
    private TextView totalText;
    private TextView percentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inputBar = findViewById(R.id.inputBar);
        this.inputValue = findViewById(R.id.inputValue);
        this.gorjetaText = findViewById(R.id.gorjetaText);
        this.totalText = findViewById(R.id.totalText);
        this.percentText = findViewById(R.id.percentText);

        this.wakeUpBar();
    }

    private void wakeUpBar() {
        inputBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String inputValueText = inputValue.getText().toString();
                if (inputValueText.equals("")){
                    inputValueText = "0";
                }
                double userValue = Double.parseDouble(inputValueText);
                double percentValue = (double) progress/ 100;
                String percentValueText = Double.toString(Math.round(percentValue * 100)) + "%";

                double tipValue = (double) Math.round(userValue * percentValue * 100)/ 100;
                String tipText = "R$ " + Double.toString( tipValue );

                double totalValue = userValue + tipValue;
                String totalValueText = "R$ " + Double.toString(totalValue);

                gorjetaText.setText(tipText);
                totalText.setText(totalValueText);
                percentText.setText(percentValueText);



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


}
