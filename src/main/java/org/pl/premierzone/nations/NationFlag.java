package org.pl.premierzone.nations;

import java.util.Arrays;

public enum NationFlag {
    ARG("ar"),
    ALB("al"),
    AUS("au"),
    AUT("at"),
    BEL("be"),
    BIH("ba"),
    BRA("br"),
    CAN("ca"),
    COD("cd"),
    COL("co"),
    CIV("ci"),
    CMR("cm"),
    CRO("hr"),
    CZE("cz"),
    DEN("dk"),
    DZA("dz"),
    ECU("ec"),
    EGY("eg"),
    ENG("gb-eng"),
    ESP("es"),
    EST("ee"),
    FIN("fi"),
    FRA("fr"),
    GEO("ge"),
    GIN("gn"),
    GER("de"),
    GHA("gh"),
    GAB("ga"),
    NIR("gb"),
    GRE("gr"),
    IRL("ie"),
    ISR("il"),
    IRQ("iq"),
    IRN("ir"),
    ITA("it"),
    JAM("jm"),
    JPN("jp"),
    KOR("kr"),
    LBR("lr"),
    MAR("ma"),
    MEX("mx"),
    MNE("me"),
    MLI("ml"),
    MSR("ms"),
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
    SVK("sk"),
    SWE("se"),
    TUN("tn"),
    TUR("tr"),
    UKR("ua"),
    URU("uy"),
    USA("us"),
    VEN("ve"),
    WAL("gb-wls"),
    ZAM("zm"),
    ZIM("zw"),
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