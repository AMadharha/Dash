package src.objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Character {
	private double x, y;
	private double width, height;
	private Image[] imgRun;
	private ImageView iview;
	private int index;
	public boolean isDead;

	public Character(int character) {
		x = 0;
		y = 0;
		index = 0;

		imgRun = new Image[2];

		if(character == 1) {
			imgRun[0] = new Image("./././images/characterOne-run1.png");
			imgRun[1] = new Image("./././images/characterOne-run2.png");
		}
		else if(character == 2) {
			imgRun[0] = new Image("./././images/characterTwo-run1.png");
			imgRun[1] = new Image("./././images/characterTwo-run2.png");
		}
		else if(character == 3) {
			imgRun[0] = new Image("./././images/characterThree-run1.png");
			imgRun[1] = new Image("./././images/characterThree-run2.png");
		}
		else {
			imgRun[0] = new Image("./././images/characterOne-run1.png");
			imgRun[1] = new Image("./././images/characterOne-run2.png");
		}

		width = imgRun[index].getWidth();
		height = imgRun[index].getHeight();
		iview = new ImageView(imgRun[index]);
		iview.setX(x);
		iview.setY(y);
		isDead = false;
	}

	public void move() {
		if(index == imgRun.length) {
			index = 0;
		}
		iview.setImage(imgRun[index]);
		index++;
	}

	public void killEskimo() {
		isDead = true;
		imgRun[0] = new Image("./././images/bloodSplatter.png");
		iview.setImage(imgRun[0]);
	}

	public void setX(double xPos) {
		x = xPos;
	}

	public void setY(double yPos) {
		y = yPos;
	}

	public void setWidth(double w) {
		width = w;
	}

	public void setHeight(double h) {
		height = h;
	}

	public void setImages(Image[] img) {
		imgRun = img;
	}

	public void setIndex(int i) {
		index = i;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public Image getImage() {
		return imgRun[index];
	}

	public ImageView getNode() {
		if(isDead == false ) {
			if(index == imgRun.length) {
				index = 0;
			}
			iview.setImage(imgRun[index]);
			iview.setX(x);
			iview.setY(y);
		
			return iview;
		} else {
			imgRun[0] = new Image("./././images/bloodSplatter.png");
			iview.setImage(imgRun[0]);
			return iview;
		}
	}
}