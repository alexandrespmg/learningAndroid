package ale.terceiroprojeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectedOption(String userChoise){
        ImageView appChoiceImage = findViewById(R.id.imageView);

        String[] options = {
                "Pedra",
                "Papel",
                "Tesoura"
        };

        int randomNumber = new Random().nextInt(3);
        String appChoice = options[randomNumber];

        switch (appChoice){
            case "Pedra":
                appChoiceImage.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                appChoiceImage.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                appChoiceImage.setImageResource(R.drawable.tesoura);
                break;
        }

        this.setWinner(userChoise, appChoice);

    }

    public void selectedTesoura(View view){
        this.selectedOption("Tesoura");
    }

    public void selectedPedra(View view){
        this.selectedOption("Pedra");
    }

    public void selectedPapel(View view){
        this.selectedOption("Papel");
    }

    public void setWinner(String userChoice, String appChoice){

        TextView textResult = findViewById(R.id.textResult);
        String textToDisplay;

        if( (userChoice == "Pedra" && appChoice == "Tesoura") ||
            (userChoice == "Papel" && appChoice == "Pedra") ||
            (userChoice == "Tesoura" && appChoice == "Papel")){

            textToDisplay = "Você ganhou! Parabéns :)";

            textResult.setText( textToDisplay);

        }else if((appChoice == "Pedra" && userChoice == "Tesoura") ||
                (appChoice == "Papel" && userChoice == "Pedra") ||
                (appChoice == "Tesoura" && userChoice == "Papel")){

            textToDisplay = "Você perdeu! Tente Novamente :(";

            textResult.setText( textToDisplay);

        }else{

            textToDisplay = "Vocês empataram!! :o";

            textResult.setText( textToDisplay);

        }


    }


}
