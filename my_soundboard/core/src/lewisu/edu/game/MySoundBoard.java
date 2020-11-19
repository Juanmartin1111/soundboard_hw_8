package lewisu.edu.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
//import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

/**
 * This class represents an object that appears on the screen.
 * it consists of a label. When the user clicks it, it triggers
 * a sound to be played. Each SoundLabel object has a label that
 * appears on the screen that the user will click, and a Sound 
 * that will be played when it is clicked.
 */
class SoundLabel {
	private Label label;
	private Sound sound;

	public Label getLabel() {
		return label;
	}

	/**
	 * This sets up SoundLabel that is ready to be clicked and play sounds.
	 * @param pathToSound where the sound file is located
	 * @param textToShow the text to show on the screen
	 * @param style the font to use (in nutshell)
	 * @param xpos xcoord where label will appear
	 * @param ypos ycoord where label will appear
	 */

	public SoundLabel(String pathToSound, String textToShow, LabelStyle style,
	int xpos, int ypos) {
		sound = Gdx.audio.newSound(Gdx.files.internal(pathToSound));
		label = new Label(textToShow,style);
		label.setPosition(xpos,ypos);
	}
	// play sound at max value
	public void playSound() {
		sound.play();

	}
	/**
	 * plays sound at requested volume
	 * @param vol the requested volume (between 0 and 1)
	 */
	public void PlaySound(float vol) {
		sound.play(vol);
	}
	/**
	 * This determines if the label was clicked
	 * @param x where the mouse's x coordinate is
	 * @param y where the mouse's y coordinate is
	 * @return true if x,y lie within the label's area
	 */
	
}


public class MySoundBoard extends ApplicationAdapter {
	SpriteBatch batch;
	Texture tex, background, title, menu;
	TextureRegion img;
	Texture[] buttons = new Texture[9];
	Sound[] sounds = new Sound[9];
	OrthographicCamera cam;
	int WIDTH;
	int HEIGHT;
	//Label label;
	LabelStyle labelStyle;
	SoundLabel sound1,sound2,sound3,sound4,sound5,sound6,sound7,sound8,sound9;
	Sound bulb; // sound effect of a lightbulb burstin
	Sound gun1;
	Music whis; // backing track - whistling blowing constanly
	int imgX, imgY; // state variables associated with the location
	int imgWidth, imgHeight;
	int imgOrgX, imgOrgY;
	int imgAngle;

	public void setupLabelStyle() {
		labelStyle = new LabelStyle();
		labelStyle.font = new BitmapFont(Gdx.files.internal("font/scaryfont.fnt"));
	}
	/**
	 * render the sounLabel on the screen
	 */
	public void drawSoundLabel() {
		sound1.getLabel().draw(batch,1);
		sound2.getLabel().draw(batch,1);
		sound3.getLabel().draw(batch,1);
		sound4.getLabel().draw(batch,1);
		sound5.getLabel().draw(batch,1);
		sound6.getLabel().draw(batch,1);
		sound7.getLabel().draw(batch,1);
		sound8.getLabel().draw(batch,1);
		sound9.getLabel().draw(batch,1);
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		tex = new Texture("hand.png");
		img = new TextureRegion(tex); // gives rotation abilities to the image we loaded in
		title = new Texture("weapons.png");
		imgWidth = 50;
		imgHeight = 50;
		imgAngle = 0;
		imgX = 0;
		imgY = 0;
		imgOrgX = imgWidth/2;
		imgOrgY = imgHeight/2;
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		cam = new OrthographicCamera(WIDTH, HEIGHT);
		background = new Texture("gunshop.jpg");
		cam.translate(WIDTH/2, HEIGHT/2); //move the image to the screen
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		cam.setToOrtho(false,750,1334);
		buttons[0] = new Texture("images/m9.png");
		buttons[1] = new Texture("images/hammer.png");
		buttons[2] = new Texture("images/revolver.png");
		buttons[3] = new Texture("images/winchester.png");
		buttons[4] = new Texture("images/knife.png");
		buttons[5] = new Texture("images/bazooka.png");
		buttons[6] = new Texture("images/laser_gun.png");
		buttons[7] = new Texture("images/sword.png");
		buttons[8] = new Texture("images/paintball.png");
	


		sounds[0] = Gdx.audio.newSound(Gdx.files.internal("audio/shotgun.mp3"));
		sounds[1] = Gdx.audio.newSound(Gdx.files.internal("audio/hammer.mp3")); 
		sounds[2] = Gdx.audio.newSound(Gdx.files.internal("audio/lasergun.mp3"));
		sounds[3] = Gdx.audio.newSound(Gdx.files.internal("audio/winchester.mp3"));
		sounds[4] = Gdx.audio.newSound(Gdx.files.internal("audio/knife.mp3")); 
		sounds[5] = Gdx.audio.newSound(Gdx.files.internal("audio/magnum.mp3"));
		sounds[6] = Gdx.audio.newSound(Gdx.files.internal("audio/bazooka.mp3"));
		sounds[7] = Gdx.audio.newSound(Gdx.files.internal("audio/sword.mp3")); 
		sounds[8] = Gdx.audio.newSound(Gdx.files.internal("audio/paintball.mp3"));
		setupLabelStyle();
		sound1 = new SoundLabel("audio/shotgun.mp3", "M9", labelStyle, 80, 884);
		sound2 = new SoundLabel("audio/hammer.mp3", "HAMMER", labelStyle, 280, 884);
		sound3 = new SoundLabel("audio/magnum.mp3", "REVOLVER", labelStyle, 500, 884);
		sound4 = new SoundLabel("audio/winchester.mp3", "WINCHESTER", labelStyle, 20, 574);
		sound5 = new SoundLabel("audio/knife.mp3", "KNIFE", labelStyle, 310, 574);
		sound6 = new SoundLabel("audio/bazooka.mp3", "BAZOOKA", labelStyle, 500, 574);
		sound7 = new SoundLabel("audio/lasergun.mp3", "LASER GUN", labelStyle, 20, 274);
		sound8 = new SoundLabel("audio/sword.mp3", "SWORD", labelStyle, 310, 274);
		sound9 = new SoundLabel("audio/paintball.mp3", "PAINTBALL GUN", labelStyle, 500, 274);
		//bulb = Gdx.audio.newSound(Gdx.files.internal("audio/bulb.mp3"));
		//gun1 = Gdx.audio.newSound(Gdx.files.internal("audio/gun1.mp3"));
		whis = Gdx.audio.newMusic(Gdx.files.internal("audio/whistling.wav"));
		whis.setLooping(true);
		whis.setVolume(0.5f);
		whis.play();

	}

	/**
	 * handles all keyboard and mouse imput
	 * it is called from render
	 * UP, DOWN, LEFT, RIGHT - camera
	 * if shift+UP or shift+DOWN - zoom
	 * if shift+LEFT or shift+RIGHT - rotate
	 * ESCAPE - leave the program
	 * A,S,W,D control the image
	 * A,D - up down
	 * shift + W and S -> rotate the image
	 * if you click on the game, it will print the coorinates
	 */
	public void handleInput() {
		boolean shiftHeld = false;
		boolean cameraNeedsUpdating = false;
		if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT)) {
			shiftHeld = true;
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
			Gdx.app.exit();		// quit the game
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.R)) {
			sounds[0].play();
			//buttons[0] += 10;
		}
		if (Gdx.input.isKeyJustPressed(Keys.H)) {
			sounds[1].play();
		}
		if (Gdx.input.isKeyJustPressed(Keys.L)) {
			sounds[2].play();
		}
		if (Gdx.input.isKeyJustPressed(Keys.W)) {
			sounds[3].play();
		}
		if (Gdx.input.isKeyJustPressed(Keys.K)) {
			sounds[4].play();
		}
		if (Gdx.input.isKeyJustPressed(Keys.M)) {
			sounds[5].play();
		}
		if (Gdx.input.isKeyJustPressed(Keys.B)) {
			sounds[6].play();
		}
		if (Gdx.input.isKeyJustPressed(Keys.S)) {
			sounds[7].play();
		}
		if (Gdx.input.isKeyJustPressed(Keys.P)) {
			sounds[8].play();
		}



		if (Gdx.input.isTouched()) {
			String btnName;
			if (Gdx.input.isButtonPressed(Buttons.LEFT)) {
				btnName = "left";
			} else {
				btnName = "right";
			}
			if (btnName.equals("right")) {
				imgOrgX = Gdx.input.getX();
				imgOrgY = HEIGHT - Gdx.input.getY();
				cam.zoom += 0.01;
			} else {
				imgX = Gdx.input.getX()-imgWidth/2;
				imgY = HEIGHT - Gdx.input.getY()-imgHeight/2;
				cam.zoom -= 0.01;	
			}
		}
		
		if (cameraNeedsUpdating) {
			updateCamera();
		}
	}

	public void updateCamera() {
		cam.update();
		batch.setProjectionMatrix(cam.combined);
	}




	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		handleInput();
		//label.setPosition(20+cam.position.x-WIDTH/2,400+cam.position.y-HEIGHT/2);
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		//batch.draw(title, 0, 1100);
		batch.draw(background, 0, 0, 800, 1400);
		batch.draw(img, imgX, imgY, imgOrgX, imgOrgY, imgWidth, imgHeight, 3, 3, imgAngle);
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				batch.draw(buttons[i*3+j], j * 250, 884 - i*300, 200, 250);
			}
		}
		drawSoundLabel();
		//label.draw(batch,1);
		batch.draw(title, 80, 25);
		batch.end();
		if (Gdx.input.justTouched()) {
			int x = Gdx.input.getX();
			int y = Gdx.input.getY();
			Vector3 touchPos = new Vector3(x,y,0);
			cam.unproject(touchPos);
			System.out.println("X: " + x + ", " + "Y: " + y);
			System.out.println("X: " + touchPos.x + ", " + "Y: " + touchPos.y);
			if (touchPos.x > 15 && touchPos.x < 235) {
				if (touchPos.y > 874 && touchPos.y < 1094) {
				sounds[5].play(1);
				}
				if (touchPos.y > 574 && touchPos.y < 794) {
					sounds[3].play(1);
					}
					if (touchPos.y > 274 && touchPos.y < 494) {
						sounds[2].play(1);
						}
			}
			
			if (touchPos.x > 265 && touchPos.x < 485) {
				if (touchPos.y > 874 && touchPos.y < 1094) {
				sounds[1].play();
				}
				if (touchPos.y > 574 && touchPos.y < 794) {
					sounds[4].play();
					}
					if (touchPos.y > 274 && touchPos.y < 494) {
						sounds[7].play();
						}
			}

			if (touchPos.x > 515 && touchPos.x < 735) {
				if (touchPos.y > 874 && touchPos.y < 1094) {
				sounds[0].play();
				}
				if (touchPos.y > 574 && touchPos.y < 794) {
					sounds[6].play();
					}
					if (touchPos.y > 274 && touchPos.y < 494) {
						sounds[8].play();
						}
			}
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
		whis.dispose();
		bulb.dispose();
		gun1.dispose();
	}
}
