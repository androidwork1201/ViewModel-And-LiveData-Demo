package com.example.test.ViewModel;

import android.os.Handler;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<String>> shoppingList;

    public MutableLiveData<List<String>> getShoppingList() {

        if (shoppingList == null) {
            shoppingList = new MutableLiveData<>();
            loadShoppingList();
        }

        return shoppingList;
    }

    private void loadShoppingList() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            List<String> shoppingListSample = new ArrayList<>();
            shoppingListSample.add("A");
            shoppingListSample.add("B");
            shoppingListSample.add("C");
            shoppingListSample.add("D");

            long seed = System.nanoTime();
            Collections.shuffle(shoppingListSample, new Random(seed));
            shoppingList.setValue(shoppingListSample);
        }, 5000);
    }
}

