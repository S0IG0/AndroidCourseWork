package com.example.kosu;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
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
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DesignFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DesignFragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "isWhite";
    private static final String ARG_PARAM2 = "nameSneakers";
    private static final String ARG_PARAM3 = "FullNameSneakers";

    // TODO: Rename and change types of parameters
    private Boolean isWhite;
    private String nameSneakers;
    private String FullNameSneakers;

    public DesignFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
     * @return A new instance of fragment DesignFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static DesignFragment2 newInstance(boolean param1, String param2, String param3) {
        DesignFragment2 fragment = new DesignFragment2();
        Bundle args = new Bundle();
        args.putBoolean(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            isWhite = getArguments().getBoolean(ARG_PARAM1);
            nameSneakers = getArguments().getString(ARG_PARAM2);
            FullNameSneakers = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_design2, container, false);
    }

    @SuppressLint("DiscouragedApi")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView fullName = view.findViewById(R.id.textView40);
        fullName.setText(FullNameSneakers);

        ImageView image = view.findViewById(R.id.imageView39);


        String resourceName = nameSneakers;

        if (isWhite) {
            resourceName += "_white";
        } else {
            resourceName += "_black";
        }

        image.setImageResource(getResources().getIdentifier(
                resourceName,
                "drawable",
                requireContext().getPackageName()
        ));

        ImageButton goBack = view.findViewById(R.id.imageButton38);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(
                        getActivity(),
                        R.id.nav_host_fragment
                ).navigate(R.id.action_designFragment2_to_designFragment1);
            }
        });

        Button next = view.findViewById(R.id.button60);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(
                        getActivity(),
                        R.id.nav_host_fragment
                ).navigate(R.id.action_designFragment2_to_designFragment3);
            }
        });
    }
}