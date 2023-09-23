package herrero.julen.implicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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
                String herria = lekuStr.getText().toString(); // lekuaren izena jaso
                // Lekuaren izena maps-eko url-arekin konkatenatu
                String urlOsoa = "http://maps.google.com/maps?q=" + herria;

                Uri getLoc = Uri.parse(urlOsoa); // url-a sortu
                Intent intent = new Intent(Intent.ACTION_VIEW, getLoc); // intent-a sortu

                Log.d("URL_DEBUG", getLoc.toString()); // url-aren debug-a

                startActivity(intent); // activity-a hasi

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
                String testua = partekatuTxt.getText().toString(); // partekatuko den testua lortu

                Intent intent = new Intent(); // intent berria sortu
                intent.setAction(Intent.ACTION_SEND); // akzioa ezarri
                intent.putExtra(Intent.EXTRA_TEXT, testua); // testua extra moduan ezarri
                intent.setType("text/plain"); // tipoa ezarri

                Intent prt = Intent.createChooser(intent, null);
                startActivity(prt); // activity-a hasi
            }
        });
    }
    public void openWeb(View view) {

        EditText webOrria = findViewById(R.id.urlStr);
        Button bilatuWb = findViewById(R.id.findUrl);
        String weba = webOrria.getText().toString(); // web orriaren url-a lortu

        Uri web = Uri.parse(weba); // url-a kargatu
        Intent intent = new Intent(Intent.ACTION_VIEW, web); // intent-a sortu

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent); // activity-a hasi
        }
    }
}