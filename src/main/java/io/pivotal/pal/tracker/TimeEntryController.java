package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {

        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry timeEntry = timeEntryRepository.create(timeEntryToCreate);
        ResponseEntity responseEntity = new ResponseEntity<TimeEntry>(timeEntry, null, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
        ResponseEntity responseEntity = null;

        TimeEntry timeEntry = timeEntryRepository.find(timeEntryId);
        if(timeEntry == null){
            responseEntity = new ResponseEntity<TimeEntry>(timeEntry, null, HttpStatus.NOT_FOUND);
        }else {
            responseEntity = new ResponseEntity<TimeEntry>(timeEntry, null, HttpStatus.OK);
        }
        return responseEntity;
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> timeEntries = timeEntryRepository.list();
        ResponseEntity responseEntity = new ResponseEntity<List<TimeEntry>>(timeEntries, null, HttpStatus.OK);
        return responseEntity;
    }
    @PutMapping("/time-entries/{id}")
    public ResponseEntity update(@PathVariable long id,@RequestBody TimeEntry timeEntry) {
        ResponseEntity responseEntity = null;

        TimeEntry updatedTimeEntry = timeEntryRepository.update(id, timeEntry);
        if(updatedTimeEntry == null){
            responseEntity = new ResponseEntity<TimeEntry>(updatedTimeEntry, null, HttpStatus.NOT_FOUND);
        }else {
            responseEntity = new ResponseEntity<TimeEntry>(updatedTimeEntry, null, HttpStatus.OK);
        }
        return responseEntity;
    }

    @DeleteMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long timeEntryId) {

        ResponseEntity responseEntity = null;

        TimeEntry deletedTimeEntry = timeEntryRepository.delete(timeEntryId);

        responseEntity = new ResponseEntity<TimeEntry>(deletedTimeEntry, null, HttpStatus.NO_CONTENT);
        return responseEntity;
    }
}
