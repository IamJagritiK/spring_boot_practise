package com.stackroute.service;

import com.stackroute.domain.Muzix;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;

public interface MuzixService {
    public Muzix saveTracks(Muzix musix) throws TrackAlreadyExistsException;

    public List<Muzix> getAlltracks();
    public Muzix getById(int id) throws TrackNotFoundException;

    public String deleteById(int id) throws TrackNotFoundException;

    public boolean updateById(Muzix musix, int id) throws TrackNotFoundException;

    public boolean UpdateComments(int trackId, String trackComments);

    public List<Muzix> getByName(String name);


}
