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
	QingkeConsole.println("总问题数"+player.getQuestions().size());
	QingkeConsole.println("总回答数"+player.getAnswers().size());
	QingkeConsole.println("总分数"+player.getScore());
		int score=player.getScore();
		String leval="弱鸡";
		if(score>100){
			leval="学霸";
		}else if(score>60){
			leval="学生";		
		}else if(score>30){
			leval="学渣";
		}
		QingkeConsole.println("当前段位："+leval);
		
	}
}
