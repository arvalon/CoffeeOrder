package ru.arvalon.coffeeorder.bill.impl;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import ru.arvalon.coffeeorder.bill.interfaces.IBillPresenter;
import ru.arvalon.coffeeorder.bill.interfaces.IBillView;
import ru.arvalon.coffeeorder.R;
import ru.arvalon.coffeeorder.model.CoffeeOrder;

public class BillActivity extends AppCompatActivity implements IBillView{

    private IBillPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        log(getClass().getSimpleName()+" onCreate");

        presenter=BillPresenterImpl.getInstance();
        presenter.setView(this);
        presenter.init();

        findViewById(R.id.saveOrderBtn).setOnClickListener(view -> presenter.saveOrder());

    }

    @Override
    public void notifySuccsess() {
        Toast.makeText(this,"Order save...",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void notifyError() {
        Toast.makeText(this,"Order error save...",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showOrder(CoffeeOrder order) {
        TextView price = findViewById(R.id.price);
        price.setText(String.valueOf(order.getTotalPrice()));
    }

    @Override
    public void closeBill() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unregisterView();
    }
}
