package adcourseflow;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

import jgame.ButtonState;
import jgame.Context;
import jgame.GButton;
import jgame.GContainer;
import jgame.GMessage;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.Interpolation;
import jgame.controller.MovementTween;
import jgame.listener.DelayListener;

public class ProgAnim extends GContainer {

	private ToggleButton bjcbs = new ToggleButton(
			"Beauty and Joy of Computing",
			"This course will introduce students to computer programming",
			"through the programming \"language\" SNAP!.", "",
			"Roughly 40% of this course will be programming while the",
			"other 60% will cover other computer science concepts",
			"in alignment with the APCS Principles course curriculum.");
	private ToggleButton apscp = new ToggleButton(
			"AP Computer Science Principles",
			"The APCS Principles  course will introduce students to computer programming",
			"through the programming \"language\" SNAP!.", "",
			"Roughly 40% of this course will be programming while the",
			"other 60% will cover other computer science concepts.");
	private ToggleButton aa = new ToggleButton(
			"Advanced Animation",
			"Students may be introduced to programming in Advanced Animation",
			"through ActionScript with Adobe Flash.",
			"",
			"Students will use ActionScript to create sweet computer games",
			"with a variety of platforms.",
			"",
			"The emphasis will be on preparation for the AP Computer Science course,",
			"in which students may subsequently elect to matriculate.");
	private ToggleButton weba = new ToggleButton(
			"Web Design & Animation",
			"Students may be introduced to programming in Web Design",
			"through ActionScript with Adobe Flash.",
			"",
			"Students will use ActionScript to create sweet computer games",
			"with a variety of platforms, which they will embed into HTML",
			"files if DreamWeaver is in a good mood.",
			"",
			"The emphasis will be on preparation for the AP Computer Science course,",
			"in which students may subsequently elect to matriculate.");
	private ToggleButton apcsj = new ToggleButton(
			"AP Computer Science in Java",
			"This is the standard AP Computer Science A course.",
			"",
			"This course introduces students to object-oriented programming",
			"concepts through the Java programming language. It parallels what",
			"a student might expect to find in any first-year computer programming ",
			"course at most universities in the United States.");
	private ToggleButton aa2 = new ToggleButton("Advanced Animation II",
			"After completing the APCS course, students may elect to take",
			"Advanced Animation and Computer Programming.", "",
			"In this class, students will use Java and C# to create",
			"computer games in both 2- and 3-dimensional environments.",
			"This may be taken as a third year of Java programming",
			"or as an introduction to C#, which is structurally and",
			"syntactically quite similar to Java.");

	public ProgAnim() {
		setSize(1000, 900);
		setBackgroundColor(Color.black);

		BufferedImage bgi = ImageCache.getImage("buttons/bg3.png");
		GSprite bgs = new GSprite(bgi);
		setBackgroundSprite(bgs);

		addAt(bjcbs, 161, 184);
		addAt(apscp, 667, 186);
		addAt(aa, 409, 335);
		addAt(weba, 159, 506);
		addAt(apcsj, 668, 528);
		addAt(aa2, 905, 336);

		GButton mbProgramming = createButton(1, "AnimProg");
		mbProgramming.setLocation(0, 100);

		GButton mbAudio = createButton(2, "Audio");
		mbAudio.setLocation(-200, 200);

		GButton Film = createButton(3, "Film");
		Film.setLocation(-400, 300);

		GButton Photo = createButton(4, "Photography");
		Photo.setLocation(-500, 400);
	}

	private GButton createButton(final int buttonIndex, String buttonText) {

		MovementTween mt = new MovementTween(36, Interpolation.EASE_IN, 150, 0);
		MovementTween mtb = new MovementTween(20, Interpolation.EASE_OUT, -100,
				0);

		mt.chain(mtb);

		final GButton btn = new GButton();
		btn.addController(mt);

		Image image1 = ImageCache.getImage("buttons/orangeBase.png");
		GSprite nonegs = new GSprite(image1);

		Image image2 = ImageCache.getImage("buttons/orangeHover.png");
		GSprite hovergs = new GSprite(image2);

		Image image3 = ImageCache.getImage("buttons/orangePressed.png");
		GSprite pressedgs = new GSprite(image3);

		btn.setStateSprite(ButtonState.NONE, nonegs);
		btn.setStateSprite(ButtonState.HOVERED, hovergs);
		btn.setStateSprite(ButtonState.PRESSED, pressedgs);
		btn.setSize(200, 80);

		GMessage gm = new GMessage(buttonText);
		gm.setSize(btn.getWidth(), btn.getHeight());
		gm.setFontSize(24);
		gm.setColor(Color.BLACK);
		btn.addAtCenter(gm);
		gm.setSize(200, 80);
		gm.setAlignmentX(0.5);
		gm.setAlignmentY(0.5);

		DelayListener dl = new DelayListener(buttonIndex * 9) {

			@Override
			public void invoke(GObject target, Context context) {
				addAt(btn, -(buttonIndex - 1) * 260 + 900, 700);
			}
		};
		addListener(dl);
		return btn;
	}

}
