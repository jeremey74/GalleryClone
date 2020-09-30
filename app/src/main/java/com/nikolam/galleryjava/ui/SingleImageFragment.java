package com.nikolam.galleryjava.ui;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.nikolam.galleryjava.R;
import com.nikolam.galleryjava.databinding.SingleImageFragmentBinding;
import com.nikolam.galleryjava.ui.adapter.SingleImageAdapter;

public class SingleImageFragment extends Fragment {


    private String url;

    private SingleImageFragmentBinding binding;

    private SingleImageViewModel mViewModel;

    private SingleImageAdapter adapter;

    public static SingleImageFragment newInstance() {
        return new SingleImageFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(
                inflater, R.layout.single_image_fragment, container, false);

        binding.setLifecycleOwner(this);

        adapter = new SingleImageAdapter(getContext());

        View view = binding.getRoot();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SingleImageViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        url = SingleImageFragmentArgs.fromBundle(getArguments()).getImageUrl();

        binding.setImageUrl(url);

    }

    @Override
    public void onStart() {
        super.onStart();

        adapter.setImages(mViewModel.getAllImages());
        mViewModel.setCurrentPosition(url);

        binding.viewPager.setAdapter(adapter);

        binding.viewPager.setCurrentItem(mViewModel.currentPos);

        adapter.notifyDataSetChanged();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}