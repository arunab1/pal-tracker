package io.pivotal.pal.tracker;

import java.util.Collection;
import java.util.List;

public interface TimeEntryRepository {
    TimeEntry create(TimeEntry timeEntry);
    TimeEntry find(long id);

    TimeEntry update(long l, TimeEntry timeEntry);

    TimeEntry delete(long id);

    List<TimeEntry> list();
}
