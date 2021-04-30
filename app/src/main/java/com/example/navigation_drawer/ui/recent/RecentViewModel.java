package com.example.navigation_drawer.ui.recent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecentViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mText;

    public RecentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Account fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}