package no.unit.alma.record;

import no.unit.alma.bibs.Bib;

public interface AlmaBibRecord extends AlmaRecord {

    Bib getBib();

    class Factory {

        public static AlmaBibRecord create(Bib bibResponse) {

            return new AlmaBibRecordImplementation(bibResponse);

        }

    }
}
