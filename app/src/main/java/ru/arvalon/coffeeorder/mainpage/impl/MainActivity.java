package ru.arvalon.coffeeorder.mainpage.impl;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ru.arvalon.coffeeorder.R;
import ru.arvalon.coffeeorder.bill.impl.BillActivity;
import ru.arvalon.coffeeorder.mainpage.interfaces.CoffeeOrderView;
import ru.arvalon.coffeeorder.mainpage.interfaces.IMainPagePresenter;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, CoffeeOrderView {

    static final String TAG = "coffee.log";

    private final static String COFFEE_COUNT = "coffee_count";

    public final static String COFFEE_PRICE = "coffee_price";

    private IMainPagePresenter presenter;

    /** Цена за 1 порцию кофе */
    private EditText mCoffePrice;

    /** Количество порций кофе */
    private TextView mCoffeeCount;

    /** Итоговая цена */
    private TextView mTotalPrice;

    /** Порция кофе */
    //private CoffeeOrder mOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        log(getClass().getSimpleName()+" onCreate");

        presenter= MainPagePresenterImpl.getInstance();
        presenter.setView(this);

        setContentView(R.layout.activity_main);

        mCoffePrice = findViewById(R.id.coffee_price);
        mTotalPrice = findViewById(R.id.total_price);

        mCoffeeCount = findViewById(R.id.coffee_count);

        mCoffePrice.setText(String.valueOf(presenter.getPrice()));

        mTotalPrice.setText(String.valueOf(presenter.getTotalPrice()));

        findViewById(R.id.coffee_increment).setOnClickListener(this);
        findViewById(R.id.coffee_decrement).setOnClickListener(this);
        findViewById(R.id.bill_btn).setOnClickListener(this);

        mCoffePrice.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length()!=0){
                    presenter.setPrice(Double.valueOf(editable.toString()));
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        log(getClass().getSimpleName()+" onResume");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.coffee_increment:
                presenter.incrementCoffeeCount();
                break;

            case R.id.coffee_decrement:
                presenter.decrementCoffeeCount();
                break;

            case R.id.bill_btn:
                showBill();
                break;
        }
    }

    @Override
    public void updateCoffeeCount() {
        mCoffeeCount.setText(String.valueOf(presenter.getCoffeeCount()));
    }

    @Override
    public void updatePrice() {
        mCoffePrice.setText(String.valueOf(presenter.getPrice()));
    }

    @Override
    public void updateTotalPrice() {
        mTotalPrice.setText(String.valueOf(presenter.getTotalPrice()));
    }

    /** открыть активность со счётом за кофе */
    private void showBill() {
        Intent i = new Intent(this,BillActivity.class);
        startActivity(i);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unregisterView();
    }
}
