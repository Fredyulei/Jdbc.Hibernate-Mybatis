package com.qingke.easy.jdbc.command.impl;

import com.qingke.easy.Player;
import com.qingke.easy.jdbc.command.PlayerCommand;
import com.qingke.jdbcapp.util.QingkeConsole;

public class ScoreCommand extends PlayerCommand{

	public ScoreCommand(Player player) {
		super(player);
	}
	@Override
	public void executePlayerCommand() {
	QingkeConsole.println("========"+player.getName()+"======");
	QingkeConsole.println("��������"+player.getQuestions().size());
	QingkeConsole.println("�ܻش���"+player.getAnswers().size());
	QingkeConsole.println("�ܷ���"+player.getScore());
		int score=player.getScore();
		String leval="����";
		if(score>100){
			leval="ѧ��";
		}else if(score>60){
			leval="ѧ��";		
		}else if(score>30){
			leval="ѧ��";
		}
		QingkeConsole.println("��ǰ��λ��"+leval);
		
	}
}
