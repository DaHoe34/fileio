package kr.hs.emirim.dahoe0304.fileio;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button butOut, butIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butOut = (Button)findViewById(R.id.but_output);
        butIn = (Button)findViewById(R.id.but_input);
        butOut.setOnClickListener(new View.OnClickListener() {  //파일에 저장하는일
            @Override
            public void onClick(View v){
                try {
                    FileOutputStream out = openFileOutput("2111Dahoe.txt", Context.MODE_WORLD_WRITEABLE);
                    String massage="미림여자정보과학고등학교 정말 최...고...^.^";
                    out.write(massage.getBytes());  //1차원배열로 변환해줌
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }

            }
        });

        butIn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    FileInputStream in= openFileInput("2111Dahoe.txt");
                    byte[] readMassge=new byte[200];
                    in.read(readMassge);
                    Toast.makeText(getApplicationContext(),new String(readMassge),Toast.LENGTH_LONG).show();
                    in.close();
                } catch (FileNotFoundException e) {
                    Toast.makeText(getApplicationContext(),"파일이 존재하지 않는다.",Toast.LENGTH_SHORT).show();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }

        });
    }
}
