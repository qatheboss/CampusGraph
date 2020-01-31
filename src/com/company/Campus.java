package com.company;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Campus {

     private class Route implements Comparable {
         public ArrayList<String> soFar;
         public int distance;

         public Route()  {
             soFar = new ArrayList<String>();
             distance = 0;
         }

         public Route(Route o) {
             soFar = new ArrayList<String>();
             distance = o.distance;
             for (String s : o.soFar) {
                 soFar.add(s);
             }
         }


         @Override
         public int compareTo(Object o) {
             Route other = (Route) o;
             return distance - ((Route) o).distance;
         }

         public String getCurrent() {
             return soFar.get(soFar.size()-1);
         }
     }


    private class Location {
        public ArrayList<Path> paths;
        public String label;
        public boolean visted;
        public Location (String label) {
            this.label = label;
            paths = new ArrayList<Path>() ;
            visted = false;
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

    public ArrayList<String> doDijkstra (String start, String end) {
        for (HashMap.Entry<String, Location> locs : locations.entrySet()) {
            locs.getValue().visted = false;
        }
        PriorityQueue<Route> toDo = new PriorityQueue<Route>();
        Route first = new Route();
        first.soFar.add(start);
        toDo.add(first);
        while (toDo.isEmpty() == false) {
            Route nextRoute = toDo.remove();
            String atLoc = nextRoute.getCurrent();
            if (atLoc.equals(end)) {
                System.out.println("Path found, distance: " + nextRoute.distance);
                return nextRoute.soFar;
            }
            ArrayList<Path> paths = locations.get(atLoc).paths;
            for(Path p : paths) {
                if (p.target.visted == true) {
                    continue;
                }
                p.target.visted = true;
                Route newRoute = new Route(nextRoute);
                newRoute.soFar.add(p.target.label);
                newRoute.distance += p.distance;
                toDo.add(newRoute);
            }
        }
        return null;
    }
}
