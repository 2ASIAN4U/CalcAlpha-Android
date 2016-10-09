package tk.sbschools.calc;

import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.jexl3.*;

import java.util.Locale;

public class Calc extends AppCompatActivity {
    int dispLen = 11;
    TextView display, prevAws;
    Button clearAll;
    JexlEngine ExpressionEval = new JexlBuilder().create();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_calc);
        display = (TextView)findViewById(R.id.Display);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Roboto-Light.ttf");
        display.setTypeface(custom_font);
        prevAws = (TextView)findViewById(R.id.PrevAwnser);
        prevAws.setTypeface(custom_font);
        prevAws.setText("");
        clearAll = (Button)findViewById(R.id.button_clear);
        clearAll.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                display.setText("0");
                prevAws.setText("0");
                return true;
            }
        });
    }

    public void calcPressed(View v){
        switch (v.getId()){
            case (R.id.button_0):{
                if(display.getText().length() < dispLen){
                    if(display.getText().equals("0")){
                        display.setText("0");
                    }else{
                        display.setText(display.getText() + "0");
                    }
                }
            }break;
            case (R.id.button_1):{
                if(display.getText().length() < dispLen){
                    if(display.getText().equals("0")){
                        display.setText("1");
                    }else{
                        display.setText(display.getText() + "1");
                    }
                }
            }break;
            case (R.id.button_2):{
                if(display.getText().length() < dispLen){
                    if(display.getText().equals("0")){
                        display.setText("2");
                    }else {
                        display.setText(display.getText() + "2");
                    }
                }
            }break;
            case (R.id.button_3):{
                if(display.getText().length() < dispLen){
                    if(display.getText().equals("0")){
                        display.setText("3");
                    }else {
                        display.setText(display.getText() + "3");
                    }
                }
            }break;
            case (R.id.button_4):{
                if(display.getText().length() < dispLen){
                    if(display.getText().equals("0")){
                        display.setText("4");
                    }else {
                        display.setText(display.getText() + "4");
                    }
                }
            }break;
            case (R.id.button_5):{
                if(display.getText().length() < dispLen){
                    if(display.getText().equals("0")){
                        display.setText("5");
                    }else {
                        display.setText(display.getText() + "5");
                    }
                }
            }break;
            case (R.id.button_6):{
                if(display.getText().length() < dispLen){
                    if(display.getText().equals("0")){
                        display.setText("6");
                    }else {
                        display.setText(display.getText() + "6");
                    }
                }
            }break;
            case (R.id.button_7):{
                if(display.getText().length() < dispLen){
                    if(display.getText().equals("0")){
                        display.setText("7");
                    }else {
                        display.setText(display.getText() + "7");
                    }
                }
            }break;
            case (R.id.button_8):{
                if(display.getText().length() < dispLen){
                    if(display.getText().equals("0")){
                        display.setText("8");
                    }else {
                        display.setText(display.getText() + "8");
                    }
                }
            }break;
            case (R.id.button_9):{
                if(display.getText().length() < dispLen){
                    if(display.getText().equals("0")){
                        display.setText("9");
                    }else {
                        display.setText(display.getText() + "9");
                    }
                }
            }break;
            case (R.id.button_dec):{
                if(display.getText().length() < dispLen){
                    display.setText(display.getText() + ".");
                }
            }break;
            case (R.id.button_add):{
                if(display.getText().length() < dispLen){
                    if(display.getText().equals("0")){
                        if(prevAws.getText().length() > 0)
                            display.setText(prevAws.getText() + "+");
                    }else {
                        display.setText(display.getText() + "+");
                    }
                }
            }break;
            case (R.id.button_subtract):{
                if(display.getText().length() < dispLen){
                    if(display.getText().equals("0")){
                        if(prevAws.getText().length() > 0)
                            display.setText(prevAws.getText() + "-");
                        else
                            display.setText("0-");
                    }else {
                        display.setText(display.getText() + "-");
                    }
                }
            }break;
            case (R.id.button_multiply):{
                if(display.getText().length() < dispLen){
                    if(display.getText().equals("0")){
                        if(prevAws.getText().length() > 0)
                            display.setText(prevAws.getText() + "×");
                        else
                            display.setText("0×");
                    }else {
                        display.setText(display.getText() + "×");
                    }
                }
            }break;
            case (R.id.button_div):{
                if(display.getText().length() < dispLen){
                    if(display.getText().equals("0")){
                        if(prevAws.getText().length() > 0)
                            display.setText(prevAws.getText() + "÷");
                        else
                            display.setText("0÷");
                    }else {
                        display.setText(display.getText() + "÷");
                    }
                }
            }break;
            case (R.id.button_commit):{
                String equation = display.getText().toString().replaceAll("÷"," / ");
                equation = equation.replaceAll("×", " * ");
                equation = equation.replaceAll("[+]", " + ");
                equation = equation.replaceAll("-", " - ");
                Number result = 0;
                try {
                    JexlExpression e = ExpressionEval.createExpression(equation);
                    JexlContext context = new MapContext();

                    result = (Number) e.evaluate(context);
                }catch(Exception e){
                    Toast.makeText(Calc.this, "Ya dun fucked up: " + e.toString(), Toast.LENGTH_SHORT).show();
                    display.setText("0");
                    System.err.println(e);
                }
                prevAws.setText(result.toString());
                display.setText("0");
            }break;
            case (R.id.button_clear):{
                if(display.getText().length() > 1)
                    display.setText(display.getText().subSequence(0,display.getText().length()-1));
                else
                    display.setText("0");
            }
        }
    }
}
