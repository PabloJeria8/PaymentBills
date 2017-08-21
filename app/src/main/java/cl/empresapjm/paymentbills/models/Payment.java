package cl.empresapjm.paymentbills.models;

import com.orm.SugarRecord;

/**
 * Created by Pablo on 20-08-2017.
 */

public class Payment extends SugarRecord {

    private String periodP, kind, Description, amount;
    private boolean done;

    public Payment() {
    }

    public Payment(String periodP, String kind, String description, String amount, boolean done) {
        this.periodP = periodP;
        this.kind = kind;
        this.Description = description;
        this.amount = amount;
        this.done = done;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPeriodP() {
        return periodP;
    }

    public void setPeriodP(String periodP) {
        this.periodP = periodP;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }


}
