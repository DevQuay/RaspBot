package raspberryBot;

import java.io.File;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

public class EmoteScanner {
	static void ScanEmotes(User messenger, String messaged, MessageChannel chanel, String path, Guild guilded,Message words) {
		File emotedir = new File(path + "Emotes/Big"+guilded.getId());
		File[] files = emotedir.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				File emotedier = new File(emotedir +"/"+ file.getName());
				BigEmote.AddEmote(messenger, messaged, chanel, file.getName(), emotedier, words, guilded);
			}
		}
	}
	static void ScanGlobalEmotes(User messenger, String messaged, MessageChannel chanel, String path, Guild guilded,Message words) {
		File emotedir = new File(path + "Emotes/Big/global");
		File[] files = emotedir.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				File emotedier = new File(emotedir +"/"+ file.getName());
				BigEmote.AddEmote(messenger, messaged, chanel, file.getName(), emotedier, words, guilded);
			}
		}
	}
}