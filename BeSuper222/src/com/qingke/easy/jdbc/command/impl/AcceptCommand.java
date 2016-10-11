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
		long qid=QingkeConsole.askUserInputInt("����������ID");
		Question question=dao.getQuestion(qid);
		if(question==null){
			QingkeConsole.println("�������ID������");
			return;
		}
		if(question.getFrom().getId()!=player.getId()){
			QingkeConsole.println("�޷��Ա��˵�������в���");
			return;
		}
		int aid=QingkeConsole.askUserInputInt("��������Ѵ�ID");
		Answer answer=dao.getAnswer(aid);
		if(answer==null){
			QingkeConsole.println("������Ĵ�ID������");
			return;
		}
		if(answer.getFrom().getId()==player.getId()){
			QingkeConsole.println("�޷�ѡ���Լ��Ļش���Ϊ��Ѵ�");
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
