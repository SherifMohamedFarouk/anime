package com.veirn.animee;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.veirn.animee.Model.AnimeCh;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class OneFragment extends Fragment {
    DividerItemDecoration mDividerItemDecoration;
    private CustomAdapter adapter;
    private RecyclerView recyclerView;

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        getAnimeCh();

        recyclerView = view.findViewById(R.id.AnimeREC);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:
                        Log.v("SCROLL_STATE_IDLE","The RecyclerView is not scrolling");
                        System.out.println("The RecyclerView is not scrolling");
                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        Log.v("SCROLL_STATE_IDLE","SCROLL_STATE_DRAGGING");
                        System.out.println("Scrolling now");
                        break;
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        Log.v("SCROLL_STATE_IDLE","SCROLL_STATE_SETTLING");
                        System.out.println("Scroll Settling");
                        break;

                }


//                if(newState== NumberPicker.OnScrollListener.SCROLL_STATE_IDLE);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        return view;
    }

    private void getAnimeCh() {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<AnimeCh> call = service.getAllCH();


        call.enqueue(new Callback<AnimeCh>() {
            @Override
            public void onResponse(Call<AnimeCh> call, Response<AnimeCh> response) {

                adapter = new CustomAdapter(getActivity(), response.body(), null);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                        ((LinearLayoutManager) layoutManager).VERTICAL);
                recyclerView.addItemDecoration(mDividerItemDecoration);
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<AnimeCh> call, Throwable t) {
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });
    }


}