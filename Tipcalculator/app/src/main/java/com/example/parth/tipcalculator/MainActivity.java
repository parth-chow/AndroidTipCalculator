package com.example.parth.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText billEdittext;
    private TextView Taxtextview;
    private TextView Tiptextview;
    private TextView TotalBillview;
    private TextView tipPerctectview;
    private SeekBar Tipseekbar;
    private double tax, tip, bill,totalBill;
    private int seekprogress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billEdittext = (EditText) findViewById(R.id.bill_editText);
        Taxtextview = (TextView) findViewById(R.id.Tax_textView7);
        Tiptextview = (TextView) findViewById(R.id.Tip_textView9);
        TotalBillview = (TextView) findViewById(R.id.totalBill_textView2);
        tipPerctectview = (TextView) findViewById(R.id.tippercentage_textView3);

        Tipseekbar = (SeekBar) findViewById(R.id.tip_seekBar2);
        Tipseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekprogress=progress;
                tipPerctectview.setText(String.valueOf(seekprogress+" %"));
                //Toast.makeText(MainActivity.this, "tipbar "+progress, Toast.LENGTH_SHORT).show();
                tip= (bill/100)*seekprogress;
                totalBill= bill+tax+tip;
                Tiptextview.setText(String.valueOf(tip));
                TotalBillview.setText(String.valueOf(totalBill));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        billEdittext.addTextChangedListener(textWatcher);
    }





    private  TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(!billEdittext.getText().toString().equals("")){
                bill = Double.parseDouble(billEdittext.getText().toString());
                tax= (bill/100)*10;
                tip= (bill/100)*seekprogress;
                totalBill= bill+tax+tip;
                Taxtextview.setText(String.valueOf(tax));
                Tiptextview.setText(String.valueOf(tip));
                TotalBillview.setText(String.valueOf(totalBill));


            }else{
                Taxtextview.setText("0.0");
                Tiptextview.setText("0.0");
                TotalBillview.setText("0.0");
            }


        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
