package com.example.test.controller.quizz;

public class StartQuizzController {
    private static StartQuizzController controller = null;

    private StartQuizzController(){}

    public static final StartQuizzController getInstance(){
        if(StartQuizzController.controller == null){
            StartQuizzController.controller = new StartQuizzController();
        }
        return StartQuizzController.controller;
    }

    public int getBestScore(){
        return 0;
    }
}
