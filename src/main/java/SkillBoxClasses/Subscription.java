package SkillBoxClasses;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @EmbeddedId
    private idComposite comId;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Subscription() {
    }

    public idComposite getComId() {
        return comId;
    }

    public void setComId(idComposite comId) {
        this.comId = comId;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
