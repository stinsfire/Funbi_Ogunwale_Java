package com.example.utilityapi.controller;

import com.example.utilityapi.models.Record;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RecordStoreController {

    private List<Record> recordList;

    private static int idCounter = 1;

    public RecordStoreController() {
        recordList = new ArrayList<>();

        recordList.add(new Record("The Beach Boys", "Pet Sounds", "1968", idCounter++));
        recordList.add(new Record("Billy Joel", "The Stranger", "1977", idCounter++));
        recordList.add(new Record("The Beatles", "Revolver", "1964", idCounter++));
        recordList.add(new Record("Kanye West", "My Beautiful Dark Twisted Fantasy", "2008", idCounter++));
        recordList.add(new Record("Sturgill Simpson", "Metamodern Sounds in Country Music", "2010", idCounter++));
    }

    @RequestMapping(value = "/records", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Record> getAllRecords() {

        return recordList;
    }

    @RequestMapping(value = "/records/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Record getRecordById(@PathVariable @Valid int id) {

        Record foundRecord = null;


        for(Record record : recordList) {
            if(record.getId() == id) {
                foundRecord = record;
                break;
            }
        }
        if (foundRecord==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND) ;
        }
        return foundRecord;
    }
}
