package com.example.kosu;

import android.annotation.SuppressLint;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kosu.dataType.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistratedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistratedFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegistratedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistratedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistratedFragment newInstance(String param1, String param2) {
        RegistratedFragment fragment = new RegistratedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registrated, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference();

        Button register = view.findViewById(R.id.button107);
        EditText login = view.findViewById(R.id.editTextTextEmailAddress103);
        EditText email = view.findViewById(R.id.editTextTextEmailAddress104);
        EditText password = view.findViewById(R.id.editTextTextPassword105);
        EditText retypePassword = view.findViewById(R.id.editTextTextPassword106);
        TextView error = view.findViewById(R.id.TextViewErrorRegister);
        retypePassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    register.performClick();
                    return true;
                }
                return false;
            }
        });
        String sample = "Пользователь с данным email уже зарегестрирован";
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                error.setText("");
                reference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                            User user = userSnapshot.getValue(User.class);
                            assert user != null;
                            if (user.getEmail().equals(email.getText().toString())) {
                                error.setText(sample);
                            }
                        }

                        if (password.getText().toString().equals(retypePassword.getText().toString())
                                && !error.getText().toString().equals(sample)) {
                            @SuppressLint("SimpleDateFormat")
                            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                                    .format(Calendar.getInstance().getTime());
                            reference.child("users").child(timeStamp).setValue(new User(
                                    login.getText().toString(),
                                    email.getText().toString(),
                                    password.getText().toString()
                            ));

                            Navigation.findNavController(
                                    getActivity(),
                                    R.id.nav_host_fragment
                            ).navigate(R.id.action_registratedFragment_to_account);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
    }
}