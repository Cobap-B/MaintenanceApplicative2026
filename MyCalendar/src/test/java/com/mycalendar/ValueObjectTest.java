package com.mycalendar;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import com.mycalendar.domaine.*;

public class ValueObjectTest {

  @Test
    void should_store_title() {
        TitreEvenement titre = new TitreEvenement("Dentiste");

        assertEquals("Dentiste", titre.toString());
    }

    @Test
    void should_store_duration() {
        DureeEvenement duree = new DureeEvenement(30);

        assertEquals(30, duree.toMinutes());
    }

    @Test
    void should_store_frequency() {
        FrequenceJours freq = new FrequenceJours(7);

        assertEquals(7, freq.toInt());
    }

}
