/**
 * 
 */
package com.mathesh.student.test.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author mathesh
 *
 */
public class QuestionAndAnswer {

    private Long id;
    
    private String question;
    
    @JsonIgnore
    private Boolean answer;
    
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
     * @return the answer
     */
    public Boolean getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

}
