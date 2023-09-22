package herrero.julen.secondactivityv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ShowMessageActivity extends AppCompatActivity {

    public static final String REPLY_MESSAGE = "herrero.julen.secondactivityv2.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView jasotakoMez = findViewById(R.id.mezuaP);
        jasotakoMez.setText(message);
    }

    public void sendReply(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        EditText ans = findViewById(R.id.answerText);
        String answer = ans.getText().toString();
        intent.putExtra(REPLY_MESSAGE, answer);
        startActivity(intent);
    }
}