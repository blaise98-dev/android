package com.example.smell.Fragments;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smell.Adapters.SmellDataAdapter;
import com.example.smell.R;
import com.example.smell.model.SmellTypesModal;
import com.example.smell.smell_db.DBHandler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SmellLocalListFragment extends Fragment {
    RecyclerView userDataRecyclerView;
    FloatingActionButton fabLocal;
    ArrayList<SmellTypesModal> smellDataArrayList;
    SmellDataAdapter smellDataAdapter;
    DBHandler dbHandler;
    TextView noData;

    @SuppressLint("NotifyDataSetChanged")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.smell_local_list_fragment, container, false);
        fabLocal = view.findViewById(R.id.fab_local);
        userDataRecyclerView = view.findViewById(R.id.smellrecyclerview);
        dbHandler = new DBHandler(requireContext());
        dbHandler.open();
        Cursor cursor = dbHandler.getSmellTypes();
        noData = view.findViewById(R.id.no_data);

        smellDataArrayList = new ArrayList<>();
        if (cursor.moveToFirst()) {
            if (smellDataArrayList != null) {
                smellDataArrayList.clear();
                noData.setVisibility(View.VISIBLE);
            }
            noData.setVisibility(View.GONE);
            do {
                String title = cursor.getString(cursor.getColumnIndexOrThrow("smell_title"));
                String desc = cursor.getString(cursor.getColumnIndexOrThrow("smell_desc"));
//                int hasImage = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow("has_image")));
//
//                if (hasImage == 1) {
//                    String imagePath = cursor.getString(cursor.getColumnIndexOrThrow("image_path"));
//                    smellDataArrayList.add(new SmellTypesModal(title, desc, true, smellDataArrayList.size()));
//                }
//                else {
                    smellDataArrayList.add(new SmellTypesModal(title, desc, false, smellDataArrayList.size()));
//                }

            } while (cursor.moveToNext());

            smellDataAdapter = new SmellDataAdapter(smellDataArrayList, getContext());
            userDataRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            userDataRecyclerView.setVerticalScrollBarEnabled(true);
            smellDataAdapter.notifyDataSetChanged();
            userDataRecyclerView.setAdapter(smellDataAdapter);
        }
//        dbHandler.close();

        fabLocal.setOnClickListener(v-> {
            SmellTypeForm formFrag= new SmellTypeForm(0);
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.thisView, formFrag, SmellTypeForm.class.getSimpleName())
                    .commit();
        });

        return view;
    }

}
