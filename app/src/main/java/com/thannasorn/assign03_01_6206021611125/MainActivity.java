//6206021611125 น.ส.ธรรณศร เมตตา

package com.thannasorn.assign03_01_6206021611125;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText num;
    private RadioButton btnBinary, btnOctal, btnHexa;
    private Button btnOk;
    private TextView Show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = (EditText) findViewById(R.id.num);
        btnBinary = (RadioButton) findViewById(R.id.btnBinary);
        btnOctal = (RadioButton) findViewById(R.id.btnOctal);
        btnHexa = (RadioButton) findViewById(R.id.btnHexa);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnOk.setOnClickListener(this);
        Show = (TextView) findViewById(R.id.Show);

    }

    @Override
    public void onClick(View view) {
        if (num.getText().toString().equals("")) {
            Toast.makeText(this, "กรุณาใส่ข้อมูล", Toast.LENGTH_SHORT).show();
            return;
        }

        String message = "";
        int Deci = Integer.parseInt(num.getText().toString());
        int temp;
        char charHe[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        if (btnBinary.isChecked()) {
            while (Deci > 0) {
                temp = Deci % 2;
                Deci = Deci / 2;
                message = temp + message;
            }
            Show.setText("Decimal : " + num.getText().toString() + "\n Binary : " + message);
        }
        else if (btnOctal.isChecked()) {
            while (Deci > 0) {
                temp = Deci % 8;
                Deci = Deci / 8;
                message = temp + message;
            }
            Show.setText("Decimal : " + num.getText().toString() + "\n Octal : " + message);
        }
        else if (btnHexa.isChecked()) {
            while (Deci > 0) {
                temp = Deci % 16;
                Deci = Deci / 16;
                message = charHe[temp] + message;
            }
            Show.setText("Decimal : " + num.getText().toString() + "\n Hexa : " + message);
        }
    }
}

