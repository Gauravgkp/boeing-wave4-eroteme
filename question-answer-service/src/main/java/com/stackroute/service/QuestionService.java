package com.stackroute.service;

import com.stackroute.domain.Answer;
import com.stackroute.domain.Comment;
import com.stackroute.domain.Question;
import com.stackroute.domain.Replies;

import com.stackroute.exceptions.*;

import java.util.List;

public interface QuestionService {
    public Question addQuestion(Question questionObject) throws QuestionAlreadyExistsException;
    public Question addQuestionDescription(int questionId, String description) throws QuestionNotFoundException;
    public Question addAnswer(int questionId, List<Answer> answer) throws QuestionNotFoundException;
    public Question addQuestionComment(int questionId, List<Comment> comment) throws QuestionNotFoundException;
    public Question addQuestionCommentReply(int questionId, String comment, List<Replies> replies) throws QuestionNotFoundException, CommentNotFoundException;
    public Question addAnswerComment(int questionId, String answer, List<Comment> comment) throws QuestionNotFoundException, AnswerNotFoundException;
    public Question addAnswerCommentReply(int questionId,String answer,String comment,List<Replies> replies);
    public Question addQuestionUpvote(int questionId) throws QuestionNotFoundException;
    public Question addQuestionDownvote(int questionId) throws QuestionNotFoundException;
    public Question addAnswerUpvote(int questionId,String answer)throws QuestionNotFoundException,AnswerNotFoundException;
    public Question addQuestionCommentLikes(int questionId, String comment);
    public Question addQuestionCommentReplyLikes(int questionId,String comment,String reply);
    public Question addAnswerCommentLikes(int questionId,String answer,String comment);
    public Question addAnswerCommentReplyLikes(int questionId,String answer,String comment,String reply);
    public Question addQuestionAnswerAccepted(int questionId,String answer) throws QuestionNotFoundException,AnswerNotFoundException;
}
