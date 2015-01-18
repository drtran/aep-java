package patterns.structural.adapter;

/**
 * Adapter Pattern Example:
 * 
 * Source: http://www.tutorialspoint.com/design_pattern/adapter_pattern.htm
 *
 * from: http://sourcemaking.com/design_patterns/adapter
 * 
 * An "off the shelf" component offers compelling functionality 
 * that you would like to reuse, but its "view of the world" is 
 * not compatible with the philosophy and architecture of the 
 * system currently being developed.
 * 
 * 
 */
public class AdapterPatternDemo {
	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();

		audioPlayer.play("mp3", "beyond the horizon.mp3");
		audioPlayer.play("mp4", "alone.mp4");
		audioPlayer.play("vlc", "far far away.vlc");
		audioPlayer.play("avi", "mind me.avi");
	}
}