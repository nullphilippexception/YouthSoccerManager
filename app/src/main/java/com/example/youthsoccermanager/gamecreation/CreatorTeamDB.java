package com.example.youthsoccermanager.gamecreation;

import com.example.youthsoccermanager.dataclasses.admin.Team;
import com.example.youthsoccermanager.dataclasses.attributeenums.EAgeGroup;
import com.example.youthsoccermanager.dataclasses.attributeenums.ELeague;
import com.example.youthsoccermanager.gamecreation.database.GameDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreatorTeamDB {
    public static void createTeams() {
        // LATER: CREATE PARAMETERS FOR DIFFERENT COUNTRIES
        List<ELeague> leagues = ELeague.getAllLeagues();
        Map<ELeague, List<String>> teams = germanTeams(leagues); // CHANGE THIS IN FUTURE BASED ON INPUT PARAMETER
        // BAD STYLE - SWITCH THIS
        List<String> ageGroups = Arrays.asList(EAgeGroup.U19.toString(), EAgeGroup.U17.toString(), EAgeGroup.U15.toString(),
                EAgeGroup.U13.toString());
        for(ELeague league: teams.keySet()) {
            for(String name: teams.get(league)) {
                for(String ageGroup : ageGroups) {
                    Team tmpTeam = new Team(name + " " + ageGroup, league.toString(), ageGroup, 0, 0, 0, 0);
                    GameDatabase.getDB().teamDAO().insertTeam(tmpTeam);
                }
            }
        }
    }

    private static Map<ELeague, List<String>> germanTeams(List<ELeague> leagues) {
        Map<ELeague, List<String>> result = new HashMap<>();
        for(ELeague league: leagues) {
            List<String> teams = germanData(league);
            result.put(league, teams);
        }
        return result;
    }

    private static List<String> germanData(ELeague league) {
        Map<ELeague, List<String>> teamsPerLeague = new HashMap<>();
        List<String> firstNationalLeague = Arrays.asList("Yellow Dortmund", "Blue Schalke", "Red Munich", "White Leipzig",
                "Red Leverkusen", "White Cologne", "Black Frankfurt", "White Moenchengladbach",
                "Green Wolfsburg", "Blue Hoffenheim", "Red Berlin", "Red Mainz");
        teamsPerLeague.put(ELeague.FirstNationalLeague, firstNationalLeague);

        List<String> secondNationalLeague = Arrays.asList("Black Freiburg", "Blue Bochum", "Red Augsburg", "Blue Berlin",
                "Red Stuttgart", "Blue Bielefeld", "Green Fuerth", "Blue Darmstadt",
                "Blue Hamburg", "Green Bremen", "Brown St Pauli", "Red Nuremberg");
        teamsPerLeague.put(ELeague.SecondNationalLeague, secondNationalLeague);

        List<String> stateLeague = Arrays.asList("Blue Paderborn", "Red Dusseldorf", "Black Cologne", "Blue Duisburg",
                "Black Verl", "Green Muenster", "Red Essen", "Red Wuppertal",
                "Red Oberhausen", "Red Cologne", "Green Roedinghausen", "Blue Wiedenbrueck");
        teamsPerLeague.put(ELeague.StateLeague, stateLeague);

        List<String> regionalLeague = Arrays.asList("Red Ahlen", "Yellow Aachen", "Red Lippstadt", "Yellow Straelen",
                "Blue Bonn", "Black Wegberg Beeck", "Blue Lotte", "Yellow Homberg",
                "Red Uerdingen", "Black Kaan Marienborn","Blue Rhynern", "White Wattenscheid");
        teamsPerLeague.put(ELeague.RegionalLeague, regionalLeague);

        List<String> districtLeague = Arrays.asList("Green Guetersloh", "Blue Dortmund", "Blue Rheine", "Blue Erndtebrueck",
                "Black Schermbeck", "Red Siegen", "Blue Sprockhoevel", "Blue Vreden",
                "Blue Ennepetal", "Red Hamm", "Black Clarholz", "Blue Meinerzhagen");
        teamsPerLeague.put(ELeague.DistrictLeague, districtLeague);

        List<String> cityLeagueI = Arrays.asList("Blue Westhofen", "Red Holzen", "Black Hoerde", "White Dortmund",
                "Black Rahm","Red Dortmund", "Blue Kirchlin", "Red Barop",
                "White Hoerde", "Blue Oespel", "Yellow Hellweg", "Blue Dorstfeld");
        teamsPerLeague.put(ELeague.CityLeagueI, cityLeagueI);

        List<String> cityLeagueII = Arrays.asList("Red Mengede", "Red Kirchhoerde", "Green Dorstfeld", "Blue Marten",
                "Green Schueren", "Green Eving", "Green Dortmund", "Green Soelde",
            "Blue Gahmen", "Yellow Scharnhorst", "Black Luenen", "Red Koerne");
        teamsPerLeague.put(ELeague.CityLeagueII, cityLeagueII);

        List<String> cityLeagueIII = Arrays.asList("Red Husen Kurl", "Red Soelderholz", "Green Kemminghausen", "Red Brambauer",
                "Red Hombruch", "Red Neheim", "Blue Neuasseln", "Green Lindenhorst",
                "Yellow Kaiserau", "Yellow Schwerte", "Blue Holzwickede"); // Only 11 teams here because user team is 12th
        teamsPerLeague.put(ELeague.CityLeagueIII, cityLeagueIII);

        return teamsPerLeague.get(league);
    }
}
