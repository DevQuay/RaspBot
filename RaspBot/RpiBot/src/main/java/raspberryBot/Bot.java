package raspberryBot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.security.auth.login.LoginException;

import org.apache.commons.io.FileUtils;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
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
	File jarDir = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath());
	String path = jarDir.getAbsolutePath() + "/";
	String pathe = path + "Emotes/";

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
			LocalCommands.removeLater(messaged, chanel, guilded, messenger, new File(pathe), words);
			TextCommands.addTextCommands(messaged, chanel, guilded, messenger, words);
			EmoteAdder.addEmoteCommands(messaged, chanel, guilded, messenger, new File(pathe), words);
			if (messaged.toLowerCase().equals("!dl") && messenger.getId().equals("257943503269527552")
					&& guilded.getId().equals("348935653976965120")) {
				Downloader.Download(chanel, words, pathe);
				BotLogger.loged(messenger, messaged, chanel, guilded);
			} else {
				if (messenger.isBot()) {
					return;
				} else {
					try {
						EmoteScanner.ScanGlobalEmotes(messenger, messaged, chanel, path, guilded, words);
						EmoteScanner.ScanEmotes(messenger, messaged, chanel, path, guilded, words);
					} catch (Exception e) {
					}
					BotLogger.loged(messenger, messaged, chanel, guilded);
				}
			}
		}
	}
}