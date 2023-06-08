package com.example.kosu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DesignMain#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DesignMain extends Fragment {

    public DesignMain() {
    }

    public static DesignMain newInstance() {
        System.out.println("newInstance");
        return new DesignMain();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmen
        return inflater.inflate(R.layout.fragment_design_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button putBid = view.findViewById(R.id.button93);
        Button makeOwnDesign = view.findViewById(R.id.button96);

        putBid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(
                        getActivity(),
                        R.id.nav_host_fragment
                ).navigate(R.id.action_designMain_to_designFragment1);

            }
        });

        makeOwnDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(
                        getActivity(),
                        R.id.nav_host_fragment
                ).navigate(R.id.action_designMain_to_statementFragment);
            }
        });
    }
}