package lk.accio.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.TimeZone;

@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "lk.accio")
@SpringBootApplication(scanBasePackages = {"lk.accio"})
public class SampleApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

    static {
        try {
            System.setProperty("hostAddress", InetAddress.getLocalHost().getHostAddress().replaceAll("\\.", "_"));
            TimeZone.setDefault(TimeZone.getTimeZone("GMT+0530"));
        } catch (UnknownHostException ex) {
            LOGGER.error("AppStartError|" + ex.getLocalizedMessage(), ex);
        }

    }

}
