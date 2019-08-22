package com.example.appbbva;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText edtemail;
    private EditText edtpass;
    private ProgressDialog progressDialog;
    private Button btn1;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        edtemail = (EditText)findViewById(R.id.edtusuario);
        edtpass = (EditText)findViewById(R.id.edtpassword);

        btn1 =  (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mAuth.signInWithEmailAndPassword(edtemail.getText().toString(), edtpass.getText().toString())
                        .addOnCompleteListener( MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    Toast.makeText(MainActivity.this,"Bienvenido" ,Toast.LENGTH_LONG).show();
                                    Intent act =new Intent(getApplicationContext(),Main2Activity.class);
                                    startActivity(act);
                                } else {
                                    // If sign in fails, display a message to the user.
                                   edtemail.setText("");
                                   edtpass.setText("");
                                    Toast.makeText(MainActivity.this,"Ingresó mal su contraseña o password" ,Toast.LENGTH_LONG).show();

                                }

                                // ...
                            }
                        });

            }
        });
    }


}
