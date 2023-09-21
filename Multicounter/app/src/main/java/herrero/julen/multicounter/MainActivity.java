package herrero.julen.multicounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int kontuGlobala, kontuBat, kontuBi, kontuHiru, kontuLau;

    // Testu eta botoiak deklaratu banan banan
    TextView totala;
    Button resetGlobala;

    TextView batCount;
    Button batGehi;
    Button batReset;

    TextView biCount;
    Button biGehi;
    Button biReset;

    TextView hiruCount;
    TextView hiruGehi;
    Button hiruReset;

    TextView lauCount;
    Button lauGehi;
    Button lauReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Elementu bakoitzari bere ID-a izendatu

        // Panel orokorra
        totala = findViewById(R.id.countTotal);
        resetGlobala = findViewById(R.id.resetGeneral);

        // lehen panela
        batCount = findViewById(R.id.batPanelText);
        batGehi = findViewById(R.id.batPanelGehitu);
        batReset = findViewById(R.id.batPanelReset);

        // bigarren panela
        biCount = findViewById(R.id.biPanelText);
        biGehi = findViewById(R.id.biPanelGehitu);
        biReset = findViewById(R.id.biPanelReset);

        // hirugarren panela
        hiruCount = findViewById(R.id.hiruPanelText);
        hiruGehi = findViewById(R.id.hiruPanelGehitu);
        hiruReset = findViewById(R.id.hiruPanelReset);

        // laugarren panela
        lauCount = findViewById(R.id.lauPanelText);
        lauGehi = findViewById(R.id.lauPanelGehitu);
        lauReset = findViewById(R.id.lauPanelReset);

        batGehi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kontuBat++;
                batCount.setText(String.valueOf(kontuBat));
                kontuGlobala = kontuBat + kontuBi + kontuHiru + kontuLau;
                totala.setText(String.valueOf(kontuGlobala));
            }
        });

        batReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kontuBat = 0;
                kontuGlobala = kontuBat + kontuBi + kontuHiru + kontuLau;
                batCount.setText("0");
                totala.setText(String.valueOf(kontuGlobala));
            }
        });

        biGehi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kontuBi++;
                biCount.setText(String.valueOf(kontuBi));
                kontuGlobala = kontuBat + kontuBi + kontuHiru + kontuLau;
                totala.setText(String.valueOf(kontuGlobala));
            }
        });

        biReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kontuBi = 0;
                kontuGlobala = kontuBat + kontuBi + kontuHiru + kontuLau;
                biCount.setText("0");
                totala.setText(String.valueOf(kontuGlobala));
            }
        });

        hiruGehi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kontuHiru++;
                hiruCount.setText(String.valueOf(kontuHiru));
                kontuGlobala = kontuBat + kontuBi + kontuHiru + kontuLau;
                totala.setText(String.valueOf(kontuGlobala));
            }
        });

        hiruReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kontuHiru = 0;
                kontuGlobala = kontuBat + kontuBi + kontuHiru + kontuLau;
                hiruCount.setText("0");
                totala.setText(String.valueOf(kontuGlobala));
            }
        });

        lauGehi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kontuLau++;
                lauCount.setText(String.valueOf(kontuLau));
                kontuGlobala = kontuBat + kontuBi + kontuHiru + kontuLau;
                totala.setText(String.valueOf(kontuGlobala));
            }
        });

        lauReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kontuLau = 0;
                kontuGlobala = kontuBat + kontuBi + kontuHiru + kontuLau;
                lauCount.setText("0");
                totala.setText(String.valueOf(kontuGlobala));
            }
        });
    }
}