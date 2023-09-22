package herrero.julen.secondactivityv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "herrero.julen.secondactivityv2.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String rep = intent.getStringExtra(ShowMessageActivity.REPLY_MESSAGE);

        TextView replyTit = findViewById(R.id.ansTitle);
        TextView replyMsg = findViewById(R.id.replyText);
        replyMsg.setText(rep);

        if (replyMsg.getText().equals("")) {
            replyTit.setText("");
        } else {
            replyTit.setText("Reply Received");
        }
    }
    public void sendMessage(View view) {

        Intent intent = new Intent(this, ShowMessageActivity.class);
        EditText msg = findViewById(R.id.messageInput);
        String message = msg.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}