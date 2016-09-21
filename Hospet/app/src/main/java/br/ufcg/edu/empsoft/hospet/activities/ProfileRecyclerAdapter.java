package br.ufcg.edu.empsoft.hospet.activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.ufcg.edu.empsoft.hospet.R;
import br.ufcg.edu.empsoft.hospet.models.Profile;

/**
 * Created by Isaque Fontinele on 21/09/2016.
 */
public class ProfileRecyclerAdapter extends RecyclerView.Adapter<ProfileRecyclerAdapter.ViewHolder> {

    private List<Profile> profiles;

    @Override
    public ProfileRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profile, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProfileRecyclerAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView name;
        private TextView info;
        private ImageView pic1;

        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.profile_name);
            info = (TextView) v.findViewById(R.id.profile_info);
            pic1 = (ImageView) v.findViewById(R.id.profile_pic);

        }

        public TextView getName() {
            return name;
        }

        public TextView getInfo() {
            return info;
        }

        public ImageView getPic1() {
            return pic1;
        }
    }
}
