package com.psuwgipgf.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.psuwgipgf.okhttplib.OkHttpManager;
import com.psuwgipgf.okhttplib.callback.CallResult;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends Activity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView)findViewById(R.id.text);
    }

    public void onClick( View v){
        final View view=v;
        switch (v.getId()){
            case R.id.button:
                OkHttpManager.get()
                        .url("/")
                        .tag("get")
                        .exec(new CallResult(){
                            @Override
                            public void onResponse(Call call, final Response response) throws IOException {
                                view.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            text.setText(response.body().string());
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }

                            @Override
                            public void onFailure(Call call, IOException e) {

                            }
                        });
                break;
            default:
                break;
        }
    }

}
