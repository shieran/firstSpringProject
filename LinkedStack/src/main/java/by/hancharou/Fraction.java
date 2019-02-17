package by.hancharou;
import java.util.Objects;


public class Fraction implements Comparable <Fraction>{

    private int numerator;
    private int denumerator;

    public Fraction(int numerator, int denumerator) {
        if (denumerator <= 0 || numerator <= 0){
                    throw new LessThanZeroException();
                }
        this.numerator = numerator;
        this.denumerator = denumerator;
    }

    public Fraction(int numerator) {
            if (numerator <= 0) {
                throw new LessThanZeroException();
            }
            this.numerator = numerator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenumerator() {
        return denumerator;
    }

    //свой метод сравнения дробей
    @Override
    public int compareTo(Fraction fraction) {
        double thisDoubleValue = (double)this.numerator / (double)this.denumerator;
        double fractionDoubleValue = (double)fraction.numerator / (double)fraction.denumerator;
        if (thisDoubleValue > fractionDoubleValue)
            return 1;
        else if (thisDoubleValue < fractionDoubleValue)
            return -1;
        else return 0;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator &&
                denumerator == fraction.denumerator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denumerator);
    }

    @Override
    public String toString() {
        if (denumerator == 1){
            return Integer.toString(numerator);
        }
        return numerator + "/" + denumerator;
    }

    //сложение дробей
    Fraction addFractions(Fraction fraction){
        int newDenumerator = this.denumerator * fraction.denumerator;
        int newNumerator = this.numerator * fraction.denumerator + fraction.numerator * this.denumerator;
        return new Fraction(newNumerator, newDenumerator);
    }

    //умножение дробей
    Fraction multiplyFractions(Fraction fraction){
        int newDenumerator = this.denumerator * fraction.denumerator;
        int newNumerator = this.numerator * fraction.numerator;
        return new Fraction(newNumerator, newDenumerator);
    }

    //сокращение дробей
    static Fraction fractionReduction(Fraction fraction){
        Fraction someFraction;
        if (findMinimal(fraction) == 1) {
            for (int i = fraction.denumerator; i > 1; i--) {
                someFraction = getNewFraction(fraction, i);//метод getNewFraction проверяет, делятся ли числитель и знаменатель без остатка на число
                //если да, то создаём новый объект на основе поделённых значений, если нет - вернем null
                if (someFraction != null) {//если getNewFraction вернул не null, дробь сократилась, возвращаем новый объект
                    return someFraction;
                }
            }
        }
        else if (findMinimal(fraction) == 2){
                for (int i = fraction.numerator; i > 1; i--){
                    someFraction = getNewFraction(fraction, i);
                    if (someFraction != null){
                        return someFraction;
                    }
                }
        }
        System.out.println("дробь нельзя сократить");
        return new Fraction(fraction.numerator, fraction.denumerator);
    }


    //метод getNewFraction проверяет, делятся ли числитель и знаменатель без остатка на число
    //если да, то создаём новый объект на основе поделённых значений, если нет - вернем null
    static Fraction getNewFraction(Fraction fraction, int num){
        if (fraction.numerator % num == 0 && fraction.denumerator % num == 0){
            return new Fraction(fraction.numerator / num, fraction.denumerator / num);
        }
        return null;
    }

    //определяет что меньше: числитель или знаменатель
    static int findMinimal(Fraction fraction){
        if (fraction.numerator >= fraction.denumerator){
            return 1;
        }else{
            return 2;
        }
    }

}
