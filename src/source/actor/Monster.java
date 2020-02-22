package source.actor;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Monster extends Component {
	
	public Monster() {
		type = ActorType.PLAYER;
		try {
			image = ImageIO.read(new File(".\\src\\resource\\monster.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
