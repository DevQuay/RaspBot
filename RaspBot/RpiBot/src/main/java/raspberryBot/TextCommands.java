package raspberryBot;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.utils.PermissionUtil;

public class TextCommands {
	static void addTextCommands(String messaged, MessageChannel chanel, Guild guilded, User messenger, Message wordsIn,
			Member emeber) {
		String prefix = "!";
		if (messaged.toLowerCase().equals(prefix + "hitler")) {
			chanel.sendMessage("https://www.youtube.com/watch?v=3ToEvz-7trY").queue();
			BotLogger.loged(messenger, messaged, chanel, guilded);
		} else if (messaged.toLowerCase().equals(prefix + "limmycider")) {
			chanel.sendMessage("https://twitter.com/DaftLimmy/status/991229443480924160").queue();
			BotLogger.loged(messenger, messaged, chanel, guilded);
		} else if (messaged.toLowerCase().equals(prefix + "candle")) {
			chanel.sendMessage("https://twitter.com/CursedVideos/status/992735287905222656").queue();
			BotLogger.loged(messenger, messaged, chanel, guilded);
		} else if (messaged.toLowerCase().equals(prefix + "cathedral")) {
			chanel.sendMessage("https://www.youtube.com/watch?v=txsHuXIZtxQ").queue();
			BotLogger.loged(messenger, messaged, chanel, guilded);
		} else if (messaged.toLowerCase().equals(prefix + "reset") && messenger.getId().equals("257943503269527552")) {
			guilded.getController().removeRolesFromMember(emeber, emeber.getRoles());
		} else if (messaged.toLowerCase().equals(prefix + "exit") && messenger.getId().equals("257943503269527552")) {
			if (PermissionUtil.checkPermission(guilded.getSelfMember(), Permission.MESSAGE_MANAGE)) {
				wordsIn.delete().complete();
				guilded.leave().queue();
			} else {
				guilded.leave().queue();
			}
		}
	}
}
