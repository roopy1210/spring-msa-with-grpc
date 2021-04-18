package com.roopy.domain;

import lombok.*;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PaymentApproval {

    @Id
    @Column(name = "aprval_no", nullable = false, length = 15)
    private String aprvalNo;

    @Column(name = "aprval_amt", nullable = false)
    private Integer aprvalAmt;

    @Column(name = "aprval_dtm", nullable = false, length = 14)
    private String aprvalDtm;

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, new MultilineRecursiveToStringStyle()).toString();
    }
}
