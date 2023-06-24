package com.example.a5lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DeliverySystem deliverySystem = new DeliverySystem();

    // поля для добавления информации курьере

    private ConstraintLayout constraintLayout;

    private ImageView imageView;

    private TextView fullName;

    private TextView settlementAccount;


    // поля для списка заказов

    private ListView listView;

    private OrderAdapter orderAdapter = new OrderAdapter(this, deliverySystem);


    // поля для кнопок

    private Button clearButton;

    private Button calculateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // блок с информацией о курьере
        setCourierInfo();

        // блок с заказами
        listView = findViewById(R.id.lvMain);
        listView.setAdapter(orderAdapter);

        // блок с кнопками
        calculateButton = findViewById(R.id.ok_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotalCost();
            }
        });
        clearButton = findViewById(R.id.clear_button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAllCheckBoxes();
            }
        });

    }

    private void setCourierInfo() {
        // находим ConstraintLayout, в который помещена информаация
        constraintLayout = findViewById(R.id.info_field);
        // находим аватарку и подставляем новую
        imageView = constraintLayout.findViewById(R.id.avatar_photo);
        imageView.setImageResource(R.drawable.avatar1);
        // находим текстовый блок с полным именем и подставляем нужное
        fullName = constraintLayout.findViewById(R.id.full_name);
        fullName.setText(deliverySystem.getCourier().getName());
        // то же самое с расчетным счетом
        settlementAccount = constraintLayout.findViewById(R.id.settlement_acc);
        settlementAccount.setText(deliverySystem.getCourier().getBalance());
    }


    private void calculateTotalCost() {
        int totalCost = 0;
        List<Order> orders = deliverySystem.getOrders();

        Order order;
        //View view;
        for (int i = 0; i < orders.size(); i++) {
            order = orders.get(i);

            View view = listView.getChildAt(i);  // здесь при i = 3 и i = 4  view = nul



            if (view != null) {

                CheckBox checkBox = view.findViewById(R.id.cbBox);

                // когда выбрала 5ый заказ (индекс i = 4), во view почему-то записался 3ий заказ (индекс i = 2)
                if (checkBox != null && checkBox.isChecked() && deliverySystem.courierAbility(i)) {
                    totalCost += order.getCost();
                    Log.d("GETCOST", order.getCost() + "");
                    Log.d("LISTVIEW_CHILD", view + "");
                    Log.d("HASH", order + "");
                } else if (checkBox == null) {
                    Log.e("CalculateTotalCost", "CheckBox is null for order at position: " + i);
                }

            } else {
                Log.e("CalculateTotalCost", "View is null for order at position: " + i);
            }
        }
        Toast.makeText(this, "Total Cost: " + totalCost + " rubles", Toast.LENGTH_SHORT).show();
    }

    private void clearAllCheckBoxes() {
        for (int i = 0; i < deliverySystem.getOrders().size(); i++) {
            View view = listView.getChildAt(i);
            if (view == null) {
                Log.e("ClearAllCheckBoxes", "View is null for order at position: " + i);
            } else {
                CheckBox checkBox = view.findViewById(R.id.cbBox);
                if (checkBox != null) {
                    checkBox.setChecked(false);
                } else {
                    Log.e("ClearAllCheckBoxes", "CheckBox is null for order at position: " + i);
                }
            }

        }
    }


}