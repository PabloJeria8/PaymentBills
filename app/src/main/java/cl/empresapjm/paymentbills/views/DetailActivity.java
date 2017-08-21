package cl.empresapjm.paymentbills.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import cl.empresapjm.paymentbills.R;
import cl.empresapjm.paymentbills.models.Payment;

public class DetailActivity extends AppCompatActivity {

    private Payment payment;
    private EditText description;
    private EditText amounth;
    private EditText kind;
/*    RadioGroup rg;
    RadioGroup radgroup_opcionesEventos = null;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        long id = getIntent().getLongExtra(PaymentFragment.PAYMENT_ID, 0);
        payment = Payment.findById(Payment.class, id);

        getSupportActionBar().setTitle(payment.getPeriodP());

/*        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
        final String value =
                ((RadioButton)findViewById(rg.getCheckedRadioButtonId()))
                        .getText().toString();

        rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                (EditText) kind = (EditText) value;
            }
        });*/

        description = (EditText) findViewById(R.id.descriptionEt);
        amounth = (EditText) findViewById(R.id.amounthEt);

    }

    @Override
    protected void onResume() {

/*        radgroup_opcionesEventos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                String mySelectedIndex = radioButton.getTag().toString();
            }
        });*/

        super.onResume();

        if (payment.getDescription() != null){
            description.setText(payment.getDescription());
        }

        if (payment.getAmount() != null){
            amounth.setText(payment.getAmount());
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        payment.setDescription(description.getText().toString());
        payment.setAmount(amounth.getText().toString());
        payment.save();
    }


}
