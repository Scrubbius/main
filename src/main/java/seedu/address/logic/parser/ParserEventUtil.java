package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.Date;
import seedu.address.model.event.Description;
import seedu.address.model.event.Event;
import seedu.address.model.event.Location;
import seedu.address.model.event.Name;
import seedu.address.model.event.Time;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes for Event entity.
 */
public class ParserEventUtil {
    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     *
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_NAME_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String location} into a {@code Location}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code location} is invalid.
     */
    public static Location parseLocation(String location) throws ParseException {
        requireNonNull(location);
        String trimmedLocation = location.trim();
        if (!Location.isValidLocation(trimmedLocation)) {
            throw new ParseException(Location.MESSAGE_LOCATION_CONSTRAINTS);
        }
        return new Location(trimmedLocation);
    }

    /**
     * Parses a {@code String date} into a {@code Date}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code date} is invalid.
     */
    public static Date parseDate(String date) throws ParseException {
        requireNonNull(date);
        String trimmedDate = date.trim();
        if (!Date.isValidDate(trimmedDate)) {
            throw new ParseException(Date.MESSAGE_DATE_CONSTRAINTS);
        }
        return new Date(trimmedDate);
    }

    /**
     * Parses a {@code String startDate} and a {@code String endDate } to check if startDate comes before endDate.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code startDate} is before {@code endDate}.
     */
    public static void parseStartEndDate(String startDate, String endDate) throws ParseException {
        requireNonNull(startDate);
        requireNonNull(endDate);
        String trimmedStartDate = startDate.trim();
        String trimmedEndDate = endDate.trim();

        Date start = new Date(trimmedStartDate);
        Date end = new Date(trimmedEndDate);

        if (!start.isLessThanOrEqualTo(end)) {
            throw new ParseException(Event.MESSAGE_START_END_DATE_CONSTRAINTS);
        }
    }

    /**
     * Parses a {@code String time} into a {@code Time}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code time} is invalid.
     */
    public static Time parseTime(String time) throws ParseException {
        requireNonNull(time);
        String trimmedTime = time.trim();
        if (!Location.isValidLocation(trimmedTime)) {
            throw new ParseException(Time.MESSAGE_TIME_CONSTRAINTS);
        }
        return new Time(trimmedTime);
    }

    /**
     * Parses a {@code String startTime} and a {@code String endTime } to check if startTime comes before endTime.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code startTime} is before {@code endTime}.
     */
    public static void parseStartEndTime(String startTime, String endTime) throws ParseException {
        requireNonNull(startTime);
        requireNonNull(endTime);
        String trimmedStartTime = startTime.trim();
        String trimmedEndTime = endTime.trim();

        Time start = new Time(trimmedStartTime);
        Time end = new Time(trimmedEndTime);

        if (!start.isLessThanOrEqualTo(end)) {
            throw new ParseException(Event.MESSAGE_START_END_TIME_CONSTRAINTS);
        }
    }

    /**
     * Parses a {@code String description} into a {@code Description}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code description} is invalid.
     */
    public static Description parseDescription(String description) throws ParseException {
        requireNonNull(description);
        String trimmedDescription = description.trim();
        if (!Location.isValidLocation(trimmedDescription)) {
            throw new ParseException(Description.MESSAGE_DESCRIPTION_CONSTRAINTS);
        }
        return new Description(trimmedDescription);
    }
}
