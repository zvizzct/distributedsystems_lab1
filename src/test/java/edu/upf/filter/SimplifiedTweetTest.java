package edu.upf.filter;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.Optional;

import edu.upf.parser.*;

public class SimplifiedTweetTest {

    @Test
    public void testFromJson() {
        String jsonStr = "{\"id\":123456,\"text\":\"Test tweet\",\"user\":{\"id\":654321,\"name\":\"Test User\"},\"lang\":\"en\",\"timestamp_ms\":1612431565000}";
        Optional<SimplifiedTweet> tweet = SimplifiedTweet.fromJson(jsonStr);
        assertTrue(tweet.isPresent());
        assertTrue(tweet.get().getTweetId() == 123456);
        assertTrue(tweet.get().getText().equals("Test tweet"));
        assertTrue(tweet.get().getUserId() == 654321);
        assertTrue(tweet.get().getUserName().equals("Test User"));
        assertTrue(tweet.get().getLanguage().equals("en"));
        assertTrue(tweet.get().getTimestampMs() == 1612431565000L);
    }

}
