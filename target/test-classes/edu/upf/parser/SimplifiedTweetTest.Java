import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SimplifiedTweetTest {

  private static final String SAMPLE_JSON = 
      "{\"id\":12345,\"text\":\"Test tweet\"," +
      "\"user\":{\"id\":67890,\"name\":\"Test User\"}," +
      "\"lang\":\"en\",\"timestamp_ms\":1623477989000}";

  private static final String SAMPLE_JSON_WITH_MISSING_FIELD = 
      "{\"id\":12345," +
      "\"user\":{\"id\":67890,\"name\":\"Test User\"}," +
      "\"lang\":\"en\",\"timestamp_ms\":1623477989000}";

  @Test
  public void fromJsonTest() {
    Optional<SimplifiedTweet> tweet = SimplifiedTweet.fromJson(SAMPLE_JSON);
    assertTrue(tweet.isPresent());
    assertEquals(12345, tweet.get().getTweetId());
    assertEquals("Test tweet", tweet.get().getText());
    assertEquals(67890, tweet.get().getUserId());
    assertEquals("Test User", tweet.get().getUserName());
    assertEquals("en", tweet.get().getLanguage());
    assertEquals(1623477989000L, tweet.get().getTimestampMs());
  }

  @Test
  public void fromJsonWithMissingFieldTest() {
    Optional<SimplifiedTweet> tweet = SimplifiedTweet.fromJson(SAMPLE_JSON_WITH_MISSING_FIELD);
    assertTrue(tweet.isPresent());
    assertEquals(12345, tweet.get().getTweetId());
    assertEquals("", tweet.get().getText()); // Assert that the missing field is set to a default value
    assertEquals(67890, tweet.get().getUserId());
    assertEquals("Test User", tweet.get().getUserName());
    assertEquals("en", tweet.get().getLanguage());
    assertEquals(1623477989000L, tweet.get().getTimestampMs());
  }

  @Test
  public void fromJsonFailureTest() {
    Optional<SimplifiedTweet> tweet = SimplifiedTweet.fromJson("{\"id\":12345}");
    assertFalse(tweet.isPresent());
  }
}
