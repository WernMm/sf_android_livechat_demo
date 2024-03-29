package com.example.sflivechat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.salesforce.android.chat.core.ChatConfiguration;
import com.salesforce.android.chat.ui.ChatUI;
import com.salesforce.android.chat.ui.ChatUIClient;
import com.salesforce.android.chat.ui.ChatUIConfiguration;
import com.salesforce.android.service.common.utilities.control.Async;


public class MainActivity extends AppCompatActivity {

    private Context context;
    // DEV
    public static final String ORG_ID = "00DO000000544EH";
    public static final String DEPLOYMENT_ID = "572O000000000bk";
    public static final String BUTTON_ID = "573O000000000ey";
    public static final String LIVE_AGENT_POD = "d.la1-c1cs-ukb.salesforceliveagent.com";

    //UAT
//    public static final String ORG_ID = "00D0w0000000aS5";
//    public static final String DEPLOYMENT_ID = "572O000000000bk";
//    public static final String BUTTON_ID = "573O000000000ey";
//    public static final String LIVE_AGENT_POD = "d.la1-c1cs-ukb.salesforceliveagent.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        ChatConfiguration.Builder chatConfigBuilder = new ChatConfiguration.Builder(ORG_ID, BUTTON_ID, DEPLOYMENT_ID, LIVE_AGENT_POD);

        ChatUIConfiguration.Builder chatUIConfigurationBuilder = new ChatUIConfiguration.Builder();
        chatUIConfigurationBuilder.defaultToMinimized(false);
        chatUIConfigurationBuilder.chatConfiguration(chatConfigBuilder.build());

//        binding.salesforceMessageInputActionButton2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                launchChatViaWebView(view);
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
//            }
//        });

        ChatUI.configure(chatUIConfigurationBuilder.build())
                .createClient(getApplicationContext())
                .onResult(new Async.ResultHandler<ChatUIClient>() {
                    @Override public void handleResult (Async<?> operation,
                                                        ChatUIClient chatUIClient) {
                        chatUIClient.startChatSession(MainActivity.this);
                    }
                });
    }
}