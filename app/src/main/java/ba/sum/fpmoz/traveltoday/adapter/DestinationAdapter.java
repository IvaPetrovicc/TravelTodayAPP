package ba.sum.fpmoz.traveltoday.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import ba.sum.fpmoz.traveltoday.R;
import ba.sum.fpmoz.traveltoday.models.Destination;

public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.MyViewHolder> {

    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance("https://traveltodayapp-fffaf-default-rtdb.europe-west1.firebasedatabase.app/");
    private final Context context;
    private final ArrayList<Destination> list;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Destination destination);
    }

    public DestinationAdapter(Context context, ArrayList<Destination> list, OnItemClickListener listener, String user) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.destination_entry, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Destination destination = list.get(position);
        holder.destination.setText(destination.getName());

        if (context != null) {
            Glide.with(context)
                    .load(destination.getImage())
                    .placeholder(R.drawable.picture)
                    .into(holder.destinationImage);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        FirebaseAuth auth;
        FirebaseUser user;
        TextView destination;
        Button editBtn;
        Button deleteBtn;
        ImageView destinationImage;

        DatabaseReference destinationReference = mDatabase.getReference("destination");


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            destination = itemView.findViewById(R.id.textName);
            destinationImage = itemView.findViewById(R.id.destinationImage);
            editBtn = itemView.findViewById(R.id.btnEditDestination);
            deleteBtn = itemView.findViewById(R.id.btnDeleteDestination);
            auth = FirebaseAuth.getInstance();
            user = auth.getCurrentUser();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemClick(list.get(position));
                    }
                }
            });


            editBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });




            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        Destination destination = list.get(position);

                        AlertDialog.Builder builder = new AlertDialog.Builder(context);

                        builder.setMessage("Are you sure you want to delete this item?")
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                        if (context != null) {

                                            destinationReference.child(user.getUid()).child(destination.getName().toString()).removeValue()
                                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                        @Override
                                                        public void onSuccess(Void aVoid) {
                                                            // Provide feedback to the user (optional)
                                                            Toast.makeText(context, "Destination deleted successfully", Toast.LENGTH_SHORT).show();
                                                        }
                                                    })
                                                    .addOnFailureListener(new OnFailureListener() {
                                                        @Override
                                                        public void onFailure(@NonNull Exception e) {
                                                            // Provide feedback to the user (optional)
                                                            Toast.makeText(context, "Failed to delete destination", Toast.LENGTH_SHORT).show();
                                                        }
                                                    });



                                        }
                                        dialogInterface.dismiss();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                })
                                .show();
                    }
                }
            });
        }
    }
}