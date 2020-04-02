package cat.udl.urbandapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;

import cat.udl.urbandapp.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    Button registerButton;
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerButton = findViewById(R.id.register);
        username = findViewById(R.id.usertel);
        password = findViewById(R.id.userpassword);

        userViewModel = new UserViewModel(this.getApplication());


        //@TODO: Despúes de un login correcto tienes que volver al login.
        //@TODO: El usuario tiene que saber que ha hecho un login correcto.
        //@TODO: Arreglar la funcionalidad para que se muestre el TOAST.
        registerButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                String _username = username.getText().toString();
                String _password = password.getText().toString();
                if(_username != "" && _password != ""){

                    userViewModel.registerUser(_username,_password);
                }
                else{
                    Toast.makeText(MainActivity.this, "rellena los cmapos de registro!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
