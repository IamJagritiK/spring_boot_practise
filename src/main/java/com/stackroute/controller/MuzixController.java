package com.stackroute.controller;


import com.stackroute.domain.Muzix;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.MuzixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MuzixController {


    private MuzixService muzixService;


    @Autowired
    public MuzixController(MuzixService muzixService) {

        this.muzixService = muzixService;
    }

    @PostMapping("muzix")
    public ResponseEntity<?> saveTracks(@RequestBody Muzix musix)  {
        ResponseEntity responseEntity;
        try{
            muzixService.saveTracks(musix);
            responseEntity= new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        } catch (TrackAlreadyExistsException e) {
            responseEntity= new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("muzix")
    public ResponseEntity<?> getAllUsers() {
        ResponseEntity responseEntity;
        try{
            responseEntity = new ResponseEntity<List<Muzix>>(muzixService.getAlltracks(), HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("/muzix/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {

        ResponseEntity responseEntity;
        try {
            Muzix musix = muzixService.getById(id);
            responseEntity = new ResponseEntity<Muzix>(musix, HttpStatus.OK);
        } catch (TrackNotFoundException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            ex.printStackTrace();
        }
        return responseEntity;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTrack(@PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<>(
                    muzixService.deleteById(id),
                    HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }



    @PutMapping("/update")   public ResponseEntity UpdateComments(@RequestBody Muzix user)
    {       ResponseEntity responseEntity;
        responseEntity= new ResponseEntity<>(muzixService.UpdateComments(user.getId(),user.getComments()), HttpStatus.OK);        return responseEntity;
    }


    @GetMapping("/names/{name}")
    public ResponseEntity<List<Muzix>> getByName(@PathVariable String name) {
        List<Muzix> musix = muzixService.getByName(name);
        return new ResponseEntity<List<Muzix>>(musix, HttpStatus.OK);
    }

}
