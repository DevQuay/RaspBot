package raspberryBot;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.Message.Attachment;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

public class EmoteAdder {
	public static void addEmoteCommands(String messaged, MessageChannel chanel, Guild guilded, User messenger,
			File fileIn, Message words) {
		if (messaged.toLowerCase().equals("!addemote local")) {
			Attachment attatch = words.getAttachments().get(0);
			String Filename = attatch.getFileName();
			String Path = fileIn + "Big/" + guilded.getId() + "/";
			String Path2 = Path + Filename;
			try {
				Files.createDirectories(Paths.get(Path));
				File fileloc = new File(Path2);
				attatch.download(fileloc);
				chanel.sendMessage("Local Emote Added Successfully!").queue();
			} catch (Exception e) {
				e.printStackTrace();
			}
			BotLogger.loged(messenger, messaged, chanel, guilded);
		} else if (messaged.toLowerCase().equals("!addemote global")) {
			Attachment attatch = words.getAttachments().get(0);
			String Filename = attatch.getFileName();
			String Path = fileIn + "Big/global/";
			String Path2 = Path + Filename;
			try {
				Files.createDirectories(Paths.get(Path));
				File fileloc = new File(Path2);
				attatch.download(fileloc);
				chanel.sendMessage("Global Emote Added Successfully!").queue();
			} catch (Exception e) {
				e.printStackTrace();
			}
			BotLogger.loged(messenger, messaged, chanel, guilded);
		}

	}

}
