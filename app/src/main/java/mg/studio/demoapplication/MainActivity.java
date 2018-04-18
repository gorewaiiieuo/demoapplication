package mg.studio.demoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TextView tvName;
    private SessionManager session;

    private ListView listView;
    private SimpleAdapter mAdapter;
    private List<Map<String,Object>> listContent;
    public static List<demoapp> mDemoappList = new ArrayList<demoapp>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.user_name);
        listView = findViewById(R.id.listView);
        /**
         * Only logged in users should access this activity
         */
        session = new SessionManager(getApplicationContext());
        if (!session.isLoggedIn()) {
            //logout();
        }

        /**
         * If the user just registered an account from Register.class,
         * the parcelable should be retrieved
         */
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            // Retrieve the parcelable
            Feedback feedback = bundle.getParcelable("feedback");
            // Get the from the object
            String userName = feedback.getName();
            tvName.setText(userName);
        }


        mDemoappList.add(new demoapp("Lifecycle"));
        mDemoappList.add(new demoapp("UserName"));
        mDemoappList.add(new demoapp("UserName_Final"));
        mDemoappList.add(new demoapp("Layout"));
        mDemoappList.add(new demoapp("Layout_Final"));
        mDemoappList.add(new demoapp("Button_Design"));
        mDemoappList.add(new demoapp("Button_Toast"));
        mDemoappList.add(new demoapp("Button_Intent"));
        mDemoappList.add(new demoapp("Button_StartActivity"));
        mDemoappList.add(new demoapp("Button_StartActivity_extra"));
        mDemoappList.add(new demoapp("ImageButton"));
        mDemoappList.add(new demoapp("EditText"));
        mDemoappList.add(new demoapp("RadioButtons_listener"));
        mDemoappList.add(new demoapp("RadioButtons_onclick"));
        mDemoappList.add(new demoapp("listView"));
        mDemoappList.add(new demoapp("GetColor"));
        mDemoappList.add(new demoapp("GradientBackground"));
        mDemoappList.add(new demoapp("AppIntentCaller"));
        mDemoappList.add(new demoapp("AppIntentReceiver"));
        mDemoappList.add(new demoapp("Weather_App_Design"));
        mDemoappList.add(new demoapp("ListViewCustomAdapter"));
        mDemoappList.add(new demoapp("ListViewCustomAdapter"));
        mDemoappList.add(new demoapp("AudioRecorder"));
        mDemoappList.add(new demoapp("DataBase"));
        mDemoappList.add(new demoapp("FragmentOne"));
        mDemoappList.add(new demoapp("Webview"));
        mDemoappList.add(new demoapp("ServiceDemo"));
        mDemoappList.add(new demoapp("Service"));
        mDemoappList.add(new demoapp("Fingerprint"));
        mDemoappList.add(new demoapp("AppPrivateDirectory"));
        mDemoappList.add(new demoapp("AssetsFolder"));
        mDemoappList.add(new demoapp("IntentExtras"));


        String[] tvRes = new String[]{"00_LifeCycle","01_UserName","02_Layout","03_Button_Design","03_Button_Toast",
                "04_Button_Intent","05_Button_StartActivity","05_Button_StartActivity_extra","06_ImageButton","07_EditText",
                "08_RadioButtons_listener","08_RadioButtons_onclick","09_listView","10_GetColor","11_GradientBackground","12_ImplicitIntent",
                "13_Weather_App_Design","15_ListView","16_ListViewCustomAdapter","17_AudioRecorder","19_DataBase","20_FragmentOne","21_Webview",
                "22_ServiceDemo","23_Service","24_Fingerprint","25_AppPrivateDirectory","26_AssetsFolder","27_IntentExtras"};
        int[] imgRes = new int[tvRes.length];
        for(int i = 0; i <tvRes.length; i++ ){
            imgRes[i] = R.drawable.file;
        }
        listContent = new ArrayList<>();

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < tvRes.length; j++){
                Map<String, Object> map = new HashMap<>();
                map.put("iv_title", imgRes[j]);
                map.put("tv_demoname", tvRes[j]);
                listContent.add(map);
            }
        }

        //mListViewFinal = findViewById(R.id.lv_demo);
        mAdapter = new SimpleAdapter(this,
                listContent,
                R.layout.listview_item,
                new String[]{"iv_title","tv_demoname"},
                new int[]{R.id.iv_title, R.id.tv_demoname});
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(getApplicationContext(), Lifecycle.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(), UserName.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), UserName_Final.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(), Layout.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(), Layout_Final.class));
                        break;
                    case 5:
                        startActivity(new Intent(getApplicationContext(), Button_Design.class));
                        break;
                    case 6:
                        startActivity(new Intent(getApplicationContext(), Button_Toast.class));
                        break;
                    case 7:
                        startActivity(new Intent(getApplicationContext(), Button_Intent.class));
                        break;
                    case 8:
                        startActivity(new Intent(getApplicationContext(), Button_StartActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(getApplicationContext(), Button_StartActivity_extra.class));
                        break;
                    case 10:
                        startActivity(new Intent(getApplicationContext(), ImageButton.class));
                        break;
                    case 11:
                        startActivity(new Intent(getApplicationContext(), EditTextActivity.class));
                        break;
                    case 12:
                        startActivity(new Intent(getApplicationContext(), RadioButtons_listener.class));
                        break;
                    case 13:
                        startActivity(new Intent(getApplicationContext(), RadioButtons_onclick.class));
                        break;
                    case 14:
                        startActivity(new Intent(getApplicationContext(), listView.class));
                        break;
                    case 15:
                        startActivity(new Intent(getApplicationContext(), GetColor.class));
                        break;
                    case 16:
                        startActivity(new Intent(getApplicationContext(), GradientBackground.class));
                        break;
                    case 17:
                        startActivity(new Intent(getApplicationContext(), AppIntentCaller.class));
                        break;
                    case 18:
                        startActivity(new Intent(getApplicationContext(), AppIntentReceiver.class));
                        break;
                    case 19:
                        startActivity(new Intent(getApplicationContext(), Weather_App_Design.class));
                        break;
                    case 20:
                        startActivity(new Intent(getApplicationContext(), ListViewCustomAdapter.class));
                        break;
                    case 21:
                        startActivity(new Intent(getApplicationContext(), ListViewAcitivity.class));
                        break;
                    case 22:
                        startActivity(new Intent(getApplicationContext(), AudioRecorder.class));
                        break;
                    case 23:
                        startActivity(new Intent(getApplicationContext(), DataBase.class));
                        break;
                    case 24:
                        startActivity(new Intent(getApplicationContext(), FragmentOne.class));
                        break;
                    case 25:
                        startActivity(new Intent(getApplicationContext(), Webview.class));
                        break;
                    case 26:
                        startActivity(new Intent(getApplicationContext(), ServiceDemo.class));
                        break;
                    case 27:
                        startActivity(new Intent(getApplicationContext(), Service.class));
                        break;
                    case 28:
                        startActivity(new Intent(getApplicationContext(), Fingerprint.class));
                        break;
                    case 29:
                        startActivity(new Intent(getApplicationContext(), AppPrivateDirectory.class));
                        break;
                    case 30:
                        startActivity(new Intent(getApplicationContext(), AssetsFolder.class));
                        break;
                    case 31:
                        startActivity(new Intent(getApplicationContext(), IntentExtras.class));
                        break;

                }
            }
        });

    }

    /**
     * Logging out the user:
     * - Will set isLoggedIn flag to false in SharedPreferences
     * - Clears the user data from SqLite users table
     */

    public void btnLogout(View view) {
        logout();
    }

    public void logout() {
        // Updating the session
        session.setLogin(false);
        // Redirect the user to the login activity
        startActivity(new Intent(this, Login.class));
        finish();
    }



}