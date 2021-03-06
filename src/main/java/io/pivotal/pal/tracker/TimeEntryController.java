package io.pivotal.pal.tracker;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;

import java.util.List;


@RestController
public class TimeEntryController {

    @Autowired
    public TimeEntryRepository timeEntryRepository;
    private  final CounterService counter;
    private final GaugeService gauge;


    public TimeEntryController(
            TimeEntryRepository timeEntryRepository,
            CounterService counter,
            GaugeService gauge
    ) {
        this.timeEntryRepository = timeEntryRepository;
        this.counter = counter;
        this.gauge = gauge;
    }

    @RequestMapping(value = "/time-entries", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        System.out.println("Creating Time: " + timeEntry.getId());
        counter.increment("TimeEntry.created");
        gauge.submit("timeEntries.count", timeEntryRepository.list().size());
        return new ResponseEntity<TimeEntry>(timeEntryRepository.create(timeEntry), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/time-entries/{id}", method = RequestMethod.GET , produces = "application/json")
    public ResponseEntity<TimeEntry> read(@PathVariable("id") long id) {
        System.out.println("Reading Time>>>: " );
        TimeEntry response = timeEntryRepository.find(id);
        counter.increment("TimeEntry.read");
        if(response != null)
            return new ResponseEntity<TimeEntry>(response, HttpStatus.OK);
        else
            return new ResponseEntity<TimeEntry>(response, HttpStatus.NOT_FOUND);

    }

    @RequestMapping(value = "/time-entries", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<TimeEntry>> list() {
        System.out.println("Listing Time>>>: " );
        counter.increment("TimeEntry.listed");
        List<TimeEntry> response = timeEntryRepository.list();
        return new ResponseEntity<List<TimeEntry>>(response, HttpStatus.OK);


    }

    @RequestMapping(value = "/time-entries/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<TimeEntry> update( @PathVariable("id") long id, @RequestBody TimeEntry timeEntry) {
        System.out.println("Update Time>>>: " );
        TimeEntry response = timeEntryRepository.update(id,timeEntry);
        counter.increment("TimeEntry.updated");
        if(response != null)
            return new ResponseEntity<TimeEntry>(response, HttpStatus.OK);
        else
            return new ResponseEntity<TimeEntry>(response, HttpStatus.NOT_FOUND);

    }

    @RequestMapping(value = "/time-entries/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<TimeEntry> delete( @PathVariable("id") long id) {
        System.out.println("Delete Time>>>: " );
        timeEntryRepository.delete(id);
        counter.increment("TimeEntry.deleted");
        gauge.submit("timeEntries.count", timeEntryRepository.list().size());
        return new ResponseEntity(HttpStatus.NO_CONTENT);


    }



}