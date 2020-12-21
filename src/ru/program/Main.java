package ru.program;

import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Conf conf = new Conf();
        Weather weather = new Weather();

//        weather.OpenService("Kazan", 5);
//        weather.WeatherBit("Kazan", 1);
//        weather.WeatherAPI("Kazan", 5);

        Scanner scanner = new Scanner(System.in);

        int service = conf.getProp(0);
        String city = conf.getCity();
        while (true) {
            System.out.println("Текущий город: " + city);
            System.out.println("""
                    Введите погодный сервис:\s
                    1) OpenService\s
                    2) WeatherBit\s
                    3) WeatherAPI\s
                    4) Продолжить с настройками из конфига\s
                    5) Сменить город\s
                    6) Сохранить город\s
                    7) Сохранить сервис\s
                    0) Выход""");

            int option = scanner.nextInt();
            if (option == 0){
                System.exit(0);
            } else if (1 <= option & option <= 3) {
                service = option;
            } else if (option == 5){
                scanner.nextLine();
                System.out.println("Введите город на английском языке: ");
                city = scanner.nextLine();
                System.out.println("Введите сервис: ");
                service = scanner.nextInt();
            } else if (option == 6){
                conf.setCity(city);
            } else if (option == 7){
                conf.setService(service);
            }

            System.out.println("Введите параметры для вывода: 1 - weather 2 - wind 3 - temp 4 - pressure 5 - sunrise and sunset");
            int param = scanner.nextInt();

            if (service == 1) {
                weather.OpenService(city, param);
            } else if (service == 2) {
                weather.WeatherBit(city, param);
            } else if (service == 3) {
                weather.WeatherAPI(city, param);
            }
        }

    }
}
