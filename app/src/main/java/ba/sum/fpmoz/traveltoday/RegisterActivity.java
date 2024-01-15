package ba.sum.fpmoz.traveltoday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private TextView textViewLogin;
    private EditText editTextFirstName, editTextEmail, editTextPassword, editTextConfirmPassword;
    private Button buttonSignIn;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textViewLogin = findViewById(R.id.textViewLogin);
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        buttonSignIn = findViewById(R.id.buttonSignIn);
        auth = FirebaseAuth.getInstance();


        textViewLogin.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        });

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextFirstName.getText().toString().trim();
                String user = editTextEmail.getText().toString().trim();
                String pass = editTextPassword.getText().toString().trim();
                String confPass = editTextConfirmPassword.getText().toString().trim();
                if (name.isEmpty()) {
                    editTextFirstName.setError("First name can't be empty");
                }
                if (user.isEmpty()) {
                    editTextEmail.setError("Email can't be empty");
                }
                if (pass.isEmpty()) {
                    editTextPassword.setError("Password can't be empty");
                }
                if (confPass.isEmpty()) {
                    editTextConfirmPassword.setError("Confirm password can't be empty");
                }
                if (!pass.equals(confPass)) {

                    Toast.makeText(RegisterActivity.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();

                } else {
                    auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                            } else {
                                Toast.makeText(RegisterActivity.this, "Registration failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
