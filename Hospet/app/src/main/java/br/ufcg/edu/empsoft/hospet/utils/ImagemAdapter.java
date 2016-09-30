package br.ufcg.edu.empsoft.hospet.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import br.ufcg.edu.empsoft.hospet.R;

/**
 * Created by Julio on 30/09/2016.
 */
public class ImagemAdapter extends ArrayAdapter<Bitmap> {
    private Context context;
    private int layoutResourceId;
    private List<Bitmap> imagens = new ArrayList<>();

    public ImagemAdapter(Context context, int layoutResourceId, List<Bitmap> objects) {
        super(context, layoutResourceId, objects);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.imagens = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ImageView image;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            image = (ImageView) row.findViewById(R.id.image);
            row.setTag(image);
        } else {
            image = (ImageView) row.getTag();
        }

        Bitmap item = imagens.get(position);
        image.setImageBitmap(item);
        return row;
    }

    @Override
    public Bitmap getItem(int position) {
        return imagens.get(position);
    }

    @Override
    public int getCount() {
        return imagens.size();
    }
}
