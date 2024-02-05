package Quiz;

import java.util.Scanner;

public class QuestionService {
    Question questions[] = new Question[5];

    public QuestionService() {
        questions[0] = new Question(1, "Size of int ? ", "1", "2", "3", "4", "4");
        questions[1] = new Question(2, "Size of double ? ", "8", "2", "3", "4", "8");
        questions[2] = new Question(3, "Size of char ? ", "1", "2", "3", "4", "2");
        questions[3] = new Question(4, "Size of long ? ", "6", "2", "8", "4", "8");
        questions[4] = new Question(5, "Size of boolean ? ", "1", "2", "3", "4", "1");

    }

    public void playQuiz(){
        int score = 0;
        for(Question q : questions){
            System.out.println("Id : " + q.getId());
            System.out.println("Question : " + q.getQuestion());
            System.out.println("Option 1: " + q.getOpt1());
            System.out.println("Option 2: " + q.getOpt2());
            System.out.println("Option 3: " + q.getOpt3());
            System.out.println("Option 4: " + q.getOpt4());

            Scanner sc = new Scanner(System.in);
            String ans = sc.nextLine();
            if(ans.equals(q.getAnswer())){
                score = score + 1;
            }
        }

        System.out.println("Your Total score: " + score);
    }
    
}
