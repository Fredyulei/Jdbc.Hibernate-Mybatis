package com.qingke.easy.jdbc.command.impl;

import com.qingke.easy.Answer;
import com.qingke.easy.Player;
import com.qingke.easy.Question;
import com.qingke.easy.jdbc.app.BesuperDao;
import com.qingke.easy.jdbc.command.PlayerCommand;
import com.qingke.jdbcapp.util.QingkeConsole;

public class AcceptCommand extends PlayerCommand {
	public AcceptCommand(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void executePlayerCommand() {
		// TODO Auto-generated method stub
		BesuperDao dao=new BesuperDao();
		long qid=QingkeConsole.askUserInputInt("请输入问题ID");
		Question question=dao.getQuestion(qid);
		if(question==null){
			QingkeConsole.println("您输入的ID不存在");
			return;
		}
		if(question.getFrom().getId()!=player.getId()){
			QingkeConsole.println("无法对别人的问题进行操作");
			return;
		}
		int aid=QingkeConsole.askUserInputInt("请输入最佳答案ID");
		Answer answer=dao.getAnswer(aid);
		if(answer==null){
			QingkeConsole.println("您输入的答案ID不存在");
			return;
		}
		if(answer.getFrom().getId()==player.getId()){
			QingkeConsole.println("无法选择自己的回答作为最佳答案");
			return;
		}
		question.setOpen(false);
		question.setBestAnswer(answer);
		answer.setBestAnswer(true);
		Player answerFrom=answer.getFrom();
		int score=question.getCredit()+answerFrom.getScore();
		answerFrom.setScore(score);
		dao.acceptAnswer(question, answer);	
	}

}
