package br.ufcg.edu.empsoft.hospet.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.ufcg.edu.empsoft.hospet.R;
import br.ufcg.edu.empsoft.hospet.models.Hospedeiro;

/**
 * Created by Julio on 15/10/2016.
 */
public class HospedeiroAdapter extends ArrayAdapter<Hospedeiro> {

    private Context context;
    private int layoutResourceId;
    private List<Hospedeiro> hospedeiros = new ArrayList<>();
    private final LayoutInflater  mInflater;

    public HospedeiroAdapter(Context context, int layoutResourceId, List<Hospedeiro> hospedeiros) {
        super(context, layoutResourceId, hospedeiros);

        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.hospedeiros = hospedeiros;
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return hospedeiros.size();
    }

    @Override
    public Hospedeiro getItem(int i) {
        return hospedeiros.get(i);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_profile, null);
            holder = new ViewHolder();
            holder.foto = (ImageView) convertView.findViewById(R.id.iv_foto_hospedeiro);
            holder.nome = (TextView) convertView.findViewById(R.id.tv_nome_hospedeiro);
            holder.preco = (TextView) convertView.findViewById(R.id.tv_preco_hospedeiro);
            holder.distancia = (TextView) convertView.findViewById(R.id.tv_distancia_hospedeiro);
            holder.avaliacao = (RatingBar) convertView.findViewById(R.id.rbar_rating_hospedeiro);
            holder.contratar = (Button) convertView.findViewById(R.id.btn_reserva_hospedeiro);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Hospedeiro hospedeiro = getItem(position);
        if (hospedeiro != null) {
            holder.foto.setImageBitmap(hospedeiro.getFotoDePerfil());
            holder.nome.setText(hospedeiro.getNome());
            holder.preco.setText(String.valueOf(hospedeiro.getPrecoDiaria()));
            setLeftDrawable(holder.preco, R.drawable.ic_cash);
            holder.distancia.setText(String.valueOf(hospedeiro.getDistancia()) + " km");
            setLeftDrawable(holder.distancia, R.drawable.ic_map_localization);
            holder.avaliacao.setRating(hospedeiro.getNumEstrelas().floatValue());
            holder.contratar.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //TODO
                        }
                    }
            );
        }

        return convertView;
    }

    private void setLeftDrawable(TextView tv, int viewId){
        Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), viewId, null);
        drawable = scaleImage(drawable, 0.5);
        tv.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
    }

    private Drawable scaleImage (Drawable image, double scaleFactor) {

        if ((image == null) || !(image instanceof BitmapDrawable)) {
            return image;
        }

        Bitmap b = ((BitmapDrawable)image).getBitmap();

        int sizeX = (int) Math.round(image.getIntrinsicWidth() * scaleFactor);
        int sizeY = (int) Math.round(image.getIntrinsicHeight() * scaleFactor);

        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, sizeX, sizeY, false);

        image = new BitmapDrawable(context.getResources(), bitmapResized);

        return image;

    }

    public class ViewHolder {
        ImageView foto;
        TextView nome;
        TextView preco;
        TextView distancia;
        RatingBar avaliacao;
        Button contratar;
    }
}
