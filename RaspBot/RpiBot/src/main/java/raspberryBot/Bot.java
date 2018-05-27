package raspberryBot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.security.auth.login.LoginException;

import org.apache.commons.io.FileUtils;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.Message.Attachment;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.MessageReaction.ReactionEmote;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.EventListener;

public class Bot implements EventListener {
	public static void main(String[] args)
			throws LoginException, RateLimitedException, InterruptedException, IOException {
		File jarDir = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath());
		String path = jarDir.getAbsolutePath() + "/Token.txt";
		File input = new File(path);
		String token = FileUtils.readFileToString(input, Charset.defaultCharset());
		new JDABuilder(AccountType.BOT).setToken(token).addEventListener(new Bot()).buildBlocking();
	}

	static Boolean reacted = false;
	static String messageid = "test value";

	@Override
	public void onEvent(Event event) {
		File jarDir = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath());
		String path = jarDir.getAbsolutePath() + "/";
		String pathe = path + "Emotes/";
		if (event instanceof ReadyEvent) {
			String writePath = path + "StartLog.txt";
			System.out.println("API is ready!");
			String timeStamp2 = new SimpleDateFormat("dd/MM/yy @ HH:mm").format(Calendar.getInstance().getTime());
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(writePath, true));
				out.write("Bot Started On: " + timeStamp2 + "\r\n");
				out.close();
			} catch (IOException e) {
				System.out.println("exception occured" + e);
			}
		} else if (event instanceof MessageReactionAddEvent) {
			String id = ((MessageReactionAddEvent) event).getMessageId();
			MessageChannel chnl = ((MessageReactionAddEvent) event).getTextChannel();
			ReactionEmote react = ((MessageReactionAddEvent) event).getReactionEmote();
			if (react.getName().equals("Download")) {
				reacted = true;
				messageid = id;
				chnl.pinMessageById(messageid).complete();

			}
		} else if (event instanceof MessageReactionRemoveEvent) {
			String id = ((MessageReactionRemoveEvent) event).getMessageId();
			MessageChannel chnl = ((MessageReactionRemoveEvent) event).getTextChannel();
			ReactionEmote react = ((MessageReactionRemoveEvent) event).getReactionEmote();
			if (react.getName().equals("Download")) {
				chnl.unpinMessageById(id).complete();
			}
		} else if (event instanceof MessageReceivedEvent) {
			MessageChannel chanel = ((MessageReceivedEvent) event).getTextChannel();
			User messenger = ((MessageReceivedEvent) event).getMessage().getAuthor();
			Guild guilded = ((MessageReceivedEvent) event).getGuild();
			String messaged = ((MessageReceivedEvent) event).getMessage().getContentDisplay();
			Message words = ((MessageReceivedEvent) event).getMessage();
			if (messaged.toLowerCase().equals("!chippy")) {
				File fileloc = new File(pathe + "Delet The Chippy.jpg");
				Message message = null;
				chanel.sendFile(fileloc, "Delet The Chippy.jpg", message).queue();
				BotLogger.loged(messenger, messaged, chanel, guilded);
			} else if (messaged.toLowerCase().contains("yeet")) {
				File fileloc = new File(pathe + "Yeet.png");
				Message message = null;
				chanel.sendFile(fileloc, "Yeet.png", message).queue();
				BotLogger.loged(messenger, messaged, chanel, guilded);

			} else if (messaged.toLowerCase().equals("!addemote local")) {
				Attachment attatch = words.getAttachments().get(0);
				String Filename = attatch.getFileName();
				String Path = pathe + "Big/" + guilded.getId() + "/";
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
				String Path = pathe + "Big/global/";
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

			} else if (messaged.toLowerCase().equals("free mp3")) {
				File fileloc = new File(pathe + "FreeMP3.png");
				Message message = null;
				chanel.sendFile(fileloc, "FreeMP3.png", message).queue();
				BotLogger.loged(messenger, messaged, chanel, guilded);
			} else if (messaged.toLowerCase().equals("!hitler")) {
				chanel.sendMessage("https://www.youtube.com/watch?v=3ToEvz-7trY").queue();
				BotLogger.loged(messenger, messaged, chanel, guilded);
			} else if (messaged.toLowerCase().equals("!colgate")) {
				Message message = null;
				File fileloc = new File(pathe + "CoLgAtE.jpg");
				chanel.sendFile(fileloc, "CoLgAtE.jpg", message).queue();
				BotLogger.loged(messenger, messaged, chanel, guilded);
			} else if (messaged.toLowerCase().equals("!excite")) {
				Message message = null;
				File fileloc = new File(pathe + "Excited.jpg");
				chanel.sendFile(fileloc, "Excited.jpg", message).queue();
				BotLogger.loged(messenger, messaged, chanel, guilded);
			} else if (messaged.toLowerCase().equals("!willjoshdietomorrow")) {
				File fileloc = new File(pathe + "Maybe.png");
				Message message = null;
				chanel.sendFile(fileloc, "Maybe.png", message).complete();
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
			} else if (messaged.toLowerCase().equals("!dl") && messenger.getId().equals("257943503269527552")
					&& guilded.getId().equals("348935653976965120")) {
				Downloader.Download(chanel, words, pathe);
				BotLogger.loged(messenger, messaged, chanel, guilded);
			} else {
				try {
				EmoteScanner.ScanGlobalEmotes(messenger, messaged, chanel, path, guilded, words);
				EmoteScanner.ScanEmotes(messenger, messaged, chanel, path, guilded, words);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				BotLogger.loged(messenger, messaged, chanel, guilded);
			}
		}
	}
}