/**
 * 
 */
package com.mathesh.student.test.Model.DTO;


/**
 * @author mathesh
 *
 */
public class QuestionAndAnswerDTO {

    private Long id;
    
    private String question;
    
    private Boolean chosenAnswer;
    
    private Boolean correctAnswer;
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the Correct
     */
    public Boolean getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * @param correctanswer the answer to set
     */
    public void setCorrectAnswer(Boolean correctanswer) {
        this.correctAnswer = correctanswer;
    }

    /**
     * @return the chosenAnswer
     */
    public Boolean getChosenAnswer() {
        return chosenAnswer;
    }

    /**
     * @param chosenAnswer the chosenAnswer to set
     */
    public void setChosenAnswer(Boolean chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }

}
