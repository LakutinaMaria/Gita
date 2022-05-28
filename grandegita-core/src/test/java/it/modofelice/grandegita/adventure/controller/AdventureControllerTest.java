package it.modofelice.grandegita.adventure.controller;

import it.modofelice.grandegita.adventure.dto.AdventureDto;
import it.modofelice.grandegita.adventure.facade.AdventureFacade;
import it.modofelice.grandegita.adventure.facade.imp.AdventureFacadeImp;
import it.modofelice.grandegita.adventure.model.Adventure;
import it.modofelice.grandegita.adventure.model.AdventureStatus;
import it.modofelice.grandegita.adventure.service.AdventureService;
import it.modofelice.grandegita.adventure.service.imp.AdventureServiceImp;
import it.modofelice.grandegita.spot.dto.SpotDto;
import it.modofelice.grandegita.spot.model.Spot;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class AdventureControllerTest {

  private AdventureController underTest;
  @Mock
  private AdventureService adventureService = Mockito.mock(AdventureServiceImp.class);
  ;
  @Mock
  private AdventureFacade facade = Mockito.mock(AdventureFacadeImp.class);
  private AutoCloseable autoCloseable;

  private final UUID adventureId = UUID.randomUUID();
  private final UUID spotId = UUID.randomUUID();
  private final AdventureStatus adventureStatus = AdventureStatus.ACTIVE;
  private final Spot spot = Spot.builder()
      .id(spotId)
      .description("Paris").build();
  private final SpotDto spotDto = SpotDto.builder()
      .id(spotId)
      .description("Paris").build();
  private final LocalDateTime dateTime = LocalDateTime.now();
  private final Adventure adventure = Adventure.builder()
      .id(adventureId)
      .dateTime(dateTime)
      .adventureStatus(adventureStatus)
      .spot(spot).build();
  private final AdventureDto adventureDto = AdventureDto.builder()
      .id(adventureId)
      .dateTime(dateTime)
      .spot(spotDto)
      .adventureStatus(adventureStatus).build();

  @BeforeEach
  void setUp() {
    autoCloseable = MockitoAnnotations.openMocks(this);
    underTest = new AdventureController(adventureService, facade);
  }

  @AfterEach
  void tearDown() throws Exception {
    autoCloseable.close();
  }

  @Test
  @Disabled
  void getAllAdventures() {
  }

  @Test
  void testGetAdventureById() {
    when(facade.findAdventureById(adventureId)).thenReturn(adventureDto);
    ResponseEntity<AdventureDto> expected = underTest.getAdventureById(adventureId);
    verify(facade).findAdventureById(adventureId);
    assertEquals(expected.getStatusCode(), HttpStatus.OK);
    assertEquals(expected.getBody(), adventureDto);
  }

  @Test
  @Disabled
  void addAdventure() {
    when(adventureService.addAdventure(adventure)).thenReturn(adventure);
  }

  @Test
  @Disabled
  void updateAdventure() {
  }

  @Test
  @Disabled
  void deleteAdventure() {
  }
}