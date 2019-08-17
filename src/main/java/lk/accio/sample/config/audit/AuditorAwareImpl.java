package lk.accio.sample.config.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

//    @Autowired
//    private UserService userService;

    @Override
    public Optional<String> getCurrentAuditor() {

        //Computer user name
//        return Optional.of(userService.loggedUser());

        return Optional.of("Mr. Eshan");
    }


}
