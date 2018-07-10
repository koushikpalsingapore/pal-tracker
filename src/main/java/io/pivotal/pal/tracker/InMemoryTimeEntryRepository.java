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

     public TimeEntry update(long l, TimeEntry timeEntry) throws Exception {


         updatedEntry

    }

   /* public void delete() throws Exception {
        InMemoryTimeEntryRepository repo = new InMemoryTimeEntryRepository();
        TimeEntry created = repo.create(new TimeEntry(123L, 456L, LocalDate.parse("2017-01-08"), 8));

        repo.delete(created.getId());
        assertThat(repo.list()).isEmpty();
    }*/


}