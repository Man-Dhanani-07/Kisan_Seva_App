package com.man.fapp.Fragment;

import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.man.fapp.Fragment.Item_list;
import com.man.fapp.MainActivity;
import com.man.fapp.Model.Item;
import com.man.fapp.R;
import com.man.fapp.databinding.ActivityMainBinding;
import com.man.fapp.databinding.FragmentAddItemActivityBinding;

public class AddItemActivity extends Fragment {
    FragmentAddItemActivityBinding binding;
    ActivityMainBinding mainBinding;
    private ProgressBar progressBar;
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private StorageReference storageReference;
    private final CollectionReference collectionReference = db.collection("Item");
    ActivityResultLauncher<String> mtakephoto;
    Uri imageUri;
    FragmentManager fragmentManager;


    public AddItemActivity() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddItemActivityBinding.inflate(inflater, container, false);

        storageReference = FirebaseStorage.getInstance().getReference();
        binding.postProgressBar.setVisibility(View.INVISIBLE);
        binding.productSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Submitbutton();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                if (fm != null) {
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.content, new Item_list());
                    ft.commit();
                } else {

                }
            }
        });
        mtakephoto = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri o) {
                binding.imageVieww.setImageURI(o);
                imageUri = o;
            }
        });
        binding.postimagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mtakephoto.launch("image/*");
            }
        });
        return binding.getRoot();
    }

    private void Submitbutton() {
        String title = binding.productName.getText().toString().trim();
        String quantity = binding.productQuantity.getText().toString().trim();
        String quality = binding.productQuality.getText().toString().trim();
        String price = binding.productPrice.getText().toString().trim();
        String description = binding.productDescription.getText().toString().trim();
        binding.postProgressBar.setVisibility(View.VISIBLE);
        if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(quantity) && !TextUtils.isEmpty(quality) && !TextUtils.isEmpty(price) && !TextUtils.isEmpty(description)) {
            final StorageReference filepath = storageReference.child("item_images").child("my_image" + Timestamp.now().getSeconds());

            filepath.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    filepath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            String imageUri = uri.toString();
                            Item item = new Item();
                            item.setQuantity(quantity);
                            item.setDescription(description);
                            item.setPrice(price);
                            item.setQuality(quality);
                            item.setTitle(title);
                            item.setImageUrl(imageUri);
                            collectionReference.add(item).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    if (fragmentManager != null) {
                                        progressBar.setVisibility(View.INVISIBLE);
                                        FragmentTransaction ft = fragmentManager.beginTransaction();
                                        ft.replace(R.id.content, new Item_list());
//                                        ft.addToBackStack(null);
                                        ft.commit();
                                    } else {

                                    }
//                                    FragmentManager fm = getActivity().getSupportFragmentManager();
//                                    FragmentTransaction ft = fm.beginTransaction();
//                                    ft.replace(R.id.content, new Item_list());
//                                    ft.commit();

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    binding.postProgressBar.setVisibility(View.INVISIBLE);
                                    Toast.makeText(getActivity(), "Failed" + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
        } else {
            binding.postProgressBar.setVisibility(View.INVISIBLE);
        }

    }
}