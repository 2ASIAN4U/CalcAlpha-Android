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

import net.sourceforge.jeval.EvaluationConstants;
import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

import java.util.Locale;

public class Calc extends AppCompatActivity {
    int dispLen = 110;
    TextView display, prevAws;
    Button clearAll;

    Evaluator eval = new Evaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
        if(display.getText().length() >= 11){
            display.setTextSize(48);
            if(display.getText().length() >= 28){
                display.setTextSize(24);
                if(display.getText().length() >= 116){
                    display.setTextSize(18);
                    if(display.getText().length() >= 140){
                        Toast.makeText(Calc.this, "Twitter has a 140 character limit... What are you doing?", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Calc.this, "At this point, possibly consider using a physical calculator.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            //System.err.println(display.length());
        }else{
            display.setTextSize(64);
        }
        switch (v.getId()){
            case (R.id.button_0):{
                if(display.getText().equals("0")){
                    display.setText("0");
                }else{
                    display.setText(display.getText() + "0");
                }
            }break;
            case (R.id.button_1):{
                if(display.getText().equals("0")){
                    display.setText("1");
                }else{
                    display.setText(display.getText() + "1");
                }
            }break;
            case (R.id.button_2):{
                if(display.getText().equals("0")){
                    display.setText("2");
                }else {
                    display.setText(display.getText() + "2");
                }
            }break;
            case (R.id.button_3):{
                if(display.getText().equals("0")){
                    display.setText("3");
                }else {
                    display.setText(display.getText() + "3");
                }
            }break;
            case (R.id.button_4):{
                if(display.getText().equals("0")){
                    display.setText("4");
                }else {
                    display.setText(display.getText() + "4");
                }
            }break;
            case (R.id.button_5):{
                if(display.getText().equals("0")){
                    display.setText("5");
                }else {
                    display.setText(display.getText() + "5");
                }
            }break;
            case (R.id.button_6):{
                if(display.getText().equals("0")){
                    display.setText("6");
                }else {
                    display.setText(display.getText() + "6");
                }
            }break;
            case (R.id.button_7):{
                if(display.getText().equals("0")){
                    display.setText("7");
                }else {
                    display.setText(display.getText() + "7");
                }
            }break;
            case (R.id.button_8):{
                if(display.getText().equals("0")){
                    display.setText("8");
                }else {
                    display.setText(display.getText() + "8");
                }
            }break;
            case (R.id.button_9):{
                if(display.getText().equals("0")){
                    display.setText("9");
                }else {
                    display.setText(display.getText() + "9");
                }
            }break;
            case (R.id.button_dec):{
                if(display.getText().length() < dispLen){
                    display.setText(display.getText() + ".");
                }
            }break;
            case (R.id.button_add):{
                    if(display.getText().equals("0")){
                        if(prevAws.getText().length() > 0)
                            display.setText(prevAws.getText() + "+");
                    }else {
                        display.setText(display.getText() + "+");
                    }
            }break;
            case (R.id.button_subtract):{
                if(display.getText().equals("0")){
                    if(prevAws.getText().length() > 0)
                        display.setText(prevAws.getText() + "-");
                    else
                        display.setText("0-");
                }else {
                    display.setText(display.getText() + "-");
                }
            }break;
            case (R.id.button_multiply):{
                if(display.getText().equals("0")){
                    if(prevAws.getText().length() > 0)
                        display.setText(prevAws.getText() + "×");
                    else
                        display.setText("0×");
                }else {
                    display.setText(display.getText() + "×");
                }
            }break;
            case (R.id.button_div):{
                if(display.getText().equals("0")){
                    if(prevAws.getText().length() > 0)
                        display.setText(prevAws.getText() + "÷");
                    else
                        display.setText("0÷");
                }else {
                    display.setText(display.getText() + "÷");
                }
            }break;
            case (R.id.button_sine):{
                if(display.getText().equals("0")){
                    display.setText("sin(");
                }else {
                    display.setText(display.getText() + "sin(");
                }
            }break;
            case (R.id.button_cosine):{
                if(display.getText().equals("0")){
                    display.setText("cos(");
                }else {
                    display.setText(display.getText() + "cos(");
                }
            }break;
            case (R.id.button_tangent):{
                if(display.getText().equals("0")){
                    display.setText("tan(");
                }else {
                    display.setText(display.getText() + "tan(");
                }
            }break;
            case (R.id.button_left_parenthesis):{
                if(display.getText().equals("0")){
                    display.setText("(");
                }else {
                    display.setText(display.getText() + "(");
                }
            }break;
            case (R.id.button_right_parenthesis):{
                if(display.getText().equals("0")){
                    display.setText(")");
                }else {
                    display.setText(display.getText() + ")");
                }
            }break;
            case (R.id.button_power):{
                if(display.getText().equals("0")){
                    display.setText("^");
                }else {
                    display.setText(display.getText() + "^");
                }
            }break;
            case (R.id.button_commit):{
                String equation = display.getText().toString().replaceAll("÷"," / ");
                equation = equation.replaceAll("×", " * ");
                equation = equation.replaceAll("sin\\(", " sin( ");
                equation = equation.replaceAll("cos\\(", " cos( ");
                equation = equation.replaceAll("tan\\(", " tan( ");
                equation = equation.replaceAll(" \\.", " 0.");
                System.err.println(equation);
                String result = "0";
                try {
                    result = eval.evaluate(equation);
                }catch(Exception e){
                    Toast.makeText(Calc.this, "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
                    display.setText("0");
                    System.err.println(e);
                }
                prevAws.setText(result);
                display.setText("0");
                display.setTextSize(64);
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
