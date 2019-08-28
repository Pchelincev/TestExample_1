package ru.examples;


import java.util.Scanner;

/**
 * @author pchelincev-denis (pchelincev-denis@mail.ru)
 * @version 0.0.1
 * @link https://github.com/
 *
 * <p>
 * Задание:
 * Есть строка, состоящая из слов. Все слова в ней разделены одним пробелом.
 * Нужно преобразовать строку в такую структуру данных, которая группирует слова по первой букве в слове.
 * Затем вывести только группы, содержащие более одного элемента.
 *
 * Группы должны быть отсортированы в алфавитном порядке.
 * Слова внутри группы нужно сортировать по убыванию количества символов;
 * если количество символов равное, то сортировать в алфавитном порядке.

 * Пример строки: String s = «сапог сарай арбуз болт бокс биржа»
 * Отсортированная строка: [б=[биржа, бокс, болт], c=[caпог, сарай]]
 */
public class GroupedStringsStructureExample {

    private static final String KEY_CONSOLE = "-w";
    private final static String testString = "сапог сарай арбуз болт бокс биржа";


    public static void main(String[] args) {
        String source;
        if (args.length == 1 && args[0].equalsIgnoreCase(KEY_CONSOLE)) {
            System.out.println("Введите слова и закончите ввод клавишей Enter:");
            Scanner in = new Scanner(System.in);
            source = in.nextLine();
        } else {
            System.out.println("Тест по заранее подготовленному примеру.");
            source = testString;
        }
        try {
            ResultStructureExecuter resultStructureExecuter = new ResultStructureExecuter(source);
            resultStructureExecuter.doExecute();
            System.out.println("Исходная тестовая строка: " + resultStructureExecuter.getSourceString());
            System.out.println("Результирующая структура: " + resultStructureExecuter.toString());
            System.out.println("Результирующая структура без единичных элементов: " +
                    resultStructureExecuter.toStringWithOutOnesElements());
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Ошибка ввода. Скорей всего был введён символ пробела.");
        } catch (Exception e) {
            System.err.println("Недетерминированная ошибка.");
        }
    }
}
