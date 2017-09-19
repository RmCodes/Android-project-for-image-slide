package com.rm.imageslide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    
    private  final String android_version_name[] = {
            "mall_1",
            "mall_2",
            "mall_3",
            "mall_4",
            "mall_5",
            "mall_6",
            "mall_7",
            "mall_8",
            "mall_9",
            "mall_10"
    };

    private final String android_image_urls[] ={
            "http://192.168.1.6/android/recycleview/display_image.php",
            "http://192.168.1.6/android/recycleview/display_image.php",
            "http://192.168.1.6/android/recycleview/display_image.php",
            "http://192.168.1.6/android/recycleview/display_image.php",
            "http://192.168.1.6/android/recycleview/display_image.php",
            "http://192.168.1.6/android/recycleview/display_image.php",
            "http://192.168.1.6/android/recycleview/display_image.php",
            "http://192.168.1.6/android/recycleview/display_image.php",
            "http://192.168.1.6/android/recycleview/display_image.php",
            "http://192.168.1.6/android/recycleview/display_image.php"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intViews();
    }

    private void intViews() {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager  = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList androidVersions = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(),androidVersions);
        recyclerView.setAdapter(adapter);
    }
    
    private ArrayList prepareData(){
        
        ArrayList android_version = new ArrayList<>();
        for (int i=0;i<android_version_name.length;i++) {
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_version_name(android_version_name[i]);
            androidVersion.setAndroid_image_url(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }
}
