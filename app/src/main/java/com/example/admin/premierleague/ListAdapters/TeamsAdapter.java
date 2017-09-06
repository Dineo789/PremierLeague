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
import android.widget.Toast;

import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.example.admin.premierleague.Data.Team;
import com.example.admin.premierleague.R;
import com.caverock.androidsvg.SVG;
import com.example.admin.premierleague.SVGHandler.SvgDecoder;
import com.example.admin.premierleague.SVGHandler.SvgDrawableTranscoder;
import com.example.admin.premierleague.SVGHandler.SvgSoftwareLayerSetter;
import com.example.admin.premierleague.TeamActivity;

import java.io.InputStream;
import java.util.List;

/**
 * Created by admin on 2017/08/28.
 */

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.MyViewHolder>/* implements View.OnClickListener*/ {

    private List<Team> teamList;
    private Team mTeams;
    Context context;
    private PostItemListener mItemListener;


    public TeamsAdapter(Context context, List<Team> teamList, PostItemListener itemListner) {
        this.context = context;
        this.teamList = teamList;
        this.mItemListener = itemListner;
    }


    @Override
    public TeamsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_item, parent, false);

        return new MyViewHolder(itemView, this.mItemListener);
    }


    @Override
    public void onBindViewHolder(TeamsAdapter.MyViewHolder holder, int position) {

        Team team = teamList.get(position);
        holder.teamName.setText(team.getName());//getteamname
        holder.teamCode.setText(team.getCode());//get team code


        Glide.with(context)//shows png only
                .load(team.getCrestUrl())
                .placeholder(R.mipmap.ic_launcher_round)
                .dontAnimate()
                .centerCrop()
                .into(holder.teamLogo);
//shows svg only
        GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> requestBuilder = Glide.with(context)
                .using(Glide.buildStreamModelLoader(Uri.class, context), InputStream.class)
                .from(Uri.class)
                .as(SVG.class)
                .transcode(new SvgDrawableTranscoder(), PictureDrawable.class)
                .sourceEncoder(new StreamEncoder())
                .cacheDecoder(new FileToStreamDecoder<SVG>(new SvgDecoder()))
                .decoder(new SvgDecoder())
                .listener(new SvgSoftwareLayerSetter<Uri>());

        requestBuilder
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.mipmap.ic_launcher_round)
                .load(Uri.parse(team.getCrestUrl()))
                .into(holder.teamLogo);
    }


    @Override
    public int getItemCount() {
        return teamList.size();//count = 20
    }

    public Team getItem(int adapterPosition) {
        return teamList.get(adapterPosition);
    }

    public void getFootBallTeams(List<Team> team) {
        teamList = team;
        notifyDataSetChanged();
    }


    /*ViewHolder Class*/

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView teamName, teamCode;
        ImageView teamLogo;
        PostItemListener viewPostListner;


        public MyViewHolder(View v, PostItemListener postItemListener) {
            super(v);
            teamName = (TextView) v.findViewById(R.id.team_name);
            teamCode = (TextView) v.findViewById(R.id.team_code);
            teamLogo = (ImageView) v.findViewById(R.id.team_logo);
            this.viewPostListner = postItemListener;
            v.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {

            Team teamItem = getItem(getAdapterPosition());


            //Toast.makeText(context, teamItem.getName() + " was clicked", Toast.LENGTH_SHORT).show();
            // Intent intent = new Intent(context, TeamActivity.class);
            //passTeamInfo();
            // context.startActivity(intent);
            Intent i = new Intent(context, TeamActivity.class);
            i.putExtra("team_name", teamItem.getName());
            i.putExtra("team_shortname", teamItem.getShortName());
            i.putExtra("team_logo", teamItem.getCrestUrl());
            i.putExtra("team_url", teamItem.returnUrl());
            //i.putExtra("datumTodoa", item.getRecordDate());
            // i.putExtra("idTodoa", item.getItemId());
            context.startActivity(i);


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
