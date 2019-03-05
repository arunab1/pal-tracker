package io.pivotal.pal.tracker;

import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    private Map<Long, TimeEntry> timeEntryMap = new HashMap<Long, TimeEntry>();
    long counter = 0;
    @Override

    public TimeEntry create(TimeEntry timeEntry) {
        ++counter;
        TimeEntry createdTimeEntry = new TimeEntry(counter, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntryMap.put(createdTimeEntry.getId(), createdTimeEntry);
        return createdTimeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        return timeEntryMap.get(id);
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if(timeEntryMap.containsKey(id) == false) {
            return null;
        }
        TimeEntry updatedTimeEntry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntryMap.put(updatedTimeEntry.getId(), updatedTimeEntry);
        return updatedTimeEntry;
    }

    @Override
    public TimeEntry delete(long id) {
        return timeEntryMap.remove(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(timeEntryMap.values());
    }
}
