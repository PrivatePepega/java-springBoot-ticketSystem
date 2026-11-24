package com.pepega.ticketingApp.services;

import com.pepega.ticketingApp.domain.entities.QrCode;
import com.pepega.ticketingApp.domain.entities.Ticket;
import java.util.UUID;

public interface QrCodeService {

  QrCode generateQrCode(Ticket ticket);

  byte[] getQrCodeImageForUserAndTicket(UUID userId, UUID ticketId);
}
