package org.pl.premierzone.nations;

import java.util.Arrays;

public enum NationFlag {
    ARG("🇦🇷"),
    AUS("🇦🇺"),
    AUT("🇦🇹"),
    BEL("🇧🇪"),
    BRA("🇧🇷"),
    CAN("🇨🇦"),
    CIV("🇨🇮"),
    CRO("🇭🇷"),
    CZE("🇨🇿"),
    DEN("🇩🇰"),
    EGY("🇪🇬"),
    ENG("🏴"),
    ESP("🇪🇸"),
    FRA("🇫🇷"),
    GEO("🇬🇪"),
    GER("🇩🇪"),
    GHA("🇬🇭"),
    GRE("🇬🇷"),
    IRL("🇮🇪"),
    ITA("🇮🇹"),
    JAM("🇯🇲"),
    JPN("🇯🇵"),
    KOR("🇰🇷"),
    MAR("🇲🇦"),
    MEX("🇲🇽"),
    NED("🇳🇱"),
    NGA("🇳🇬"),
    NOR("🇳🇴"),
    NZL("🇳🇿"),
    PAR("🇵🇾"),
    POL("🇵🇱"),
    POR("🇵🇹"),
    SCO("🏴"),
    SEN("🇸🇳"),
    SRB("🇷🇸"),
    SUI("🇨🇭"),
    SWE("🇸🇪"),
    TUN("🇹🇳"),
    UKR("🇺🇦"),
    URU("🇺🇾"),
    USA("🇺🇸"),
    WAL("🏴"),
    UNKNOWN("🌍");

    private final String emoji;

    NationFlag(String emoji) {
        this.emoji = emoji;
    }

    public String getEmoji() {
        return emoji;
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
