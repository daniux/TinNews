package com.tinnews.tinnews.save;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tinnews.tinnews.R;
import com.tinnews.tinnews.common.TinBasicFragment;
import com.tinnews.tinnews.common.TinFragmentManager;
import com.tinnews.tinnews.mvp.MvpFragment;
import com.tinnews.tinnews.retrofit.response.News;
import com.tinnews.tinnews.save.detail.SavedNewsDetailedFragment;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedNewsFragment extends MvpFragment<SavedNewsContract.Presenter> implements SavedNewsContract.View {
    //4.3
    private TextView author;
    private TextView description;


    public static SavedNewsFragment newInstance() {
        //Bundle args = new Bundle();
        SavedNewsFragment fragment = new SavedNewsFragment();
        //fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        /*
        TextView textView = view.findViewById(R.id.text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinFragmentManager.doFragmentTransaction(SavedNewsDetailedFragment.newInstance());
            }
        });
        return view;
        */
    }

    //lifecycle code starts from here
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public SavedNewsContract.Presenter getPresenter() {
        return new SavedNewsPresenter();
    }

    @Override
    public void loadSavedNews(List<News> newsList) {
        //4.4
        if (newsList.size() > 0) {
            News news = newsList.get(newsList.size() - 1);
            author.setText(news.getAuthor());
            description.setText(news.getDescription());
        }
    }
}
