package com.example.demo.cart.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineItemTest {

    @Test
    void testAddQuantityIncreasesQuantityAndTotalPrice() {
        // 준비
        LineItem lineItem = new LineItem("1", "Test Product", 50, 2);

        // 실행
        lineItem.addQuantity(3);

        // 검증
        assertThat(lineItem.getQuantity()).isEqualTo(5);
        assertThat(lineItem.getTotalPrice()).isEqualTo(250); // 50 * 5
    }

    @Test
    void testAddQuantityWithNegativeOrZeroDoesNotChangeQuantity() {
        // 준비
        LineItem lineItem = new LineItem("1", "Test Product", 50, 2);

        // 실행
        lineItem.addQuantity(0);

        // 검증
        assertThat(lineItem.getQuantity()).isEqualTo(2);
        assertThat(lineItem.getTotalPrice()).isEqualTo(100); // 초기 가격 50 * 초기 수량 2

        // 실행
        lineItem.addQuantity(-1);

        // 검증
        assertThat(lineItem.getQuantity()).isEqualTo(2);
        assertThat(lineItem.getTotalPrice()).isEqualTo(100); // 초기 가격 50 * 초기 수량 2
    }
}