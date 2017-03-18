package org.coursera.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.coursera.mypentagram.Pets;
import org.coursera.org.coursera.adapter.PetAdapter;
import org.coursera.mypentagram.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    ArrayList<Pets> pets;
    private RecyclerView petList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);


        petList = (RecyclerView) v.findViewById(R.id.rvPets);
        //Recycler View como LinerLayout
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //GridLayoutManager llm = new GridLayoutManager(getActivity(), 3);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        petList.setLayoutManager(llm);

        arrayInit();
        adapterInit();


        return v;
    }

     public void scrollToTop(){
        petList.scrollToPosition(0);
        petList.smoothScrollToPosition(0);
    }


    public void adapterInit(){
        PetAdapter adapter = new PetAdapter(pets, getActivity());
        petList.setAdapter(adapter);
    }


    public void arrayInit(){

        pets = new ArrayList<Pets>();

        pets.add(new Pets("Flow", R.drawable.image1, 3 ));
        pets.add(new Pets("Yako", R.drawable.image2, 4));
        pets.add(new Pets("Urkia", R.drawable.image3, 5 ));
        pets.add(new Pets("Bilma", R.drawable.image4, 7));
        pets.add(new Pets("Tuka", R.drawable.image5, 9));

    }


}
