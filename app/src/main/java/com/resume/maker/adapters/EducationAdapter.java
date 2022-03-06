package com.resume.maker.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.resume.maker.R;
import com.resume.maker.models.EducationModel;

import java.util.ArrayList;

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.ViewHolder> {

    private final ArrayList<EducationModel> modelList;

    public EducationAdapter(ArrayList<EducationModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edu_recyclerview_item, parent, false);
        return new EducationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EducationModel model = modelList.get(position);
        holder.className.setText(model.getClassType());
        holder.passingYear.setText(model.getPassingYear());
        holder.percentage.setText(model.getPercentage());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView className, percentage, passingYear;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            className = itemView.findViewById(R.id.class_name_recyclerview_item);
            percentage = itemView.findViewById(R.id.percentage_recyclerview_item);
            passingYear = itemView.findViewById(R.id.passing_year_recyclerview_item);
        }
    }
}
