package com.rikkei.training.activity.fragmentstate;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class FragmentA extends Fragment {

    View view;
    MediaPlayer mediaPlayer;
    final  String tag = "----Fragment log----";
    int time;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_a, container, false);
        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.bai1);
        mediaPlayer.setLooping(true);

        Log.d(tag, "onCreateView");
        Toast.makeText(getContext(), "Fragment log: onCreateView", Toast.LENGTH_SHORT).show();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //if (savedInstanceState != null){
            //time = savedInstanceState.getInt("key");
       // }

        Log.d(tag, "onViewCreated");
        Toast.makeText(getContext(), "Fragment log: onViewCreated", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

        time = mediaPlayer.getCurrentPosition();
        outState.putInt("key", time);

        Log.d(tag, "onSaveInstanceState");
        Toast.makeText(getContext(), "Fragment log: onSaveInstanceState", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if (savedInstanceState != null){
            time = savedInstanceState.getInt("key");
            mediaPlayer.seekTo(time);
            mediaPlayer.start();
        }
        else {
            mediaPlayer.start();
        }
        Log.d(tag, "onViewStateRestore");
        Toast.makeText(getContext(), "Fragment log: onViewStateRestore", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer.pause();

        Log.d(tag, "onStop");
        Toast.makeText(getContext(), "Fragment log: onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();

        //mediaPlayer.start();

        Log.d(tag, "onStart");
        Toast.makeText(getContext(), "Fragment log: onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        mediaPlayer.pause();

        Log.d(tag, "onPause");
        Toast.makeText(getContext(), "Fragment log: onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();

        mediaPlayer.seekTo(time);
        mediaPlayer.start();

        Log.d(tag, "Resume");
        Toast.makeText(getContext(), "Fragment log: onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mediaPlayer.stop();
        mediaPlayer.release();
        //time = 0;

        Log.d(tag, "onDestroy");
        Toast.makeText(getContext(), "Fragment log: onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.d(tag, "onDestroyView");
        Toast.makeText(getContext(), "Fragment log: onDestroyView", Toast.LENGTH_SHORT).show();
    }
}