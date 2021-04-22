package com.tqc.gdd01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class GDD01 extends Activity
{
  private EditText etheight;
  private EditText etweight;
  private RadioButton rb1;
  private RadioButton rb2;
  private RadioGroup rg_sex;
  private String sexText;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    etheight = findViewById(R.id.etHeight);
    etweight = findViewById(R.id.etWeight);
    rb1 = findViewById(R.id.rbMale);
    rb2 = findViewById(R.id.rbFemale);

    Button b1 = (Button) findViewById(R.id.button1);
    b1.setOnClickListener(new Button.OnClickListener()
    {
      public void onClick(View v)
      {
        //從輸入介面中取出了的身高、體重值，要將身高、體重值傳送給 child_Activity 後作計算

        //這些附加在 Intent 上的訊息都儲存在 Bundle 物件中
        Intent intent = new Intent(GDD01.this, GDD01_child.class);

        //透過「intent.putExtras(bundle)」敘述，將「bundle」 物件附加在 Intent 上，隨著 Intent 送出而送出
        Bundle bundle = new Bundle();
        bundle.putDouble("height", Double.parseDouble(etheight.getText().toString()));
        bundle.putDouble("weight", Double.parseDouble(etweight.getText().toString()));
        bundle.putString("Sex", sexText);
        intent.putExtras(bundle);
        startActivity(intent);

      }
    });

    rg_sex = findViewById(R.id.rgSex);
    rg_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId)
        {
          case R.id.rbMale:
            sexText = rb1.getText().toString();
            break;
          case R.id.rbFemale:
            sexText = rb2.getText().toString();
            break;
        }
      }
    });

  }

}
