package cl.empresapjm.paymentbills.data;

import java.util.ArrayList;
import java.util.List;

import cl.empresapjm.paymentbills.models.Payment;

/**
 * Created by Pablo on 20-08-2017.
 */

public class Queries {

    public List<Payment> payments(){

        List<Payment> payments =  new ArrayList<>();
        List<Payment> paymentListList =  Payment.find(Payment.class, "done = 0");

        if (paymentListList != null && paymentListList.size()>0){
            payments.addAll(paymentListList);
        }
        return payments;
    }
}
