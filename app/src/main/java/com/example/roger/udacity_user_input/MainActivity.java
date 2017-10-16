package com.example.roger.udacity_user_input;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.quantity_text_view)
    TextView quantityTextView;
    @BindView(R.id.order_summary_text_view)
    TextView orderSummaryTextView;
    @BindView(R.id.add_whipped_cream)
    CheckBox whippedCream;
    @BindView(R.id.add_chocolate)
    CheckBox chocolate;
    @BindView(R.id.name_field)
    EditText NameEditTextField;

    int quantity = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind the view using butterknife
        ButterKnife.bind(this);

    }

    @OnClick(R.id.increment)
    public void incrementQuantity(View view) {
        quantity++;
        displayQuantity(quantity);


    }

    @OnClick(R.id.decrement)
    public void decrementQuantity(View view) {
        quantity--;
        if (quantity < 0) quantity = 0;
        displayQuantity(quantity);

    }


    @OnClick(R.id.button)
    public void submitOrder(View view) {

        boolean addWhippedCream = whippedCream.isChecked();
        boolean addChocolate = chocolate.isChecked();
        String name = NameEditTextField.getText().toString();


        int price = calculatePrice();
        String priceMessage = createOrderSummary(price, name, addWhippedCream, addChocolate);
        displayMessage(priceMessage);
    }

    private String createOrderSummary(int price, String name, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";

        return priceMessage;
    }

    private int calculatePrice() {
        return quantity * 5;
    }

    private void displayQuantity(int quantity) {
        quantityTextView.setText(String.valueOf(quantity));
    }


    private void displayMessage(String message) {
        orderSummaryTextView.setText(message);
    }


}
