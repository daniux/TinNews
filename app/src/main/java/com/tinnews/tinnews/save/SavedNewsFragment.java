package com.tinnews.tinnews.save;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tinnews.tinnews.R;
import com.tinnews.tinnews.common.TinBasicFragment;
import com.tinnews.tinnews.common.TinFragmentManager;
import com.tinnews.tinnews.common.ViewModelAdapter;
import com.tinnews.tinnews.mvp.MvpFragment;
import com.tinnews.tinnews.retrofit.response.News;
import com.tinnews.tinnews.save.detail.SavedNewsDetailedFragment;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedNewsFragment extends MvpFragment<SavedNewsContract.Presenter> implements SavedNewsContract.View {
    //4.3
    // private TextView author;
    // private TextView description;
    //3.8
    // private SavedNewsAdapter savedNewsAdapter;
    private ViewModelAdapter savedNewsAdapter;
    private TextView emptyState;
    // record location start
    private LinearLayoutManager linearLayoutManager;
    private int initPosition = -1;
    // record location stop

    public static SavedNewsFragment newInstance() {
        Bundle args = new Bundle();
        SavedNewsFragment fragment = new SavedNewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //7.8
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //7.8
        View view = inflater.inflate(R.layout.fragment_saved_news, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        // record position start
        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        // record position stop
        emptyState = view.findViewById(R.id.empty_state);

        // record location start
        if (isViewEmpty()) {
            emptyState.setVisibility(View.VISIBLE);
        } else {
            emptyState.setVisibility(View.GONE);
        }
        if (savedNewsAdapter == null) {
            savedNewsAdapter = new ViewModelAdapter();
        }


        // savedNewsAdapter = new SavedNewsAdapter(tinFragmentManager);
        //savedNewsAdapter = new ViewModelAdapter();
        recyclerView.setAdapter(savedNewsAdapter);
        // record location stop
        return view;
    }


    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_saved_news, container, false);
        View view = inflater.inflate(R.layout.fragment_saved_news, container, false);
        view.findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinFragmentManager.doFragmentTransaction(SavedNewsDetailedFragment.newInstance());
            }
        });
        return view;

    }
    */
    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saved_news, container, false);
        //4.3
        author = view.findViewById(R.id.author);
        description = view.findViewById(R.id.description);
        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinFragmentManager.doFragmentTransaction(SavedNewsDetailedFragment.newInstance());
            }
        });
        return view;
    }
    */

    @Override
    public SavedNewsContract.Presenter getPresenter() {
        return new SavedNewsPresenter();
    }

    @Override
    public void loadSavedNews(List<News> newsList) {
        if (newsList.size() == 0) {
            emptyState.setVisibility(View.VISIBLE);
        } else {
            emptyState.setVisibility(View.GONE);
        }
        if (newsList != null) {
            List<SavedNewsViewModel> models = new LinkedList<>();
            for (News news : newsList) {
                models.add(new SavedNewsViewModel(news, tinFragmentManager));
            }
            savedNewsAdapter.addViewModels(models);
        }


        /*
        if (newsList.size() == 0) {
            emptyState.setVisibility(View.VISIBLE);
        } else {
            emptyState.setVisibility(View.GONE);
        }
        if (newsList != null) {
            savedNewsAdapter.setNewsList(newsList);
        }
        */
        //4.4
        /*
        if (newsList.size() - 0) {
            News news = newsList.get(newsList.size() - 1);
            author.setText(news.getAuthor());
            description.setText(news.getDescription());
        }
        */
    }
    // record location start
    @Override
    public boolean isViewEmpty() {
        return savedNewsAdapter == null || savedNewsAdapter.isEmpty();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        initPosition = linearLayoutManager.findFirstVisibleItemPosition();
    }
    // record location stop
}
