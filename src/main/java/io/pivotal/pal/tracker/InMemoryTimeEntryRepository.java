package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.TimeEntryRepository;
import io.pivotal.pal.tracker.TimeEntry;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import static java.util.Arrays.asList;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    HashMap<Long, TimeEntry> timeEntryHashMap = new HashMap<Long, TimeEntry>();

    public TimeEntry create(TimeEntry timeEntry) {
        Long id = timeEntryHashMap.size() + 1L;

        TimeEntry createdTimeEntry = new TimeEntry (
            id,
            timeEntry.getProjectId(),
            timeEntry.getUserId(),
            timeEntry.getDate(),
            timeEntry.getHours()
        );

        timeEntryHashMap.put(id, createdTimeEntry);
        return createdTimeEntry;
    }

    public TimeEntry find(long l) {
        return timeEntryHashMap.get(l);
    }


    public List<TimeEntry> list() {
        List<TimeEntry> result = new ArrayList<TimeEntry>(timeEntryHashMap.values());
        return result;
    }

     public TimeEntry update(long l, TimeEntry timeEntry){

         TimeEntry updatedTimeEntry = new TimeEntry (
                 l,
                 timeEntry.getProjectId(),
                 timeEntry.getUserId(),
                 timeEntry.getDate(),
                 timeEntry.getHours()
         );

         timeEntryHashMap.put(l, updatedTimeEntry);
         return updatedTimeEntry;


     }

   public TimeEntry delete(long l) {

       TimeEntry deletedTimeEntry = timeEntryHashMap.get(l);
       return timeEntryHashMap.remove(l);
   }


}