package com.swm.sportwithme.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "log_phone_pass_hash")
public class LogPassModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String logPassHash;
    String phonePassHash;
    @OneToOne
    CustomersModel customerId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogPassModel that = (LogPassModel) o;
        return Objects.equals(id, that.id) && Objects.equals(logPassHash, that.logPassHash) && Objects.equals(phonePassHash, that.phonePassHash) && Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, logPassHash, phonePassHash, customerId);
    }

    @Override
    public String toString() {
        return "LogPassModel{" +
                "logPassHash='" + logPassHash + '\'' +
                ", phonePassHash='" + phonePassHash + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
