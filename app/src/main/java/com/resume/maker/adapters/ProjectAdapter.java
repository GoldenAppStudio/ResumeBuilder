package com.resume.maker.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.resume.maker.R;
import com.resume.maker.models.ExperienceModel;
import com.resume.maker.models.ProjectModel;
import com.resume.maker.ui.fragments.resume.ProjectFragment;

import java.util.ArrayList;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {

    private final ArrayList<ProjectModel> modelList;

    public ProjectAdapter(ArrayList<ProjectModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_recyclerview_item, parent, false);
            return new ProjectAdapter.ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProjectModel model = modelList.get(position);
        holder.projectName.setText(model.getProjectName());
        holder.teamSize.setText(model.getTeamSize());
        holder.tech.setText("Tech: " + model.getTechUsed());
        holder.summary.setText(model.getProjectSummary());
        holder.role.setText(model.getYourRole());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView projectName, role, teamSize, summary, tech;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            projectName = itemView.findViewById(R.id.project_name_recyclerview_item);
            role = itemView.findViewById(R.id.role_recyclerview_item);
            summary = itemView.findViewById(R.id.project_summary_recyclerview_item);
            teamSize = itemView.findViewById(R.id.team_size_recyclerview_item);
            tech = itemView.findViewById(R.id.tech_used_recyclerview_item);
        }
    }
}
