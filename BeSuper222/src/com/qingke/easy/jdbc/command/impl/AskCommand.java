package com.qingke.easy.jdbc.command.impl;

import com.qingke.easy.Player;
import com.qingke.easy.Question;
import com.qingke.easy.jdbc.app.BesuperDao;
import com.qingke.easy.jdbc.command.PlayerCommand;
import com.qingke.jdbcapp.util.QingkeConsole;

public class AskCommand extends PlayerCommand {
//	private Player player;
//	public void PlayerCommandFactory(Player player) {
//		this.player = player;
//	}
	public AskCommand(Player player) {
		super(player);
	}
	@Override
	public void executePlayerCommand() {
		// TODO Auto-generated method stub
		String content = QingkeConsole.askUserInput("�������������");
		int credit = QingkeConsole.askUserInputInt("����������Ľ�����ֵ", false);
		if (credit > player.getScore()) {
			credit = player.getScore();
			QingkeConsole.println("�����ֵ������ǰ�û�!Ĭ��ʹ���û�����Ϊ����ֵ");
		}
		Question question = new Question(-1, content, player, credit);
		new BesuperDao().upsertQuestion(question);
		player.getQuestions().add(question);
		player.setScore(player.getScore() - credit);
	}

}
