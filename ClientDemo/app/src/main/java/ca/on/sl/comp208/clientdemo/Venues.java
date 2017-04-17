package ca.on.sl.comp208.clientdemo;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by alexash on 2017-04-14.
 */

public class Venues {

    private double score;
    private StatsBean stats;
    private String short_title;
    private InHandBean in_hand;
    private String datetime_local;
    private VenueBean venue;
    private int id;
    private String created_at;
    private String type;
    private String datetime_utc;
    private boolean date_tbd;
    private String title;
    private String url;
    private String visible_until_utc;
    private boolean time_tbd;
    private boolean is_open;
    private boolean datetime_tbd;
    private String announce_date;
    private List<TaxonomiesBean> taxonomies;
    private List<PerformersBean> performers;
    private List<?> links;

    public static Event objectFromData(String str) {

        return new Gson().fromJson(str, Event.class);
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public StatsBean getStats() {
        return stats;
    }

    public void setStats(StatsBean stats) {
        this.stats = stats;
    }

    public String getShort_title() {
        return short_title;
    }

    public void setShort_title(String short_title) {
        this.short_title = short_title;
    }

    public InHandBean getIn_hand() {
        return in_hand;
    }

    public void setIn_hand(InHandBean in_hand) {
        this.in_hand = in_hand;
    }

    public String getDatetime_local() {
        return datetime_local;
    }

    public void setDatetime_local(String datetime_local) {
        this.datetime_local = datetime_local;
    }

    public VenueBean getVenue() {
        return venue;
    }

    public void setVenue(VenueBean venue) {
        this.venue = venue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDatetime_utc() {
        return datetime_utc;
    }

    public void setDatetime_utc(String datetime_utc) {
        this.datetime_utc = datetime_utc;
    }

    public boolean isDate_tbd() {
        return date_tbd;
    }

    public void setDate_tbd(boolean date_tbd) {
        this.date_tbd = date_tbd;
    }

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

    public String getVisible_until_utc() {
        return visible_until_utc;
    }

    public void setVisible_until_utc(String visible_until_utc) {
        this.visible_until_utc = visible_until_utc;
    }

    public boolean isTime_tbd() {
        return time_tbd;
    }

    public void setTime_tbd(boolean time_tbd) {
        this.time_tbd = time_tbd;
    }

    public boolean isIs_open() {
        return is_open;
    }

    public void setIs_open(boolean is_open) {
        this.is_open = is_open;
    }

    public boolean isDatetime_tbd() {
        return datetime_tbd;
    }

    public void setDatetime_tbd(boolean datetime_tbd) {
        this.datetime_tbd = datetime_tbd;
    }

    public String getAnnounce_date() {
        return announce_date;
    }

    public void setAnnounce_date(String announce_date) {
        this.announce_date = announce_date;
    }

    public List<TaxonomiesBean> getTaxonomies() {
        return taxonomies;
    }

    public void setTaxonomies(List<TaxonomiesBean> taxonomies) {
        this.taxonomies = taxonomies;
    }

    public List<PerformersBean> getPerformers() {
        return performers;
    }

    public void setPerformers(List<PerformersBean> performers) {
        this.performers = performers;
    }

    public List<?> getLinks() {
        return links;
    }

    public void setLinks(List<?> links) {
        this.links = links;
    }

    public static class StatsBean {
        public static StatsBean objectFromData(String str) {

            return new Gson().fromJson(str, StatsBean.class);
        }
    }

    public static class InHandBean {
        public static InHandBean objectFromData(String str) {

            return new Gson().fromJson(str, InHandBean.class);
        }
    }

    public static class VenueBean {

        private String url;
        private String name_v2;
        private String name;
        private String address;
        private String state;
        private String extended_address;
        private LocationBean location;
        private String display_location;
        private String country;
        private int id;
        private String timezone;
        private String postal_code;
        private String city;
        private double score;
        private boolean has_upcoming_events;
        private int num_upcoming_events;
        private String slug;
        private List<?> links;

        public static VenueBean objectFromData(String str) {

            return new Gson().fromJson(str, VenueBean.class);
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName_v2() {
            return name_v2;
        }

        public void setName_v2(String name_v2) {
            this.name_v2 = name_v2;
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

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getExtended_address() {
            return extended_address;
        }

        public void setExtended_address(String extended_address) {
            this.extended_address = extended_address;
        }

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public String getDisplay_location() {
            return display_location;
        }

        public void setDisplay_location(String display_location) {
            this.display_location = display_location;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public String getPostal_code() {
            return postal_code;
        }

        public void setPostal_code(String postal_code) {
            this.postal_code = postal_code;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public boolean isHas_upcoming_events() {
            return has_upcoming_events;
        }

        public void setHas_upcoming_events(boolean has_upcoming_events) {
            this.has_upcoming_events = has_upcoming_events;
        }

        public int getNum_upcoming_events() {
            return num_upcoming_events;
        }

        public void setNum_upcoming_events(int num_upcoming_events) {
            this.num_upcoming_events = num_upcoming_events;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public List<?> getLinks() {
            return links;
        }

        public void setLinks(List<?> links) {
            this.links = links;
        }

        public static class LocationBean {

            private double lon;
            private double lat;

            public static LocationBean objectFromData(String str) {

                return new Gson().fromJson(str, LocationBean.class);
            }

            public double getLon() {
                return lon;
            }

            public void setLon(double lon) {
                this.lon = lon;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }
        }
    }

    public static class TaxonomiesBean {

        private Object parent_id;
        private int id;
        private String name;

        public static TaxonomiesBean objectFromData(String str) {

            return new Gson().fromJson(str, TaxonomiesBean.class);
        }

        public Object getParent_id() {
            return parent_id;
        }

        public void setParent_id(Object parent_id) {
            this.parent_id = parent_id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class PerformersBean {

        private double score;
        private String short_name;
        private Object home_venue_id;
        private StatsBeanX stats;
        private boolean away_team;
        private Object divisions;
        private int id;
        private String url;
        private Object image_license;
        private String slug;
        private String type;
        private int num_upcoming_events;
        private ImagesBean images;
        private String name;
        private Object colors;
        private Object image_attribution;
        private boolean has_upcoming_events;
        private Object image;
        private boolean home_team;
        private boolean primary;
        private List<TaxonomiesBeanX> taxonomies;

        public static PerformersBean objectFromData(String str) {

            return new Gson().fromJson(str, PerformersBean.class);
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getShort_name() {
            return short_name;
        }

        public void setShort_name(String short_name) {
            this.short_name = short_name;
        }

        public Object getHome_venue_id() {
            return home_venue_id;
        }

        public void setHome_venue_id(Object home_venue_id) {
            this.home_venue_id = home_venue_id;
        }

        public StatsBeanX getStats() {
            return stats;
        }

        public void setStats(StatsBeanX stats) {
            this.stats = stats;
        }

        public boolean isAway_team() {
            return away_team;
        }

        public void setAway_team(boolean away_team) {
            this.away_team = away_team;
        }

        public Object getDivisions() {
            return divisions;
        }

        public void setDivisions(Object divisions) {
            this.divisions = divisions;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Object getImage_license() {
            return image_license;
        }

        public void setImage_license(Object image_license) {
            this.image_license = image_license;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getNum_upcoming_events() {
            return num_upcoming_events;
        }

        public void setNum_upcoming_events(int num_upcoming_events) {
            this.num_upcoming_events = num_upcoming_events;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getColors() {
            return colors;
        }

        public void setColors(Object colors) {
            this.colors = colors;
        }

        public Object getImage_attribution() {
            return image_attribution;
        }

        public void setImage_attribution(Object image_attribution) {
            this.image_attribution = image_attribution;
        }

        public boolean isHas_upcoming_events() {
            return has_upcoming_events;
        }

        public void setHas_upcoming_events(boolean has_upcoming_events) {
            this.has_upcoming_events = has_upcoming_events;
        }

        public Object getImage() {
            return image;
        }

        public void setImage(Object image) {
            this.image = image;
        }

        public boolean isHome_team() {
            return home_team;
        }

        public void setHome_team(boolean home_team) {
            this.home_team = home_team;
        }

        public boolean isPrimary() {
            return primary;
        }

        public void setPrimary(boolean primary) {
            this.primary = primary;
        }

        public List<TaxonomiesBeanX> getTaxonomies() {
            return taxonomies;
        }

        public void setTaxonomies(List<TaxonomiesBeanX> taxonomies) {
            this.taxonomies = taxonomies;
        }

        public static class StatsBeanX {
            public static StatsBeanX objectFromData(String str) {

                return new Gson().fromJson(str, StatsBeanX.class);
            }
        }

        public static class ImagesBean {
            public static ImagesBean objectFromData(String str) {

                return new Gson().fromJson(str, ImagesBean.class);
            }
        }

        public static class TaxonomiesBeanX {

            private Object parent_id;
            private int id;
            private String name;

            public static TaxonomiesBeanX objectFromData(String str) {

                return new Gson().fromJson(str, TaxonomiesBeanX.class);
            }

            public Object getParent_id() {
                return parent_id;
            }

            public void setParent_id(Object parent_id) {
                this.parent_id = parent_id;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
