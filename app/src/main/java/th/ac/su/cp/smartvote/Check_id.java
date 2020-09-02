package th.ac.su.cp.smartvote;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Check_id extends AppCompatActivity {

    public void showDialog(Check_id c,String msg){
        AlertDialog.Builder dialog = new AlertDialog.Builder(c);
        dialog.setTitle("ผลการตรวจสอบสิทธิ์เลือกตั้ง");
        dialog.setMessage(msg);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_id);



        Button checkButton = findViewById(R.id.check_button);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextNumber = findViewById(R.id.editText_Number);
                String id = editTextNumber.getText().toString();
                String noti_toast = "กรุณากรอกหมายเลขบัตรประชาชน 13 หลัก";

                if(id==null || id.length()<13){
                    Toast t = Toast.makeText(Check_id.this,noti_toast,Toast.LENGTH_LONG);
                    t.show();
                }else {
                    if (id.equals("1111111111111") || id.equals("2222222222222")) {
                        showDialog(Check_id.this, "คุณเป็นผู้มีสิทธิเลือกตั้ง");
                    } else {
                        showDialog(Check_id.this, "คุณไม่มีสิทธิ์เลือกตั้ง");
                    }
                }
            }
        });


    }
}