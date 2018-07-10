package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.TimeEntry;
import java.util.List;

public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry timeEntry);
    public TimeEntry find(long l);
    public List<TimeEntry> list();



}