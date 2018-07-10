package io.pivotal.pal.tracker;


import org.springframework.beans.factory.annotation.Autowired;
import io.pivotal.pal.tracker.TimeEntry;
import io.pivotal.pal.tracker.TimeEntryRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import static java.util.Arrays.asList;



@RestController
public class TimeEntryController {

    @Autowired
    public TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }


    @RequestMapping(value = "/create/", method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody TimeEntry timeEntry) {
        System.out.println("Creating Time " + timeEntry.getId());
        return new ResponseEntity<Object>(timeEntryRepository.create(timeEntry), HttpStatus.CREATED);
    }



}