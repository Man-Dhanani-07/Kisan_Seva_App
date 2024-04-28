package com.man.fapp.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.StorageReference;
import com.man.fapp.Adapter.MyAdapter;
import com.man.fapp.Model.Item;
import com.man.fapp.R;
import com.man.fapp.databinding.ActivityMainBinding;
import com.man.fapp.databinding.FragmentItemListBinding;

import java.util.ArrayList;
import java.util.List;


public class Item_list extends Fragment {
    FragmentItemListBinding binding;
    ActivityMainBinding mainBinding;
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final CollectionReference collectionReference = db.collection("Item");
    private StorageReference storageReference;
    private List<Item> itemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private FloatingActionButton floatbtn;

    public Item_list() {

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentItemListBinding.inflate(inflater);

        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        itemList = new ArrayList<>();
        binding.floatingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
//                ft.setCustomAnimations(R.anim.slide_in_bottom, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out_bottom);
                ft.replace(R.id.content, new AddItemActivity()).addToBackStack(null);
                ft.commit();
            }
        });

        return binding.getRoot();
    }


    @Override
    public void onStart() {
        super.onStart();
        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot items : queryDocumentSnapshots) {
                    Item item = items.toObject(Item.class);
                    itemList.add(item);
                }
                myAdapter = new MyAdapter(getActivity(), itemList);
                binding.recyclerview.setAdapter(myAdapter);
                myAdapter.notifyDataSetChanged();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Opps! Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}