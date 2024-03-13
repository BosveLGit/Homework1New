package com.example.homework1new;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<String> UserName = new MutableLiveData<>("Аноним!");
    private MutableLiveData<Integer> countNum = new MutableLiveData<>(0);

    public LiveData<String> getUserName() {
        return UserName;
    }
    public void setUserName(String UserName) {
        this.UserName.setValue(UserName);
    }

    public LiveData<Integer> getCountNum() {
        return countNum;
    }

    public void setCountNum(Integer countNum) {
        this.countNum.setValue(countNum);
    }

}
