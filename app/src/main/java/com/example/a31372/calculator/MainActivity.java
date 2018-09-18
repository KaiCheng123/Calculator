package com.example.a31372.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private double result = 0;
    private TextView text;
    private StringBuffer stb = new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void counter(View view) {
        text = (TextView)findViewById(R.id.text);
        switch (view.getId()){
            case R.id.button1:
                stb.delete(0,stb.length());
                text.setText(stb);
                break;
            case R.id.button2:
                stb = stb.append(" / ");
                text.setText(stb);
                break;
            case R.id.button3:
                stb = stb.append(" * ");
                text.setText(stb);
                break;
            case R.id.button4:
                stb = stb.append(" - ");
                text.setText(stb);
                break;
            case R.id.button5:
                stb = stb.append("7");
                text.setText(stb);
                break;
            case R.id.button6:
                stb = stb.append("8");
                text.setText(stb);
                break;
            case R.id.button7:
                stb = stb.append("9");
                text.setText(stb);
                break;
            case R.id.button8:
                stb = stb.append(" + ");
                text.setText(stb);
                break;
            case R.id.button9:
                stb = stb.append("4");
                text.setText(stb);
                break;
            case R.id.button10:
                stb = stb.append("5");
                text.setText(stb);
                break;
            case R.id.button11:
                stb = stb.append("6");
                text.setText(stb);
                break;
            case R.id.button13:
                stb = stb.append("1");
                text.setText(stb);
                break;
            case R.id.button14:
                stb = stb.append("2");
                text.setText(stb);
                break;
            case R.id.button15:
                stb = stb.append("3");
                text.setText(stb);
                break;
            case R.id.button16:
                stb = stb.append("0");
                text.setText(stb);
                break;
            case R.id.button12:
                getResult();
                break;
            default:
                break;
        }
    }

    private void getResult(){
        String s1 = stb.substring(0,stb.indexOf(" "));
        String op = stb.substring(stb.indexOf(" ")+1,stb.indexOf(" ")+2);
        String s2 = stb.substring(stb.indexOf(" ")+3);
        if(s2.indexOf(" ") != -1 || s1.indexOf(" ") != -1){
            Toast.makeText(this,"输入错误！",Toast.LENGTH_LONG).show();
            stb.delete(0,stb.length());
            result = 0;
        }else {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            switch (op) {
                case "+":
                    result = d1 + d2;
                    break;
                case "-":
                    result = d1 - d2;
                    break;
                case "*":
                    result = d1 * d2;
                    break;
                case "/":
                    if (d2 == 0) {
                        Toast.makeText(this, "输入错误！", Toast.LENGTH_LONG).show();
                        result = 0;
                    } else {
                        result = d1 / d2;
                    }
                    break;
            }
        }
        text.setText(result+"");
        stb.delete(0,stb.length());
        stb.append(text.getText());
    }
}
