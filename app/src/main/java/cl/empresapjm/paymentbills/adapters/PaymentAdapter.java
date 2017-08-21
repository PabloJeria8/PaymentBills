package cl.empresapjm.paymentbills.adapters;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import cl.empresapjm.paymentbills.R;
import cl.empresapjm.paymentbills.data.Queries;
import cl.empresapjm.paymentbills.models.Payment;

/**
 * Created by Pablo on 20-08-2017.
 */

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.ViewHolder> {

    private List<Payment> payments = new Queries().payments();
    private PaymentClickListener listener;
    public PaymentAdapter(PaymentClickListener listener) {
        this.listener = listener;
    }


    @Override
    public PaymentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_payment, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final Payment payment = payments.get(position);

        holder.textView.setText(payment.getPeriodP());
        holder.checkBox.setChecked(payment.isDone());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int auxposition = holder.getAdapterPosition();
                            Payment auxPayment = payments.get(auxposition);
                            auxPayment.setDone(true);
                            auxPayment.save();
                            payments.remove(auxposition);
                            notifyItemRemoved(auxposition);
                        }
                    },400);
                }

            }
        });

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Payment auxPayment =  payments.get(holder.getAdapterPosition());
                listener.clickedID(auxPayment.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return payments.size();
    }

    public void update(Payment payment) {
        payments.add(payment);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private CheckBox checkBox;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            checkBox = itemView.findViewById(R.id.paymentCb);
            textView = itemView.findViewById(R.id.paymentTv);
        }
    }
}
