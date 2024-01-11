package wow.startup.ci;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private String code = "" ;
Drawable point_background_solid , bordered_dot_background ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_registers);
        bordered_dot_background  = getResources().getDrawable(R.drawable.bordered_dot_background );
        point_background_solid = getResources().getDrawable(R.drawable.point_background_solid);

    }

    public void handlePadBtnClicked(View view){
        Button button = (Button) view ;
        String numberCliked = button.getText().toString();
//        System.out.println(numberCliked);
        code = code + numberCliked;
        Log.i(TAG, code);
        setCodePoint();
      if(code.length()==4) {
          Log.i(TAG, "Auth req");
          boolean isAuth = false;
          if(isAuth){
          }else {
              Toast.makeText(MainActivity.this , "Auth echou" , Toast.LENGTH_SHORT).show();
              handleCodeReset();
          }
      }
    }

    public void  setCodePoint(){
        LinearLayout  point_layout = findViewById(R.id.point_layout);
        for (int i =0; i<4; i++){
            if(i<= code.length() - 1){
                point_layout.getChildAt(i).setBackground(point_background_solid);
            } else {
                point_layout.getChildAt(i).setBackground(bordered_dot_background);
            }
        }
    }

    private void handleCodeReset() {
        if (!code.isEmpty()) {
            code = "";
            setCodePoint();
        }
    }
    public void handlePadDeleteClick(View view) {
        if (!code.isEmpty()) {
            code = code.substring(0, code.length() - 1);
            setCodePoint();
        }
    }
}