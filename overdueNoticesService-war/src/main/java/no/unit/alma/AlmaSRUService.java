package no.unit.alma;

import javax.annotation.Nonnull;
import java.io.UnsupportedEncodingException;

public interface AlmaSRUService {
    String retrieveRecords(String title, String author, String isbnOrIssn, String mmsMaterialType, int maximumNumberOfRecords);

    String retrieveRecords(String title, String author, String isbnOrIssn, String mmsMaterialType);

    String retrieveRecord(@Nonnull String mmsId) throws UnsupportedEncodingException;
}
