
package com.example.wyz.calculator;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {



    //前一次按的的运算符
    public  static   String Operation = "";
    //结果
    private static float   num = 0;
    private static String num1 = "0";
    private static int flag = 0;

    TextView result;
    TextView process;
    Button empty;
    Button  except;
    Button multiply;
    Button delete;
    Button seven;
    Button eight;
    Button nine;
    Button reduce;
    Button four;
    Button five;
    Button six;
    Button add;
    Button one;
    Button two;
    Button three;
    Button equal;
    Button zero;
    Button point;
    public  MainActivity()
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViewComponent();

    }
    private void setupViewComponent()
    {
        empty=(Button)findViewById(R.id.empty);
        except=(Button)findViewById(R.id.except);
        multiply=(Button)findViewById(R.id.multiply);
        delete=(Button)findViewById(R.id.delete);
        seven=(Button)findViewById(R.id.seven);
        eight=(Button)findViewById(R.id.eight);
        nine=(Button)findViewById(R.id.nine);
        reduce=(Button)findViewById(R.id.reduce);
        four=(Button)findViewById(R.id.four);
        five=(Button)findViewById(R.id.five);
        six=(Button)findViewById(R.id.six);
        add=(Button)findViewById(R.id.add);
        one=(Button)findViewById(R.id.one);
        two=(Button)findViewById(R.id.two);
        three=(Button)findViewById(R.id.three);
        equal=(Button)findViewById(R.id.equal);
        zero=(Button)findViewById(R.id.zero);
        point=(Button)findViewById(R.id.point);

        result=(TextView)findViewById(R.id.result);
        process=(TextView)findViewById(R.id.process);

        NumListener numlistener=new NumListener();
        OperListener operListener=new OperListener();
        empty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //全部清空
                result.setText("");
                //运算结果
                process.setText("");
                //公式
                Operation = "";
                //运算符
                num1 = "0";

                flag = 1;
            }
        });
        except.setOnClickListener(operListener);
        multiply.setOnClickListener(operListener);

        seven.setOnClickListener(numlistener);
        eight.setOnClickListener(numlistener);
        nine.setOnClickListener(numlistener);
        reduce.setOnClickListener(operListener);
        four.setOnClickListener(numlistener);
        five.setOnClickListener(numlistener);
        six.setOnClickListener(numlistener);
        add.setOnClickListener(operListener);
        one.setOnClickListener(numlistener);
        two.setOnClickListener(numlistener);
        three.setOnClickListener(numlistener);
        equal.setOnClickListener(operListener);
        zero.setOnClickListener(numlistener);
        point.setOnClickListener(numlistener);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int l = result.getText().length();
                int l1 = process.getText().length();

                if (Operation.equals("+")|| Operation.equals("-")|| Operation.equals("*") ||Operation.equals("/"))
                {
                    //全部清空
                    result.setText("");
                    //运算结果
                    process.setText("");
                    //公式
                    Operation = "";
                    //运算符
                    num1= "0";

                    flag = 1;
                }
                else
                {
                    if (l > 0)
                    {
                        result.setText(result.getText().subSequence(0, l - 1));

                    }
                    if (l1 > 0)
                        process.setText(process.getText().subSequence(0,l1-1));
                }
            }
        });
    }
    //数字按键事件
    class  NumListener implements  View.OnClickListener
    {

        @Override
        public void onClick(View v) {

            //如果之前的操作时按下了等于符号，清除之前的操作
            if (Operation .equals("="))
            {
                System.out.println("aa---清空");
                result.setText("");
                //结果框
                process.setText("");
                //公式框
                Operation = "";
                //操作符
                num1 = "0";
                //结果
                flag = 1;
            }

           switch (v.getId())
            {

                case R.id.zero: result.setText(result.getText().toString() +zero.getText().toString());
                    process.setText(process.getText().toString()+zero.getText().toString());
                    break;
                case R.id.one: result.setText(result.getText().toString()+one.getText().toString());
                    process.setText(process.getText()+""+one.getText().toString());
                    break;
                case R.id.two: result.setText(result.getText().toString()+two.getText().toString());
                    process.setText(process.getText().toString()+two.getText().toString());
                    break;
                case R.id.three: result.setText(result.getText().toString()+three.getText().toString());
                    process.setText(process.getText().toString()+three.getText().toString());
                    break;
                case R.id.four: result.setText(result.getText().toString()+four.getText().toString());
                    process.setText(process.getText().toString()+four.getText().toString());
                    break;
                case R.id.five: result.setText(result.getText().toString()+five.getText().toString());
                    process.setText(process.getText().toString()+five.getText().toString());
                    break;
                case R.id.six: result.setText(result.getText().toString()+six.getText().toString());
                    process.setText(process.getText().toString()+six.getText().toString());
                    break;
                case R.id.seven: result.setText(result.getText().toString()+seven.getText().toString());
                    process.setText(process.getText().toString()+seven.getText().toString());
                    break;
                case R.id.eight: result.setText(result.getText().toString()+eight.getText().toString());
                    process.setText(process.getText().toString()+eight.getText().toString());
                    break;
                case R.id.nine: result.setText(result.getText().toString()+nine.getText().toString());
                    process.setText(process.getText().toString()+nine.getText().toString());
                    break;
                case R.id.point:
                    String str=result.getText().toString();
                    if(!str.contains("."))
                    {
                        result.setText(result.getText().toString()+point.getText().toString());
                        process.setText(process.getText().toString()+point.getText().toString());
                        break;
                    }
            }

        }
    }
    //符号按键事件
    class  OperListener implements  View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            if(num1=="Infinity")
            {
                result.setText("");
                process.setText("");
                Operation="";
                num1="";
            }
            else
            {
                OperationNum("=");
                result.setText(num1);
                //如果之前的运算符是等号
                if (Operation.equals("="))
                {
                    process.setText(result.getText().toString());
                    //刚才的结果显示到公式框中
                    Operation = "";
                    //初始化运算符
                }
                switch (v.getId())
                {
                    case R.id.add:
                        process.setText(process.getText().toString()+add.getText().toString());
                        OperationNum(add.getText().toString());
                        result.setText("");
                        break;
                    case R.id.reduce:
                        process.setText(process.getText().toString() + reduce.getText().toString());
                        OperationNum(reduce.getText().toString());
                        result.setText("");
                        break;
                    case R.id.except:
                        process.setText(process.getText().toString() + except.getText().toString());
                        OperationNum(except.getText().toString());
                        result.setText("");
                        break;
                    case R.id.multiply:
                        process.setText(process.getText().toString()+multiply.getText().toString());
                        OperationNum(multiply.getText().toString());
                        result.setText("");
                        break;
                    case R.id.equal:
                        Operation="=";
                }
            }


        }
    }
    //通过运算符进行运算
    private  void OperationNum(String s)
    {
        //结果框有数字
        if (!result.getText().toString().equals(""))
        {
            switch (Operation)
            {
                case "":
                    num = Float.parseFloat(result.getText().toString());
                    num1 = String.valueOf(num);
                    //结果就是结果框的数
                    Operation = s;
                    //记录运算符
                    break;
                case "+":
                    if (result.getText().toString().equals("."))
                        num += 0;
                    else
                        num += Float.parseFloat( result.getText().toString());
                    num1 = String.valueOf(num);
                    Operation = s;
                    break;
                case "-":
                    if (result.getText().toString().equals(".") )
                        num -= 0;
                    else
                        num -= Float.parseFloat( result.getText().toString());
                    num1 = String.valueOf(num);
                    Operation = s;
                    break;
                case "*":
                    if (result.getText().toString().equals("."))
                        num *= 0;
                    else
                        num *= Float.parseFloat( result.getText().toString());
                    num1 = String.valueOf(num);
                    Operation = s;
                    break;
                case "/":
                    if (!result.getText().toString().equals("0")&&!result.getText().toString().equals("."))
                    {
                        num /= Float.parseFloat( result.getText().toString());
                        num1 = String.valueOf(num);

                    }
                    else
                    {
                        num1 = "";
                        Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();

                    }
                    Operation = s;
                    break;

                default: break;


            }
        }
        //结果框不是数字，即就是运算符
        else
            Operation = s;
    }


}
