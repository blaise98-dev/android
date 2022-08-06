package com.example.smell.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smell.R;
import com.example.smell.ViewHolder.SmellDataViewHolder;
import com.example.smell.model.SmellTypesModal;

import java.util.ArrayList;

public class SmellDataAdapter extends RecyclerView.Adapter<SmellDataViewHolder> {
    ArrayList<SmellTypesModal> userDataArrayList;
    SmellDataViewHolder smellDataViewHolder;
    Context context;

    public SmellDataAdapter(ArrayList<SmellTypesModal> smellDataList, Context context) {
        this.userDataArrayList = smellDataList;
        this.context = context;
    }

    @NonNull
    @Override
    public SmellDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.smell_type, parent, false);
        return new SmellDataViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull SmellDataViewHolder holder, int position) {
        final SmellTypesModal smellData = userDataArrayList.get(position);
        holder.BindSmellData(smellData);
        smellDataViewHolder = holder;
    }

    @Override
    public int getItemCount() {
        return userDataArrayList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
