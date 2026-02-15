package org.pl.premierzone.nations;

import java.util.Arrays;

public enum NationFlag {
    ARG("ar"),
    AUS("au"),
    AUT("at"),
    BEL("be"),
    BRA("br"),
    CAN("ca"),
    CIV("ci"),
    CRO("hr"),
    CZE("cz"),
    DEN("dk"),
    EGY("eg"),
    ENG("gb-eng"),
    ESP("es"),
    FRA("fr"),
    GEO("ge"),
    GER("de"),
    GHA("gh"),
    GRE("gr"),
    IRL("ie"),
    ITA("it"),
    JAM("jm"),
    JPN("jp"),
    KOR("kr"),
    MAR("ma"),
    MEX("mx"),
    NED("nl"),
    NGA("ng"),
    NOR("no"),
    NZL("nz"),
    PAR("py"),
    POL("pl"),
    POR("pt"),
    SCO("gb-sct"),
    SEN("sn"),
    SRB("rs"),
    SUI("ch"),
    SWE("se"),
    TUN("tn"),
    UKR("ua"),
    URU("uy"),
    USA("us"),
    WAL("gb-wls"),
    UNKNOWN("un");

    private final String flagIconCode;

    NationFlag(String flagIconCode) {
        this.flagIconCode = flagIconCode;
    }

    public String getFlagIconCode() {
        return flagIconCode;
    }

    public String getFlagIconClass() {
        return "fi fi-" + flagIconCode;
    }

    public static NationFlag fromCode(String code) {
        if (code == null || code.isBlank()) {
            return UNKNOWN;
        }

        return Arrays.stream(values())
                .filter(value -> value.name().equalsIgnoreCase(code))
                .findFirst()
                .orElse(UNKNOWN);
    }

    public static String extractCode(String nation) {
        if (nation == null || nation.isBlank()) {
            return "";
        }

        String[] nationParts = nation.trim().split("\\s+");
        return nationParts[nationParts.length - 1].toUpperCase();
    }
}
