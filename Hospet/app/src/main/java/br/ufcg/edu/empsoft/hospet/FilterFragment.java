package br.ufcg.edu.empsoft.hospet;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

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

    private Calendar dataInicio;
    private Calendar dataFinal;

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
        dInicio = (TextView) mView.findViewById(R.id.tv_data_inicio);
        dFinal = (TextView) mView.findViewById(R.id.tv_data_final);
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

        ctvCachorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctvCachorro.toggle();
                ctvGato.setChecked(false);
                ctvAve.setChecked(false);
                ctvTartaruga.setChecked(false);
                updateBoxes();
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
            }
        });

        ctvCasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctvCasa.toggle();
                ctvApartamento.setChecked(false);
                updateBoxes();
            }
        });

        ctvApartamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctvCasa.setChecked(false);
                ctvApartamento.toggle();
                updateBoxes();
            }
        });

        ctvCredito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctvCredito.toggle();
                ctvDebito.setChecked(false);
                ctvPaypal.setChecked(false);
                ctvDinheiro.setChecked(false);
                updateBoxes();
            }
        });

        ctvDebito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctvCredito.setChecked(false);
                ctvDebito.toggle();
                ctvPaypal.setChecked(false);
                ctvDinheiro.setChecked(false);
                updateBoxes();
            }
        });

        ctvPaypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctvCredito.setChecked(false);
                ctvDebito.setChecked(false);
                ctvPaypal.toggle();
                ctvDinheiro.setChecked(false);
                updateBoxes();
            }
        });

        ctvDinheiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctvCredito.setChecked(false);
                ctvDebito.setChecked(false);
                ctvPaypal.setChecked(false);
                ctvDinheiro.toggle();
                updateBoxes();
            }
        });

        dataInicio = Calendar.getInstance();
        dataFinal = Calendar.getInstance();

        updateLabels();

        dInicio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), date, dataInicio.get(Calendar.YEAR),
                        dataInicio.get(Calendar.MONTH),
                        dataInicio.get(Calendar.DAY_OF_MONTH));
            }
        });

        dFinal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), date2, dataFinal.get(Calendar.YEAR),
                        dataFinal.get(Calendar.MONTH),
                        dataFinal.get(Calendar.DAY_OF_MONTH));
            }
        });

        return mView;
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            dataInicio.set(Calendar.YEAR, year);
            dataInicio.set(Calendar.MONTH, monthOfYear);
            dataInicio.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabels();
        }

    };

    DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            dataFinal.set(Calendar.YEAR, year);
            dataFinal.set(Calendar.MONTH, monthOfYear);
            dataFinal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabels();
        }

    };

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


}
