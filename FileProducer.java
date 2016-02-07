package p1;

import javax.swing.Icon;

public class FileProducer implements IconProducer {
	private String file;

	public FileProducer(String filename) {
		this.file = filename;
	}

	public int delay() {
		return this.delay();
	}

	@Override
	public int times() {
		return this.times();

	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public Icon nextIcon() {
		return null;
	}
}
