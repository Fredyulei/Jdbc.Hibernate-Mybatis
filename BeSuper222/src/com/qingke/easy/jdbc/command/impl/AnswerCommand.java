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
		int qid=QingkeConsole.askUserInputInt("请输入问题ID");
		BesuperDao dao=new BesuperDao();
		Question question=dao.getQuestion(qid);
		if(question==null){
			QingkeConsole.println("输入ID不存在");
			return;
		}
		if(question.getFrom().getId()==player.getId()){
			QingkeConsole.println("您不允许回答自己提出的问题");
			return;
		}
		String content=QingkeConsole.askUserInput("请输入您的回答");
		//
		Answer answer=new Answer(-1,content,player);
		//
		dao.upsertAnwser(answer);
		player.getAnswers().add(answer);
		question.getAnswers().add(answer);
	}
}
