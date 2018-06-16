package raspberryBot;

import java.io.File;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

public class LocalCommands {
	Message message = null;

	public static void removeLater(String messaged, MessageChannel chanel, Guild guilded, User messenger, File FileIn,
			Message wordsIn) {
		if (messaged.toLowerCase().equals("!chippy")) {
			File fileloc = new File(FileIn + "Delet The Chippy.jpg");
			Message message = null;
			chanel.sendFile(fileloc, "Delet The Chippy.jpg", message).queue();
			BotLogger.loged(messenger, messaged, chanel, guilded);
		} else if (messaged.toLowerCase().contains("yeet")) {
			File fileloc = new File(FileIn + "Yeet.png");
			Message message = null;
			chanel.sendFile(fileloc, "Yeet.png", message).queue();
			BotLogger.loged(messenger, messaged, chanel, guilded);
		} else if (messaged.toLowerCase().equals("free mp3")) {
			File fileloc = new File(FileIn + "FreeMP3.png");
			Message message = null;
			chanel.sendFile(fileloc, "FreeMP3.png", message).queue();
			BotLogger.loged(messenger, messaged, chanel, guilded);
		} else if (messaged.toLowerCase().equals("!colgate")) {
			Message message = null;
			File fileloc = new File(FileIn + "CoLgAtE.jpg");
			chanel.sendFile(fileloc, "CoLgAtE.jpg", message).queue();
			BotLogger.loged(messenger, messaged, chanel, guilded);
		} else if (messaged.toLowerCase().equals("!excite")) {
			Message message = null;
			File fileloc = new File(FileIn + "Excited.jpg");
			chanel.sendFile(fileloc, "Excited.jpg", message).queue();
			BotLogger.loged(messenger, messaged, chanel, guilded);
		} else if (messaged.toLowerCase().equals("!willjoshdietomorrow")) {
			File fileloc = new File(FileIn + "Maybe.png");
			Message message = null;
			chanel.sendFile(fileloc, "Maybe.png", message).complete();
			BotLogger.loged(messenger, messaged, chanel, guilded);
		}
	}
}