package raspberryBot;

import java.io.File;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.Message.Attachment;
import net.dv8tion.jda.core.entities.MessageChannel;

public class Downloader {
static void Download(MessageChannel chanel,Message words, String pathe) {
	List<Message> pinned = chanel.getPinnedMessages().complete();
	words.delete().complete();
	for (Message message : pinned) {
		Attachment attach = message.getAttachments().get(0);
		String Filename = attach.getFileName();
		String Path = pathe + "Cough/" + Filename + "/";
		File fileloc = new File(Path);
		if (!fileloc.exists()) {
			attach.download(fileloc);
			message.clearReactions().complete();
			message.unpin().complete();
		} else {
			int min = 1;
			int max = 1000;
			int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
			String Filenamee = pathe + "Cough/" + randomNum + attach.getFileName() + "/";
			File fileloce = new File(Filenamee);
			attach.download(fileloce);
			message.clearReactions().complete();
			message.unpin().complete();
		}
}
}
}