package com.veirn.animee;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.veirn.animee.Model.Top;
import com.veirn.animee.Model.TopAnime;

import java.util.ArrayList;

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

    }
    TopAnime topAnime;
    ArrayList<Top> tops;
    LinearLayoutManager layoutManager ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        recyclerView = view.findViewById(R.id.AnimeREC2);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        topAnime = new TopAnime();
        tops = new ArrayList<>();
        mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                ((LinearLayoutManager) layoutManager).VERTICAL);
        recyclerView.addItemDecoration(mDividerItemDecoration);
        adapter = new CustomAdapter(getActivity() ,null,tops);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);


                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:
                        Log.v("SCROLL_STATE_IDLE","The RecyclerView is not scrolling");
                        System.out.println("The RecyclerView is not scrolling");
                        Log.v("SCROLL_STATE_IDLE","layoutManager.findLastCompletelyVisibleItemPosition() ---> " + layoutManager.findLastCompletelyVisibleItemPosition());
                        if((layoutManager.findLastCompletelyVisibleItemPosition())==tops.size()-1){
                           getAnimeUsingPagination(String.valueOf(++page));
                        }
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
            }
        });
        getAnimeUsingPagination(String.valueOf(page));
        return view;
    }

    private void getAnimeUsingPagination(String pageForRequest) {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance2().create(GetDataService.class);
        Call<TopAnime> Call = service.gettopanime(pageForRequest);
        Call.enqueue(new Callback<TopAnime>() {
            @Override
            public void onResponse(@NonNull Call<TopAnime> call, @NonNull Response<TopAnime> response) {
                if(response.body() !=null && response.body().getTop()!=null)
                    tops.addAll(response.body().getTop() );

//                adapter = new CustomAdapter(getActivity() ,null,tops);
                adapter.setTopAnime(tops);
                adapter.notifyDataSetChanged();
//                recyclerView.setAdapter(adapter);
                if(page==1&&tops.size()>0)
                    recyclerView.getLayoutManager().scrollToPosition(0);
//                else{
//                    recyclerView.getLayoutManager().scrollToPosition(0);
//
//                }

            }

            @Override
            public void onFailure(Call<TopAnime> call, Throwable t) {
                Toast.makeText( getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });

    }

}
