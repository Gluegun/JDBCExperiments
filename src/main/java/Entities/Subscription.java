package Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subscriptions")
@Data
public class Subscription {

    @EmbeddedId
    private idComposite comId;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Subscription() {

    }
}
