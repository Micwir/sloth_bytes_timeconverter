package org.micwir;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.micwir.exception.WrongTimeFormatException;

import static org.assertj.core.api.Assertions.*;

class TimeConverterTest {

    private TimeConverter converter = new TimeConverter();

    @Test
    void shouldConvertTimeTo12HourFormat() {
        assertThat(converter.convert("12:00"))
                .isEqualTo("12:00 pm");
    }

    @Test
    void shouldConvertTimeTo24HourFormatAndAddLeadingZero(){
        assertThat(converter.convert("2:40 pm"))
                .isEqualTo("14:40");
    }

    @Test
    void shouldConvertTimeTo24HourFormat() {
        assertThat(converter.convert("01:00 am"))
                .isEqualTo("01:00");
    }


    @ParameterizedTest
    @ValueSource(strings = {"009:35 pm", "09:355 pm", "09:35pm", "09:35 am pm", "09:35 ampm", "i am a test"})
    void shouldThrowWrongTimeFormatException(String faultyString) {
        assertThatExceptionOfType(WrongTimeFormatException.class)
                .isThrownBy(() -> converter.convert(faultyString))
                .withMessage("Input of '" + faultyString + "' is not a valid time format");
    }
}
