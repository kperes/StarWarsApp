package com.batista.kleyton.starwarsapp.Usuario;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.batista.kleyton.starwarsapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CadastrarActivity extends AppCompatActivity {

    private EditText emailCadastro;
    private EditText senhaCadastro;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        emailCadastro = findViewById(R.id.edt_email_cadastro);
        senhaCadastro = findViewById(R.id.edt_senha_cadastro);

        auth = FirebaseAuth.getInstance();

    }

    public void cadastrarUsuario(View view) {

        String email = emailCadastro.getText().toString().trim();
        String senha = senhaCadastro.getText().toString();

        auth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            Toast.makeText(CadastrarActivity.this, "Cadastrado com  sucesso!", Toast.LENGTH_SHORT).show();
                        } else {
                            String resposta = task.getException().toString();
                            Toast.makeText(CadastrarActivity.this, resposta, Toast.LENGTH_SHORT).show();
                        }


                    }
                });
    }
}
