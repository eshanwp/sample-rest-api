package lk.accio.sample.config.log4j;
/**
 * @author Esh
 */

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;


public class CommonUtils {

    /**
     * @return String.
     * @des generated UUID as a String to identify request processing flow
     */
    public static String getUniqueId() {
        try {
            return String.valueOf(new SecureRandom(SecureRandom.getInstance("SHA1PRNG").generateSeed(10)).nextLong());
        } catch (NoSuchAlgorithmException ex) {
            return UUID.randomUUID().toString();
        }
    }

}
