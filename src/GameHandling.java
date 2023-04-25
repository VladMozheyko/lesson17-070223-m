import java.util.Scanner;

public class GameHandling {

    public GameHandling() {                                          // Конструктор
        while (true) {                                               // Пользовательский(бесконечный) цикл для управления игрой
            handleGame();                                            // Метод для управления игрой
        }
    }

    /**
     * Метод для управления игрой
     */
    public void handleGame(){
        System.out.println("Выберите действие:\n " +                  // Выводим приглашение пользователю
                "1 - играть\n" +
                "2 - сжульничать\n" +
                "3 - выйти");
        Scanner scanner = new Scanner(System.in);                    // Создаем объект Scanner для считывания из консоли
        int choice = scanner.nextInt();                              // Объявляем(декларируем) переменную для выбора пользователя и присваиваем(инициализируем) ее введенным значением с консоли
        Lottery lottery = new Lottery();                             // Создаем объект класса Lottery. Для того, чтобы можно было его использовать в разных методах - он для них будет общим
        lottery.generateWinCombination(10);                          // Создаем выигрышную комбинацию. Инициализируем массив с выигрышной комбинацией.
        if(choice == 1){                                             // Проверяем ввод пользователя
            performGame(lottery);                                    // Вызываем метод запуска игры, если пользователь ввел 1
        }
        else if(choice == 2){                                        // Если пользователь ввел 2
            cheat(lottery);                                          // Вызываем метод для жульничества
            performGame(lottery);                                    // Запускаем игру
        }
        else {
            System.exit(0);                                          // Выводим из программы с корректным статусом завершения - 0
        }
    }

    public void cheat(Lottery lottery) {                             // Метод для жульничества
        lottery.cheat();                                             // Вызываем метод cheat из объекта lottery
    }

    public void performGame(Lottery lottery){
        lottery.userCombination();                                   // Приглашаем пользователя ввести комбинацию
        lottery.checkCombination();                                  // Проверяем комбинацию
        int res = lottery.guessedPositions();                        // Получаем количество указанных позиций
        System.out.println("Количество угаданных позиций: " + res);  // Выводим результат на консоль
        lottery.cheat();                                             // Выводим выигрышную комбинацию
    }
}
