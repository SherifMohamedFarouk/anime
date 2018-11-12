package com.veirn.animee;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.veirn.animee.Model.AnimeCh;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private AnimeCh dataList;
    private Context context;

    public CustomAdapter(Context context,AnimeCh dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView name , role , voiceactor;
        private ImageView coverImage;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            name = mView.findViewById(R.id.Name);
            role = mView.findViewById(R.id.Name);
            voiceactor = mView.findViewById(R.id.Name);
            coverImage = mView.findViewById(R.id.Image);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.name.setText(String.valueOf(this.dataList.getCharacters().get(position).getName()));
        holder.role.setText(String.valueOf(this.dataList.getCharacters().get(position).getRole()));
        holder.voiceactor.setText(String.valueOf(this.dataList.getCharacters().get(position).getVoiceActors().get(0).getName()));
        holder.coverImage.setImageResource(this.dataList.getCharacters().get(position).getImageUrl().charAt(0));




    }

    @Override
    public int getItemCount() {
        return dataList.getCharacters().size();
    }
}
