package core.services;

import core.dtos.EvenementDTO;

import java.util.List;

public interface coreService {
//    DogDto getAllEvents(DogDto dogDto);
//
//    DogDto getEventById(Long dogId);

    List<EvenementDTO> getAllComingEvents();

    boolean getCommentsByEventId(Long eventId);

    boolean getLieuxByEventId(Long eventId);

}
