package ua.iot.lviv.view;

import ua.iot.lviv.exception.OwnDateTimeException;
import ua.iot.lviv.exception.OwnPriceFormatException;
import ua.iot.lviv.exception.OwnTimeException;

import java.sql.SQLException;
import java.text.ParseException;

@FunctionalInterface
public interface Printable {
    void print() throws SQLException, ParseException, OwnTimeException, OwnPriceFormatException, OwnDateTimeException;
}
