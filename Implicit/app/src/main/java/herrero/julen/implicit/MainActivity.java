package herrero.julen.implicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bilatuLekua = findViewById(R.id.lekuButton);

        bilatuLekua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText lekuStr = findViewById(R.id.locName);
                String herria = lekuStr.getText().toString();
                String urlOsoa = "http://maps.google.com/maps?q=" + herria;

                Uri getLoc = Uri.parse(urlOsoa);
                Intent intent = new Intent(Intent.ACTION_VIEW, getLoc);

                Log.d("URL_DEBUG", getLoc.toString());

                startActivity(intent);

                // Hau da errorea, ez du funtzionatzen bloke honekin. Zuzenean activitya hasi
                /*if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }*/
            }
        });

        Button partekatu = findViewById(R.id.shareButton);

        partekatu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                EditText partekatuTxt = findViewById(R.id.shareTxt);
                String testua = partekatuTxt.getText().toString();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, testua);
                intent.setType("text/plain");

                Intent prt = Intent.createChooser(intent, null);
                startActivity(prt);

            }
        });
    }
    public void openWeb(View view) {

        EditText webOrria = findViewById(R.id.urlStr);
        Button bilatuWb = findViewById(R.id.findUrl);
        String weba = webOrria.getText().toString();

        Uri web = Uri.parse(weba);
        Intent intent = new Intent(Intent.ACTION_VIEW, web);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}