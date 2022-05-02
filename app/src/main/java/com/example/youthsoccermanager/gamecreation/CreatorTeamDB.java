package com.example.youthsoccermanager.gamecreation;

import com.example.youthsoccermanager.dataclasses.admin.Team;
import com.example.youthsoccermanager.gamecreation.database.GameDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreatorTeamDB {
    public static void createTeams() {
        // LATER: CREATE PARAMETERS FOR DIFFERENT COUNTRIES
        List<String> leagues = Arrays.asList("First National League", "Second National League", "State League",
                "Regional League", "District League", "City League I", "City League II", "City League III"); // ENUM would be better
        Map<String, List<String>> teams = germanTeams(leagues); // CHANGE THIS IN FUTURE BASED ON INPUT PARAMETER
        for(String league: teams.keySet()) {
            for(String name: teams.get(league)) {
                Team tmpTeam = new Team(name, league, 0, 0, 0, 0);
                GameDatabase.getDB().teamDAO().insertTeam(tmpTeam);
            }
        }
    }

    private static Map<String, List<String>> germanTeams(List<String> leagues) {
        Map<String, List<String>> result = new HashMap<>();
        for(String league: leagues) {
            List<String> teams = germanData(league);
            result.put(league, teams);
        }
        return result;
    }

    private static List<String> germanData(String league) {
        Map<String, List<String>> teamsPerLeague = new HashMap<>();
        List<String> firstNationalLeague = Arrays.asList("Yellow Dortmund", "Blue Schalke", "Red Munich", "White Leipzig",
                "Red Leverkusen", "White Cologne", "Black Frankfurt", "White Moenchengladbach",
                "Green Wolfsburg", "Blue Hoffenheim", "Red Berlin", "Red Mainz");
        teamsPerLeague.put("First National League", firstNationalLeague);

        List<String> secondNationalLeague = Arrays.asList("Black Freiburg", "Blue Bochum", "Red Augsburg", "Blue Berlin",
                "Red Stuttgart", "Blue Bielefeld", "Green Fuerth", "Blue Darmstadt",
                "Blue Hamburg", "Green Bremen", "Brown St Pauli", "Red Nuremberg");
        teamsPerLeague.put("Second National League", secondNationalLeague);

        List<String> stateLeague = Arrays.asList("Blue Paderborn", "Red Dusseldorf", "Black Cologne", "Blue Duisburg",
                "Black Verl", "Green Muenster", "Red Essen", "Red Wuppertal",
                "Red Oberhausen", "Red Cologne", "Green Roedinghausen", "Blue Wiedenbrueck");
        teamsPerLeague.put("State League", stateLeague);

        List<String> regionalLeague = Arrays.asList("Red Ahlen", "Yellow Aachen", "Red Lippstadt", "Yellow Straelen",
                "Blue Bonn", "Black Wegberg Beeck", "Blue Lotte", "Yellow Homberg",
                "Red Uerdingen", "Black Kaan Marienborn","Blue Rhynern", "White Wattenscheid");
        teamsPerLeague.put("Regional League", regionalLeague);

        List<String> districtLeague = Arrays.asList("Green Guetersloh", "Blue Dortmund", "Blue Rheine", "Blue Erndtebrueck",
                "Black Schermbeck", "Red Siegen", "Blue Sprockhoevel", "Blue Vreden",
                "Blue Ennepetal", "Red Hamm", "Black Clarholz", "Blue Meinerzhagen");
        teamsPerLeague.put("District League", districtLeague);

        List<String> cityLeagueI = Arrays.asList("Blue Westhofen", "Red Holzen", "Black Hoerde", "White Dortmund",
                "Black Rahm","Red Dortmund", "Blue Kirchlin", "Red Barop",
                "White Hoerde", "Blue Oespel", "Yellow Hellweg", "Blue Dorstfeld");
        teamsPerLeague.put("City League I", cityLeagueI);

        List<String> cityLeagueII = Arrays.asList("Red Mengede", "Red Kirchhoerde", "Green Dorstfeld", "Blue Marten",
                "Green Schueren", "Green Eving", "Green Dortmund", "Green Soelde",
            "Blue Gahmen", "Yellow Scharnhorst", "Black Luenen", "Red Koerne");
        teamsPerLeague.put("City League II", cityLeagueII);

        List<String> cityLeagueIII = Arrays.asList("Red Husen Kurl", "Red Soelderholz", "Green Kemminghausen", "Red Brambauer",
                "Red Hombruch", "Red Neheim", "Blue Neuasseln", "Green Lindenhorst",
                "Yellow Kaiserau", "Yellow Schwerte", "Blue Holzwickede"); // Only 11 teams here because user team is 12th
        teamsPerLeague.put("City League III", cityLeagueIII);

        return teamsPerLeague.get(league);
    }
}
