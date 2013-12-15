package org.kruithne.gamething.screens.menus;

import org.kruithne.gamething.GameController;
import org.kruithne.gamething.rendering.RenderPosition;
import org.kruithne.gamething.screens.ScreenBase;
import org.kruithne.gamething.rendering.RenderImage;
import org.kruithne.gamething.screens.levels.LevelScreen;
import org.kruithne.gamething.ui.RenderSimpleButton;
import org.newdawn.slick.GameContainer;

public class MainScreen extends ScreenBase
{
	public MainScreen()
	{
		background = new RenderImage("brick.png");

		logo = new RenderImage("logo.png", 0, 35);
		logoFlash = new RenderImage("logo_flash.png", 0, 35);

		playButtonImage = new RenderImage("play_button.png", 0, 300);
		playButton = new RenderSimpleButton(playButtonImage, new RenderImage("play_button_flash.png"));

		playButton.addClickHandler(new Runnable() {
			@Override
			public void run() {
				GameController.setGameScreen(new LevelScreen());
			}
		});

		logo.setRenderPositionX(RenderPosition.SCREEN_CENTRE);
		logoFlash.setRenderPositionX(RenderPosition.SCREEN_CENTRE);
		playButtonImage.setRenderPositionX(RenderPosition.SCREEN_CENTRE);

		addComponent(logo);
		addComponent(logoFlash);
		addComponent(playButton);
	}

	@Override
	public void update(GameContainer window)
	{
		if (logoIsUpdating)
		{
			if (logoFlashAlpha >= 1F)
				logoIsUpdating = false;
			else
				logoFlashAlpha += 1F / 10000;

			logoFlash.setAlpha(logoFlashAlpha);
		}
	}

	@Override
	public RenderImage getBackImage()
	{
		return background;
	}

	private RenderImage logo;
	private RenderImage logoFlash;
	private RenderImage background;
	private float logoFlashAlpha = 0F;
	private boolean logoIsUpdating = true;
	private RenderSimpleButton playButton;
	private RenderImage playButtonImage;
}
