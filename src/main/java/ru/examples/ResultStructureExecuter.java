package ru.examples;

import java.util.*;

public class ResultStructureExecuter {


    private final Map<String, List<String>> resultStructure = new TreeMap<>();
    private String sourceString;

    /**
     * Конструктор
     *
     * @param source исходная строка (запоминается)
     */
    public ResultStructureExecuter(String source) {
        sourceString = source;
    }

    public String getSourceString() {
        return sourceString;
    }

    /**
     * Алгоритм группировки и сортировки.
     */
    public void doExecute() {
        if (sourceString == null || sourceString.isEmpty()) return;
        Arrays.stream(sourceString.trim().split("\\PL+"))
                .map(String::toLowerCase)
                .distinct()
                .forEach(s -> {
                    String letter = s.substring(0, 1);
                    if (!resultStructure.containsKey(letter)) {
                        List<String> list = new ArrayList<>();
                        list.add(s);
                        resultStructure.put(letter, list);
                    } else {
                        resultStructure.get(letter).add(s);
                    }
                });
    }


    /**
     * Представляет результирующую структуру в виде строки, как есть без фильтрации.
     *
     * @return строковое представление структуры
     */
    @Override
    public String toString() {
        return resultStructure.toString();
    }

    /**
     * Представляет результирующую структуру в виде строки, группы содержащие единственный элемент отфильтрованы.
     *
     * @return строковое представление структуры
     */
    public String toStringWithOutOnesElements() {
        Map<String, List<String>> result = new TreeMap<>();
        resultStructure.forEach((k, v) -> {
            if (v.size() > 1) {
                result.put(k, sortValues(v));
            }
        });
        return result.toString();
    }

    /**
     * Сортировка строк в списке.
     * <p>
     * Сортировка в алфавитном порядке по всем буквам в слове.
     * Слова внутри группы сортированы по убыванию (по количеству символов),
     * если число символов равное, то сортировка в алфавитном порядке.
     *
     * @param source Список строк
     * @return исходный список строк в отсортированном виде
     */
    private List<String> sortValues(List<String> source) {
        List<String> result = new ArrayList<>(source);
        result.sort((s1, s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            } else {
                return s2.length() - s1.length();
            }
        });
        return result;
    }
}
