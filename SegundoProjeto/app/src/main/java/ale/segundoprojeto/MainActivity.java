package ale.segundoprojeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void generatePhrase(View view){
        String[] phrases = {
                "Vencedor não é aquele que sempre vence, mas sim aquele que nunca para de lutar.",
                "Às vezes você tem que levantar sozinho e seguir em frente...",
                "Não tenha medo da mudança. Coisas boas se vão para que melhores possam vir.",
                "Não chore porque acabou, sorria porque aconteceu.",
                "Nunca diga eu não consigo. Você consegue sim, basta ter força de vontade e fé.",
                "Tudo é possível. O impossível apenas demora mais...",
                "No fim tudo dá certo, e se não deu certo é porque ainda não chegou ao fim."
        };


        int randomNumber = new Random().nextInt(phrases.length);

        TextView text = findViewById(R.id.text_result);

        text.setText(phrases[randomNumber]);

    }
}
