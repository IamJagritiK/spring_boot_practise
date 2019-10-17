package com.stackroute.Listener;


import com.stackroute.domain.Muzix;
import com.stackroute.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {
    private MuzixRepository trackRepository;
    @Autowired
    public void setTrackRepository(MuzixRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
        trackRepository.save(new Muzix(1, "Desire", 4, " Studies"));
        trackRepository.save(new Muzix(2, "Hello", 7, "thersideeee"));
    }
}