public class Converter {

    int convertToKm(int steps){
        return (int)Math.ceil(steps * 0.00075);
    }
    int convertStepsToKilocalories(int steps){
        return  (int)Math.ceil(steps / 20.0);
    }
}