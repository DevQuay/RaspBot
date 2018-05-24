package raspberryBot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

public class BotLogger {
	static void loged(User messenger, String messaged, MessageChannel chanel, Guild guilded) {
		File jarDir = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath());
		String path = jarDir.getAbsolutePath() + "/Logs/" + guilded.getId();
		if (messenger.isBot()) {
			return;
		}
		String timeStamp = new SimpleDateFormat("dd/MM/yy @ HH:mm").format(Calendar.getInstance().getTime());
		String timeStamp2 = new SimpleDateFormat("dd_MM_yy").format(Calendar.getInstance().getTime());
		String log = "[" + timeStamp + "][" + guilded.getName() + "]" + messenger.getName() + ":" + messaged + "\r\n";
		System.out.printf("%s", log);
			try {
				Files.createDirectories(Paths.get(path));
				String writePath = path + "/" + "Log" + "_" + timeStamp2 + ".txt";
				BufferedWriter out = new BufferedWriter(new FileWriter(writePath, true));
				out.write(log);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
