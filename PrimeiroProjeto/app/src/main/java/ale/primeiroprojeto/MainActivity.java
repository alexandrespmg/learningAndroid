package ale.primeiroprojeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void requestResult(View view){
        TextView player1View = findViewById(R.id.jogo1);
        TextView player2View = findViewById(R.id.jogo2);

        int player1Value = Integer.parseInt(player1View.getText().toString());
        int player2Value = Integer.parseInt(player2View.getText().toString());

        int randomValue = (int)(Math.random() * 10) + 1;

        this.printValue(player1Value,player2Value, randomValue );

    }


    public void printValue(int value1, int value2, int value3){
        TextView textResult = findViewById(R.id.resultado);

        int diff1 = Math.abs(value1 - value3);
        int diff2 = Math.abs(value2 - value3);
        String winner;

        if (diff1 < diff2){
            winner = "Jogador 1";
        }else if (diff1 == diff2){
            winner = "Empate";
        }else{
            winner = "Jogador 2";
        }
        String result = "Valor sorteado: " + Integer.toString(value3) + " Vencedor: " + winner;
        textResult.setText(result);


    }
}
