import java.util.Scanner;
public class StepTracker {
   Scanner scanner;
    MonthData[] monthToData;
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan){
        scanner = scan;

        monthToData = new MonthData[12];
        for (int i = 0; i < 12; i++){
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay(){
        System.out.println("Введите номер месяца от 1 до 12 включительно");
        int month = scanner.nextInt();
        if ((month < 1) || (month > 12)){
            System.out.println("Введено некорректное число");
            return;
        }
        System.out.println("Введите номер дня от 1 до 30 включительно");
        int day = scanner.nextInt();
        if ((day < 1) || (day > 30)){
            System.out.println("Введено некорректное число");
            return;
        }
        System.out.println("Введите кол-во пройденных шагов");
        int step = scanner.nextInt();
        if (step <= 0){
            System.out.println("Введено некорректное число");
            return;
        }System.out.println("Данные успешно сохранены");
        MonthData monthData =  monthToData[month - 1];
        monthData.days[day - 1] = step;
    }
    void changeStepGoal(){
      System.out.println("Введите желаемую цель");
        int ByStepsPerDay = scanner.nextInt();
        if (ByStepsPerDay < 1){
            System.out.println("Введено некорректное число");
            return;
        }goalByStepsPerDay = ByStepsPerDay;
        System.out.println("Данные успешно сохранены");
    }

    void printStatistic(){
        Converter converter = new Converter();
        System.out.println("Введите месяц");
        int staticMonth = scanner.nextInt();
        MonthData monthData = monthToData[staticMonth-1];
        System.out.println("Ваша статистика за " +  monthData.year(staticMonth));
        monthData.printDaysAndStepsFromMonth();
        System.out.println("сумма пройденных шагов: " + monthData.sumStepsFromMonth());
        System.out.println("максимальное пройденное количество шагов в месяце: " + monthData.maxSteps());
        //noinspection IntegerDivisionInFloatingPointContext
        var ceil = (int) Math.ceil(monthData.sumStepsFromMonth() / monthData.days.length);
        System.out.println("среднее количество шагов: " + ceil);
        System.out.println("пройденная дистанция (в км): " + converter.convertToKm( monthData.sumStepsFromMonth()));
        System.out.println("количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(monthData.sumStepsFromMonth()));
        System.out.println("лучшая серия:" + monthData.bestSeries(goalByStepsPerDay));
    }
}

