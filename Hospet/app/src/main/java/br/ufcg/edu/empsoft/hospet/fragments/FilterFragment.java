package br.ufcg.edu.empsoft.hospet.fragments;

import android.app.DatePickerDialog;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import br.ufcg.edu.empsoft.hospet.models.ConstantesFiltro;

import br.ufcg.edu.empsoft.hospet.R;

public class FilterFragment extends Fragment {

    private TextView dInicio;
    private TextView dFinal;
    private CheckedTextView ctvGato;
    private CheckedTextView ctvCachorro;
    private CheckedTextView ctvAve;
    private CheckedTextView ctvTartaruga;
    private CheckedTextView ctvCasa;
    private CheckedTextView ctvApartamento;
    private CheckedTextView ctvDinheiro;
    private CheckedTextView ctvCredito;
    private CheckedTextView ctvDebito;
    private CheckedTextView ctvPaypal;
    private Spinner filtros;

    private Calendar dataInicio;
    private Calendar dataFinal;
    private ConstantesFiltro.TipoAnimal tipoAnimal;
    private ConstantesFiltro.TipoLocal tipoLocal;
    private ConstantesFiltro.TipoOrdenacao tipoOrdenacao;
    private ConstantesFiltro.TipoPagamento tipoPagamento;

    public FilterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_filter, container, false);
        dInicio = (TextView) mView.findViewById(R.id.et_data_inicio);
        dFinal = (TextView) mView.findViewById(R.id.et_data_final);
        ctvGato = (CheckedTextView) mView.findViewById(R.id.ctv_gato);
        ctvCachorro = (CheckedTextView) mView.findViewById(R.id.ctv_cachorro);
        ctvAve = (CheckedTextView) mView.findViewById(R.id.ctv_ave);
        ctvTartaruga = (CheckedTextView) mView.findViewById(R.id.ctv_tartaruga);
        ctvCasa = (CheckedTextView) mView.findViewById(R.id.ctv_casa);
        ctvApartamento = (CheckedTextView) mView.findViewById(R.id.ctv_apartamento);
        ctvCredito = (CheckedTextView) mView.findViewById(R.id.ctv_credito);
        ctvDebito = (CheckedTextView) mView.findViewById(R.id.ctv_debito);
        ctvDinheiro = (CheckedTextView) mView.findViewById(R.id.ctv_dinheiro);
        ctvPaypal = (CheckedTextView) mView.findViewById(R.id.ctv_paypal);
        filtros = (Spinner) mView.findViewById(R.id.spinner_filtros);

        dataInicio = Calendar.getInstance();
        dataFinal = Calendar.getInstance();

        updateLabels();

        ctvCachorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctvCachorro.toggle();
                ctvGato.setChecked(false);
                ctvAve.setChecked(false);
                ctvTartaruga.setChecked(false);
                updateBoxes();
                tipoAnimal = ConstantesFiltro.TipoAnimal.CACHORRO;
            }
        });

        ctvGato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctvCachorro.setChecked(false);
                ctvGato.toggle();
                ctvAve.setChecked(false);
                ctvTartaruga.setChecked(false);
                updateBoxes();
                tipoAnimal = ConstantesFiltro.TipoAnimal.GATO;
            }
        });

        ctvAve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctvCachorro.setChecked(false);
                ctvGato.setChecked(false);
                ctvAve.toggle();
                ctvTartaruga.setChecked(false);
                updateBoxes();
                tipoAnimal = ConstantesFiltro.TipoAnimal.AVE;
            }
        });

        ctvTartaruga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctvCachorro.setChecked(false);
                ctvGato.setChecked(false);
                ctvAve.setChecked(false);
                ctvTartaruga.toggle();
                updateBoxes();
                tipoAnimal = ConstantesFiltro.TipoAnimal.TARTARUGA;
            }
        });

        ctvCasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctvCasa.toggle();
                ctvApartamento.setChecked(false);
                updateBoxes();
                tipoLocal = ConstantesFiltro.TipoLocal.CASA;
            }
        });

        setLeftDrawable(ctvCasa, R.drawable.ic_home_button);

        ctvApartamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctvCasa.setChecked(false);
                ctvApartamento.toggle();
                updateBoxes();
                tipoLocal = ConstantesFiltro.TipoLocal.APARTAMENTO;
            }
        });

        setLeftDrawable(ctvApartamento, R.drawable.ic_old_building);

        ctvCredito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctvCredito.toggle();
                ctvDebito.setChecked(false);
                ctvPaypal.setChecked(false);
                ctvDinheiro.setChecked(false);
                updateBoxes();
                tipoPagamento = ConstantesFiltro.TipoPagamento.CREDITO;
            }
        });

        setLeftDrawable(ctvCredito, R.drawable.ic_credit_card);

        ctvDebito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctvCredito.setChecked(false);
                ctvDebito.toggle();
                ctvPaypal.setChecked(false);
                ctvDinheiro.setChecked(false);
                updateBoxes();
                tipoPagamento = ConstantesFiltro.TipoPagamento.DEBITO;
            }
        });

        setLeftDrawable(ctvDebito, R.drawable.ic_credit_card);

        ctvPaypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctvCredito.setChecked(false);
                ctvDebito.setChecked(false);
                ctvPaypal.toggle();
                ctvDinheiro.setChecked(false);
                updateBoxes();
                tipoPagamento = ConstantesFiltro.TipoPagamento.PAYPAL;
            }
        });

        setLeftDrawable(ctvPaypal, R.drawable.ic_paypal);

        ctvDinheiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctvCredito.setChecked(false);
                ctvDebito.setChecked(false);
                ctvPaypal.setChecked(false);
                ctvDinheiro.toggle();
                updateBoxes();
                tipoPagamento = ConstantesFiltro.TipoPagamento.DINHEIRO;
            }
        });

        setLeftDrawable(ctvDinheiro, R.drawable.ic_cash);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                dataInicio.set(Calendar.YEAR, year);
                dataInicio.set(Calendar.MONTH, monthOfYear);
                dataInicio.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabels();
            }

        };

        final DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                dataFinal.set(Calendar.YEAR, year);
                dataFinal.set(Calendar.MONTH, monthOfYear);
                dataFinal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabels();
            }

        };

        dInicio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), date, dataInicio.get(Calendar.YEAR),
                        dataInicio.get(Calendar.MONTH),
                        dataInicio.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        dFinal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), date2, dataFinal.get(Calendar.YEAR),
                        dataFinal.get(Calendar.MONTH),
                        dataFinal.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.filtros,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filtros.setAdapter(adapter);

        filtros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                switch(index){
                    case 0:
                        tipoOrdenacao = ConstantesFiltro.TipoOrdenacao.NOTA;
                        break;
                    case 1:
                        tipoOrdenacao = ConstantesFiltro.TipoOrdenacao.PRECO;
                        break;
                    case 2:
                        tipoOrdenacao = ConstantesFiltro.TipoOrdenacao.PROXIMIDADE;
                        break;
                }
            }
        });

        return mView;
    }


    private void updateLabels() {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        dInicio.setText(sdf.format(dataInicio.getTime()));
        dFinal.setText(sdf.format(dataFinal.getTime()));
    }

    private void updateBoxes(){
        List<CheckedTextView> boxes = new ArrayList<>();
        boxes.add(ctvGato);
        boxes.add(ctvCachorro);
        boxes.add(ctvAve);
        boxes.add(ctvTartaruga);
        boxes.add(ctvCasa);
        boxes.add(ctvApartamento);
        boxes.add(ctvCredito);
        boxes.add(ctvDebito);
        boxes.add(ctvDinheiro);
        boxes.add(ctvPaypal);

        for (CheckedTextView box: boxes) {
            if(box.isChecked()){
                box.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.tag_selected));
            } else {
                box.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.tag_background));
            }
        }
    }

    private Drawable scaleImage (Drawable image, double scaleFactor) {

        if ((image == null) || !(image instanceof BitmapDrawable)) {
            return image;
        }

        Bitmap b = ((BitmapDrawable)image).getBitmap();

        int sizeX = (int) Math.round(image.getIntrinsicWidth() * scaleFactor);
        int sizeY = (int) Math.round(image.getIntrinsicHeight() * scaleFactor);

        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, sizeX, sizeY, false);

        image = new BitmapDrawable(getResources(), bitmapResized);

        return image;

    }

    private void setLeftDrawable(CheckedTextView tv, int viewId){
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), viewId, null);
        drawable = scaleImage(drawable, 0.5);
        tv.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
    }
}
