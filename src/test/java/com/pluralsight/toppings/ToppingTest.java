package com.pluralsight.toppings;

import com.pluralsight.toppings.classes.PremiumTopping;
import com.pluralsight.toppings.classes.RegularTopping;
import com.pluralsight.toppings.interfaces.Topping;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToppingTest {

        @Test
        public void regularTopping_GetCost_IncludedTopping_ReturnsZeroCost() {
            // Arrange
            Topping lettuce = new RegularTopping("lettuce");

            // Act
            String name = lettuce.getName();
            double size4 = lettuce.getCost(4);
            double size8 = lettuce.getCost(8);
            double size12 = lettuce.getCost(12);

            // Assert
            assertEquals("lettuce", name);
            assertEquals(0.0, size4);
            assertEquals(0.0, size8);
            assertEquals(0.0, size12);
        }

        @Test
        public void premiumTopping_GetCost_ExtraMeat_ReturnsExpectedCost() {
            // Arrange
            Topping steak = new PremiumTopping("steak");

            // Act
            String name = steak.getName();
            double costSize4 = steak.getCost(4);
            double costSize8 = steak.getCost(8);
            double costSize12 = steak.getCost(12);

            // Assert
            assertEquals("steak", name);
            assertEquals(1.0, costSize4);
            assertEquals(2.0, costSize8);
            assertEquals(3.0, costSize12);
        }
    }