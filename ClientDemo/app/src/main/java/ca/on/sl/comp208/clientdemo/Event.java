package ca.on.sl.comp208.clientdemo;


import java.util.List;

/**
 * Created by alexash on 2017-04-03.
 */

public class Event {

    public List<Events> events;
    public List<Venue> venues;

    @Override
    public String toString() {
        return events.toString();
    }

    public class Events {
        String id;
        String title;
        String short_title;
        String url;
        String datetime_local;


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDatetime_local() {
            return datetime_local;
        }

        public void setDatetime_local(String datetime_local) {
            this.datetime_local = datetime_local;
        }

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Events{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", short_title='" + short_title + '\'' +
                    ", url='" + url + '\'' +
                    ", datetime_local='" + datetime_local + '\'' +
                    '}';
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getShort_title() {
            return short_title;
        }

        public void setShort_title(String short_title) {
            this.short_title = short_title;
        }
    }
    public class Venue {
        String display_location;
        String name;
        String address;
        String location;

        @Override
        public String toString() {
            return "Venue{" +
                    "display_location='" + display_location + '\'' +
                    ", name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    ", location='" + location + '\'' +
                    '}';
        }

        public String getDisplay_location() {
            return display_location;
        }

        public void setDisplay_location(String display_location) {
            this.display_location = display_location;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

    }

}
