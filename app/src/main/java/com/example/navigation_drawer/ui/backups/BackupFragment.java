package com.example.navigation_drawer.ui.backups;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.navigation_drawer.R;
import com.example.navigation_drawer.ui.uploads.UploadViewModel;

public class BackupFragment extends Fragment {

    private BackupViewModel backupViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        backupViewModel =
                new ViewModelProvider(this).get(BackupViewModel.class);
        View root = inflater.inflate(R.layout.fragment_backup, container, false);
        final TextView textView = root.findViewById(R.id.text_backups);
        backupViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}