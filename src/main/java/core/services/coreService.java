package core.services;

import core.dtos.CommentaireDTO;
import core.dtos.EvenementDTO;

import java.util.List;

public interface coreService {
    List<EvenementDTO> getAllComingEvents();

    List<CommentaireDTO> getCommentsByEventId(Long eventId);

    boolean getLieuByEventId(Long eventId);
}
