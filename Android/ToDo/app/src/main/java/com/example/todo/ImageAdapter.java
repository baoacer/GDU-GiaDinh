package com.example.todo;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private List<Uri> imageUris;

    public ImageAdapter(List<Uri> imageUris) {
        this.imageUris = imageUris;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Uri imageUri = imageUris.get(position);
        Glide.with(holder.imageView.getContext()).load(imageUri).into(holder.imageView);

        holder.itemView.setOnClickListener(v -> {
            // Chuyển đến ImageDetailActivity với Uri
            Intent intent = new Intent(holder.imageView.getContext(), ImageDetailActivity.class);
            intent.putExtra("imageUri", imageUri.toString());
            holder.imageView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return imageUris.size(); // Sửa lỗi cú pháp ở đây
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView); // Đảm bảo ID này khớp với layout của bạn
        }
    }
}