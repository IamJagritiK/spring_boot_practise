package com.stackroute.commandLine;

import com.stackroute.domain.Muzix;
import com.stackroute.repository.MuzixRepository;
import com.stackroute.service.MuzixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

    @PropertySource("classpath:application.properties")
    @Component
    public class CommandLineStartupRunner implements CommandLineRunner {

        private MuzixService muzixService;
        @Value("${in.name}")
        private String name;
        @Value("${in.comment}")
        private String comment;
        public CommandLineStartupRunner(@Autowired MuzixService muzixService) { this.muzixService = muzixService;    }



        private MuzixRepository trackRepository;

        @Autowired
        public void setTrackRepository(MuzixRepository trackRepository) {
            this.trackRepository = trackRepository;
        }
        @Override
        public void run(String... args) throws Exception {
            trackRepository.save(new Muzix(3, name, 4 ,comment ));
        }
    }

