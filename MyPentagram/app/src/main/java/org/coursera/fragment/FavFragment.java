package org.coursera.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;

import org.coursera.mypentagram.Pets;
import org.coursera.mypentagram.R;
import org.coursera.org.coursera.adapter.PetFavAdapter;

import java.util.ArrayList;




/**
 * A simple {@link Fragment} subclass.
 */
public class FavFragment extends Fragment {


    public FavFragment() {
        // Required empty public constructor
    }

    ArrayList<Pets> pets;
    private RecyclerView petList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_fav, container, false);


        petList = (RecyclerView) v.findViewById(R.id.rvFavPets);

        RecyclerViewHeader header = (RecyclerViewHeader) v.findViewById(R.id.header);

        GridLayoutManager llm = new GridLayoutManager(getActivity(), 3);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        petList.setLayoutManager(llm);
        header.attachTo(petList);





        arrayInit();
        adapterInit();


        // Inflate the layout for this fragment
        return v;
    }


    public void adapterInit(){
        PetFavAdapter adapter = new PetFavAdapter(pets, getActivity());
        petList.setAdapter(adapter);
    }


    public void arrayInit(){

        pets = new ArrayList<Pets>();

        pets.add(new Pets("Tuka", R.drawable.cuadrada, 9));
        pets.add(new Pets("Bilma", R.drawable.cuadrada, 7));
        pets.add(new Pets("Urkia", R.drawable.cuadrada, 5 ));
        pets.add(new Pets("Yako", R.drawable.cuadrada, 4));
        pets.add(new Pets("Flow", R.drawable.cuadrada, 3 ));
        pets.add(new Pets("Tuka", R.drawable.cuadrada, 9));
        pets.add(new Pets("Bilma", R.drawable.cuadrada, 7));
        pets.add(new Pets("Urkia", R.drawable.cuadrada, 5 ));
        pets.add(new Pets("Yako", R.drawable.cuadrada, 4));
        pets.add(new Pets("Flow", R.drawable.cuadrada, 3 ));
        pets.add(new Pets("Tuka", R.drawable.cuadrada, 9));
        pets.add(new Pets("Bilma", R.drawable.cuadrada, 7));
        pets.add(new Pets("Urkia", R.drawable.cuadrada, 5 ));
        pets.add(new Pets("Yako", R.drawable.cuadrada, 4));
        pets.add(new Pets("Flow", R.drawable.cuadrada, 3 ));
        pets.add(new Pets("Tuka", R.drawable.cuadrada, 9));
        pets.add(new Pets("Bilma", R.drawable.cuadrada, 7));
        pets.add(new Pets("Urkia", R.drawable.cuadrada, 5 ));
        pets.add(new Pets("Yako", R.drawable.cuadrada, 4));
        pets.add(new Pets("Flow", R.drawable.cuadrada, 3 ));
        pets.add(new Pets("Tuka", R.drawable.cuadrada, 9));
        pets.add(new Pets("Bilma", R.drawable.cuadrada, 7));
        pets.add(new Pets("Urkia", R.drawable.cuadrada, 5 ));
        pets.add(new Pets("Yako", R.drawable.cuadrada, 4));
        pets.add(new Pets("Flow", R.drawable.cuadrada, 3 ));

    }

}
