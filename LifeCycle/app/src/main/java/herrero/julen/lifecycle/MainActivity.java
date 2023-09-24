package herrero.julen.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        showToast("Activity has been started");
    }

    @Override
    protected void onResume() {
        super.onResume();

        showToast("Activity has been resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();

        showToast("Activity has beem paused");
    }

    @Override
    protected void onStop() {
        super.onStop();

        showToast("Activity has been stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        showToast("Activity has been destroyed");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}