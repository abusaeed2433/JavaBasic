package testOnly;

public class City implements Comparable<City>{
    private final String city;
    private final String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    public String getCityName(){
        return this.city;
    }

    public String getProvinceName(){
        return this.province;
    }

    @Override
    public int compareTo(City city) {
        return this.city.compareTo(city.getCityName());
    }
}