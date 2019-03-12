/**
 * 
 */
package com.mathesh.student.test.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mathesh.student.test.Model.QuestionAndAnswer;
import com.mathesh.student.test.Model.DTO.QuestionAndAnswerDTO;
import com.mathesh.student.test.Service.QuestionAndAnswerService;
import com.mathesh.student.test.util.exception.ApplicationException;
import com.mathesh.student.test.util.exception.ExceptionHandlingController;

import io.swagger.annotations.ApiOperation;

/**
 */
@RestController
@RequestMapping("/v1/rest/questions")
public class QuestionAndAnswerController extends ExceptionHandlingController {

    @Autowired
    private QuestionAndAnswerService questionAndAnswerService;
    
    @GetMapping("")
    @ApiOperation(value = "Get the questions")
    @ResponseStatus(HttpStatus.OK)
    public List<QuestionAndAnswer> getQuestions() throws ApplicationException {
        
        return questionAndAnswerService.getQuestions();        
    }
    
    @PostMapping("/verify")
    @ApiOperation(value = "Verify the questions")
    @ResponseStatus(HttpStatus.OK)
    public List<QuestionAndAnswerDTO> verifyQuestions(@RequestBody List<QuestionAndAnswerDTO> questionAndAnswerDTOs) throws ApplicationException {
        
        return questionAndAnswerService.verify(questionAndAnswerDTOs);        
    }
}
