/**
 * 
 */
package com.mathesh.student.test.Service;

import java.util.List;

import com.mathesh.student.test.Model.QuestionAndAnswer;
import com.mathesh.student.test.Model.DTO.QuestionAndAnswerDTO;

/**
 * @author mathesh
 *
 */
public interface QuestionAndAnswerService {

    List<QuestionAndAnswer> getQuestions();
    
    List<QuestionAndAnswerDTO> verify(List<QuestionAndAnswerDTO> questionAndAnswerDTOs);

    void createDefaultQuestions();

}
