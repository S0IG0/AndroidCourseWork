package com.example.kosu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DesignFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DesignFragment1 extends Fragment {

    public DesignFragment1() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DesignFragment1 newInstance() {
        DesignFragment1 fragment = new DesignFragment1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_design1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton goBack = view.findViewById(R.id.imageButton11);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(
                        getActivity(),
                        R.id.nav_host_fragment
                ).navigate(R.id.action_designFragment1_to_designMain);
            }
        });

        List<Button> buttons = new ArrayList<Button>(){{
            add(view.findViewById(R.id.button20));
            add(view.findViewById(R.id.button28));
            add(view.findViewById(R.id.button36));
        }};

        for (Button button: buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Navigation.findNavController(
                            getActivity(),
                            R.id.nav_host_fragment
                    ).navigate(R.id.action_designFragment1_to_designFragment2);
                }
            });
        }
    }
}