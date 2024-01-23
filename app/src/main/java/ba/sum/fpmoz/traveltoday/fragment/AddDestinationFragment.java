package ba.sum.fpmoz.traveltoday.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

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
import ba.sum.fpmoz.traveltoday.activity.AdminBottomBarActivity;
import ba.sum.fpmoz.traveltoday.models.Destination;

public class AddDestinationFragment extends Fragment {

    private FirebaseAuth auth;
    private FirebaseUser user;

    private Button selectImageBtn;
    private EditText editTextDestinationName, editTextDescription;
    private ImageView imagePreview;
    private TextView tvBack;

    private FirebaseStorage storage;
    private StorageReference storageReference;
    private FirebaseDatabase mDatabase;

    private Uri filePath;
    private String destinationImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_destination, container, false);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        mDatabase = FirebaseDatabase.getInstance("https://traveltodayapp-fffaf-default-rtdb.europe-west1.firebasedatabase.app/");

        selectImageBtn = view.findViewById(R.id.selectImageBtn);
        editTextDestinationName = view.findViewById(R.id.editTextDestinationName);
        editTextDescription = view.findViewById(R.id.editTextDescription);
        imagePreview = view.findViewById(R.id.imagePreview);
        tvBack = view.findViewById(R.id.tvBack);

        selectImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });

        Button destinationSaveBtn = view.findViewById(R.id.btnSaveDestination);

        DatabaseReference destinationReference = mDatabase.getReference("destination");

        destinationSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextDestinationName.getText().toString();
                String about = editTextDescription.getText().toString();
                Destination m = new Destination(name, about, destinationImage);
                destinationReference.child(user.getUid()).child(name).setValue(m);
                Intent i = new Intent(requireContext(), AdminBottomBarActivity.class);
                startActivity(i);
            }
        });

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), AdminBottomBarActivity.class);
                startActivity(intent);
                requireActivity().finish();
            }
        });

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 22 &&
                resultCode == getActivity().RESULT_OK &&
                data != null &&
                data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireContext().getContentResolver(), filePath);
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
        startActivityForResult(Intent.createChooser(i, "Pick an image "), 22);
    }

    private void uploadImage() {
        if (filePath != null) {
            ProgressDialog progressDialog = new ProgressDialog(requireContext());
            progressDialog.setTitle("Image loading...");
            progressDialog.show();
            StorageReference ref = storageReference.child("images/" + UUID.randomUUID().toString());
            ref.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    progressDialog.hide();
                    Toast.makeText(requireContext(), "Image has been imported!", Toast.LENGTH_LONG).show();
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
