package com.nikolam.galleryjava.ui;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nikolam.galleryjava.R;
import com.nikolam.galleryjava.databinding.GalleryFragmentBinding;
import com.nikolam.galleryjava.ui.adapter.ImageAdapter;

public class GalleryFragment extends Fragment {

    private GalleryViewModel mViewModel;

    private GalleryFragmentBinding binding;

    private ImageAdapter imageAdapter;

    public static GalleryFragment newInstance() {
        return new GalleryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(
                inflater, R.layout.gallery_fragment, container, false);


        imageAdapter = new ImageAdapter();

        GridLayoutManager manager = new GridLayoutManager(this.getContext(), 4);

        binding.setAdapter(imageAdapter);
        binding.galleryGridRecycleView.setLayoutManager(manager);
        binding.setLifecycleOwner(this);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageAdapter.setImages(mViewModel.getAllImageUrls());
            }
        });



        View view = binding.getRoot();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
    }


}