package adcourseflow;

import java.awt.Color;

import jgame.GRootContainer;
import jgame.Game;
import jgame.ImageCache;
import jgame.SoundManager;

public class CFMain extends Game {

	public static void main(String[] args) {
		new CFMain().startGame();
	}

	public CFMain() {
		ImageCache.create(CFMain.class, "/adcourseflow/rsc/");
		SoundManager.create(CFMain.class, "/adcourseflow/rsc/sounds/");
		// Create an instance and assign to a variable
		// Starts the CourseFlow App
		// GRootContainer is not a game object (Deck of cards)
		GRootContainer root = new GRootContainer(Color.BLACK);
		setRootContainer(root);
		
		  MainMenuView mmv = new MainMenuView(); root.addView(Views.MAIN_MENU,
		  mmv);
		 

		// add these two lines for each view
		ProgAnim pav = new ProgAnim();
		root.addView(Views.PROG_ANIM, pav);
	}

	public enum Views {
		// These are all of the views for this game
		MAIN_MENU, PROG_ANIM, FILM, DGI_PHOTO, AUDIO;
	}

}
