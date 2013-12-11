package adcourseflow;

import java.awt.Color;
import java.awt.Font;

import jgame.GContainer;
import jgame.GMessage;
import jgame.ImageCache;
import jgame.controller.ConstantRotationController;
import jgame.controller.PulsateController;

class ModalTextPanel extends GContainer {
	public ModalTextPanel(String title, String... messages) {
		super(ImageCache.getSprite("buttons/modalwindow.png"));

		Color color = new Color(0xEE, 0xA5, 0x44);

		GMessage mTitle = new GMessage(title);
		mTitle.setFontSize(36);
		mTitle.setFontStyle(Font.BOLD);
		mTitle.setColor(color);
		addAt(mTitle, 100, 100);

		final int step = 30;
		int y = 150 - step;
		for (String message : messages) {
			GMessage mMessage = new GMessage(message);
			mMessage.setFontSize(20);
			mMessage.setColor(Color.WHITE);
			addAt(mMessage, 100, y += step);
		}

		PulsateController c = new PulsateController(0.9, 0.05, 120);
		c.setProperties(PulsateController.ALPHA);
		addController(c);
	}
}