package com.resume.maker.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.TextViewCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.resume.maker.R;
import com.resume.maker.models.ExperienceModel;

import java.util.ArrayList;
import java.util.Objects;

public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.ViewHolder> {

    private final ArrayList<ExperienceModel> modelList;

    public ExperienceAdapter(ArrayList<ExperienceModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.experience_recyclerview_item, parent, false);
        return new ExperienceAdapter.ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ExperienceModel data = modelList.get(position);
        holder.jobTitle.setText(data.getJobTitle());
        holder.jobDescription.setText(data.getJobDescription());
        holder.jobTo.setText(" - " + data.getJobStartDate());
        holder.jobFrom.setText(data.getJobEndDate());
        holder.companyName.setText(data.getCompanyName());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView jobTitle;
        private final TextView jobDescription;
        private final TextView jobTo;
        private final TextView jobFrom;
        private final TextView companyName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            jobTitle = itemView.findViewById(R.id.job_name_recyclerview_item);
            companyName = itemView.findViewById(R.id.company_name_recyclerview_item);
            jobFrom = itemView.findViewById(R.id.from_recyclerview_item);
            jobTo = itemView.findViewById(R.id.to_recyclerview_item);
            jobDescription = itemView.findViewById(R.id.description_recyclerview_item);
        }
    }
}
