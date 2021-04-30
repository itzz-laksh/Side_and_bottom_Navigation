package com.example.navigation_drawer.ui.uploads;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UploadViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mText;

    public UploadViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Uploads fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}