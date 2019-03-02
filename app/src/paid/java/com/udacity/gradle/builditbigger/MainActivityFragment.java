package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.jokelibrary.DisplayJokeActivity;


public class MainActivityFragment extends Fragment {
    public String displayedJoke = null;
    public boolean testFlag = false;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        // Set onClickListener for the button
        Button button = (Button) root.findViewById(R.id.joke_btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getJoke();
            }
        });
        return root;
    }

    public void getJoke(){
        new EndpointAsyncTask().execute(this);
    }

    public void DisplayJokeActivity(){
        if (!testFlag) {
            Context context = getActivity();
            Intent intent = new Intent(context, DisplayJokeActivity.class);
            intent.putExtra(context.getString(R.string.jokeString), displayedJoke);

            context.startActivity(intent);
        }
    }
}