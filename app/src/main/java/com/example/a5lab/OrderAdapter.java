package com.example.a5lab;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends BaseAdapter {

    Context context;  /* Context – это объект, который предоставляет доступ к базовым функциям
                         приложения: доступ к ресурсам, к файловой системе, вызов активности и т.д */

    List<Order> orders;

    public OrderAdapter(Context context, DeliverySystem deliverySystem) {
        this.context = context;
        this.orders = deliverySystem.getOrders();
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Object getItem(int i) {
        return orders.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /* Метод getVew() содержит параметр convertView, который позволяет использовать заново
        уже существующий элемент списка, который не отображается, т.к. пользователь пролистнул его
        с видимой части дисплея. Если convertView не пустой, он может быть использован заново,
        чтобы не грузить разметку списка. Подобный подход способствует увеличению производительности.*/

        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.order, parent, false);
        }

        setUpData(view, position);
        return view;

    }

    public void setUpData(View view, int position) {
        LinearLayout linearLayout = view.findViewById(R.id.id_order);
        LinearLayout nestedLinearLayout = linearLayout.findViewById(R.id.order_info);
        Order currentOrder = (Order) getItem(position);
        CardView cardView = view.findViewById(R.id.addresses);
        String price = currentOrder.getCost() + " ₽";

        ((TextView) nestedLinearLayout.findViewById(R.id.firm_name)).setText(currentOrder.getFirm().getName());
        ((TextView) nestedLinearLayout.findViewById(R.id.type_of_sending)).setText(currentOrder.getSending().getTypeOfSending().toString());
        ((TextView) cardView.findViewById(R.id.from_add)).setText(currentOrder.getAddressFrom());
        ((TextView) cardView.findViewById(R.id.to_add)).setText(currentOrder.getAddressTo());
        ((TextView) nestedLinearLayout.findViewById(R.id.price)).setText(price);

        CheckBox checkBox = linearLayout.findViewById(R.id.cbBox);
        checkBox.setChecked(false);

    }
}
