package com.pepega.ticketingApp.services.impl;

import com.pepega.ticketingApp.domain.entities.Ticket;
import com.pepega.ticketingApp.domain.entities.TicketStatusEnum;
import com.pepega.ticketingApp.domain.entities.TicketType;
import com.pepega.ticketingApp.domain.entities.User;
import com.pepega.ticketingApp.exceptions.TicketTypeNotFoundException;
import com.pepega.ticketingApp.exceptions.TicketsSoldOutException;
import com.pepega.ticketingApp.exceptions.UserNotFoundException;
import com.pepega.ticketingApp.repositories.TicketRepository;
import com.pepega.ticketingApp.repositories.TicketTypeRepository;
import com.pepega.ticketingApp.repositories.UserRepository;
import com.pepega.ticketingApp.services.QrCodeService;
import com.pepega.ticketingApp.services.TicketTypeService;
import jakarta.transaction.Transactional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketTypeServiceImpl implements TicketTypeService {

  private final UserRepository userRepository;
  private final TicketTypeRepository ticketTypeRepository;
  private final TicketRepository ticketRepository;
  private final QrCodeService qrCodeService;

  @Override
  @Transactional
  public Ticket purchaseTicket(UUID userId, UUID ticketTypeId) {
    User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(
        String.format("User with ID %s was not found", userId)
    ));

    TicketType ticketType = ticketTypeRepository.findByIdWithLock(ticketTypeId)
        .orElseThrow(() -> new TicketTypeNotFoundException(
            String.format("Ticket type with ID %s was not found", ticketTypeId)
        ));

    int purchasedTickets = ticketRepository.countByTicketTypeId(ticketType.getId());
    Integer totalAvailable = ticketType.getTotalAvailable();

    if(purchasedTickets + 1 > totalAvailable) {
      throw new TicketsSoldOutException();
    }

    Ticket ticket = new Ticket();
    ticket.setStatus(TicketStatusEnum.PURCHASED);
    ticket.setTicketType(ticketType);
    ticket.setPurchaser(user);

    Ticket savedTicket = ticketRepository.save(ticket);
    qrCodeService.generateQrCode(savedTicket);

    return ticketRepository.save(savedTicket);
  }
}
