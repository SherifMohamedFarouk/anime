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
import com.veirn.animee.Model.TopAnime;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private AnimeCh dataList;
    private Context context;
    private TopAnime topAnime ;

    public CustomAdapter(Context context,AnimeCh dataList,TopAnime topAnime){
        this.context = context;
        this.dataList = dataList;
        this.topAnime = topAnime ;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView name , role , voiceactor;
        TextView title , episode ,rank ,type,rate ;
        ImageView coverImage;
        ImageView topimage;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            if(dataList !=null) {

                name = mView.findViewById(R.id.Name);
                role = mView.findViewById(R.id.Role );
                voiceactor = mView.findViewById(R.id.VoiceActor);
                coverImage = mView.findViewById(R.id.Image);
            }
            else{
                title = mView.findViewById(R.id.title);
                episode  = mView.findViewById(R.id.episode);
                rank = mView.findViewById(R.id.rank);
                type = mView.findViewById(R.id.type);
                rate = mView.findViewById(R.id.rate);
                topimage = mView.findViewById(R.id.topimage);

            }
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view ;
        if (dataList != null) {
           view = layoutInflater.inflate(R.layout.list_item, parent, false);
        }
        else if (topAnime !=null){
            view = layoutInflater.inflate(R.layout.list_item2, parent, false);
        }
        else{
            view = null;
        }
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        if (dataList!=null) {
            holder.name.setText(String.valueOf(this.dataList.getCharacters().get(position).getName()));
            holder.role.setText(String.valueOf(this.dataList.getCharacters().get(position).getRole()));
            if (this.dataList.getCharacters().get(position).getVoiceActors().size() > 0) {
                holder.voiceactor.setText(String.valueOf(this.dataList.getCharacters().get(position).getVoiceActors().get(0).getName()));
            }
            // holder.coverImage.setImageResource(this.dataList.getCharacters().get(position).getImageUrl().charAt(0));

                Glide.with(context)
                        .load(this.dataList.getCharacters().get(position).getImageUrl())
                        .into(holder.coverImage);

        }
        else{

            holder.title.setText(String.valueOf(this.topAnime.getTop().get(position).getTitle()));
            holder.episode.setText(String.valueOf(this.topAnime.getTop().get(position).getEpisodes()));
            holder.rank.setText(String.valueOf(this.topAnime.getTop().get(position).getRank()));
            holder.type.setText(String.valueOf(this.topAnime.getTop().get(position).getType()));
            holder.rate.setText(String.valueOf(this.topAnime.getTop().get(position).getScore()));
            Glide.with(context)
                    .load(this.topAnime.getTop().get(position).getImageUrl())
                    .into(holder.topimage);


        }




    }

    @Override
    public int getItemCount() {
         int data ;
        if (dataList != null) {
           data = dataList.getCharacters().size();
        }
        else if (topAnime !=null){
            data = topAnime.getTop().size();

        }
        else {
            data = 0 ;
        }

        return data;


    }
}
