package com.alialfayed.marketapp.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alialfayed.marketapp.R;
import com.alialfayed.marketapp.model.CategoryItems;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 2/8/2020 - 12:34 AM
 */
public class FragmentCatAdapter extends RecyclerView.Adapter<FragmentCatAdapter.FragmentCatViewHolder> {
    private ArrayList<CategoryItems> catItems = new ArrayList<>();
    private Context context;
    public FragmentCatAdapter(Context mContext){
        this.context = mContext;
    }

    @NonNull
    @Override
    public FragmentCatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewgrid,parent,false);
        FragmentCatViewHolder holder = new FragmentCatViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentCatViewHolder holder, int position) {
        holder.getTxtTitle().setText(catItems.get(position).getId());
        Glide.with(context).load(catItems.get(position).getCategory_img()).into(holder.getImgCat());

    }

    @Override
    public int getItemCount() {
//        if (catItems.size() > 0){
//            return catItems.size();
//        }else{
//            return 0;
//        }
        return catItems.size() > 0 ? catItems.size() : 0 ;
    }

    public void setDataToAdapter(ArrayList<CategoryItems> categoryItems){
        this.catItems = categoryItems;
        notifyDataSetChanged();
    }

    class FragmentCatViewHolder extends RecyclerView.ViewHolder{

        private TextView txtTitle;
        private ImageView imgCat;

        public FragmentCatViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public TextView getTxtTitle(){
            if (txtTitle == null){
                txtTitle = itemView.findViewById(R.id.txtTitle_RecyclerViewGrid);
            }
            return txtTitle;
        }
        public ImageView getImgCat(){
            if (imgCat == null){
                imgCat = itemView.findViewById(R.id.imgView_RecyclerViewGrid);
            }
            return imgCat;
        }

    }

}
