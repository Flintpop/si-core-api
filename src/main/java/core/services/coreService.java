package core.services;

import core.dtos.EventDto;

import java.util.List;

public interface coreService {
//    DogDto getAllEvents(DogDto dogDto);
//
//    DogDto getEventById(Long dogId);

    List<EventDto> getAllComingEvents();

    boolean getCommentsByEventId(Long eventId);

    boolean getLieuxByEventId(Long eventId);

}
