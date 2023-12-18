package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
    // Initialize variable
    RecyclerView recyclerView;

    // Make sure to use the FloatingActionButton for all the FABs
    FloatingActionButton mAddFab, mAddAlarmFab, mAddPersonFab;

    // These are taken to make visible and invisible along with FABs
    TextView addAlarmActionText, addPersonActionText;

    ImageView refine;

    // to check whether sub FAB buttons are visible or not.
    Boolean isAllFabsVisible;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Initialize view
        View rootView =inflater.inflate(R.layout.fragment_main, container, false);
        refine=rootView.findViewById(R.id.refine);
        ArrayList<Employee> employelist
                = Constants.getEmployeeData();
        Adapter itemAdapter = new Adapter(employelist);
        RecyclerView recyclerView
                = rootView.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(itemAdapter);

        // Register all the FABs with their IDs This FAB button is the Parent
        mAddFab = rootView.findViewById(R.id.add_fab);

        // FAB button
        mAddAlarmFab = rootView.findViewById(R.id.add_alarm_fab);
        mAddPersonFab = rootView.findViewById(R.id.add_person_fab);

        // Also register the action name text, of all the FABs.
        addAlarmActionText = rootView.findViewById(R.id.add_alarm_action_text);
        addPersonActionText = rootView.findViewById(R.id.add_person_action_text);

        // Now set all the FABs and all the action name texts as GONE
        mAddAlarmFab.setVisibility(View.GONE);
        mAddPersonFab.setVisibility(View.GONE);
        addAlarmActionText.setVisibility(View.GONE);
        addPersonActionText.setVisibility(View.GONE);

        // make the boolean variable as false, as all the
        // action name texts and all the sub FABs are invisible
        isAllFabsVisible = false;

        // We will make all the FABs and action name texts
        // visible only when Parent FAB button is clicked So
        // we have to handle the Parent FAB button first, by
        // using setOnClickListener you can see below
        mAddFab.setOnClickListener(view -> {
            if (!isAllFabsVisible) {
                // when isAllFabsVisible becomes true make all
                // the action name texts and FABs VISIBLE
                mAddAlarmFab.show();
                mAddPersonFab.show();
                addAlarmActionText.setVisibility(View.VISIBLE);
                addPersonActionText.setVisibility(View.VISIBLE);

                // make the boolean variable true as we
                // have set the sub FABs visibility to GONE
                isAllFabsVisible = true;
            } else {
                // when isAllFabsVisible becomes true make
                // all the action name texts and FABs GONE.
                mAddAlarmFab.hide();
                mAddPersonFab.hide();
                addAlarmActionText.setVisibility(View.GONE);
                addPersonActionText.setVisibility(View.GONE);

                // make the boolean variable false as we
                // have set the sub FABs visibility to GONE
                isAllFabsVisible = false;
            }
        });

        refine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(rootView.getContext(), Filters.class);
                startActivity(intent);
            }
        });

        // return view
        return rootView;
    }
}
