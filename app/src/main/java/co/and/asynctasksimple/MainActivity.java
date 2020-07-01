package co.and.asynctasksimple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Trace;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Comunication {
   public EditText etName,etPassword;
   public Button btOkay;
   public ProgressBar progressBar;
    AsyncTaskUSer asyncTaskuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        btOkay = findViewById(R.id.btOk);
        progressBar = findViewById(R.id.progressBar);

        btOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncTaskUSer(MainActivity.this).execute(etName.getText().toString(),
                        etPassword.getText().toString(),3000);
            }
        });
    }


    @Override
    public void progressBar(Boolean status) {
        if(status){
            progressBar.setVisibility(View.VISIBLE);
        }else {
            progressBar.setVisibility(View.GONE);
        }

    }

    @Override
    public void launchActivity(Class<?> kindActivity) {
        Intent mIntent = new Intent (this,kindActivity);
        mIntent.putExtra("user",etName.getText().toString());
        startActivity(mIntent);

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, "Information: "+ message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void visibleButton(Boolean visible) {
        if(visible){
            btOkay.setEnabled(true);
        }else{
            btOkay.setEnabled(false);
        }
    }
}