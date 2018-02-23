package com.lfad.bountydevmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int LOC_AWAL = 1;
    public static final int LOC_AKHIR = 2;
    private TextView mLatlngAwal;
    private TextView mLatlngAkhir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLatlngAwal = findViewById(R.id.latlng_awal);
        mLatlngAkhir = findViewById(R.id.latlng_tujuan);
    }

    public void viewMapsAwal(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivityForResult(intent, LOC_AWAL);
    }

    public void viewMapsAkhir(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivityForResult(intent, LOC_AKHIR);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LOC_AWAL){
           if(resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                String latlng = "lat: " + bundle.getFloat("latitude") + " long: " + bundle.getFloat("longitude");
                mLatlngAwal.setText(latlng);
                mLatlngAwal.setVisibility(View.VISIBLE);
           }
        } else if (requestCode == LOC_AKHIR){
            if(resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                String latlng = "lat: " + bundle.getFloat("latitude") + " long: " + bundle.getFloat("longitude");
                mLatlngAkhir.setText(latlng);
                mLatlngAkhir.setVisibility(View.VISIBLE);
            }
        }
    }
}
