package org.coursera.org.coursera.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.widget.Toast;

import org.coursera.mypentagram.PetDetails;
import org.coursera.mypentagram.Pets;
import org.coursera.mypentagram.R;

import java.util.ArrayList;

/**
 * Created by TouxStudio on 07/03/2017.
 */

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.VhPets> {

        public PetAdapter(ArrayList<Pets> pets, Activity activity){
            this.pets = pets;
            this.activity = activity;
        }

    ArrayList<Pets> pets;
    Activity activity;



    //INFLAR LAYOUT Y PASARA AL VIEW HOLDER PARA OBTENER VIEWS
    @Override
    public VhPets onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.petcardview, parent, false);
        return new VhPets(v);
    }
    //ASOCIA CADA ELEMENTO DE LA LISTA CON CADA VIEW
    @Override
    public void onBindViewHolder(VhPets vhPets, int position) {
        final Pets pet = pets.get(position);
        vhPets.imPic.setImageResource(pet.getPic());
        vhPets.tvName.setText(pet.getName());
        vhPets.tvRate.setText(String.valueOf(pet.getRate()));

        vhPets.imPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, pet.getName(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(activity, PetDetails.class);
                i.putExtra(activity.getResources().getString(R.string.pName), pet.getName());
                i.putExtra(activity.getResources().getString(R.string.pRate), pet.getRate());
                i.putExtra(activity.getResources().getString(R.string.pPic), String.valueOf(pet.getPic()));
                activity.startActivity(i);
            }
        });

    }

    // Cantidad Elementos lista
    @Override
    public int getItemCount() {
        return pets.size();
    }


    public static class VhPets extends RecyclerView.ViewHolder {

        private ImageView imPic;
        private TextView tvName;
        private TextView tvRate;

        public VhPets(View itemView) {
            super(itemView);
            imPic = (ImageView) itemView.findViewById(R.id.imPic);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvRate = (TextView) itemView.findViewById(R.id.tvRate);
        }
    }

}

