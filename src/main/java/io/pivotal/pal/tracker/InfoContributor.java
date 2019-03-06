package io.pivotal.pal.tracker;

import org.springframework.boot.actuate.info.Info;
import org.springframework.stereotype.Component;

@Component
public class InfoContributor implements org.springframework.boot.actuate.info.InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {

        builder.withDetail("version","0.0.1");

    }
}
