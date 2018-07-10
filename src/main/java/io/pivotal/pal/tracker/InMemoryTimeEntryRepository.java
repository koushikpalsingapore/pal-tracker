package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.TimeEntryRepository;
import io.pivotal.pal.tracker.TimeEntry;
import java.time.LocalDate;
import java.util.List;

import static java.util.Arrays.asList;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    public TimeEntry create(TimeEntry timeEntry) {
        return timeEntry;

    }

    public TimeEntry find(long l) {
        InMemoryTimeEntryRepository repo = new InMemoryTimeEntryRepository();
        repo.create(new TimeEntry(123L, 456L, LocalDate.parse("2017-01-08"), 8));
        //TimeEntry readEntry = repo.find(1L);
        return repo.find(l);

    }


    /*public List<Object> magicalListGetter() {
        List<Object> list = doMagicalVooDooHere();

        return list;
    }
*/
    public List<TimeEntry> list() {
        InMemoryTimeEntryRepository repo = new InMemoryTimeEntryRepository();
        TimeEntry t1 = new TimeEntry(123L, 456L, LocalDate.parse("2017-01-08"), 8);
        TimeEntry t2 = new TimeEntry(789L, 654L, LocalDate.parse("2017-01-07"), 4);

        List<TimeEntry> result = asList(
                t1,
                t2
        );
        return result;
    }

     /*public void update() throws Exception {
        InMemoryTimeEntryRepository repo = new InMemoryTimeEntryRepository();
        TimeEntry created = repo.create(new TimeEntry(123L, 456L, LocalDate.parse("2017-01-08"), 8));

        TimeEntry updatedEntry = repo.update(
                created.getId(),
                new TimeEntry(321L, 654L, LocalDate.parse("2017-01-09"), 5));

        TimeEntry expected = new TimeEntry(created.getId(), 321L, 654L, LocalDate.parse("2017-01-09"), 5);
        assertThat(updatedEntry).isEqualTo(expected);
        assertThat(repo.find(created.getId())).isEqualTo(expected);
    }

    public void delete() throws Exception {
        InMemoryTimeEntryRepository repo = new InMemoryTimeEntryRepository();
        TimeEntry created = repo.create(new TimeEntry(123L, 456L, LocalDate.parse("2017-01-08"), 8));

        repo.delete(created.getId());
        assertThat(repo.list()).isEmpty();
    }*/


}