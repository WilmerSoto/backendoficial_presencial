package co.udea.airline.api.utils.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StateDriverEnumTest {
  @Test
  void testEnumValues() {
      assertEquals("ACTIVE", StateDriverEnum.ACTIVE.name());
      assertEquals("INACTIVE", StateDriverEnum.INACTIVE.name());
      assertEquals("REST", StateDriverEnum.REST.name());
  }

  @Test
  void testValueOf() {
      assertEquals(StateDriverEnum.ACTIVE, StateDriverEnum.valueOf("ACTIVE"));
      assertEquals(StateDriverEnum.INACTIVE, StateDriverEnum.valueOf("INACTIVE"));
      assertEquals(StateDriverEnum.REST, StateDriverEnum.valueOf("REST"));

      assertThrows(IllegalArgumentException.class, () -> StateDriverEnum.valueOf("INVALID_VALUE"));
  }

  @Test
  void testValues() {
      StateDriverEnum[] states = StateDriverEnum.values();
      assertEquals(3, states.length);
      assertEquals(StateDriverEnum.ACTIVE, states[0]);
      assertEquals(StateDriverEnum.INACTIVE, states[1]);
      assertEquals(StateDriverEnum.REST, states[2]);
  }
}
