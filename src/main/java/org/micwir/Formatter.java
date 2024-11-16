package org.micwir;

import java.time.format.DateTimeFormatter;

public record Formatter(DateTimeFormatter parsingFormatter, DateTimeFormatter convertingFormatter) {
}
