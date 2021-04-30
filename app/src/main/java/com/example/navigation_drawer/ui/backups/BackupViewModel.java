package com.example.navigation_drawer.ui.backups;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BackupViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mText;

    public BackupViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is backups fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}