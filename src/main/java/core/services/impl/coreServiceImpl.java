package core.services.impl;

import core.dtos.EventDto;
import core.services.coreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dogService")
public class coreServiceImpl implements coreService {

  @Override
  public List<EventDto> getAllComingEvents() {
    return null;
  }

  @Override
  public boolean getCommentsByEventId(Long eventId) {
    return false;
  }

  @Override
  public boolean getLieuxByEventId(Long eventId) {
    return false;
  }
}
