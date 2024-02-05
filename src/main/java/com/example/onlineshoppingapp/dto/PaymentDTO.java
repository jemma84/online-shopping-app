package com.example.onlineshoppingapp.dto;

import com.example.onlineshoppingapp.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.atn.SemanticContext;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDTO implements Serializable {
    private Long id;

    private PaymentStatus status;

    private long paypalPaymentId;

    private BigDecimal amount;
}
