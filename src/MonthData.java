import static sun.swing.MenuItemLayoutHelper.max;

public class MonthData {
    int[] days = new int[30];
    void printDaysAndStepsFromMonth(){
        for (int i = 0; i < days.length; i++){
        System.out.println((i + 1) + " день: " + days[i]);
        }
    }
    int sumStepsFromMonth(){
        int sum = 0;
        for (int i = 0; i < 30; i ++){
            sum += days[i];
        }return sum;
    }
    int maxSteps(){
        return max(days);
    }
    int bestSeries(int goalByStepsPerDay){
        int maxLen = 0;
        int maxSteps = 0;
        for (int i = 0; i < days.length; i ++){
            if (days[i] >= goalByStepsPerDay){
               maxLen += 1;
               if ( maxLen > maxSteps){
                   maxSteps = maxLen;
               }
            }else{
                maxLen = 0;
            }
        }return maxSteps;
    }
    String year(int x){
        String[] year = {"январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
       return year[x - 1];
    }
}
