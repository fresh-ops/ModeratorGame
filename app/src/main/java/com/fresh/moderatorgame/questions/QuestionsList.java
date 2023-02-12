package com.fresh.moderatorgame.questions;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Класс-агрегатор вопросов
 */
public class QuestionsList {
    /** Список вопросов */
    private final ArrayList<String> questions = new ArrayList<>();

    /**
     * Коструктор класса QuestionsList
     * @param source поток ввода с вопросами
     */
    public QuestionsList(InputStream source) {
        Scanner input = new Scanner(source);

        while (input.hasNext()) {
            String question = input.nextLine();
            if (! question.equals("")) {
                questions.add(question);
            }
        }

        input.close();
    }

    /**
     * Метод добавления вопросов в список
     * @param source поток ввода с вопросами
     */
    public void addQuestions(InputStream source) {
        Scanner input = new Scanner(source);

        while (input.hasNext()) {
            String question = input.nextLine();
            if (! question.equals("")) {
                questions.add(question);
            }
        }

        input.close();
    }

    /**
     * Метода, возвращающий случайный вопрос из списка
     * @return случайный вопрос из списка
     */
    public String nextQuestion() {
        Random random = new Random();
        int index = random.nextInt(questions.size());
        return questions.get(index);
    }
}
