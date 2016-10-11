package com.qingke.easy.jdbc.command.impl;

import java.util.ArrayList;
import java.util.List;

import com.qingke.easy.Player;
import com.qingke.easy.Question;
import com.qingke.easy.jdbc.app.BesuperDao;
import com.qingke.easy.jdbc.command.PlayerCommand;
import com.qingke.jdbcapp.util.QingkeConsole;

public class ListCommand extends PlayerCommand {
	public ListCommand(Player player) {
		super(player);
	}
	@Override
	public void executePlayerCommand() {
		String listMode = QingkeConsole.askUserInput("选择你要列出的问题(ALL/MINE/OPEN/ID)");
		BesuperDao dao = new BesuperDao();
		if (!"ALL/MINE/OPEN/ID".contains(listMode)) {
			QingkeConsole.println("请使用支持的模式");
			return;
		}
		List<Question> questions = new ArrayList<>();
		if ("ALL".equalsIgnoreCase(listMode)) {
			questions = dao.getQuestions();
		} else if ("MINE".equalsIgnoreCase(listMode)) {
			questions = dao.getQuestionsFrom(player);
		} else if ("OPEN".equalsIgnoreCase(listMode)) {
			List<Question> tmpList = dao.getQuestions();
			for (Question question : tmpList) {
				if (question.isOpen()) {
					questions.add(question);
				}
			}
		} else if ("ID".equalsIgnoreCase(listMode)) {
			long id = QingkeConsole.askUserInputInt("请输入问题ID");
			Question q = dao.getQuestion(id);
			questions.add(q);
		}
		for (Question q : questions) {
			QingkeConsole.println(q);
		}

	}			
}
