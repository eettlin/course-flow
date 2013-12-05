package adcourseflow;

import java.awt.Color;
import java.awt.Image;

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
	
	
	public ProgAnim() {
		setSize(1100, 850);
		setBackgroundColor(Color.black);

		GButton mbProgramming = createButton(1, "Programming");
		mbProgramming.setLocation(0, 100);
		
		GButton mbAudio = createButton(2, "Audio");
		mbAudio.setLocation(-200, 200);
		
		GButton Film = createButton(3, "Film");
		Film.setLocation(-400, 300);
		
		GButton Photo = createButton(4, "Photography");
		Photo.setLocation(-500, 400);
		
	}
	
	private GButton createButton(final int buttonIndex, String buttonText) {

		MovementTween mt = new MovementTween(36, Interpolation.EASE_IN, 400, 0);
		MovementTween mtb = new MovementTween(20, Interpolation.EASE_OUT, -80, 0);
		
		mt.chain(mtb);
		
		final GButton btn = new GButton();
		btn.addController(mt);
		
		Image image1 = ImageCache.getImage("buttons/orangeBase.png");
		GSprite nonegs = new GSprite(image1);
		
		Image image2 = ImageCache.getImage("buttons/orangeHover.png");
		GSprite hovergs = new GSprite(image2);
		
		Image image3 = ImageCache.getImage("buttons/orangePressed.png");
		GSprite pressedgs = new GSprite(image3);
		
		//GSprite bgs = new GSprite("buttons/buttonup.png");
		//btn.setStateSprite(ButtonState.NONE,createButtonSprite("buttons/buttonup.png"));
		btn.setStateSprite(ButtonState.NONE,nonegs);
		btn.setStateSprite(ButtonState.HOVERED,hovergs);
		btn.setStateSprite(ButtonState.PRESSED,pressedgs);
		btn.setSize(250, 50);
		
		GMessage gm = new GMessage(buttonText);

		gm.setSize(btn.getWidth(), btn.getHeight());
		//gm.setAlignmentX(0.5);
		//gm.setAlignmentY(0.5);
		gm.setFontSize(24);
		gm.setColor(Color.BLACK);
		btn.addAt(gm, 150, 50);

		DelayListener dl = new DelayListener(buttonIndex * 9) {

			@Override
			public void invoke(GObject target, Context context) {
				addAt(btn, -100, (buttonIndex-1)*100  + 220);
			}
		};
		addListener(dl);
		return btn;
	}
	
	
}
