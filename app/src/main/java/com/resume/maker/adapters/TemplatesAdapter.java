package com.resume.maker.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.resume.maker.R;
import com.resume.maker.callbacks.NavigateToPersonalDetailsFragmentCallback;
import com.resume.maker.models.TemplatesModel;

import java.util.ArrayList;

public class TemplatesAdapter extends RecyclerView.Adapter<TemplatesAdapter.RecyclerViewHolder> {

    private final ArrayList<TemplatesModel> templatesModelArrayList;
    private final NavigateToPersonalDetailsFragmentCallback callback;

    public TemplatesAdapter(ArrayList<TemplatesModel> templatesModelArrayList, NavigateToPersonalDetailsFragmentCallback callback) {
        this.templatesModelArrayList = templatesModelArrayList;
        this.callback = callback;
    }

    @NonNull
    @Override
    public TemplatesAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.templates_recyclerview_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TemplatesAdapter.RecyclerViewHolder holder, int position) {
        holder.imageView.setImageResource(templatesModelArrayList.get(position).getImageResourse());

        holder.itemView.setOnClickListener(v -> callback.navigate());
    }

    @Override
    public int getItemCount() {
        return templatesModelArrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private final ImageView imageView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.template_iv_recyclerview_item);
        }
    }
}
