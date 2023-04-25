import java.util.Random;
import java.util.Scanner;

public class Lottery {
    // Поля класса
    private Scanner scan = new Scanner(System.in);                                                  // Переменная для чтения из консоли
    private Random rand = new Random();                                                             // Переменная для генерации псевдослучайного числа
    private int[] winArray = new int[5];                                                            // Создаем массив из 5 элементов, в который запишем выигрышную комбинацию
    private int[] userArray = new int[5];                                                           // Создаем массив из 5 элементов, в который запишем комбинацию пользователя
    private int bound;                                                                              // Переменная для указания диапазона чисел в последовательности
    private int countPositions = 0;                                                                 // Переменная для подсчета угаданных позиций числа

    /**
     * Метод для генерации выигрышной комбинации
     * @param bound диапазон чисел в комбинации
     */
    public void generateWinCombination(int bound) {
         for (int i = 0; i < winArray.length; i++){                                               // Цикл для генерации чисел выигрышной комбинации
             winArray[i] = rand.nextInt(bound);                                                   // присвоение случайного значения каждому элементу массива
         }
         this.bound = bound;                                                                      // this.bound  ссылается на поле bound и присваивает ему локальную переменную bound
    }

    /**
     * Метод для ввода комбинации пользователя
     */
    public void userCombination(){
        System.out.println("Введите 5 чисел в диапазоне от 0 до " + bound);
        for (int i = 0; i < userArray.length; i++) {
            userArray[i] = scan.nextInt();
        }
    }

    /**
     * Метод для проверки комбинации пользователя
     */
    public void checkCombination(){
        for (int i = 0; i < winArray.length; i++) {
            if(winArray[i] == userArray[i]){
                countPositions++;
            }
        }
    }

    /**
    *Метод для проверки выигрышной комбинации(жульничества)
     */
    public void cheat(){
        for (int i = 0; i < winArray.length; i++) {
            System.out.print(winArray[i] + " ");
        }
        System.out.println();
    }

    /**
     * Метод для возвращения числа угаданных позиций
     * @return количество угаданных позиций
     */
    public int guessedPositions(){
         return countPositions;                                                                                // Возвращаем поле класса, в котором записано количество угаданных позиций
    }
}
