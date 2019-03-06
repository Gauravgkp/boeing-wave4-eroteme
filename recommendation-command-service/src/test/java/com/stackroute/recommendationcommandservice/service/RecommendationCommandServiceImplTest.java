package com.stackroute.recommendationcommandservice.service;

import com.stackroute.recommendationcommandservice.model.Answer;
import com.stackroute.recommendationcommandservice.model.Question;
import com.stackroute.recommendationcommandservice.model.User;
import com.stackroute.recommendationcommandservice.repository.AnswerRepository;
import com.stackroute.recommendationcommandservice.repository.QuestionRepository;
import com.stackroute.recommendationcommandservice.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RecommendationCommandServiceImplTest {

    private static final User USER = User.builder().userName("kate").reputation(1).build();
    private static final Question QUESTION = Question.builder().questionId(12).questionString("what is java").timestamp(34544).upVote(32).downVote(1).build();
    private static final Answer ANSWER = Answer.builder().answerString("Dont do it").accepted(true).build();


    @Mock
    private AnswerRepository answerRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private RecommendationCommandServiceImpl recommendationCommandService;


    @Test
    public void saveUserToDb() {
        when(userRepository.save(USER)).thenReturn(USER);
        assertThat(recommendationCommandService.saveUserToDb(USER)).isEqualTo(USER);
    }


    @Test
    public void getUsers() {

        when(userRepository.getAllUsers()).thenReturn(Collections.singletonList(USER));
        assertThat(recommendationCommandService.getUsers()).containsOnly(USER);

    }


    @Test
    public void saveQuestionToDb() {
        when(questionRepository.save(QUESTION)).thenReturn(QUESTION);
        assertThat(recommendationCommandService.saveQuestionToDb(QUESTION)).isEqualTo(QUESTION);

    }


    @Test
    public void getQuestions() {

        when(questionRepository.getAllQuestions()).thenReturn(Collections.singletonList(QUESTION));
        assertThat(recommendationCommandService.getQuestions()).containsOnly(QUESTION);

    }


    @Test
    public void saveAnswerToDb() {
        when(answerRepository.save(ANSWER)).thenReturn(ANSWER);
        assertThat(recommendationCommandService.saveAnswerToDb(ANSWER)).isEqualTo(ANSWER);

    }

    @Test
    public void getAnswers() {
        when(answerRepository.getAllAnswers()).thenReturn(Collections.singletonList(ANSWER));
        assertThat(recommendationCommandService.getAnswers()).containsOnly(ANSWER);

    }

    @Test
    public void userFollowsTopic() {
        List<String> supplierNames = Arrays.asList("pipes", "forms");


        when(userRepository.userFollowsTopicRelationship("meghana", supplierNames)).thenReturn(USER);
        assertThat(recommendationCommandService.userFollowsTopic("meghana", supplierNames)).isEqualTo(USER);

    }

    @Test
    public void getByUser() {

        when(userRepository.getByUser(12)).thenReturn(USER);
        assertThat(recommendationCommandService.getByUser(12)).isEqualTo(USER);

    }

    @Test
    public void questionBelongsTopic() {
        List<String> supplierNames = Arrays.asList("pipes", "forms");

        when(questionRepository.questionBelongsTopicRelationship(12, supplierNames)).thenReturn(QUESTION);
        assertThat(recommendationCommandService.questionBelongsTopic(12, supplierNames)).isEqualTo(QUESTION);

    }

    @Test
    public void userAnsweredAnswer() {
        when(answerRepository.userAnsweredAnswerRelationship("srinidhi", "this is good")).thenReturn(USER);
        assertThat(recommendationCommandService.userAnsweredAnswer("srinidhi", "this is good")).isEqualTo(USER);

    }

    //
    @Test
    public void userViewedQuestion() {
        when(questionRepository.userViewedQuestionRelationship("anirudh", 101)).thenReturn(USER);
        assertThat(recommendationCommandService.userViewedQuestion("anirudh", 101)).isEqualTo(USER);

    }

    @Test
    public void answerIsAnswerOfQuestion() {
        when(questionRepository.answerIsAnswerOfQuestionRelationship("this is good", 101)).thenReturn(ANSWER);
        assertThat(recommendationCommandService.answerIsAnswerOfQuestion("this is good", 101)).isEqualTo(ANSWER);

    }

    @Test
    public void userAskedQuestion() {
        when(questionRepository.userAskedQuestionRelationship("kiran", 101)).thenReturn(USER);
        assertThat(recommendationCommandService.userAskedQuestion("kiran", 101)).isEqualTo(USER);


    }

    @Test
    public void userAcceptedAnswer() {
        when(answerRepository.userAcceptedAnswerRelationship("gagana", "this is good")).thenReturn(USER);
        assertThat(recommendationCommandService.userAcceptedAnswer("gagana", "this is good")).isEqualTo(USER);

    }

    @Test
    public void userUpvotedAnswer() {
        when(answerRepository.userUpvotedAnswerRelationship("varun", "this is good")).thenReturn(USER);
        assertThat(recommendationCommandService.userUpvotedAnswer("varun", "this is good")).isEqualTo(USER);

    }

    @Test
    public void userDownvotedAnswer() {
        when(answerRepository.userDownvotedAnswerRelationship("harsha Bean", "mysuru mango")).thenReturn(USER);
        assertThat(recommendationCommandService.userDownvotedAnswer("harsha Bean", "mysuru mango")).isEqualTo(USER);

    }

    @Test
    public void userUpvoteQuestion() {
        when(questionRepository.userUpvoteQuestionRelationship("easwar", 2696)).thenReturn(USER);
        assertThat(recommendationCommandService.userUpvoteQuestion("easwar", 2696)).isEqualTo(USER);

    }

    @Test
    public void userDownvoteQuestion() {

        when(questionRepository.userDownvoteQuestionRelationship("siddharth", 102)).thenReturn(USER);
        assertThat(recommendationCommandService.userDownvoteQuestion("siddharth", 102)).isEqualTo(USER);

    }
}