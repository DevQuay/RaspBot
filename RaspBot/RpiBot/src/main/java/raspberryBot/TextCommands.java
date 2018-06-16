package raspberryBot;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

public class TextCommands {
	static void addTextCommands(String messaged, MessageChannel chanel, Guild guilded, User messenger,
			Message wordsIn) {
		if (messaged.toLowerCase().equals("!hitler")) {
			chanel.sendMessage("https://www.youtube.com/watch?v=3ToEvz-7trY").queue();
			BotLogger.loged(messenger, messaged, chanel, guilded);
		} else if (messaged.toLowerCase().equals("!limmycider")) {
			chanel.sendMessage("https://twitter.com/DaftLimmy/status/991229443480924160").queue();
			BotLogger.loged(messenger, messaged, chanel, guilded);
		} else if (messaged.toLowerCase().equals("!candle")) {
			chanel.sendMessage("https://twitter.com/CursedVideos/status/992735287905222656").queue();
			BotLogger.loged(messenger, messaged, chanel, guilded);
		} else if (messaged.toLowerCase().equals("!cathedral")) {
			chanel.sendMessage("https://www.youtube.com/watch?v=txsHuXIZtxQ").queue();
			BotLogger.loged(messenger, messaged, chanel, guilded);
		}
	}
}