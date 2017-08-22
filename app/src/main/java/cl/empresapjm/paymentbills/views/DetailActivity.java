package cl.empresapjm.paymentbills.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import cl.empresapjm.paymentbills.R;
import cl.empresapjm.paymentbills.models.Payment;

public class DetailActivity extends AppCompatActivity {

    private Payment payment;
    private EditText description;
    private EditText amounth;
    private String kind;

    private RadioGroup selectRole;
    private RadioButton btnS;
    private RadioButton btnB;
    private RadioButton btnO;


/*    RadioGroup rg;
    RadioGroup radgroup_opcionesEventos = null;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        long id = getIntent().getLongExtra(PaymentFragment.PAYMENT_ID, 0);
        payment = Payment.findById(Payment.class, id);

        getSupportActionBar().setTitle(payment.getPeriodP());

        description = (EditText) findViewById(R.id.descriptionEt);
        amounth = (EditText) findViewById(R.id.amounthEt);

    }

    @Override
    protected void onResume() {

        super.onResume();

        selectRole = (RadioGroup) findViewById(R.id.radioGroup1);
        btnS =  (RadioButton) findViewById(R.id.serviceRb);
        btnB =  (RadioButton) findViewById(R.id.bankRb);
        btnO =  (RadioButton) findViewById(R.id.otherRb);

        if (payment.getDescription() != null){
            description.setText(payment.getDescription());
        }

        if (payment.getAmount() != null){
            amounth.setText(payment.getAmount());
        }

        if (payment.getKind() != null){
            String kind = payment.getKind().toString();

            if(kind.equals(btnS.getText().toString())){
                btnS.setChecked(true);
            }

            if(kind.equals(btnB.getText().toString())){
                btnB.setChecked(true);
            }

            if(kind.equals(btnO.getText().toString())){
                btnO.setChecked(true);
            }
        }

    }


    @Override
    protected void onPause() {
        super.onPause();

        selectRole = (RadioGroup) findViewById(R.id.radioGroup1);
        int selectedId = selectRole.getCheckedRadioButtonId();
        btnS = (RadioButton) findViewById(selectedId);

        String kind = btnS.getText().toString();

        payment.setDescription(description.getText().toString());
        payment.setAmount(amounth.getText().toString());
        payment.setKind(kind.toString());
        payment.save();
    }


}
