package com.example.truyencuoi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    //Tạo một list với kiểu dl Category
    private List<Category> categoryList;
    private Context context;

    //Tạo một phương thức để gọi Adapter tại các class khác (public), yêu cầu truyền vào Context và List có kiểu dl <Category>
    public CategoryAdapter(Context context, List<Category> categoryList){
        //Truyền categoryList từ bên ngoài (class khác) vào trong CategoryAdapter
        this.categoryList = categoryList;

        //Truyền context vào adapter
        this.context = context;
    }
    // Kế thừa ViewHolder của Recycle View, cho vào Holder ảnh và tên của Category
    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView txtCategory;
        ImageView imgCategory;

        public CategoryViewHolder(@NonNull View itemView){
            super(itemView);
            txtCategory = itemView.findViewById(R.id.txtCategory);
            imgCategory = itemView.findViewById(R.id.imgCategory);
        }
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_category,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.txtCategory.setText(category.getName());
        holder.imgCategory.setImageResource(category.getImage());

        // Khi click vào item, mở Activity mới
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, StoryListActivity.class);
            intent.putExtra("category", category.getName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
