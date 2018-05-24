package raspberryBot;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.utils.PermissionUtil;

public class BigEmote {
	static void AddEmote(User messenger, String messaged, MessageChannel chanel, String name, File emotedir,
			Message words, Guild guilded) {
		String emoted = FilenameUtils.removeExtension(name);
		String fare = ":" + emoted + ":";
		if (messaged.equals(fare)
				&& PermissionUtil.checkPermission(guilded.getSelfMember(), Permission.MESSAGE_MANAGE)) {
			words.delete().complete();
			Message message = null;
			chanel.sendFile(emotedir, name, message).queue();
		}else if(messaged.equals(fare)) {
			Message message = null;
			chanel.sendFile(emotedir, name, message).queue();
		} else {
			return;
		}
	}

}
