package com.pepega.ticketingApp.services;

import com.pepega.ticketingApp.domain.entities.TicketValidation;
import java.util.UUID;

public interface TicketValidationService {
  TicketValidation validateTicketByQrCode(UUID qrCodeId);
  TicketValidation validateTicketManually(UUID ticketId);
}
