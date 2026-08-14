package Collections.AdventureGameChallenge;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private final String description;
    private final Map<String, String> nextPlaces;

    public Location(String description, Map<String, String> nextPlaces) {
        this.description = description;
        this.nextPlaces = (nextPlaces != null) ? new HashMap<>(nextPlaces) : new HashMap<>();
    }

    public String getDescription() {
        return description;
    }

   
    public String getDirectedLocation(String direction) {
        return nextPlaces.get(direction);
    }
}