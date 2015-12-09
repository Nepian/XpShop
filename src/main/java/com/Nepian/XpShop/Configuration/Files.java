package com.Nepian.XpShop.Configuration;

import static com.Nepian.XpShop.Configuration.Properties.*;

import java.io.File;
import java.io.IOException;

import com.Nepian.XpShop.Main;

public class Files {
	private static final Main plugin;

	public static final File FOLDER_MAIN;

	public static final File FILE_CONFIG;

	enum FileType { FILE, FOLDER }

	static {
		plugin = Main.getPlugin();
		FOLDER_MAIN = plugin.getDataFolder();
		FILE_CONFIG = load(NAME_FILE_CONFIG, FileType.FILE);
	}

	/* Private Methods ------------------------------------------------------*/

	private static File load(String string, FileType type) {
		File file = new File(FOLDER_MAIN, string);

		return load(file, type);
	}

	private static File load(File file, FileType type) {
		if (!file.exists()) {
			try {
				if (file.getParent() != null) {
					file.getParentFile().mkdirs();
				}

				switch (type) {
				case FILE:
					file.createNewFile();
					break;
				case FOLDER:
					file.mkdir();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return file;
	}
}
