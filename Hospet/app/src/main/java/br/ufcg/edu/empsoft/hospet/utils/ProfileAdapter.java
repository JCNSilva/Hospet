package br.ufcg.edu.empsoft.hospet.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import br.ufcg.edu.empsoft.hospet.R;
import br.ufcg.edu.empsoft.hospet.models.Profile;
import java.util.ArrayList;
import java.util.List;

import br.ufcg.edu.empsoft.hospet.models.Profile;

/**
 * Created by mayelli on 19/08/2016.
 */
public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>
                        implements  View.OnClickListener{
    public static final String PREFERENCE_NAME = "USER_PREFERENCE";
    private List<Profile> mProfiles;
    private Context context;



    public ProfileAdapter(List<Profile> mProfiles, Context context) {
        this.mProfiles = mProfiles;
        this.context = context;
    }

    public List<Profile> getmProfiles() {
        return mProfiles;
    }


    @Override
    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_cview, parent, false);

        ProfileViewHolder dvh = new ProfileViewHolder(v);



        dvh.itemView.setOnClickListener(ProfileAdapter.this);
        dvh.itemView.setTag(dvh);


        return dvh;
    }

    @Override
    public void onBindViewHolder(final ProfileViewHolder holder, final int position) {
        holder.nome.setText(mProfiles.get(position).getName());
        final Profile profile = mProfiles.get(position);
        final int itemPosition = position;



        holder.expandButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    holder.data.setText(mProfiles.get(position).getPreco());
                    holder.preco.setText(mProfiles.get(position).getDate());
                    holder.llExpandArea.setVisibility(View.VISIBLE);
                } else {
                    holder.llExpandArea.setVisibility(View.GONE);
                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return mProfiles.size();
    }

    @Override
    public void onClick(View view) {
//        ProfileViewHolder holder = (ProfileViewHolder) view.getTag();
//        Disciplina theString = mDisciplinas.get(holder.getPosition());
//
//        if (mExpandedPosition >= 0) {
//            int prev = mExpandedPosition;
//            notifyItemChanged(prev);
//        }
//
//        mExpandedPosition = holder.getPosition();
//        notifyItemChanged(mExpandedPosition);
//
//        Log.d("Click", ""+theString.getNome());
    }

    public static class ProfileViewHolder extends RecyclerView.ViewHolder {
        private final ToggleButton expandButton;
        private TextView nome;
        private TextView preco;
        private TextView data;


        private RelativeLayout llExpandArea;

        public ProfileViewHolder(View itemView) {
            super(itemView);
            nome = (TextView) itemView.findViewById(R.id.tv_nome_perfil);
            preco = (TextView) itemView.findViewById(R.id.preco);
            data = (TextView) itemView.findViewById(R.id.data);
            llExpandArea = (RelativeLayout) itemView.findViewById(R.id.llExpandArea);
            expandButton = (ToggleButton) itemView.findViewById(R.id.expand_bt);
        }
    }
}
