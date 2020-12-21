package ru.program;

import org.json.*;

public class Weather {
    private static Request request = new Request();


    public void OpenService(String city, int param) throws Exception {
        String key = "55488769bf2f6feca61987fd6341fe08";

        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city +"&units=metric&appid=" + key;

//        String test = "{\"coord\":{\"lon\":49.12,\"lat\":55.79},\"weather\":[{\"id\":601,\"main\":\"Snow\",\"description\":\"snow\",\"icon\":\"13d\"}],\"base\":\"stations\",\"main\":{\"temp\":-8,\"feels_like\":-13.16,\"temp_min\":-8,\"temp_max\":-8,\"pressure\":1024,\"humidity\":85},\"visibility\":8000,\"wind\":{\"speed\":3,\"deg\":180},\"snow\":{\"1h\":0.22},\"clouds\":{\"all\":90},\"dt\":1608110646,\"sys\":{\"type\":1,\"id\":9038,\"country\":\"RU\",\"sunrise\":1608095315,\"sunset\":1608120601},\"timezone\":10800,\"id\":551487,\"name\":\"Kazan’\",\"cod\":200}";

//        String jsonString = "{\"coord\":{\"lon\":49.12,\"lat\":55.79},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"base\":\"stations\",\"main\":{\"temp\":-15,\"feels_like\":-20.57,\"temp_min\":-15,\"temp_max\":-15,\"pressure\":1039,\"humidity\":84},\"visibility\":8000,\"wind\":{\"speed\":3,\"deg\":140},\"clouds\":{\"all\":68},\"dt\":1607867542,\"sys\":{\"type\":1,\"id\":9038,\"country\":\"RU\",\"sunrise\":1607835947,\"sunset\":1607861401},\"timezone\":10800,\"id\":551487,\"name\":\"Kazan’\",\"cod\":200}";

        JSONObject obj = new JSONObject(request.request_method(url));

        String city_name = obj.getString("name");

        JSONArray weather = obj.getJSONArray("weather");
        String weather_description = weather.getJSONObject(0).getString("description");

        int wind_speed = obj.getJSONObject("wind").getInt("speed");
        int wind_deg = obj.getJSONObject("wind").getInt("deg");

        int temp = obj.getJSONObject("main").getInt("temp");
        int feels_like = obj.getJSONObject("main").getInt("feels_like");
        int temp_min = obj.getJSONObject("main").getInt("temp_min");
        int temp_max = obj.getJSONObject("main").getInt("temp_max");

        int sunrise = obj.getJSONObject("sys").getInt("sunrise");
        int sunset = obj.getJSONObject("sys").getInt("sunset");
        String sunrise_out = new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date (sunrise*1000));
        String sunset_out = new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date (sunset*1000));

        int pressure = obj.getJSONObject("main").getInt("pressure");

        showOut(param, city_name, weather_description, wind_speed, wind_deg, temp, pressure);

        if (param == 3){
            System.out.println("Feels like temp: " + feels_like);
            System.out.println("Minimal temperature today: " + temp_min);
            System.out.println("Maximal temperature today: " + temp_max + "\n\n");
        } else if (param == 5) {
            System.out.println("Sunrise time: " + sunrise_out);
            System.out.println("Sunset time: " + sunset_out + "\n\n");
        }
    }

    public void WeatherBit(String city, int param) throws Exception {
        String key = "56e5f53925d34a09835b12c48679f195";

        String url = "http://api.weatherbit.io/v2.0/current?units=M&city="+ city + "&key=" + key;

//        String jsonString = "{\"data\":[{\"rh\":84,\"pod\":\"n\",\"lon\":49.12214,\"pres\":1021.8,\"timezone\":\"Europe\\/Moscow\",\"ob_time\":\"2020-12-13 13:34\",\"country_code\":\"RU\",\"clouds\":58,\"ts\":1607866481,\"solar_rad\":0,\"state_code\":\"73\",\"city_name\":\"Kazan\",\"wind_spd\":4,\"wind_cdir_full\":\"south-southeast\",\"wind_cdir\":\"SSE\",\"slp\":1039,\"vis\":5,\"h_angle\":-90,\"sunset\":\"12:10\",\"dni\":0,\"dewpt\":-17.1,\"snow\":0,\"uv\":0,\"precip\":0,\"wind_dir\":150,\"sunrise\":\"05:04\",\"ghi\":0,\"dhi\":0,\"aqi\":39,\"lat\":55.78874,\"weather\":{\"icon\":\"c02n\",\"code\":802,\"description\":\"Scattered clouds\"},\"datetime\":\"2020-12-13:13\",\"temp\":-15,\"station\":\"UWKD\",\"elev_angle\":-13.94,\"app_temp\":-22.7}],\"count\":1}";

        JSONObject obj = new JSONObject(request.request_method(url));

        JSONArray arr = obj.getJSONArray("data");

        String city_name = arr.getJSONObject(0).getString("city_name");

        String weather_description = arr.getJSONObject(0).getJSONObject("weather").getString("description");

        int wind_speed =  arr.getJSONObject(0).getInt("wind_spd");
        int wind_deg = arr.getJSONObject(0).getInt("wind_dir");

        int temp = arr.getJSONObject(0).getInt("temp");

        String sunrise_out = arr.getJSONObject(0).getString("sunrise");
        String sunset_out = arr.getJSONObject(0).getString("sunset");

        int pressure = arr.getJSONObject(0).getInt("pres");

        showOut(param, city_name, weather_description, wind_speed, wind_deg, temp, pressure);

        if (param == 5) {
            System.out.println("Sunrise time: " + sunrise_out);
            System.out.println("Sunset time: " + sunset_out + "\n\n");
        }
    }

    public void WeatherAPI(String city, int param) throws Exception {
        String key = "644ad3d53f9b4f00bb8145227201612";

        String url = "http://api.weatherapi.com/v1/current.json?key=" + key + "&q=" + city;

//        String jsonString = "{\n" +
//                "    \"location\": {\n" +
//                "        \"name\": \"Kazan\",\n" +
//                "        \"region\": \"Tatarstan\",\n" +
//                "        \"country\": \"Russia\",\n" +
//                "        \"lat\": 55.75,\n" +
//                "        \"lon\": 49.13,\n" +
//                "        \"tz_id\": \"Europe/Moscow\",\n" +
//                "        \"localtime_epoch\": 1608130811,\n" +
//                "        \"localtime\": \"2020-12-16 18:00\"\n" +
//                "    },\n" +
//                "    \"current\": {\n" +
//                "        \"last_updated_epoch\": 1608129911,\n" +
//                "        \"last_updated\": \"2020-12-16 17:45\",\n" +
//                "        \"temp_c\": -10.0,\n" +
//                "        \"temp_f\": 14.0,\n" +
//                "        \"is_day\": 0,\n" +
//                "        \"condition\": {\n" +
//                "            \"text\": \"Partly cloudy\",\n" +
//                "            \"icon\": \"//cdn.weatherapi.com/weather/64x64/night/116.png\",\n" +
//                "            \"code\": 1003\n" +
//                "        },\n" +
//                "        \"wind_mph\": 4.3,\n" +
//                "        \"wind_kph\": 6.8,\n" +
//                "        \"wind_degree\": 190,\n" +
//                "        \"wind_dir\": \"S\",\n" +
//                "        \"pressure_mb\": 1023.0,\n" +
//                "        \"pressure_in\": 30.7,\n" +
//                "        \"precip_mm\": 0.0,\n" +
//                "        \"precip_in\": 0.0,\n" +
//                "        \"humidity\": 85,\n" +
//                "        \"cloud\": 75,\n" +
//                "        \"feelslike_c\": -15.7,\n" +
//                "        \"feelslike_f\": 3.8,\n" +
//                "        \"vis_km\": 10.0,\n" +
//                "        \"vis_miles\": 6.0,\n" +
//                "        \"uv\": 1.0,\n" +
//                "        \"gust_mph\": 10.7,\n" +
//                "        \"gust_kph\": 17.3\n" +
//                "    }\n" +
//                "}";

        JSONObject obj = new JSONObject(request.request_method(url));

        String city_name = obj.getJSONObject("location").getString("name");

        String weather_description = obj.getJSONObject("current").getJSONObject("condition").getString("text");

        int wind_speed = obj.getJSONObject("current").getInt("wind_kph");
        int wind_deg = obj.getJSONObject("current").getInt("wind_degree");

        int temp = obj.getJSONObject("current").getInt("temp_c");
        int feels_like = obj.getJSONObject("current").getInt("feelslike_c");

        int pressure = obj.getJSONObject("current").getInt("pressure_mb");

        showOut(param, city_name, weather_description, wind_speed, wind_deg, temp, pressure);
        if (param == 3){
            System.out.println("Fells like temperature: " + feels_like + "\n\n");
        } else if (param == 5) {
            System.out.println("This api does not support this feature :(" + "\n\n");
        }

    }

    private static void showOut(int param, String city_name, String weather_description, int wind_speed, int wind_deg, int temp, int pressure) {
        System.out.println("City: " + city_name);
        if (param == 1) {
            System.out.println("Current weather description: " + weather_description + "\n\n");
        } else if (param == 2) {
            System.out.println("Wind speed = " + wind_speed + "km/h");
            System.out.println("Wind degrees = " + wind_deg + "\n\n");
        } else if (param == 3) {
            System.out.println("Current temperature: " + temp);
        } else if (param == 4) {
            System.out.println("Current pressure: " + pressure + "\n\n");
        }
    }
}
