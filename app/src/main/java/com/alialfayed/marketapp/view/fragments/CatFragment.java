package com.alialfayed.marketapp.view.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alialfayed.marketapp.R;
import com.alialfayed.marketapp.model.CategoryItems;
import com.alialfayed.marketapp.repository.APIClient;
import com.alialfayed.marketapp.repository.APIInterface;
import com.alialfayed.marketapp.view.adapters.FragmentCatAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatFragment extends Fragment {

    private RecyclerView myRecyclerView;
    private FragmentCatAdapter adapter;
    private ArrayList<CategoryItems> catItems = new ArrayList<>();

    public CatFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cat, container, false);

        myRecyclerView = view.findViewById(R.id.RecyclerItemCat);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(linearLayoutManager);

        adapter = new FragmentCatAdapter(getActivity());
        myRecyclerView.setAdapter(adapter);
        getData();
        if (catItems.size() > 0){
            Toast.makeText(getActivity(),"Done",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getActivity(),"failed",Toast.LENGTH_SHORT).show();

        }
        return view;
    }


    private void getData(){
        APIInterface apiInterface =APIClient.getClient().create(APIInterface.class);
        Call<ArrayList<CategoryItems>> call = apiInterface.getUsers();
        call.enqueue(new Callback<ArrayList<CategoryItems>>() {
            @Override
            public void onResponse(Call<ArrayList<CategoryItems>> call, Response<ArrayList<CategoryItems>> response) {
                if (response.isSuccessful()){
                    adapter.setDataToAdapter(response.body());

                }else {
                    Toast.makeText(getActivity(),"Sorry You Have an error",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<CategoryItems>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getActivity(), "Error!\nTry again later.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
