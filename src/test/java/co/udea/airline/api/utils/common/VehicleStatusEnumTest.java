package co.udea.airline.api.utils.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VehicleStatusEnumTest {

  @Test
  void testEnumValues() {
    assertEquals("ACTIVE", VehicleStatusEnum.ACTIVE.name());
    assertEquals("INACTIVE", VehicleStatusEnum.INACTIVE.name());
  }

  @Test
  void testValueOf() {
    assertEquals(VehicleStatusEnum.ACTIVE, VehicleStatusEnum.valueOf("ACTIVE"));
    assertEquals(VehicleStatusEnum.INACTIVE, VehicleStatusEnum.valueOf("INACTIVE"));

    assertThrows(IllegalArgumentException.class, () -> VehicleStatusEnum.valueOf("INVALID_VALUE"));
  }

  @Test
  void testValues() {
    VehicleStatusEnum[] vehicleStatuses = VehicleStatusEnum.values();
    assertEquals(2, vehicleStatuses.length);
    assertEquals(VehicleStatusEnum.ACTIVE, vehicleStatuses[0]);
    assertEquals(VehicleStatusEnum.INACTIVE, vehicleStatuses[1]);
  }
}
