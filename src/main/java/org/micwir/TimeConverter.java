package org.micwir;

import org.micwir.exception.WrongTimeFormatException;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeConverter {

    public String convert(String input) {
        validate(input);
        return doConvertion(input);
    }


    private String doConvertion(String input) {
        input = input.toUpperCase();
        input = addLeadingZero(input);
        Formatter formatter = getFormatter(input);
        LocalTime time = LocalTime.parse(input, formatter.parsingFormatter());
        return time.format(formatter.convertingFormatter()).toLowerCase();
    }

    private String addLeadingZero(String input) {
        if (input.split(":")[0].length() < 2) {
            input = "0" + input;
        }
        return input;
    }

    private Formatter getFormatter(String input) {
        DateTimeFormatter parsingFormatter;
        DateTimeFormatter convertingFormatter;
        if (input.contains("AM") || input.contains("PM")) {
            parsingFormatter = DateTimeFormatter.ofPattern("hh:mm a");
            convertingFormatter = DateTimeFormatter.ofPattern("HH:mm");

        } else {
            parsingFormatter = DateTimeFormatter.ofPattern("HH:mm");
            convertingFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        }

        return new Formatter(parsingFormatter, convertingFormatter);
    }

    private void validate(String input) throws WrongTimeFormatException {
        if (!input.matches("(0?[0-9]|1[0-9]|2[0-3]):[0-5][0-9](\\s(am|pm|PM|AM))?")) {
            throw new WrongTimeFormatException("Input of '" + input + "' is not a valid time format");
        }
    }
}
