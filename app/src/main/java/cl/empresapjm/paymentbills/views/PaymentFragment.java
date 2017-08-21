package cl.empresapjm.paymentbills.views;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.empresapjm.paymentbills.R;
import cl.empresapjm.paymentbills.adapters.PaymentAdapter;
import cl.empresapjm.paymentbills.adapters.PaymentClickListener;
import cl.empresapjm.paymentbills.models.Payment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentFragment extends Fragment implements PaymentClickListener {

    private PaymentAdapter adapter;
    public static final String PAYMENT_ID = "cl.empresapjm.paymentbills.views.key.PAYMENT_ID";

    public PaymentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.paymentRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter =  new PaymentAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    public void updateList (Payment payment){
        adapter.update(payment);
    }

    @Override
    public void clickedID(Long id) {
        Intent intent = new Intent (getContext(), DetailActivity.class);
        intent.putExtra (PAYMENT_ID, id);
        startActivity (intent);
    }


}
