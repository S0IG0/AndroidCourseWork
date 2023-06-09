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
import android.widget.ImageView;

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


//        buttons
        Button white1 = view.findViewById(R.id.button18);
        Button black1 = view.findViewById(R.id.button19);

        Button white2 = view.findViewById(R.id.button26);
        Button black2 = view.findViewById(R.id.button27);

        Button white3 = view.findViewById(R.id.button34);
        Button black3 = view.findViewById(R.id.button35);

        SwitchColor switchColor = new SwitchColor();

        for (Button button: new ArrayList<Button>(){{
            add(white1);
            add(white2);
            add(white3);
        }}) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switchColor.setWhite(true);
                }
            });
        }

        for (Button button: new ArrayList<Button>(){{
            add(black1);
            add(black2);
            add(black3);
        }}) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switchColor.setBlack(true);
                }
            });
        }


        for (int i = 0; i < buttons.size(); i++) {
            int finalI = i;
            buttons.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle args = new Bundle();
                    args.putBoolean("isWhite", switchColor.getWhite());

                    if (finalI == 0) {
                        args.putString("nameSneakers", "nike");
                        args.putString("FullNameSneakers", "Nike Air Force 1 '07");
                    } else if (finalI == 1) {
                        args.putString("nameSneakers", "adidas");
                        args.putString("FullNameSneakers", "adidas Originals Superstar");
                    } else if (finalI == 2) {
                        args.putString("nameSneakers", "puma");
                        args.putString("FullNameSneakers", "PUMA RBD Game Winter");
                    }

                    Navigation.findNavController(
                            getActivity(),
                            R.id.nav_host_fragment
                    ).navigate(R.id.action_designFragment1_to_designFragment2, args);
                }
            });
        }
    }
}

class SwitchColor {
    private Boolean black = false;
    private Boolean white = false;

    public Boolean getBlack() {
        return black;
    }

    public void setBlack(Boolean black) {
        this.white = false;
        this.black = black;
    }

    public Boolean getWhite() {
        return white;
    }

    public void setWhite(Boolean white) {
        this.black = false;
        this.white = white;
    }
}