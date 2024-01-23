package ba.sum.fpmoz.traveltoday.activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import java.io.IOException;
import java.util.UUID;
import ba.sum.fpmoz.traveltoday.R;
import ba.sum.fpmoz.traveltoday.models.Destination;

public class AddDestinationActivity extends AppCompatActivity {

    FirebaseAuth auth;

    Button selectImageBtn;
    EditText editTextDestinationName, editTextDescription;
    TextView tvBack;
    ImageView imagePreview, imgBack;

    FirebaseStorage storage;
    FirebaseUser user;
    StorageReference storageReference;
    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance("https://traveltodayapp-fffaf-default-rtdb.europe-west1.firebasedatabase.app/");

    Uri filePath;
    String destinationImage;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_destination);
        this.selectImageBtn = findViewById(R.id.selectImageBtn);
        this.editTextDestinationName = findViewById(R.id.editTextDestinationName);
        this.editTextDescription = findViewById(R.id.editTextDescription);
        this.imagePreview = findViewById(R.id.imagePreview);
        this.imgBack = findViewById(R.id.imgBack);
        this.tvBack = findViewById(R.id.tvBack);
        this.auth = FirebaseAuth.getInstance();
        this.user = auth.getCurrentUser();

        this.storage = FirebaseStorage.getInstance();
        this.storageReference = this.storage.getReference();

        selectImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });


        Button destinationSaveBtn = findViewById(R.id.btnSaveDestination);

        DatabaseReference destinationReference = mDatabase.getReference("destination");

        destinationSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextDestinationName.getText().toString();
                String about = editTextDescription.getText().toString();
                Destination m = new Destination(name, about, destinationImage);
                destinationReference.child(user.getUid()).child(name.toString()).setValue(m);
                Intent i = new Intent(AddDestinationActivity.this, AdminBottomBarActivity.class);
                startActivity(i);
            }
        });

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminBottomBarActivity.class);
                startActivity(intent);
                finish();
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminBottomBarActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 22 &&
                resultCode == RESULT_OK &&
                data != null &&
                data.getData() != null) {
            this.filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imagePreview.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void selectImage() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(i, "Pick an image "), 22
        );
    }

    private void uploadImage() {
        if (filePath != null) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Image loading...");
            progressDialog.show();
            StorageReference ref = storageReference.child("images/"
                    + UUID.randomUUID().toString()
            );
            ref.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    progressDialog.hide();
                    Toast.makeText(
                            getApplicationContext(),
                            "Image has been imported!",
                            Toast.LENGTH_LONG).show();
                    ref.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {
                            destinationImage = task.getResult().toString();
                        }
                    });
                }
            });
        }
    }
}