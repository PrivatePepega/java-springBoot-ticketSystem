package com.pepega.ticketingApp.mappers;

import com.pepega.ticketingApp.domain.CreateEventRequest;
import com.pepega.ticketingApp.domain.CreateTicketTypeRequest;
import com.pepega.ticketingApp.domain.UpdateEventRequest;
import com.pepega.ticketingApp.domain.UpdateTicketTypeRequest;
import com.pepega.ticketingApp.domain.dtos.CreateEventRequestDto;
import com.pepega.ticketingApp.domain.dtos.CreateEventResponseDto;
import com.pepega.ticketingApp.domain.dtos.CreateTicketTypeRequestDto;
import com.pepega.ticketingApp.domain.dtos.GetEventDetailsResponseDto;
import com.pepega.ticketingApp.domain.dtos.GetEventDetailsTicketTypesResponseDto;
import com.pepega.ticketingApp.domain.dtos.GetPublishedEventDetailsResponseDto;
import com.pepega.ticketingApp.domain.dtos.GetPublishedEventDetailsTicketTypesResponseDto;
import com.pepega.ticketingApp.domain.dtos.ListEventResponseDto;
import com.pepega.ticketingApp.domain.dtos.ListEventTicketTypeResponseDto;
import com.pepega.ticketingApp.domain.dtos.ListPublishedEventResponseDto;
import com.pepega.ticketingApp.domain.dtos.UpdateEventRequestDto;
import com.pepega.ticketingApp.domain.dtos.UpdateEventResponseDto;
import com.pepega.ticketingApp.domain.dtos.UpdateTicketTypeRequestDto;
import com.pepega.ticketingApp.domain.dtos.UpdateTicketTypeResponseDto;
import com.pepega.ticketingApp.domain.entities.Event;
import com.pepega.ticketingApp.domain.entities.TicketType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

  CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

  CreateEventRequest fromDto(CreateEventRequestDto dto);

  CreateEventResponseDto toDto(Event event);

  ListEventTicketTypeResponseDto toDto(TicketType ticketType);

  ListEventResponseDto toListEventResponseDto(Event event);

  GetEventDetailsTicketTypesResponseDto toGetEventDetailsTicketTypesResponseDto(
      TicketType ticketType);

  GetEventDetailsResponseDto toGetEventDetailsResponseDto(Event event);

  UpdateTicketTypeRequest fromDto(UpdateTicketTypeRequestDto dto);

  UpdateEventRequest fromDto(UpdateEventRequestDto dto);

  UpdateTicketTypeResponseDto toUpdateTicketTypeResponseDto(TicketType ticketType);

  UpdateEventResponseDto toUpdateEventResponseDto(Event event);

  ListPublishedEventResponseDto toListPublishedEventResponseDto(Event event);

  GetPublishedEventDetailsTicketTypesResponseDto toGetPublishedEventDetailsTicketTypesResponseDto(
      TicketType ticketType);

  GetPublishedEventDetailsResponseDto toGetPublishedEventDetailsResponseDto(Event event);
}
