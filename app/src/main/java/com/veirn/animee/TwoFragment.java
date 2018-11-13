package com.veirn.animee;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.veirn.animee.Model.TopAnime;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {
    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    DividerItemDecoration mDividerItemDecoration;
    public int page =1  ;




    public TwoFragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerView = getView().findViewById(R.id.AnimeREC2);
        GetDataService service = RetrofitClientInstance.getRetrofitInstance2().create(GetDataService.class);
        Call<TopAnime> Call = service.gettopanime(String.valueOf(page));
         Call.enqueue(new Callback<TopAnime>() {
            @Override
            public void onResponse(Call<TopAnime> call, Response<TopAnime> response) {
                recyclerView = getView().findViewById(R.id.AnimeREC2);
                adapter = new CustomAdapter(getActivity() ,null,response.body());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                        ((LinearLayoutManager) layoutManager).VERTICAL);
                recyclerView.addItemDecoration(mDividerItemDecoration);
                recyclerView.setAdapter(adapter);






            }

            @Override
            public void onFailure(Call<TopAnime> call, Throwable t) {
                Toast.makeText( getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

}
