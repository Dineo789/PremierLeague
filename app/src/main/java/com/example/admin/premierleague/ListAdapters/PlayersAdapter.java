package com.example.admin.premierleague.ListAdapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.caverock.androidsvg.SVG;
import com.example.admin.premierleague.Data.Player;
import com.example.admin.premierleague.Data.Team;
import com.example.admin.premierleague.R;
import com.example.admin.premierleague.SVGHandler.SvgDecoder;
import com.example.admin.premierleague.SVGHandler.SvgDrawableTranscoder;
import com.example.admin.premierleague.SVGHandler.SvgSoftwareLayerSetter;
import com.example.admin.premierleague.TeamActivity;

import java.io.InputStream;
import java.util.List;

/**
 * Created by admin on 2017/09/06.
 */

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.MyViewHolder> {

    private List<Player> playerList;
    private Player mPlayer;
    Context context;
    private PlayersAdapter.PostItemListener mItemListener;


    public PlayersAdapter(Context context, List<Player> playerList, PlayersAdapter.PostItemListener itemListner) {
        this.context = context;
        this.playerList = playerList;
        this.mItemListener = itemListner;
    }


    @Override
    public PlayersAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_item, parent, false);

        return new PlayersAdapter.MyViewHolder(itemView, this.mItemListener);
    }


    @Override
    public void onBindViewHolder(PlayersAdapter.MyViewHolder holder, int position) {

        Player player = playerList.get(position);
        holder.player.setText(player.getName());//getteamname


    }


    @Override
    public int getItemCount() {
        return playerList.size();//count = 20
    }

    public Player getItem(int adapterPosition) {
        return playerList.get(adapterPosition);
    }

    public void getTeamPlayers(List<Player> team) {
        playerList = team;
        notifyDataSetChanged();
    }


    /*ViewHolder Class*/

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView player;

        PlayersAdapter.PostItemListener viewPostListner;


        public MyViewHolder(View v, PlayersAdapter.PostItemListener postItemListener) {
            super(v);
            player = (TextView) v.findViewById(R.id.player_name);

            this.viewPostListner = postItemListener;
            v.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {

            Player playerItem = getItem(getAdapterPosition());



           /* Intent i = new Intent(context, TeamActivity.class);
            i.putExtra("team_name", teamItem.getName());
            i.putExtra("team_shortname", teamItem.getShortName());
            i.putExtra("team_logo",teamItem.getCrestUrl());
            i.putExtra("team_url",teamItem.returnUrl());
            //i.putExtra("datumTodoa", item.getRecordDate());
            // i.putExtra("idTodoa", item.getItemId());
            context.startActivity(i);*/


        }

        private void passTeamInfo() {
            Team item = new Team();
            Intent i = new Intent(context, TeamActivity.class);
            i.putExtra("team_name", item.getName());
            //i.putExtra("datumTodoa", item.getRecordDate());
            // i.putExtra("idTodoa", item.getItemId());
            context.startActivity(i);
        }
    }

    /* PostItemListener Interface definition*/
    public interface PostItemListener {
        void onPostClick(long id);
    }


}
