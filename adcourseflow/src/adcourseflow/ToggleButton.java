package adcourseflow;

import java.util.List;

import jgame.ButtonState;
import jgame.Context;
import jgame.GButton;
import jgame.GObject;
import jgame.GSprite;
import jgame.GSprite.PrimitiveShape;
import jgame.ImageCache;
import jgame.controller.Interpolation;
import jgame.controller.ScaleTween;
import jgame.listener.ButtonListener;

public class ToggleButton extends GButton {

	private ModalTextPanel mtp;

	public ToggleButton(String title, String... messages) {
		super();

		mtp = new ModalTextPanel(title, messages);

		GSprite sprite = ImageCache.getSprite("buttons/button.png");
		sprite.setPrimitive(PrimitiveShape.CIRCLE);
		setStateSprite(ButtonState.NONE, sprite);

		setSize(sprite.getWidth(), sprite.getHeight());
		setScale(0.8);

		ButtonListener blVisible = new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				List<ToggleButton> all = context
						.getInstancesOfClass(ToggleButton.class);
				for (ToggleButton btn : all) {
					if (btn != ToggleButton.this && !btn.isVisible()) {
						return;
					}
				}
				setVisible(!isVisible());
				if (!isVisible()) {
					GObject pare = getParent();
					if (pare != null) {
						pare.addAtCenter(mtp);
						mtp.setScale(0);
						ScaleTween tween = new ScaleTween(12,
								Interpolation.EASE_IN, 0, 1.1);
						tween.chain(new ScaleTween(4, Interpolation.EASE_OUT,
								1.1, 1));
						mtp.addController(tween);
					}
				} else {
					mtp.removeSelf();
				}
			}
		};
		addListener(blVisible);

		ButtonListener blText = new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				if (!mtp.isVisible()) {
					return;
				}
				mtp.removeSelf();
				setVisible(true);
			}
		};
		mtp.addListener(blText);
	}
}
