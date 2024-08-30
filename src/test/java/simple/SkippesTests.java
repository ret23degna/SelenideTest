package simple;

import static junit.framework.Assert.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("simple")
public class SkippesTests {

  @Test
  @Disabled
  void someTest1() {
    assertTrue(false);
  }
  @Test
  @Disabled
  void someTest2() {
    assertTrue(false);
  }
}
