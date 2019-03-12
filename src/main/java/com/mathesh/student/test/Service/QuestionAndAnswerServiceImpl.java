/**
 * 
 */
package com.mathesh.student.test.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.mathesh.student.test.Model.QuestionAndAnswer;
import com.mathesh.student.test.Model.DTO.QuestionAndAnswerDTO;

/**
 * @author mathesh
 *
 */
@Service
public class QuestionAndAnswerServiceImpl implements QuestionAndAnswerService {

    private HashMap<Long, QuestionAndAnswer> defaultQuestionAndAnswers = new HashMap<>(); 
    
    @Override
    public List<QuestionAndAnswer> getQuestions() {
        
        int  noOfQuestions = 5;
        
        int maxRange = 10;
        
        List<QuestionAndAnswer> questions = getRandomQuestion(noOfQuestions, maxRange);
        
        return questions;
    }

    private List<QuestionAndAnswer> getRandomQuestion(int noOfQuestions, int maxRange) {
        List<QuestionAndAnswer> questionsAndAnswers = new ArrayList<>();
        
        Random random = new Random();
        
        do
        {
            Long next = (long) random.nextInt(maxRange);
            
            if (next != 0l && !questionsAndAnswers.contains(defaultQuestionAndAnswers.get(next)))
            {
                questionsAndAnswers.add(defaultQuestionAndAnswers.get(next));
            }
        } while (questionsAndAnswers.size() < noOfQuestions);
 
        return questionsAndAnswers;
    }

    @Override
    public List<QuestionAndAnswerDTO> verify(List<QuestionAndAnswerDTO> questionAndAnswerDTOs) {
        
        List<QuestionAndAnswerDTO> verifiedQuestionAndAnswerDTOs = new ArrayList<>();
        
       for (QuestionAndAnswerDTO  questionAndAnswerDTO : questionAndAnswerDTOs) {
           QuestionAndAnswer questionAndAnswer = defaultQuestionAndAnswers.get(questionAndAnswerDTO.getId());
           questionAndAnswerDTO.setCorrectAnswer(questionAndAnswer.getAnswer());
           verifiedQuestionAndAnswerDTOs.add(questionAndAnswerDTO);
       }
        
        return verifiedQuestionAndAnswerDTOs;
    }

    @Override
    public void createDefaultQuestions() {
        
        
        QuestionAndAnswer question = new QuestionAndAnswer();
        question.setId(1l);
        question.setQuestion("First question");
        question.setAnswer(true);
        defaultQuestionAndAnswers.put(question.getId(), question);
        
        question = new QuestionAndAnswer();
        question.setId(2l);
        question.setQuestion("Second question");
        question.setAnswer(false);
        defaultQuestionAndAnswers.put(question.getId(), question);
        
        question = new QuestionAndAnswer();
        question.setId(3l);
        question.setQuestion("Third question");
        question.setAnswer(false);
        defaultQuestionAndAnswers.put(question.getId(), question);
        
        question = new QuestionAndAnswer();
        question.setId(4l);
        question.setQuestion("Fourth question");
        question.setAnswer(true);
        defaultQuestionAndAnswers.put(question.getId(), question);
        
        question = new QuestionAndAnswer();
        question.setId(5l);
        question.setQuestion("Fifth question");
        question.setAnswer(true);
        defaultQuestionAndAnswers.put(question.getId(), question);
        
        question = new QuestionAndAnswer();
        question.setId(6l);
        question.setQuestion("Sixth question");
        question.setAnswer(false);
        defaultQuestionAndAnswers.put(question.getId(), question);
        
        question = new QuestionAndAnswer();
        question.setId(7l);
        question.setQuestion("Seventh question");
        question.setAnswer(false);
        defaultQuestionAndAnswers.put(question.getId(), question);
        
        question = new QuestionAndAnswer();
        question.setId(8l);
        question.setQuestion("Eighth question");
        question.setAnswer(true);
        defaultQuestionAndAnswers.put(question.getId(), question);
        
        question = new QuestionAndAnswer();
        question.setId(9l);
        question.setQuestion("Nineth question");
        question.setAnswer(true);
        defaultQuestionAndAnswers.put(question.getId(), question);
        
        question = new QuestionAndAnswer();
        question.setId(10l);
        question.setQuestion("Tenth question");
        question.setAnswer(false);
        defaultQuestionAndAnswers.put(question.getId(), question);
        
    }

}
