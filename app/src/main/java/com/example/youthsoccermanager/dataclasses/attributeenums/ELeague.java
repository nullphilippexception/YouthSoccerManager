package com.example.youthsoccermanager.dataclasses.attributeenums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ELeague {
    FirstNationalLeague {
        public String toString() {
            return "First National League";
        }
    },
    SecondNationalLeague {
        public String toString() {
            return "Second National League";
        }
    },
    StateLeague {
        public String toString() {
            return "State League";
        }
    },
    RegionalLeague {
        public String toString() {
            return "Regional League";
        }
    },
    DistrictLeague {
        public String toString() {
            return "District League";
        }
    },
    CityLeagueI {
        public String toString() {
            return "City League I";
        }
    },
    CityLeagueII {
        public String toString() {
            return "City League II";
        }
    },
    CityLeagueIII {
        public String toString() {
            return "City League III";
        }
    };

    public static ELeague getLeagueEnumType(String league) throws IllegalArgumentException {
        switch(league) {
            case "First National League":
                return ELeague.FirstNationalLeague;
            case "Second National League":
                return ELeague.SecondNationalLeague;
            case "State League":
                return ELeague.StateLeague;
            case "Regional League":
                return ELeague.RegionalLeague;
            case "District League":
                return ELeague.DistrictLeague;
            case "City League I":
                return ELeague.CityLeagueI;
            case "City League II":
                return ELeague.CityLeagueII;
            case "City League III":
                return ELeague.CityLeagueIII;
        }
        throw new IllegalArgumentException("Requested unknown league type");
    }

    public static List<ELeague> getAllLeagues() {
        List<ELeague> result = Arrays.asList(ELeague.FirstNationalLeague, ELeague.SecondNationalLeague,
                ELeague.StateLeague, ELeague.RegionalLeague, ELeague.DistrictLeague, ELeague.CityLeagueI,
                ELeague.CityLeagueII, ELeague.CityLeagueIII);
        return result;
    }
}
