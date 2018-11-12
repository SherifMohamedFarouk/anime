package com.veirn.animee;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.veirn.animee.Model.AnimeCh;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class OneFragment extends Fragment{
    private CustomAdapter adapter;
    private RecyclerView recyclerView ;

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<AnimeCh> call = service.getAllCH();
        call.enqueue(new Callback<AnimeCh>() {
            @Override
            public void onResponse(Call<AnimeCh> call, Response<AnimeCh> response) {
                recyclerView = getView().findViewById(R.id.AnimeREC);
                adapter = new CustomAdapter(getActivity() ,response.body());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<AnimeCh> call, Throwable t) {
                Toast.makeText( getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

}