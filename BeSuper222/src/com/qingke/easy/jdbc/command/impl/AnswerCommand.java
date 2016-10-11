package com.qingke.easy.jdbc.command.impl;

import com.qingke.easy.Answer;
import com.qingke.easy.Player;
import com.qingke.easy.Question;
import com.qingke.easy.jdbc.app.BesuperDao;
import com.qingke.easy.jdbc.command.PlayerCommand;
import com.qingke.jdbcapp.util.QingkeConsole;
public class AnswerCommand extends PlayerCommand {
	public AnswerCommand(Player player) {
		super(player);
	}
	@Override
	public void executePlayerCommand() {
		// TODO Auto-generated method stub
		int qid=QingkeConsole.askUserInputInt("����������ID");
		BesuperDao dao=new BesuperDao();
		Question question=dao.getQuestion(qid);
		if(question==null){
			QingkeConsole.println("����ID������");
			return;
		}
		if(question.getFrom().getId()==player.getId()){
			QingkeConsole.println("��������ش��Լ����������");
			return;
		}
		String content=QingkeConsole.askUserInput("���������Ļش�");
		//
		Answer answer=new Answer(-1,content,player);
		//
		dao.upsertAnwser(answer);
		player.getAnswers().add(answer);
		question.getAnswers().add(answer);
	}
}
