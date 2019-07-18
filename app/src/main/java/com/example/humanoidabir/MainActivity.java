package com.example.humanoidabir;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button task_1 , task_2 , task_3 , task_4;
    MQTT mqtt ;
    String topic , data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        task_1 = findViewById(R.id.task1);
        task_2 = findViewById(R.id.task2);
        task_3 = findViewById(R.id.task3);
        task_4 = findViewById(R.id.task4);


        topic = "Abir_Humanoid_data_transmit";

        mqtt = new MQTT(MainActivity.this,topic);
        mqtt.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean b, String s) {
            }

            @Override
            public void connectionLost(Throwable throwable) {
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {

                Log.d("test","this is the msg : "+mqttMessage.toString());

            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
            }
        });


        task_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mqtt.publishMessage("Task_1","Turn off the fan");
                Toast.makeText(MainActivity.this , "Turn off the fan" , Toast.LENGTH_LONG).show();
            }
        });

        task_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mqtt.publishMessage("Task_1","clean the floor");
                Toast.makeText(MainActivity.this , "clean the floor", Toast.LENGTH_LONG).show();
            }
        });

        task_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mqtt.publishMessage("Task_1","open the door");
                Toast.makeText(MainActivity.this , "open the door", Toast.LENGTH_LONG).show();
            }
        });

        task_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mqtt.publishMessage("Task_1","say some jokes");
                Toast.makeText(MainActivity.this , "say some jokes", Toast.LENGTH_LONG).show();
            }
        });

    }
}
