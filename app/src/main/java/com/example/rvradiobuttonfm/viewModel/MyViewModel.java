package com.example.rvradiobuttonfm.viewModel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.rvradiobuttonfm.model.MyModel;


public class MyViewModel extends androidx.lifecycle.ViewModel {

    public MutableLiveData<MyModel> mString = new MutableLiveData<>();


    public void setmString(MyModel s) {
        mString.setValue(s);
    }

    public LiveData<MyModel> getmString() {
        return mString;
    }
}

