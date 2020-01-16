package com.company;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Campus {


    private class Location {
        public ArrayList<Path> paths;
        public String label;
        public Location (String label) {
            this.label = label;
            paths = new ArrayList<Path>() ;
        }
        @Override
        public String toString() {
            return label;
        }
    }

    private class Path {
        public Location target;
        public int distance;

        public Path(Location location, int distance) {
            this.target = location;
            this.distance = distance;
        }
        @Override
        public String toString() {
            return "-" + distance + "->" + target;
        }
    }

    private HashMap<String, Location> locations;

    public Campus() {
        locations = new HashMap<String, Location>();
    }

    public void addPath(String from, String to, int distance) {
        if (!locations.containsKey(from)) {
            locations.put(from, new Location(from));
        }
        if (!locations.containsKey(to)) {
            locations.put(to, new Location(to));
        }

        locations.get(from).paths.add(new Path(locations.get(to), distance));
        locations.get(to).paths.add(new Path(locations.get(from), distance));

    }

    public ArrayList<Path> getPaths(String label) {
        return locations.get(label).paths;
    }

    public boolean goesTo(String from, String to) {
        ArrayList<Path> paths = locations.get(from).paths;
        for(int i = 0; i< paths.size();i++) {
            if (paths.get(i).target.label.equals(to))
                return true;
        }
        return false;
    }

}
